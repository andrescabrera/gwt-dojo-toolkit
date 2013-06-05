/*
 * Copyright 2012 ArkaSoft LLC.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package gwt.dojo.core.client;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

public class JsObject extends JavaScriptObject {

	/**
	 * 
	 * @return
	 */
	public final static JsObject create() {
		return JavaScriptObject.createObject().cast();
	}

	/**
	 * Returns a non-null reference if this {@code jsonString} is really a
	 * JsObject.
	 * 
	 * @param jsonString
	 *            A JSON array to parse.
	 * @param strict
	 *            TODO
	 * @return a reference to a {@code JsObject} if this {@code jsonString} is a
	 *         {@code JsObject} or {@code null} otherwise.
	 * @throws NullPointerException
	 *             if {@code jsonString} is <code>null</code>
	 * @throws IllegalArgumentException
	 *             if {@code jsonString} is empty
	 */
	public static <T extends JsObject> T create(String jsonString,
			boolean strict) {
		JSONValue jsonValue = strict ? JSONParser.parseStrict(jsonString)
				: JSONParser.parseLenient(jsonString);
		JSONObject jsonObject = jsonValue.isObject();
		if (jsonObject != null) {
			return jsonObject.getJavaScriptObject().cast();
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param module
	 * @return
	 */
	public final static <T extends JavaScriptObject> T ref(String module) {
		try {
			return Dojo.require(module);
		} catch (JavaScriptException e) {
			throw new NullPointerException("Undefined module: " + module);
		}
	}

	/**
	 * 
	 * @param module
	 * @return
	 */
	public final static <T extends JsObject> T create(String module) {
		return create(ref(module));
	}

	private final static native <T extends JsObject> T create(
			JavaScriptObject objectRef) /*-{
		return new objectRef();
	}-*/;

	/**
	 * 
	 * @param module
	 * @param options
	 * @return
	 */
	public final static <T extends JsObject> T create(String module,
			JsObject options) {
		return create(ref(module), options);
	}

	private final static native <T extends JsObject> T create(
			JavaScriptObject objectRef, JsObject options) /*-{
		return new objectRef(options || {});
	}-*/;

	/**
	 * 
	 * @param module
	 * @param options
	 * @param nodeRef
	 * @return
	 */
	public final static <T extends JsObject> T create(String module,
			JsObject options, String nodeRef) {
		return create(ref(module), options, nodeRef);
	}

	private final static native <T extends JsObject> T create(
			JavaScriptObject objectRef, JsObject options, String nodeRef) /*-{
		return new objectRef(options || {}, nodeRef);
	}-*/;

	/**
	 * Not directly instantiable.
	 * <p>
	 * All subclasses must also define a protected, empty, no-arg constructor.
	 */
	protected JsObject() {
	}

	// DojoCallback

	public final native void put(String property, DojoCallback<?> callback) /*-{
		var callbackFcn = function() {
			try {
				@gwt.dojo.core.client.Dojo::doDojoCallback(Ljava/lang/Object;Lgwt/dojo/core/client/DojoCallback;Lgwt/dojo/core/client/JsArray;)(this,callback,arguments);
			} catch (e) {
				alert("Callback error: " + e);
			}
		};

		this[property] = callback ? callbackFcn : null;
	}-*/;

	// Object property

	public final native Object get(String property) /*-{
		var value = this[property];
		switch (typeof value) {
		case "object":
		case "undefined":
			return value;
		case "string":
			return String(value);
		case "number":
			return @java.lang.Double::new(D)(value);
		case "boolean":
			return @java.lang.Boolean::new(Z)(value);
		case "function":
			return value;
		default:
			throw new Error("Can't convert value of type: " + typeof value);
		}
	}-*/;

	public final native JsObject put(String property, Object value) /*-{
		this[property] = value;
		return this;
	}-*/;

	// JavaScriptObject property

	public final <T extends JsObject> T getJsObject(String property) {
		return getJavaScriptObject(property);
	}

	public final JsArray getJsArray(String property) {
		return getJavaScriptObject(property);
	}

	public final Element getElement(String property) {
		return getJavaScriptObject(property);
	}

	@SuppressWarnings("unchecked")
	public final <T extends JavaScriptObject> T getJavaScriptObject(
			String property) {
		Object o = get(property);
		return o != null && o instanceof JavaScriptObject ? (T) o : null;
	};

	// String property

	public final String getString(String property) {
		Object o = get(property);
		return o != null && o instanceof String ? (String) o : null;
	}

	// Integer property

	public final native int getInteger(String property) /*-{
		return this[property] || 0;
	}-*/;

	public final native int getInteger(String property, int defaultValue) /*-{
		return this[property] || defaultValue;
	}-*/;

	public final native JsObject put(String property, int value) /*-{
		this[property] = value;
		return this;
	}-*/;

	// Double property

	public final native double getDouble(String property) /*-{
		return this[property] || 0; // TODO change to NaN
	}-*/;

	public final native double getDouble(String property, double defaultValue) /*-{
		return this[property] || defaultValue;
	}-*/;

	public final native JsObject put(String property, double value) /*-{
		this[property] = value;
		return this;
	}-*/;

	// Boolean property

	public final native boolean getBoolean(String property) /*-{
		return Boolean(this[property]);
	}-*/;

	public final native boolean getBoolean(String property, boolean defaultValue) /*-{
		var value = this[property];
		return (typeof value === "boolean") ? value : defaultValue;
	}-*/;

	public final native JsObject put(String property, boolean value) /*-{
		this[property] = value;
		return this;
	}-*/;

	// ---

	public final native boolean isObject(String property) /*-{
		var value = this[property];
		switch (typeof value) {
		case "object":
		case "undefined":
			return true;
		default:
			return false;
		}
	}-*/;

	public final native boolean isString(String property) /*-{
		var value = this[property];
		switch (typeof value) {
		case "string":
			return true;
		default:
			return false;
		}
	}-*/;

	public final native boolean isNumber(String property) /*-{
		var value = this[property];
		switch (typeof value) {
		case "number":
			return true;
		default:
			return false;
		}
	}-*/;

	public final native boolean isBoolean(String property) /*-{
		var value = this[property];
		switch (typeof value) {
		case "number":
			return true;
		default:
			return false;
		}
	}-*/;

	public final native boolean isArray(String property) /*-{
		return typeof this[property] === "object"
				&& this[property] instanceof Array;
	}-*/;

	public final native boolean isNull(String property) /*-{
		return this[property] === null;
	}-*/;

	public final native boolean hasProperty(String property) /*-{
		return (property in this);
	}-*/;

	public final native String typeof(String property) /*-{
		return typeof this[property];
	}-*/;

	public final native boolean isArray() /*-{
		return this instanceof Array;
	}-*/;

	public final native JsArray/* <String> */keys() /*-{
		var keys = [];
		for (property in this) {
			keys.push(property);
		}
		return keys;
	}-*/;

	public final native JsArray/* <String, ?> */entries() /*-{
		var entries = [];
		for (property in this) {
			var entry = {};
			entry[property] = this[property];
			entries.push(entry);
		}
		return entries;
	}-*/;

	// public final native void forEach(JsObjectVisitor visitor) /*-{
	// for (property in this) {
	// visitor.@com.arkasoft.gwt.dojo.client.JsObjectVisitor::visit(Ljava/lang/String;)(property);
	// }
	// }-*/;

	// ---

	/**
	 * Converts a JsObject into a JSON representation that can be used to
	 * communicate with a JSON service.
	 */
	public final String toJson() {
		return new JSONObject(this).toString();
	}

}
