package gwt.dojo.charting.client.plot2d;

import gwt.dojo.client.Dojo;
import gwt.dojo.client.util.JsObject;

/**
 * A plot representing bubbles. Note that data for Bubbles requires 3
 * parameters, in the form of: { x, y, size }, where size determines the size of
 * the bubble.
 * 
 * @author ggeorg
 */
public class Bubble extends Base {
	public static final String MODULE = "dojox/charting/plot2d/Bubble";

	public static JsObject ref() {
		return Dojo.require(MODULE);
	}

	protected Bubble() {
	}

}
