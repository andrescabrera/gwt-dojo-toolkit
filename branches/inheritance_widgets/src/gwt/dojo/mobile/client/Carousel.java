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

/**
 * A carousel widget that manages a list of images.
 * 
 * @author ggeorg
 */
public class Carousel extends _WidgetBase implements IContainer, IContained {

	public static final String MODULE = "dojox/mobile/Carousel";

	public static native Carousel create() /*-{
		return new $wnd.dojox.mobile.Carousel();
	}-*/;

	/**
	 * numVisible: Number (3)
	 * <p>
	 * The number of visible items.
	 */
	public static final String NUMVISIBLE = "numVisible";

	/**
	 * title: String
	 * <p>
	 * A title of the carousel to be displayed on the title bar.
	 */
	public static final String TITLE = "title";

	/**
	 * pageIndicator: Boolean (true)
	 * <p>
	 * If {@code true}, a page indicator, a series of small dots that indicate
	 * the current page, is displayed on the title bar.
	 */
	public static final String PAGEINDICATOR = "pageIndicator";

	/**
	 * navButton: Boolean (false)
	 * <p>
	 * If {@code true}, navigation buttons are displyaed on the title bar.
	 */
	public static final String NAVBUTTON = "navButton";

	/**
	 * height: String ("300px")
	 * <p>
	 * Explicitly specified height of the widget (ex. "300px"). If "inherit" is
	 * specified, the height is inherited from its offset parent.
	 */
	public static final String HEIGHT = "height";

	/**
	 * store: Object
	 * <p>
	 * Reference to data provider object used by this widget.
	 */
	public static final String STORE = "store";

	/**
	 * query: Object
	 * <p>
	 * A query that can be passed to 'store' to initially filter the items.
	 */
	public static final String QUERY = "query";

	/**
	 * queryOptions: Object
	 * <p>
	 * An optional parameter for the query.
	 */
	public static final String QUERYOPTIONS = "queryOptions";

	/**
	 * Not directly instantiable. All subclasses must also define a protected,
	 * empty, no-arg constructor.
	 */
	protected Carousel() {
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
	
	public final native void refresh() /*-{
		this.refresh();
	}-*/;

}
