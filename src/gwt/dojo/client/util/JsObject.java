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
package gwt.dojo.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public class JsObject extends JavaScriptObject {

	public static JsObject cast(JavaScriptObject obj) {
		return obj.cast();
	}

	public static JsObject create() {
		return JavaScriptObject.createObject().cast();
	};

	public static JsObject create(String property, Object value) {
		return create().put(property, value);
	};

	public static JsObject create(String property, JavaScriptObject value) {
		return create().put(property, value);
	};

	public static JsObject create(String property, JsObject value) {
		return create().put(property, value);
	};

	public static JsObject create(String property, String value) {
		return create().put(property, value);
	};

	public static JsObject create(String property, int value) {
		return create().put(property, value);
	};

	public static JsObject create(String property, double value) {
		return create().put(property, value);
	};

	public static JsObject create(String property, boolean value) {
		return create().put(property, value);
	};

	/**
	 * Not directly instantiable. All subclasses must also define a protected,
	 * empty, no-arg constructor.
	 */
	protected JsObject() {
	}

	// Object property

	public final native Object get(String property) /*-{
		return this[property] || null;
	}-*/;

	public final native JsObject put(String property, Object value) /*-{
		this[property] = value;
		return this;
	}-*/;

	// JavaScriptObject property

	@SuppressWarnings("unchecked")
	public final <T extends JavaScriptObject> T getJavaScriptObject(
			String property) {
		Object o = get(property);
		return o != null && o instanceof JavaScriptObject ? (T) o : null;
	};

	public final native JsObject put(String property, JavaScriptObject value) /*-{
		this[property] = value;
		return this;
	}-*/;

	// JsObject property

	@SuppressWarnings("unchecked")
	public final <T extends JsObject> T getJsObject(String property) {
		Object o = get(property);
		return o != null && o instanceof JavaScriptObject ? (T) o : null;
	};

	public final native JsObject put(String property, JsObject value) /*-{
		this[property] = value;
		return this;
	}-*/;

	// JavaScriptObject property

	@SuppressWarnings("unchecked")
	public final <T extends Element> T getElement(String property) {
		Object o = get(property);
		return o != null && o instanceof Element ? (T) o : null;
	};

	public final native JsObject put(String property, Element value) /*-{
		this[property] = value;
		return this;
	}-*/;

	// String property

	public final String getString(String property) {
		Object o = get(property);
		return o != null && o instanceof String ? (String) o : null;
	}

	public final native JsObject put(String property, String value) /*-{
		this[property] = value;
		return this;
	}-*/;

	// Integer property

	public final native int getInteger(String property, int defaultValue) /*-{
		return this[property] || defaultValue;
	}-*/;

	public final native JsObject put(String property, int value) /*-{
		this[property] = value;
		return this;
	}-*/;

	// Double property

	public final native double getDouble(String property, double defaultValue) /*-{
		return this[property] || defaultValue;
	}-*/;

	public final native JsObject put(String property, double value) /*-{
		this[property] = value;
		return this;
	}-*/;

	// Boolean property

	public final native boolean getBoolean(String property, boolean defaultValue) /*-{
		return this[property] || defaultValue;
	}-*/;

	public final native JsObject put(String property, boolean value) /*-{
		this[property] = value;
		return this;
	}-*/;

	// ---

	public final native boolean isNull(String property) /*-{
		return this[property] === null;
	}-*/;

	public final native boolean hasProperty(String property) /*-{
		return !(typeof this[property] === "undefined");
	}-*/;

	public final native String typeof(String property) /*-{
		return typeof this[property];
	}-*/;

	public final native boolean isArray(String property) /*-{
		return typeof this[property] === "object"
				&& this[property] instanceof Array;
	}-*/;

	public final native boolean isArray() /*-{
		return this instanceof Array;
	}-*/;

}
