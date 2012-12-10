package gwt.dojo.core.client.store;

import gwt.dojo.core.client.JsObject;
import gwt.dojo.core.client.store.api.Store;

public class MemoryStore extends Store {

	public static final String MODULE = "dojo/store/Memory";

	public static native MemoryStore create(JsObject options) /*-{
		try {
			return new $wnd.dojo.store.Memory(options || {});
		} catch (e) {
			alert(e);
		}
	}-*/;

	/**
	 * data: Array (default: null).
	 * <p>
	 * The array of all the objects in the memory store.
	 */
	public static final String DATA = "data";

	/**
	 * idProperty: String (default: "id").
	 * <p>
	 * Indicates the property to use as the identity property. The values of
	 * this property should be unique.
	 */
	public static final String IDPROPERTY = "idProperty";

	protected MemoryStore() {
	}
}
