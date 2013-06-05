package gwt.dojo.mobile.client;

import gwt.dojo.core.client.JsObject;

/**
 * An automatic theme loader.
 * <p>
 * This module detects the user agent of the browser and loads the appropriate
 * theme files. It can be enabled by simply requiring dojox/mobile/deviceTheme
 * from your application.
 * @see TODO
 */
public class DeviceTheme extends JsObject {

	/**
	 * Module: {@code dojox/mobile/deviceTheme}.
	 */
	public static final String MODULE = "dojox/mobile/deviceTheme";
	
	/**
	 * Loads the given CSS file programmatically.
	 * 
	 * @param file
	 */
	public static void loadCssFile(String file) {
		DeviceTheme deviceTheme = JsObject.ref(DeviceTheme.MODULE);
		deviceTheme._loadCssFile(file);
	}
	
	/**
	 * A wrapper for require.toUrl to support non-dojo usage.
	 * 
	 * @param path
	 */
	public static String toUrl(String path) {
		DeviceTheme deviceTheme = JsObject.ref(DeviceTheme.MODULE);
		return deviceTheme._toUrl(path);
	}

	/**
	 * JSNI required constructor.
	 */
	protected DeviceTheme() {
	}

	private final native void _loadCssFile(String file) /*-{
		this.loadCssFile(file);
	}-*/;
	
	private final native String _toUrl(String path) /*-{
		return this.toUrl(path);
	}-*/;
}
