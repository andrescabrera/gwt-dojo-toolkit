package gwt.dojo.core.client.store;

import gwt.dojo.core.client.JsObject;
import gwt.dojo.core.client.store.api.Store;

/**
 * This is an adapter for using Dojo Dta stores with an object store consumer.
 * You can provide a Dojo data store and use this adapter to interact with it
 * through the Dojo object store API.
 */
public class DataStore extends Store {

	/**
	 * Module reference.
	 */
	public static final String MODULE = "dojo/store/DataStore";

	/**
	 * Create a new {@code DataStore} instance.
	 * 
	 * @return {@code DataStore} instance.
	 */
	public static DataStore create(JsObject options) {
		return create(MODULE, options);
	}
	
	/**
	 * store:
	 * <p>
	 * The object store to convert to a data store.
	 */
	public static final String STORE = "store";
	
	/**
	 * idProperty: String (default: "id").
	 * <p>
	 * Indicates the property to use as the identity property. The values of
	 * this property should be unique.
	 */
	public static final String IDPROPERTY = "idProperty";
	
	// TODO queryEngine
	
	protected DataStore() {}

}
