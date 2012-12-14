package gwt.dojo.core.client.store;

import gwt.dojo.core.client.Dojo;
import gwt.dojo.core.client.store.api.Store;

/**
 * The observable {@link Store} wrapper takes a store and stes an observable
 * method on results that can be used to monitor results for changes.
 * <p>
 * TODO Example:
 */
public class ObservableStore extends Store {

	public static final String MODULE = "dojo/store/Observable";
	
	private static final ObservableStore ref() {
		return Dojo.require(MODULE);
	}
	
	public static final ObservableStore create(Store store) {
		return ref()._create(store);
	}

	protected ObservableStore() {}
	
	private final native ObservableStore _create(Store store) /*-{
		return this(store);
	}-*/;
	
}
