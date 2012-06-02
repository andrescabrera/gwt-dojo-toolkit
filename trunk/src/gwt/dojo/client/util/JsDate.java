package gwt.dojo.client.util;

import com.google.gwt.core.client.JavaScriptObject;

public class JsDate extends com.google.gwt.core.client.JsDate {

	public static JsDate cast(JavaScriptObject obj) {
		return obj.cast();
	}

	/**
	 * Not directly instantiable. All subclasses must also define a protected,
	 * empty, no-arg constructor.
	 */
	protected JsDate() {
	}

}
