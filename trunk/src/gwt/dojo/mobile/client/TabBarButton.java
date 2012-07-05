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

/**
 * A button widget that is placed in the {@link TabBar} widget.
 * 
 * @author ggeorg
 */
public class TabBarButton extends _ItemBase {

	public static final String MODULE = "dojox/mobile/TabBarButton";

	public static native TabBarButton create() /*-{
		return new $wnd.dojox.mobile.TabBarButton();
	}-*/;

	/**
	 * icon1: String
	 * <p>
	 * A path for the unselected (typically dark) icon. If icon is not
	 * specified, the iconBase parameter of the parent widget is used.
	 */
	public static final String ICON1 = "icon1";

	/**
	 * icon2: String
	 * <p>
	 * A path for the selected (typically highlight) icon. If icon is not
	 * specified, the iconBase parameter of the parent widget or icon1 is used.
	 */
	public static final String ICON2 = "icon2";

	/**
	 * iconPos1: String
	 * <p>
	 * The position of an aggregated unselected (typically dark) icon. IconPos1
	 * is comma separated values like top,left,width,height (ex. "0,0,29,29").
	 * If iconPos1 is not specified, the iconPos parameter of the parent widget
	 * is used.
	 */
	public static final String ICONPOS1 = "iconPos1";

	/**
	 * iconPos2: String
	 * <p>
	 * The position of an aggregated selected (typically highlight) icon.
	 * IconPos2 is comma separated values like top,left,width,height (ex.
	 * "0,0,29,29"). If iconPos2 is not specified, the iconPos parameter of the
	 * parent widget or iconPos1 is used.
	 */
	public static final String ICONPOS2 = "iconPos2";

	/**
	 * selected: Boolean
	 * <p>
	 * If true, the button is in the selected status.
	 */
	public static final String SELECTED = "selected";

	protected TabBarButton() {
	}

}
