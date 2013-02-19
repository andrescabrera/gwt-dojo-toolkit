package com.rambus.gwt.imerz.client;

import gwt.dojo.core.client.SubscribeCallback;
import gwt.dojo.core.client.SubscribeHandle;

import com.google.gwt.core.client.JavaScriptObject;

public class IMerzAccess extends JavaScriptObject {

	private static native IMerzAccess ref() /*-{
		var imerzAccess = $wnd.IMerzAccess;
		if (imerzAccess) {
			imerzAccess.init();
		}
		return imerzAccess;
	}-*/;

	public static SubscribeHandle subscribe(String topic,
			SubscribeCallback callback) {
		IMerzAccess imerzAccess = ref();
		if (imerzAccess != null) {
			return imerzAccess.subscribeImpl(topic, callback);
		} else {
			throw new NullPointerException("IMerzAccess not found");
		}
	}

	public static void send(String message) {
		IMerzAccess imerzAccess = ref();
		if (imerzAccess != null) {
			imerzAccess.sendImpl(message, null);
		} else {
			throw new NullPointerException("IMerzAccess not found");
		}
	}

	public static void send(String recipient, String message) {
		IMerzAccess imerzAccess = ref();
		if (imerzAccess != null) {
			imerzAccess.sendImpl(message, recipient);
		} else {
			throw new NullPointerException("IMerzAccess not found");
		}
	}

	protected IMerzAccess() {
	}

	public final native SubscribeHandle subscribeImpl(String topic,
			SubscribeCallback callback) /*-{
		var imerzAccess = this;

		var fcn = function(e) {
			var message = [ imerzAccess.decode(e[0]), e[1] ];
			@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/SubscribeCallback;Ljava/lang/String;Lgwt/dojo/core/client/JsArray;)(callback, e.type, message);
		};

		this.subscribe(topic, fcn);

		return {
			topic : topic,
			callback : fcn,
			remove : function() {
				try {
					imerzAccess.unsubscribe(this.topic, this.callback);
				} catch (e) {
					// $wnd.console.error("Success: " + JSON.stringify(o));
				}
			}
		};
	}-*/;

	public final native void sendImpl(String message, String recipient) /*-{
		this.send(message, recipient);
	}-*/;
}
