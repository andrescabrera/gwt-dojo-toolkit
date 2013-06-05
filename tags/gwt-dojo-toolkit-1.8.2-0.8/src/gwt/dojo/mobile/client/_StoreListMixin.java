package gwt.dojo.mobile.client;

import gwt.dojo.dijit.client._WidgetBase;

/**
 * Mixin for widgets to generate the list items corresponding to the dojo/store
 * data provider object.
 * <p>
 * By mixing this class into the widgets, the list item nodes are generated as
 * the child nodes of the widget and automatically / regenerated whenever the
 * corresponding data items are modified.
 */
public class _StoreListMixin extends _StoreMixin {

	public static _StoreListMixin cast(IStoreListMixin widget) {
		assert widget instanceof _WidgetBase : "Not a widget";
		return ((_WidgetBase) widget).cast();
	}

	protected _StoreListMixin() {
	}
}
