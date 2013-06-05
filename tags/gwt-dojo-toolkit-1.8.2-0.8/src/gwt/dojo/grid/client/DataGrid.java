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
package gwt.dojo.grid.client;

import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;

public class DataGrid extends _Grid {

	public static final String MODULE = "dojox/grid/DataGrid";

	public static native DataGrid create(String id, JsObject store, JsArray structure, String rowSelector) /*-{
		try {
			var params = {id: id, store: store, structure: structure, rowSelector: rowSelector};
			return new $wnd.dojox.grid.DataGrid(params);
		} catch(e) {
			alert(e);
			return null;
		}
	}-*/;

	protected DataGrid() {
	}

}
