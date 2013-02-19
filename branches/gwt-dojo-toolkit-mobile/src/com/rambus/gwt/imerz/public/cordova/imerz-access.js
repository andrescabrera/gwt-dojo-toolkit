/**
 * IMerzAccess plugin for Cordova.
 */
var IMerzAccess = {
	initialized : false,

	init : function() {
		if (this.initialized) {
			return;
		}

		var callback = function(event) {
			var text = JSON.stringify({
				"body" : IMerzAccess.decode(event[0]),
				"sender" : event[1]
			});

			_imerz_iframe_.postMessage(text, "*");
		};

		window.addEventListener("message", function(event) {
			var json;

			try {
				json = JSON.parse(event.data);
			} catch (except) {
				console.error("Error in JSON from: " + event.origin + ": "
						+ event.data);
				return;
			}

			if (json.action === "subscribe") {
				if (json.args && json.args[0]) {
					IMerzAccess.subscribe(json.args[0], callback);
				}
			} else if (json.action === "unsubscribe") {
				if (json.args && json.args[0]) {
					IMerzAccess.unsubscribe(json.args[0], callback);
				}
			} else if (json.action === "send") {
				if (json.args && json.args[0]) {
					IMerzAccess.send(json.args[0], json.args[1]);
				}
			} else {
				console.error("Invalid action in JSON from: " + event.origin
						+ ": " + e.data);
			}

		}, false);

		this.initialized = true;
	},

	subscribe : function(topic, callback) {
		return cordova.exec(function(o) {
			if (callback) {
				document.addEventListener(topic, callback);
			}
			console.error("Success: " + JSON.stringify(o));
		}, IMerzAccess.fail, "IMerzAccess", "subscribe", [ topic ]);
	},

	unsubscribe : function(topic, callback) {
		return cordova.exec(function(o) {
			if (callback) {
				document.removeEventListener(topic, callback, false);
			}
			console.error("Success: " + JSON.stringify(o));
		}, IMerzAccess.fail, "IMerzAccess", "unsubscribe", [ topic ]);
	},

	send : function(msg, recipient) {
		return cordova.exec(IMerzAccess.success, IMerzAccess.fail,
				"IMerzAccess", "send", [ msg, recipient ]);
	},

	encode : function(str) {
		return window.btoa(window.unescape(window.encodeURIComponent(str)));
	},

	decode : function(str) {
		return window.decodeURIComponent(window.escape(window.atob(str)));
	},

	success : function(o) {
		console.error("Success: " + JSON.stringify(o));
	},

	fail : function(o) {
		console.error("Error: " + JSON.stringify(o));
	}
}