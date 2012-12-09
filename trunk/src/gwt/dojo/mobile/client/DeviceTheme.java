package gwt.dojo.mobile.client;

import gwt.dojo.core.client.Dojo;
import gwt.dojo.core.client.JsObject;

public class DeviceTheme extends JsObject {
	
	public static final String MODULE = "dojox/mobile/deviceTheme";

	/**
	 * Return instance of {@code DeviceTheme} class.
	 * 
	 * @return {@code DeviceTheme} instance.
	 */
	private static DeviceTheme ref() {
		return Dojo.require(MODULE);
	}
	
	protected DeviceTheme() {
		// Required by JSNI
	}
	
	/**
	 * Loads the given CSS file programmatically.
	 * 
	 * @param file
	 */
	public static void loadCssFile(String file) {
		ref()._loadCssFile(file);
	}

	private final native void _loadCssFile(String file) /*-{
		this.loadCssFile(file);
	}-*/;
}
