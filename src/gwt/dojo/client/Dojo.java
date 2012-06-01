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
package gwt.dojo.client;

import gwt.dojo.client.util.JsArray;
import gwt.dojo.client.util.JsObject;

import com.google.gwt.core.client.JavaScriptObject;

public class Dojo {

	public static native void require(JsArray modules) /*-{
		$wnd.require(modules);
	}-*/;

	/**
	 * Load AMD required modules.
	 * 
	 * @param dependencies
	 *            A list of module identifiers to load before calling callback.
	 * @param callback
	 *            Callback to call when dependencies are loaded.
	 */
	public static native void require(JsArray/* <String> */dependencies,
			RequireCallback callback) /*-{
		var func = function() {
			if (typeof $wnd.dojo.ready === 'undefined') {
				callback.@gwt.dojo.client.RequireCallback::callback(Lgwt/dojo/client/util/JsObject;)(arguments);
			} else {
				var _arguments = arguments;
				$wnd.dojo.ready(function() {
					callback.@gwt.dojo.client.RequireCallback::callback(Lgwt/dojo/client/util/JsObject;)(_arguments);
				});
			}
		};
		$wnd.require(dependencies, func);
	}-*/;
	
	/**
	 * 
	 * @param dependency
	 * @return
	 */
	public static native JsObject require(String dependency) /*-{
		return $wnd.require(dependency);
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
			callback.@gwt.dojo.client.ConnectCallback::callback(Lgwt/dojo/client/util/JsObject;Lgwt/dojo/client/util/JsObject;)(this,arguments);
		};
		return $wnd.dojo.connect(obj, event, context, func);
	}-*/;

	/**
	 * Publishes a message to a topic on the pub/sub hub.
	 * <p>
	 * Requires: "dojo/topic"
	 * 
	 * @param topic
	 *            The name of the topic to publish to.
	 * @param event
	 *            An event to distribute to the listeners.
	 */
	public static native void publish(String topic, Object event) /*-{
		$wnd.dojo.publish(topic, event);
	}-*/;

	/**
	 * Subscribes to topic on the pub/sub hub.
	 * <p>
	 * Note: "dojo/topic"
	 * 
	 * @param topic
	 *            The topic to subscribe to.
	 * @param callback
	 *            A function callback to call when a message is published to the
	 *            given topic.
	 */
	public static native SubscribeHandle subscribe(String topic,
			SubscribeCallback callback) /*-{
		var func = function(event) {
			var data = {
				topic : topic,
				event : event
			};
			callback.@gwt.dojo.client.SubscribeCallback::callback(Lgwt/dojo/client/util/JsObject;Lgwt/dojo/client/TopicEvent;)(this,data);
		};
		return $wnd.dojo.subscribe(topic, func);
	}-*/;

	private Dojo() {
		// hidden constructor
	}

}
