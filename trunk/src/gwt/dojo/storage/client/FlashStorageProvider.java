package gwt.dojo.storage.client;

public class FlashStorageProvider extends StorageProvider {

	public static final String MODULE = "dojox/storage/FlashStorageProvider";

	public static native FlashStorageProvider create() /*-{
		return new $wnd.dojox.storage.FlashStorageProvider();
	}-*/;

	/**
	 * Not directly instantiable (required by JSNI).
	 */
	protected FlashStorageProvider() {
	}

}
