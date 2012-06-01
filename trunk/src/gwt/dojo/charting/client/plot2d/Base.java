package gwt.dojo.charting.client.plot2d;

import gwt.dojo.charting.client.Element;

public class Base extends Element {
	
	protected Base() {
	}
	
	/**
	 * Clear out all of the information tied to this plot.
	 * 
	 * @return A reference to this plot for chaining purposes.
	 */
	public final native <T extends Base> T clear() /*-{
		return this.clear();
	}-*/;

}
