package gwt.dojo.storage.client;

import gwt.dojo.core.client.Dojo;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A singleton class in charge of the dojox.storage system.
 * <p>
 * Initializes the storage systems and figures out the best available storage
 * options on this platform.
 */
public class StorageManager extends JavaScriptObject {

	public static final String MODULE = "dojox/storage/manager";

	/**
	 * Return instance of {@code MessageHub} class.
	 * 
	 * @return {@code MessageHub} instance.
	 */
	private static StorageManager ref() {
		return Dojo.require(MODULE);
	}

	/**
	 * Not directly instantiable (required by JSNI).
	 */
	protected StorageManager() {
	}

	/**
	 * Initializes the storage system and autodetects the best storage provider
	 * we can provide on this platform.
	 */
	public static void initialize() {
		ref()._initialize();
	}

	private final native void _initialize() /*-{
		this.initialize();
	}-*/;

	/**
	 * Gets the current provider.
	 * 
	 * @return the current provider.
	 */
	public static StorageProvider getProvider() {
		return ref()._getProvider();
	}

	private final native StorageProvider _getProvider() /*-{
		return this.getProvider();
	}-*/;
}
