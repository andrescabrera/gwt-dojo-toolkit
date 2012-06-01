package gwt.dojo.charting.client;

import gwt.dojo.client.util.JsObject;

/**
 * A base class that is used to build other elements of a chart, such as a
 * series.
 * 
 * @author ggeorg
 */
public class Element extends JsObject {

	@SuppressWarnings("unchecked")
	public static Element create() {
		throw new IllegalArgumentException("no chart");
	};

	public static native Element create(Chart chart) /*-{
		return new $wnd.dojox.charting.Element(chart);
	}-*/;

	protected Element() {
	}

}
