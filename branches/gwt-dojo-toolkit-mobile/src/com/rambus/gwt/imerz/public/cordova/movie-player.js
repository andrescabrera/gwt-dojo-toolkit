/**
 * MoviePlayer plugin for Cordova.
 */
var MoviePlayer = {
	canPlayType : function(type) {
		return "";
	},

	onCompletion : function(callback) {
		document.addEventListener("movieplayer.oncompletion", callback);
		return {
			callback : callback,
			remove : function() {
				document.removeEventListener(this.callback)
			}
		};
	},

	onError : function(callback) {
		document.addEventListener("movieplayer.onerror", callback);
		return {
			callback : callback,
			remove : function() {
				document.removeEventListener(this.callback)
			}
		};
	},

	load : function(url) {
		return cordova.exec(MoviePlayer.success, MoviePlayer.fail,
				"MoviePlayer", "load", [ url ]);
	},

	play : function(starttime, endtime) {
		return cordova.exec(MoviePlayer.success, MoviePlayer.fail,
				"MoviePlayer", "play", [ starttime, endtime ]);
	},

	pause : function(pause) {
		return cordova.exec(MoviePlayer.success, MoviePlayer.fail,
				"MoviePlayer", "pause", [ pause ]);
	},

	stop : function() {
		return cordova.exec(MoviePlayer.success, MoviePlayer.fail,
				"MoviePlayer", "stop", []);
	},

	setMediatime : function(mediatime) {
		return cordova.exec(MoviePlayer.success, MoviePlayer.fail,
				"MoviePlayer", "setMediatime", [ mediatime ]);
	},

	setRate : function(rate) {
		return cordova.exec(MoviePlayer.success, MoviePlayer.fail,
				"MoviePlayer", "setRate", [ rate ]);
	},

	setVolume : function(volume) {
		return cordova.exec(MoviePlayer.success, MoviePlayer.fail,
				"MoviePlayer", "setVolume", [ volume ]);
	},

	mute : function(mute) {
		return cordova.exec(MoviePlayer.success, MoviePlayer.fail,
				"MoviePlayer", "mute", [ mute ]);
	},

	getStatus : function(success, fail) {
		return cordova.exec(success, fail, "MoviePlayer", "getStatus", []);
	},

	showControls : function(controls) {
		return cordova.exec(MoviePlayer.success, MoviePlayer.fail,
				"MoviePlayer", "showControls", [ controls ]);
	},

	success : function(o) {
		console.error("Success: " + JSON.stringify(o));
	},

	fail : function(o) {
		console.error("Error: " + JSON.stringify(o));
	}
}