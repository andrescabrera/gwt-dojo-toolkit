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
package gwt.dojo.mobile.client;

import gwt.dojo.client.util.JsObject;
import gwt.dojo.dijit.client._WidgetBase;

/**
 * Mixin for widgets to generate the list items corresponding to the data
 * provider object.
 * <p>
 * By mixin this class into widgets, the list item nodes are generated as the
 * child nodes of the widget and automatically re-generated whenever the
 * corresponding data items are modified.
 * 
 * @author ggeorg
 */
public class _DataListMixin extends JsObject {

	public static _DataListMixin cast(IDataListMixin widget) {
		assert widget instanceof _WidgetBase : "Not a widget";
		return ((_WidgetBase) widget).cast();
	}

	protected _DataListMixin() {
	}
}
