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
 * A carousel widget that manages a list of images.
 * <p>
 * The carousel widget manages a list of images that can be displayed
 * horizontally, and allows the user to scroll through the list and select a
 * single item.
 */
public class Carousel extends _WidgetBase implements IContainer, IContained {

	public static final String MODULE = "dojox/mobile/Carousel";

	public static final String TOPIC_CAROUSEL_SELECT = "/dojox/mobile/carouselSelect";

	/**
	 * numVisible: Number (default: 2)
	 * <p>
	 * The number of visible items.
	 */
	public static final String NUMVISIBLE = "numVisible";

	/**
	 * itemWidth: Number (default: 0)
	 * <p>
	 * The number of visible items (=numVisible) is determined by (carousel
	 * width / itemWidth). If itemWidth is specified, numVisible is
	 * automatically calculated. If resize() is called, numVisible is
	 * recalculated and the layout is changed accordingly.
	 */
	public static final String ITEMWIDTH = "itemWidth";

	/**
	 * title: String (default: "")
	 * <p>
	 * A title of the carousel to be displayed on the title bar.
	 */
	public static final String TITLE = "title";

	/**
	 * pageIndicator: Boolean (default: true)
	 * <p>
	 * If {@code true}, a page indicator, a series of small dots that indicate
	 * the current page, is displayed on the title bar.
	 */
	public static final String PAGEINDICATOR = "pageIndicator";

	/**
	 * navButton: Boolean (default: false)
	 * <p>
	 * If {@code true}, navigation buttons are displayed on the title bar.
	 */
	public static final String NAVBUTTON = "navButton";

	/**
	 * height: String
	 * <p>
	 * Explicitly specified height of the widget (ex. "300px"). If "inherit" is
	 * specified, the height is inherited from its offset parent.
	 */
	public static final String HEIGHT = "height";

	/**
	 * selectable: Boolean (default: true)
	 * <p>
	 * If true, an item can be selected by clicking it.
	 */
	public static final String SELECTABLE = "selectable";

	/**
	 * Not directly instantiable. All subclasses must also define a protected,
	 * empty, no-arg constructor.
	 */
	protected Carousel() {
	}

	/**
	 * Returns the index of a given item widget.
	 * 
	 * @return The index of a given item widget.
	 */
	public final native int getIndexByItemWidget(_WidgetBase widget) /*-{
		return this.getIndexByItemWidget(widget);
	}-*/;

	/**
	 * Resizes the child items of the carousel.
	 */
	public final native void resizeItems() /*-{
		this.resizeItems();
	}-*/;

	public final native void resize() /*-{
		this.resize();
	}-*/;

	/**
	 * Select the given widget.
	 * 
	 * @param index
	 */
	public final native void select(int index) /*-{
		this.select(index);
	}-*/;

	/**
	 * Select the given widget.
	 * 
	 * @param itemWidget
	 */
	public final native void select(_WidgetBase itemWidget) /*-{
		this.select(itemWidget);
	}-*/;

}
