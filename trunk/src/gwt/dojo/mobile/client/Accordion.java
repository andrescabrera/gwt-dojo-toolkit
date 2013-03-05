package gwt.dojo.mobile.client;

import gwt.dojo.core.client.JsObject;
import gwt.dojo.dijit.client.IContained;
import gwt.dojo.dijit.client._WidgetBase;

/**
 * A widget for the title of the accordion.
 */
public class Accordion extends _WidgetBase implements IContained {

	public static final String MODULE = "dojox/mobile/Accordion";

	public static Accordion create() {
		return Accordion.create(null);
	}

	public static native Accordion create(JsObject options) /*-{
		return new $wnd.dojox.mobile.Accordion(options || {});
	}-*/;

	protected Accordion() {
	}

}
