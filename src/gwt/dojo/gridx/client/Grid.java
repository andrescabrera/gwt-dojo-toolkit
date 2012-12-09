package gwt.dojo.gridx.client;

import gwt.dojo.core.client.JsObject;
import gwt.dojo.dijit.client._WidgetBase;

public class Grid extends _WidgetBase {

	public static final String MODULE = "gridx/Grid";

	public static Grid create() {
		return Grid.create(null);
	}

	public static native Grid create(JsObject options) /*-{
		try {
			return new $wnd.gridx.Grid(options || {});
		} catch (e) {
			alert(e);
		}
	}-*/;

	protected Grid() {
	}
}
