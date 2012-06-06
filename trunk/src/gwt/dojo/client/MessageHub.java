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

import com.google.gwt.core.client.JavaScriptObject;

import gwt.dojo.client.util.JsArray;
import gwt.dojo.client.util.JsObject;

/**
 * A centralized hub for publishing and subscribing to global messages by topic.
 * One can subscribe to the messages by using {@code subscribe()}, and one can
 * publish by using {@link #publish(String, Object...)}.
 * 
 * @author ggeorg
 */
public class MessageHub extends JsObject {
	public static final String MODULE = "dojo/topic";

	/**
	 * Return instance of {@code MessageHub} class.
	 * 
	 * @return {@code MessageHub} instance.
	 */
	public static MessageHub ref() {
		return Dojo.require(MODULE);
	}

	/**
	 * Not directly instantiable.
	 */
	protected MessageHub() {
	}

	/**
	 * Publishes a message to a topic on the pub/sub hub. All arguments after
	 * the first will be passed to the subscribers, so any number of arguments
	 * can be provided (not just event).
	 * 
	 * @param topic
	 *            The name of the topic to publish to.
	 * @param message
	 *            A message to distribute to the topic listeners.
	 */
	public final void publish(String topic, Object... message) {
		JsArray args = JavaScriptObject.createArray().cast();
		if (message != null) {
			for (int i = 0, n = message.length; i < n; i++) {
				args.push(message[i]);
			}
		}
		this.publish(topic, args);
	};

	private final native void publish(String topic, JsArray args) /*-{
		this.publish(topic, args);
	}-*/;

	/**
	 * Subscribes to a topic on the pub/sub hub.
	 * 
	 * @param topic
	 *            The topic to subscribe to.
	 * @param callback
	 *            A callback to call when a message is published to the given
	 *            topic.
	 * @return A simple object containing a {@code remove()} method, which can
	 *         be called to unsubscribe the listener.
	 */
	public final native SubscribeHandle subscribe(String topic,
			SubscribeCallback callback) /*-{
		var func = function(message) {
			callback.@gwt.dojo.client.SubscribeCallback::callback(Ljava/lang/String;Lgwt/dojo/client/util/JsObject;)(topic, message);
		}
		return this.subscribe(topic, func);
	}-*/;
}
