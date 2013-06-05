/*
 * Copyright 2012 ArkaSoft LLC.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package gwt.dojo.core.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Dojo {
	private static final Logger LOG = Logger.getLogger(Dojo.class.getName());

	public static native void require(JsArray modules) /*-{
		$wnd.require(modules);
	}-*/;

	/**
	 * Load AMD required modules.
	 * 
	 * @param modules
	 *            A list of module identifiers to load before calling callback.
	 * @param callback
	 *            Callback to call when dependencies are loaded.
	 */
	public static native void require(JsArray/* <String> */modules,
			DojoCallback<?> callback) /*-{
		var callbackFcn = function() {
			var _this = this;
			var _arguments = arguments;

			if (modules.indexOf("dojo/ready") == -1) {
				try {
					@gwt.dojo.core.client.Dojo::doDojoCallback(Ljava/lang/Object;Lgwt/dojo/core/client/DojoCallback;Lgwt/dojo/core/client/JsArray;)(_this, callback, _arguments);
				} catch (ex) {
					alert("Error in require callback: " + ex);
				}
			} else {
				var onReadyFcn = function() {
					try {
						@gwt.dojo.core.client.Dojo::doDojoCallback(Ljava/lang/Object;Lgwt/dojo/core/client/DojoCallback;Lgwt/dojo/core/client/JsArray;)(_this, callback, _arguments);
					} catch (ex) {
						alert("Error in require callback: " + ex);
					}
				};
				$wnd.dojo.ready(onReadyFcn);
			}
		};

		$wnd.require(modules, callback ? callbackFcn : null);
	}-*/;

	/**
	 * 
	 * @param module
	 * @return
	 */
	public static native <T extends JavaScriptObject> T require(String module) /*-{
		return $wnd.require(module);
	}-*/;

	/**
	 * 
	 * @param src
	 * @param obj
	 * @return
	 */
	public static native <T extends JavaScriptObject> T mixin(
			JavaScriptObject src, JavaScriptObject obj) /*-{
		return $wnd.dojo.mixin(src, obj);
	}-*/;

	/**
	 * Returns a [JSON](http://json.org) serialization of an object.
	 * <p>
	 * Note that this doesn't check for infinite recursion, so don't do that! It
	 * is recommend that you use dojo/json's stringify function for an lighter
	 * and faster implementation that matches the native JSON API and uses the
	 * native JSON serializer when available.
	 * 
	 * @param obj
	 *            An object to be serialized. Objects may define their own
	 *            serialization via special "__json__" or "json" function
	 *            property. If a specialized serializer has been defined, it
	 *            will be used as a fallback.
	 * @param prettyPrint
	 *            If {@code true}, we indent objects and arrays to make the
	 *            output prettier.
	 * @return A JSON string serialization of the passed-in object.
	 */
	public static native String toJson(JavaScriptObject obj, boolean prettyPrint) /*-{
		return $wnd.dojo.toJson(obj, prettyPrint);
	}-*/;

	/**
	 * TODO
	 * <p>
	 * Note: requires "dojo/_base/connect"
	 * 
	 * @param obj
	 *            The source object for the event function (defaults to
	 *            {@code kernel.global} if {@code null}). If {@code obj} is a
	 *            DOM node, the connection is delegated to use DOM event
	 *            manager.
	 * @param event
	 *            String name of the event function in {@code obj}.
	 * @param context
	 *            The object that method will receive as {@code this}. TODO
	 * @param callback
	 *            The callback function that is fired after event does. The
	 *            callback function receives the same arguments as the event.
	 * @return
	 */
	public static final native ConnectHandle connect(JavaScriptObject obj,
			String event, JavaScriptObject context, ConnectCallback<?> callback) /*-{
		var func = function() {
			callback.@gwt.dojo.core.client.ConnectCallback::callback(Lgwt/dojo/core/client/JsObject;Lgwt/dojo/core/client/JsObject;)(this,arguments);
		};
		return $wnd.dojo.connect(obj, event, context, func);
	}-*/;

	// ------------------------------------------------------------------------
	// Helper methods for callback functions & uncaught exceptions.
	// ------------------------------------------------------------------------

	private static void doDojoCallback(Object context,
			DojoCallback<Object> callback, JsArray arguments) {
		try {
			callback.callback(context, arguments);
		} catch (Throwable t) {
			handleUncaughtException(t);
		}
	}

	private static Object doDojoCallback(Object context,
			DojoGenericCallback<Object, Object> callback, JsArray arguments) {
		try {
			return callback.callback(context, arguments);
		} catch (Throwable t) {
			handleUncaughtException(t);
			return null;
		}
	}

	private static void doCallback(EventCallback callback, JsObject thiz,
			NativeEvent event) {
		try {
			callback.callback(thiz, event);
		} catch (Throwable t) {
			handleUncaughtException(t);
		}
	}

	private static void doCallback(AspectCallback callback, JsArray arguments) {
		try {
			callback.callback(arguments);
		} catch (Throwable t) {
			handleUncaughtException(t);
		}
	}

	private static void doCallback(SubscribeCallback callback, String topic,
			JsArray message) {
		try {
			callback.callback(topic, message);
		} catch (Throwable t) {
			handleUncaughtException(t);
		}
	}

	private static <T> void doCallback(AsyncCallback<T> callback, T result) {
		try {
			callback.onSuccess(result);
		} catch (Throwable t) {
			handleUncaughtException(t);
		}
	}

	private static <T> void doCallback(AsyncCallback<T> callback, String error) {
		try {
			callback.onFailure(new JavaScriptException(error));
		} catch (Throwable t) {
			handleUncaughtException(t);
		}
	}

	private static void doCallback(WatchCallback callback, Stateful source,
			String name, PropertyChangeEvent event) {
		try {
			callback.callback(source, name, event);
		} catch (Throwable t) {
			handleUncaughtException(t);
		}
	}

	private static void handleUncaughtException(Throwable t) {
		UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
		if (handler != null) {
			handler.onUncaughtException(t);
		} else if (LOG.isLoggable(Level.SEVERE)) {
			LOG.log(Level.SEVERE, "Uncaught exception escaped: ", t);
		}
	}

	// ------------------------------------------------------------------------

	/**
	 * Hidden constructor.
	 */
	private Dojo() {
	}

}
