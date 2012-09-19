package gwt.dojo.storage.client;

import gwt.dojo.client.util.JsArray;
import gwt.dojo.client.util.JsObject;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A singleton for working with dojox.storage.
 * <p>
 * dojox.storage exposes the current available storage provider on this
 * platform. It gives you methods such as dojox.storage.put(),
 * dojox.storage.get(), etc.
 */
public class StorageProvider extends JavaScriptObject {

	/**
	 * Flag that indicates a put() call to a storage provider was successful.
	 */
	public static final String FLAG_SUCCESS = "success";

	/**
	 * Flag that indicates a put() call to a storage provider failed.
	 */
	public static final String FLAG_FAILED = "failed";

	/**
	 * Flag that indicates a put() call to a storage provider is pending user
	 * approval.
	 */
	public static final String FLAG_PENDING = "pending";

	/**
	 * Not directly instantiable (required by JSNI).
	 */
	protected StorageProvider() {
	}

	/**
	 * Allows this storage provider to initialize itself. This is called after
	 * the page has finished loading, so you can not do document.writes().
	 * Storage Provider subclasses should initialize themselves inside of here
	 * rather than in their function constructor.
	 */
	public final native void initialize() /*-{
		try {
			this.initialize();
		} catch (e) {
			alert(e);
		}
	}-*/;

	/**
	 * Puts a key and value into this storage system.
	 * 
	 * @param key
	 *            A string key to use when retrieving this value in the future.
	 * @param value
	 *            A value to store.
	 * @param resultsHandler
	 *            A callback handler that will receive thress arguments. The
	 *            first argument is one of three values: dojox.storage.SUCCESS,
	 *            dojox.storage.SUCCESS, dojox.storage.FAILED, or
	 *            dojox.storage.PENDING; these values determine how the put
	 *            request went. In some storage systems users can deny a storage
	 *            request, resulting in a dojox.storage.FAILED, while in other
	 *            storage systems a storage request must wait for user approval,
	 *            resulting in a dojox.storage.PENDING status until the request
	 *            is either approved or denied, resulting in another call back
	 *            with dojox.storage.SUCCESS. The second argument in the call
	 *            back is the key name that was being stored. The third argument
	 *            in the call back is an optional message that details possible
	 *            error messages that might have occurred during the storage
	 *            process.
	 */
	public final native void put(String key, JsObject value,
			ResultsHandler resultsHandler) /*-{
		var func = function(flag, key) {
			resultsHandler.@gwt.dojo.storage.client.ResultsHandler::callback(Ljava/lang/String;Ljava/lang/String;)(flag, key);
		}
		this.put(key, value, func);
	}-*/;

	/**
	 * Puts a key and value into this storage system.
	 * 
	 * @param key
	 *            A string key to use when retrieving this value in the future.
	 * @param value
	 *            A value to store.
	 * @param resultsHandler
	 *            A callback handler that will receive thress arguments. The
	 *            first argument is one of three values: dojox.storage.SUCCESS,
	 *            dojox.storage.SUCCESS, dojox.storage.FAILED, or
	 *            dojox.storage.PENDING; these values determine how the put
	 *            request went. In some storage systems users can deny a storage
	 *            request, resulting in a dojox.storage.FAILED, while in other
	 *            storage systems a storage request must wait for user approval,
	 *            resulting in a dojox.storage.PENDING status until the request
	 *            is either approved or denied, resulting in another call back
	 *            with dojox.storage.SUCCESS. The second argument in the call
	 *            back is the key name that was being stored. The third argument
	 *            in the call back is an optional message that details possible
	 *            error messages that might have occurred during the storage
	 *            process.
	 * @param namespace
	 *            Optional string namespace that this value will be placed into;
	 *            if left off, the value will be placed into
	 *            dojox.storage.DEFAULT_NAMESPACE
	 */
	public final native void put(String key, JsObject value,
			ResultsHandler resultsHandler, String namespace) /*-{
		var func = function(flag, key, event) {
			resultsHandler.@gwt.dojo.storage.client.ResultsHandler::callback(Ljava/lang/String;Ljava/lang/String;)(flag, key);
		}
		this.put(key, value, func, namespace);
	}-*/;

	/**
	 * Gets the value with the given key. Returns null if this key is not in the
	 * storage system.
	 * 
	 * @param key
	 *            A string key to get the value of.
	 * @return Any object; {@code null} if the key is not present
	 */
	public final native JsObject get(String key) /*-{
		return this.get(key);
	}-*/;

	/**
	 * Gets the value with the given key. Returns null if this key is not in the
	 * storage system.
	 * 
	 * @param key
	 *            A string key to get the value of.
	 * @param namespace
	 *            Optional string namespace that this value will be retrieved
	 *            from; if left off, the value will be retrieved from
	 *            dojox.storage.DEFAULT_NAMESPACE
	 * @return Any object; {@code null} if the key is not present
	 */
	public final native JsObject get(String key, String namespace) /*-{
		return this.get(key, namespace);
	}-*/;

	/**
	 * Determines whether the storage has the given key.
	 * 
	 * @param key
	 * @param namespace
	 * @return
	 */
	public final native boolean hasKey(String key, String namespace) /*-{
		return this.hasKey(key, namespace);
	}-*/;

	/**
	 * Enumerates all of the available keys in this storage system.
	 * 
	 * @return Array of available keys
	 */
	public final String[] getKeys() {
		JsArray _keys = this._getKeys();
		if (_keys != null) {
			int n = _keys.length();
			String[] keys = new String[n];
			for (int i = 0; i < n; i++) {
				keys[i] = _keys.getString(i);
			}
			return keys;
		} else {
			return new String[0];
		}
	};

	private final native JsArray _getKeys() /*-{
		return this.getKeys();
	}-*/;

	/**
	 * Completely clears this storage system of all of it's values and keys. If
	 * 'namespace' is provided just clears the keys in that namespace.
	 * 
	 * @param namespace
	 */
	public final native void clear(String namespace) /*-{
		return this.clear(namespace);
	}-*/;

	/**
	 * Removes the given key from this storage system.
	 * 
	 * @param key
	 * @param namespace
	 */
	public final native void remove(String key, String namespace) /*-{
		return this.remove(key, namespace);
	}-*/;

	public final String[] getNamespaces() {
		JsArray _namespaces = this._getNamespaces();
		if (_namespaces != null) {
			int n = _namespaces.length();
			String[] namespaces = new String[n];
			for (int i = 0; i < n; i++) {
				namespaces[i] = _namespaces.getString(i);
			}
			return namespaces;
		} else {
			return new String[0];
		}
	};

	private final native JsArray _getNamespaces() /*-{
		return this.getNamespaces();
	}-*/;

	/**
	 * Returns whether this storage provider's values are persisted when this
	 * platform is shutdown.
	 * 
	 * @return
	 */
	public final native boolean isPermanent() /*-{
		return this.isPermanent();
	}-*/;

	public final native boolean isValidKey(String key) /*-{
		return this.isValidKey(key);
	}-*/;

	// TODO multiple

}
