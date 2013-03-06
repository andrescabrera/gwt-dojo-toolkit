package gwt.dojo.mobile.client;

import gwt.dojo.dijit.client.IContained;
import gwt.dojo.dijit.client._WidgetBase;

/**
 * A simple pane widget.
 * <p>
 * Pane is a simple general-purpose pane widget. It is a widget, but can be
 * regarded as a imple {@code <div>} element.
 * <p>
 * {@code baseClass='mblPane'}
 */
public class Pane extends _WidgetBase implements IContained {

	public static final String MODULE = "dojox/mobile/Pane";

	/**
	 * Default constructor.
	 */
	protected Pane() {
		// Required by JSNI.
	}

	/**
	 * Calls resize() of each child widget.
	 */
	public final native void resize() /*-{
		this.resize();
	}-*/;
}
