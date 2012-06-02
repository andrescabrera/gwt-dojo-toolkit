package gwt.dojo.mobile.app.client;

import gwt.dojo.client.Dojo;
import gwt.dojo.client.RequireCallback;
import gwt.dojo.client.util.JsArray;
import gwt.dojo.client.util.JsObject;
import gwt.dojo.mobile.client.Parser;

import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main implements EntryPoint, RequireCallback {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// Load the widget parser and mobile base
		Dojo.require(JsArray.create("dojox/mobile/parser",
				"dojox/mobile/deviceTheme", "dojox/mobile/compat",
				"dojox/mobile"), this);
	}

	@Override
	public void callback(JsObject arguments) {
		// Parse the page for widgets!
		Parser.get().parse();
	}
}
