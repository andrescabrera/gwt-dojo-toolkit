package gwt.dojo.store.client;

import gwt.dojo.core.client.JsObject;
import gwt.dojo.store.client.api.Store;

public class MemoryStore extends JsObject implements Store {

	public static final String MODULE = "dojo/store/Memory";
	
	public static native MemoryStore create(JsObject options) /*-{
		try {
			return new $wnd.dojo.store.Memory(options)
		} catch (e) {
			alert(e);
		}
	}-*/;
	
	protected MemoryStore() {
	}
}
