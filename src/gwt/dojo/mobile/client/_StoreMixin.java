/*
 * Copyright 2013 ArkaSoft LLC.
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

import gwt.dojo.core.client.JsObject;
import gwt.dojo.dijit.client._WidgetBase;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Mixin for widgets to enable dojo/store data store.
 * <p>
 * By mixing this class into widget , it can get data through a dojo/store data
 * store.
 */
public class _StoreMixin extends JavaScriptObject {

	public static _StoreMixin cast(IStoreMixin widget) {
		assert widget instanceof _WidgetBase : "Not a widget";
		return ((_WidgetBase) widget).cast();
	}

	protected _StoreMixin() {
	}

	/**
	 * Sets the store to use with this widget.
	 * 
	 * @param store
	 * @param query
	 * @param queryOptions
	 */
	public final native void setStore(JsObject store, JsObject query,
			JsObject queryOptions) /*-{
		this.setStore(store, query, queryOptions);
	}-*/;

	// TODO setQuery

	/**
	 * Fetches the data and generates the list items.
	 */
	public final native void refresh() /*-{
		this.refresh();
	}-*/;
}
