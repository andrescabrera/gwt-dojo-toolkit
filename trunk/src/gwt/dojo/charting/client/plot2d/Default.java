package gwt.dojo.charting.client.plot2d;

import gwt.dojo.charting.client.Chart;
import gwt.dojo.client.util.JsObject;

public class Default extends Base {

	public static native Default create(Chart chart) /*-{
		return new $wnd.dojox.charting.plot2d.Default(chart);
	}-*/;

	public static native Default create(Chart chart, JsObject kwArgs) /*-{
		return new $wnd.dojox.charting.plot2d.Default(chart, kwArgs);
	}-*/;

	protected Default() {
	}

}
