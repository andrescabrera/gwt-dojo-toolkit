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

import gwt.dojo.dijit.client.ITemplatedMixin;
import gwt.dojo.dijit.client._WidgetController;

/**
 * A grid widget with several scrolling, cell editing, complex rows, sorting,
 * fixed columns, sizable columns, etc.
 * <p>
 * {@code _Grid} provides the full set of grid features without any direct
 * connection to a data store.
 * <p>
 * The grid exposes a get function for the grid, or optionally individual
 * columns, to populate cell contents.
 * 
 * @author ggeorg
 */
public class _Grid extends _WidgetController implements ITemplatedMixin {

	/**
	 * rowCound: Integer (default: 5)
	 * <p>
	 * Number, of rows to display.
	 */
	public static final String ROWCOUNT = "rowCount";

	/**
	 * keepRows: Integer (default: 75)
	 * <p>
	 * Number of rows to keep in the rendering cache.
	 */
	public static final String KEEPROWS = "keepRows";

	/**
	 * rowsPerPage: Integer (default: 25)
	 * <p>
	 * Number of rows to render at a time.
	 */
	public static final String ROWSPERPAGE = "rowsPerPage";

	/**
	 * autoWidth: Boolean (default: false)
	 * <p>
	 * If {@code autoWidth} is {@code true}, grid width is automatically set to
	 * fit the data.
	 */
	public static final String AUTOWIDTH = "autoWidth";

	/**
	 * initialWidth: String (default: "")
	 * <p>
	 * A css string to use to set our initial width (only used if
	 * {@code autoWidth} is {@code true}. The first rendering of the grid will
	 * be this width, any resizing of columns, etc will result in the grid
	 * switching to {@code autoWidth} ode. Note, this width will override any
	 * styling in a stylesheet or directly on the nade.
	 */
	public static final String INITIALWIDTH = "initialWidth";

	/**
	 * autoHeight: Boolean|Integer
	 * <p>
	 * TODO
	 */
	public static final String AUTOHEIGHT = "autoHeight";

	/**
	 * rowHeight: Integer (default: 0)
	 * <p>
	 * If {@code rowHeight} is set to a positive number, it will define the
	 * height of the rows in pixels. This can provide a significant performance
	 * advantage, since it eliminates the need to measure row sizes during
	 * rendering, which is one of the primary bottlenecks in the
	 * {@link DataGrid}'s performance.
	 */
	public static final String ROWHEIGHT = "rowHeight";

	/**
	 * autoRender: Boolean (default: true)
	 * <p>
	 * If {@code autoRender} is {@code true}, grid will render itself after
	 * initialization.
	 */
	public static final String AUTORENDER = "autoRender";

	/**
	 * defaultHeight: String (default: "15em")
	 * <p>
	 * Default height of the grid, measured in any valid css unit.
	 */
	public static final String DEFAULTHEIGHT = "defaultHeight";

	/**
	 * height: String (default: "")
	 * <p>
	 * Explicit height of the grid, measured in any valid css unit. This will be
	 * populated (and overridden) if the height: css attribute exists on the
	 * source node.
	 */
	public static final String HEIGHT = "height";

	/**
	 * structure: TODO
	 * <p>
	 * View layout definition.
	 */
	public static final String STRUCTURE = "structure";

	/**
	 * elasticView: Integer (default: -1)
	 * <p>
	 * Override defaults and make the indexed grid view elastic, thus filling
	 * available horizontal space.
	 */
	public static final String ELEASTICVIEW = "elasticView";

	/**
	 * singleClickEdit: boolean (default: false)
	 * <p>
	 * Single-click starts editing. Default is double-click.
	 */
	public static final String SINGLECLICKEDIT = "singleClickEdit";

	/**
	 * selectionMode: String (default: "extended")
	 * <p>
	 * Set the selection mode of grid's Selection. Value must be 'single',
	 * 'multiple', or 'extended'.
	 */
	public static final String SELECTIONMODE = "selectionMode";

	/**
	 * rowSelector: Boolean|String
	 * <p>
	 * If set to {@code true}, will add a row selector view to this grid. If set
	 * to CSS width, will add a row selector of that width to this grid.
	 */
	public static final String ROWSELECTOR = "rowSelector";

	/**
	 * columnReordering: Boolean (default: false)
	 * <p>
	 * If set to {@code true}, will add drag and drop reordering to views with
	 * one row of columns.
	 */
	public static final String COLUMNREORDERING = "columnReordering";

	/**
	 * headerMenu: dijit.Menu (default: null)
	 * <p>
	 * If set to a {@code dijit.Menu}, will use this as a context menu for the
	 * grid headers.
	 */
	public static final String HEADERMENU = "headerMenu";

	/**
	 * placeholderLabel: String (default: "GridColumns")
	 * <p>
	 * Label of placeholders to search for in the header menu to replace with
	 * column toggling menu items.
	 */
	public static final String PLACEHOLDERLABEL = "placeHolderLabel";

	/**
	 * selectatble: Boolean
	 * <p>
	 * Set to {@code true} if you want to be able to select the text within the
	 * grid.
	 */
	public static final String SELECTABLE = "selectable";

	/**
	 * loadingMessage: String
	 * <p>
	 * Message that shows while the grid is loading.
	 */
	public static final String LOADINGMESSAGE = "loadingMessage";

	/**
	 * errorMessage: String
	 * <p>
	 * Message that shows when the grid encounters an error loading.
	 */
	public static final String ERRORMESSAGE = "errorMessage";

	/**
	 * noDataMessage: String
	 * <p>
	 * Message that shows if the grid has no data - wrap it in a span with class
	 * 'dojoxGridNoData' if you want it to be styled similar to the loading and
	 * error messages.
	 */
	public static final String NODATAMESSAGE = "noDataMessage";

	/**
	 * escapeHTMLInData: Boolean (default: true)
	 * <p>
	 * TODO
	 */
	public static final String ESCAPEHTMLINDATA = "esacpeHTMInData";

	/**
	 * formatterScope: Object (default: null)
	 * <p>
	 * An object to execute format functions within. If not set the format
	 * functions will execute within the scope of the cell that has a format
	 * function.
	 */
	public static final String FORMATTERSCOPE = "formatterScope";

	/**
	 * editable: boolean (default: false)
	 * <p>
	 * Indicates if the grid contains editable cells; set to {@code true} if
	 * editable cell encountered during rendering.
	 */
	public static final String EDITABLE = "editable";

	/**
	 * Default constructor.
	 */
	protected _Grid() {
	}
	
	/**
	 * Update the grid, calls render and subsequently this function.
	 */
	public final native void update() /*-{
		this.update();
	}-*/;

}
