package gwt.dojo.storage.client;

public class LocalStorageProvider extends StorageProvider {

	public static final String MODULE = "dojox/storage/LocalStorageProvider";

	public static native LocalStorageProvider create() /*-{
		return new $wnd.dojox.storage.LocalStorageProvider();
	}-*/;

	/**
	 * Not directly instantiable (required by JSNI).
	 */
	protected LocalStorageProvider() {
	}
	
}
