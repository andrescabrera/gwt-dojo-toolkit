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

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A centralized hub for publishing and subscribing to global messages by topic.
 * One can subscribe to the messages by using {@code subscribe()}, and one can
 * publish by using {@link #publish(String, Object...)}.
 */
public class MessageHub extends JsObject {
	public static final String MODULE = "dojo/topic";

	/**
	 * Return instance of {@code MessageHub} class.
	 * 
	 * @return {@code MessageHub} instance.
	 */
	private static MessageHub ref() {
		return Dojo.require(MODULE);
	}

	/**
	 * Not directly instantiable (required by JSNI).
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
	public static void publish(String topic, Object... message) {
		JsArray args = JavaScriptObject.createArray().cast();
		if (message != null) {
			for (int i = 0, n = message.length; i < n; i++) {
				args.push(message[i]);
			}
		}
		ref()._publish(topic, args);
	};

	private final native void _publish(String topic, JsArray a) /*-{
		switch (a.length) {
		case 0:
			this.publish(topic);
			break;
		case 1:
			this.publish(topic, a[0]);
			break;
		case 2:
			this.publish(topic, a[0], a[1]);
			break;
		case 3:
			this.publish(topic, a[0], a[1], a[2]);
			break;
		case 4:
			this.publish(topic, a[0], a[1], a[2], a[3]);
			break;
		case 5:
			this.publish(topic, a[0], a[1], a[2], a[3], a[4]);
			break;
		case 6:
			this.publish(topic, a[0], a[1], a[2], a[3], a[4], a[5]);
			break;
		case 7:
			this.publish(topic, a[0], a[1], a[2], a[3], a[4], a[5], a[6]);
			break;
		case 8:
			this.publish(topic, a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7]);
			break;
		default:
			throw "Too many args";
		}
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
	public static SubscribeHandle subscribe(String topic,
			SubscribeCallback callback) {
		return ref()._subscribe(topic, callback);
	}

	private final native SubscribeHandle _subscribe(String topic,
			SubscribeCallback callback) /*-{
		var func = function() {
			try {
				@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/SubscribeCallback;Ljava/lang/String;Lgwt/dojo/core/client/JsArray;)(callback, topic, arguments);
			} catch (ex) {
				alert("Error in subscribe callback");
			}
		}
		return this.subscribe(topic, func);
	}-*/;
}
