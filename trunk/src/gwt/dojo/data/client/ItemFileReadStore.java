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
package gwt.dojo.data.client;

import gwt.dojo.core.client.JsObject;
import gwt.dojo.core.client.Stateful;

public class ItemFileReadStore extends Stateful {

	public static final String MODULE = "dojo/data/ItemFileReadStore";

	public static native ItemFileReadStore create() /*-{
		try {
			return new $wnd.dojo.data.ItemFileReadStore();
		} catch (e) {
			alert(e);
		}
	}-*/;

	public static native ItemFileReadStore create(JsObject data) /*-{
		try {
			return new $wnd.dojo.data.ItemFileReadStore({
				data : data
			});
		} catch (e) {
			alert(e);
		}
	}-*/;

	protected ItemFileReadStore() {
	}

}
