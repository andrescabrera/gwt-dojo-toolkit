package gwt.dojo.core.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Functions to parse and serialize JSON.
 */
public class JSON extends JsObject {

	public static final String MODULE = "dojo/json";

	/**
	 * Parses a [JSON] (http://json.org) string to return a JavaScript object.
	 * <p>
	 * This function follows [native JSON
	 * API](https://developer.mozilla.org/en/JSON) Throws for invalid JSON
	 * strings. This delegates to eval() if native JSON support is not
	 * available. By default this will evaluate any valid JS expression. With
	 * the strict parameter set to true, the parser will ensure that only valid
	 * JSON strings are parsed (otherwise throwing an error). Without the strict
	 * parameter, the content passed to this method must come from a trusted
	 * source.
	 * 
	 * @param str
	 *            A string literal of a JSON item.
	 * @param strict
	 *            When set to {@code true}, this will ensure that only valid,
	 *            secure JSON is ever parsed. Make sure this is set to
	 *            {@code true} for untrusted content. Note that on
	 *            browsers/engines without native JSON support, setting this to
	 *            {@code true} will run slower.
	 * @return
	 */
	public static <T extends JavaScriptObject> T parse(String str,
			boolean strict) {
		JSON jsonRef = JsObject.ref(JSON.MODULE);
		return jsonRef._parse(str, strict);
	}
	
	/**
	 * Returns a [JSON](http://json.org) serialization of an object. This
	 * function follows [native JSON API](https://developer.mozilla.org/en/JSON)
	 * Note that this doesn't check for infinite recursion, so don't do that!
	 * 
	 * @param value
	 *            A value to be serialized.
	 * @return Returns a [JSON](http://json.org) serialization of an object.
	 */
	public static String stringify(JavaScriptObject value) {
		JSON jsonRef = JsObject.ref(JSON.MODULE);
		return jsonRef._stringify(value, "");
	}
	
	/**
	 * Returns a [JSON](http://json.org) serialization of an object. This
	 * function follows [native JSON API](https://developer.mozilla.org/en/JSON)
	 * Note that this doesn't check for infinite recursion, so don't do that!
	 * 
	 * @param value
	 *            A value to be serialized.
	 * @param spacer
	 *            A spacer string to be used for pretty printing of JSON
	 * @return Returns a [JSON](http://json.org) serialization of an object.
	 */
	public static String stringify(JavaScriptObject value, String spacer) {
		JSON jsonRef = JsObject.ref(JSON.MODULE);
		return jsonRef._stringify(value, spacer);
	}

	protected JSON() {
		// Required by JSNI
	}

	private final native <T extends JavaScriptObject> T _parse(String str,
			boolean strict) /*-{
		return this.parse(str, strict);
	}-*/;

	private final native String _stringify(JavaScriptObject value, String spacer) /*-{
		return this.stringify(value, "", spacer);
	}-*/;
}
