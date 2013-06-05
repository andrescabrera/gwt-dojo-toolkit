/*
 * Copyright 2012, 2013 ArkaSoft LLC.
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

import gwt.dojo.dijit.client.IContained;
import gwt.dojo.dijit.client.IContainer;
import gwt.dojo.dijit.client._WidgetBase;

/**
 * A rounded rectangle list.
 * <p>
 * {@code RoundRectList} is a rounded rectangle list, which can be used to
 * display a group of items. Each item must be a {@link ListItem}.
 */
public class RoundRectList extends _WidgetBase implements IContainer,
		IContained {

	/**
	 * Module: {@code dojox/mobile/RoundRectList}.
	 */
	public static final String MODULE = "dojox/mobile/RoundRectList";

	/**
	 * transition: String (default: "slide")
	 * <p>
	 * The default animated transition effect for child items.
	 */
	public static final String TRANSITION = "transition";

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
	 * select: String (default: "")
	 * <p>
	 * Selection mode of the list. The check mark is shown for the selected list
	 * item(s). The value can be "single", "multiple", or "". If "single", there
	 * can be only one selected item at a time. If "multiple", there can be
	 * multiple selected items at a time. If "", the check mark is not shown.
	 */
	public static final String SELECT = "select";

	/**
	 * stateful: Boolean
	 * <p>
	 * If {@code true}, the last selected item remains highlighted.
	 */
	public static final String STATEFUL = "stateful";

	/**
	 * syncWithViews: Boolean
	 * <p>
	 * If {@code true}, this widget listens to view transition events to be
	 * synchronized with view's visibility.
	 */
	public static final String SYNCWITHVIEWS = "syncWithViews";

	/**
	 * editable: Boolean
	 * <p>
	 * If {@code true}, the list can be reordered.
	 */
	public static final String EDITABLE = "editable";

	/**
	 * JSNI required constructor.
	 */
	protected RoundRectList() {
	}

	/**
	 * Deselects the given item.
	 * 
	 * @param item
	 *            The item to deselect.
	 */
	public final native void deselectItem(ListItem item) /*-{
		this.deselectItem(item);
	}-*/;

	/**
	 * Deselects all the items.
	 */
	public final native void deselectAll() /*-{
		this.deselectAll();
	}-*/;

	/**
	 * Selects the given item.
	 * 
	 * @param item
	 *            The given item to select.
	 */
	public final native void selectItem(ListItem item) /*-{
		this.selectItem(item);
	}-*/;

}
