package com.rambus.gwt.imerz.client;

import gwt.dojo.core.client.EventCallback;
import gwt.dojo.core.client.EventHandle;

public class Cordova {

	public static native EventHandle onDeviceReady(EventCallback callback) /*-{
		var onDeviceReady = function(e) {
			@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/EventCallback;Lgwt/dojo/core/client/JsObject;Lcom/google/gwt/dom/client/NativeEvent;)(callback, this, e);
		};

		$wnd.document.addEventListener("deviceready", onDeviceReady, false);

		return {
			callback : onDeviceReady,
			remove : function() {
				$wnd.document.removeEventListener("deviceready", this.callback,
						false);
			}
		};
	}-*/;

	public static native EventHandle onPause(EventCallback callback) /*-{
		var onDeviceReady = function(e) {
			@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/EventCallback;Lgwt/dojo/core/client/JsObject;Lcom/google/gwt/dom/client/NativeEvent;)(callback, this, e);
		};

		$wnd.document.addEventListener("pause", onDeviceReady, false);

		return {
			callback : onDeviceReady,
			remove : function() {
				$wnd.document
						.removeEventListener("pause", this.callback, false);
			}
		};
	}-*/;

	public static native EventHandle onResume(EventCallback callback) /*-{
		var onDeviceReady = function(e) {
			@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/EventCallback;Lgwt/dojo/core/client/JsObject;Lcom/google/gwt/dom/client/NativeEvent;)(callback, this, e);
		};

		$wnd.document.addEventListener("resume", onDeviceReady, false);

		return {
			callback : onDeviceReady,
			remove : function() {
				$wnd.document.removeEventListener("resume", this.callback,
						false);
			}
		};
	}-*/;

	public static native EventHandle setOnOrientationChange(
			EventCallback callback) /*-{
		var onOrientationChange = function(e) {
			@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/EventCallback;Lgwt/dojo/core/client/JsObject;Lcom/google/gwt/dom/client/NativeEvent;)(callback, this, e);
		};

		if ($wnd.onorientationchange !== undefined) {
			$wnd.top.onorientationchange = callback ? onOrientationChange
					: null;
		} else {
			$wnd.top.onresize = callback ? onOrientationChange : null;
		}
	}-*/;

	public static native int getOrientation() /*-{
		return $wnd.top.orientation;
	}-*/;
}
