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

/**
 * Callback to call when a message is published to a topic on the pub/sub hub.
 * 
 * @author ggeorg
 */
public interface SubscribeCallback {
	/**
	 * The callback method to implement by handlers.
	 * 
	 * @param topic
	 *            The topic of the message.
	 * @param message
	 *            The message as a single argument which is an array.
	 */
	void callback(String topic, JsArray message);
}
