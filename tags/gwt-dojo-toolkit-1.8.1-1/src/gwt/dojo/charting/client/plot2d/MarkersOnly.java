package gwt.dojo.charting.client.plot2d;

import gwt.dojo.core.client.Dojo;
import gwt.dojo.core.client.JsObject;

/**
 * A convenience object to draw only markers (like a scatter but not quite).
 * 
 * @author ggeorg
 */
public class MarkersOnly extends Default {
	public static final String MODULE = "dojox/charting/plot2d/MarkersOnly";

	public static JsObject ref() {
		return Dojo.require(MODULE);
	}

	protected MarkersOnly() {
	}
}
