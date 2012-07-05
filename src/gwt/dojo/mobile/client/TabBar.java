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
import gwt.dojo.dijit.client.IContained;
import gwt.dojo.dijit.client.IContainer;
import gwt.dojo.dijit.client._WidgetBase;

public class TabBar extends _WidgetBase implements IContainer, IContained {

	public static final String MODULE = "dojox/mobile/TabBar";

	public static native TabBar create() /*-{
		return new $wnd.dojox.mobile.TabBar();
	}-*/;

	public static native TabBar create(JsObject params) /*-{
		return new $wnd.dojox.mobile.TabBar(params);
	}-*/;

	/**
	 * iconBase: String
	 * <p>
	 * The default icon path for child items.
	 */
	public static final String ICONBASE = "iconBase";

	/**
	 * iconPos: String
	 * <p>
	 * The default icon position for child items.
	 */
	public static final String ICONPOS = "iconPos";

	/**
	 * barType: String
	 * <p>
	 * "tabBar"(default) or "segmentedControl".
	 */
	public static final String BARTYPE = "barType";

	protected TabBar() {
	}

}
