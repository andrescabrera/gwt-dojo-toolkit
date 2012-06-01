package gwt.dojo.charting.client.plot2d;

import gwt.dojo.charting.client.Chart;
import gwt.dojo.client.util.JsObject;

public class Stacked extends Default {

	public static native Stacked create(Chart chart) /*-{
		return new $wnd.dojox.charting.plot2d.Stacked(chart);
	}-*/;

	public static native Stacked create(Chart chart, JsObject kwArgs) /*-{
		return new $wnd.dojox.charting.plot2d.Stacked(chart, kwArgs);
	}-*/;

	protected Stacked() {
	}

}
