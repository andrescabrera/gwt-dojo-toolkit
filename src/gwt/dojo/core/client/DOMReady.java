package gwt.dojo.core.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Is an AMD loaded plugin that will wait until the DOM has finished loading
 * before returning.
 */
public class DOMReady extends JavaScriptObject {

	public static final String MODULE = "dojo/domReady!";

	protected DOMReady() {
	}
}
