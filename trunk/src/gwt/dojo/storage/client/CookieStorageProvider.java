package gwt.dojo.storage.client;

public class CookieStorageProvider extends StorageProvider {

	public static final String MODULE = "dojox/storage/CookieStorageProvider";

	public static native CookieStorageProvider create() /*-{
		return new $wnd.dojox.storage.CookieStorageProvider();
	}-*/;

	/**
	 * Not directly instantiable (required by JSNI).
	 */
	protected CookieStorageProvider() {
	}
}
