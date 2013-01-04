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


/**
 * The callback to execute when a property changes.
 * 
 * @author ggeorg
 */
public interface WatchCallback {

	/**
	 * 
	 * @param source
	 * @param name
	 * @param event
	 */
	void callback(JsObject source, String name,
			PropertyChangeEvent event);

}