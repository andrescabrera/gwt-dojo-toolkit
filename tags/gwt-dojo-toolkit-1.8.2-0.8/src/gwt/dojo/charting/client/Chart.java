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
package gwt.dojo.charting.client;

import gwt.dojo.core.client.ConnectHandle;
import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;

/**
 * The main chart object in {@code dojox.charting}. This will generate a two
 * dimensional chart based on {@code dojox.gfx}.
 * <p>
 * {@code Chart} is the primary object used for any kind of charts. It is simple
 * to create -- just pass it a node reference, which is used as the container
 * for the chart -- and a set of optional keyword arguments and go.
 * 
 * @author ggeorg
 */
public class Chart extends JsObject {

	public final static String MODULE = "dojox/charting/Chart";

	/**
	 * title: String (null)
	 * <p>
	 * Chart title text.
	 */
	public static final String TITLE = "title";

	/**
	 * titleGap: Number (20)
	 * <p>
	 * Determine the spacing between the title and the chart.
	 */
	public static final String TITLEGAP = "titleGap";

	/**
	 * titlePos: String ("top")
	 * <p>
	 * Determine adding title at the top/bottom of the chart.
	 */
	public static final String TITLEPOS = "titlePos";

	public static final String TITLEFONT = "titleFont";
	public static final String TITLEFONTCOLOR = "titleFontColor";

	protected Chart() {
	}

	/**
	 * Set the theme of the chart.
	 * 
	 * @param theme
	 *            The theme to be used for visual rendering.
	 * @return A reference to the current {@code Chart} for chaining purposes.
	 */
	public final native Chart setTheme(Theme theme) /*-{
		try {
			this.setTheme(theme);
		} catch (e) {
			alert("-1-" + e);
		}
	}-*/;
	
	/**
	 * Add an axis to the chart, for rendering.
	 * 
	 * @param name
	 *            The name of the axis.
	 * @return A reference to the current {@code Chart} for chaining purposes.
	 */
	public final native Chart addAxis(String name) /*-{
		try {
			this.addAxis(name);
		} catch (e) {
			alert("-addChart- : " + e);
		}
	}-*/;

	/**
	 * Add an axis to the chart, for rendering.
	 * 
	 * @param name
	 *            The name of the axis.
	 * @param kwArgs
	 *            An optional keyword arguments object for use in defining
	 *            details of an axis.
	 * @return A reference to the current {@code Chart} for chaining purposes.
	 */
	public final native Chart addAxis(String name, JsObject kwArgs) /*-{
		try {
			this.addAxis(name, kwArgs);
		} catch (e) {
			alert("-2-" + e);
		}
	}-*/;

	/**
	 * Add a new plot to the chart, defined by name and using the optional
	 * keyword arguments object. Note that {@code dojox.charting} assumes the
	 * main plot to be called "default"; if you do not have a plot called
	 * "default" nd attempt to add data series to the chart without specifying
	 * the plot to be rendred on, you WILL get errors.
	 * 
	 * @param name
	 *            The name of the plot to be added to the chart. If you only
	 *            plan on using one plot, call it "default".
	 * @param kwArgs
	 *            An object with optional parameters for the plot in question.
	 * @return A reference to the current {@code Chart} for chaining purposes.
	 */
	public final native Chart addPlot(String name, JsObject kwArgs) /*-{
		try {
			this.addPlot(name, kwArgs);
		} catch (e) {
			alert("-3-" + e);
		}
	}-*/;

	/**
	 * Add a data series to the chart for rendering.
	 * 
	 * @param name
	 * @param data
	 * @return
	 */
	public final native Chart addSeries(String name, JsObject data) /*-{
		try {
			alert(data instanceof Array);
			this.addSeries(name, data);
		} catch (e) {
			alert("-4-" + e);
		}
	}-*/;

	/**
	 * Add a data series to the chart for rendering.
	 * 
	 * @param name
	 *            The name of the data series to be plotted.
	 * @param data
	 *            The array of data (either numbers or objects) that represents
	 *            the data to be drawn.
	 * @return A reference to the current {@code Chart} for chaining purposes.
	 */
	public final native Chart addSeries(String name, JsArray data) /*-{
		try {
			this.addSeries(name, {
				data : data
			}); // XXX
		} catch (e) {
			alert("-4-" + e);
		}
	}-*/;

	/**
	 * Render the chart according to the current information defined. This
	 * should be the last call made when defining/creating a chart, or if data
	 * within the chart has been changed.
	 * 
	 * @return A reference to the current {@code Chart} for chaining purposes.
	 */
	public final native Chart render() /*-{
		try {
			this.render();
		} catch (e) {
			alert("-5-" + e);
		}
	}-*/;
	
	public final native ConnectHandle connectTo() /*-{
	
	}-*/;

}
