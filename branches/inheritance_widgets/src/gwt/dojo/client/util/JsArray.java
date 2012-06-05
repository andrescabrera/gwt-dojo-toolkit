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
import com.google.gwt.core.client.JsArrayMixed;

public class JsArray extends JsArrayMixed {

	public static JsArray cast(JavaScriptObject array) {
		return array.cast();
	}

	public static JsArray create() {
		return JavaScriptObject.createArray().cast();
	};

	public static JsArray create(Object... values) {
		JsArray result = JavaScriptObject.createArray().cast();
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				result.push(values[i]);
			}
		}
		return result;
	};

	public static JsArray create(double... values) {
		JsArray result = JavaScriptObject.createArray().cast();
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				result.push(values[i]);
			}
		}
		return result;
	};

	public static JsArray create(String... valuess) {
		JsArray result = JavaScriptObject.createArray().cast();
		if (valuess != null) {
			for (int i = 0; i < valuess.length; i++) {
				result.push(valuess[i]);
			}
		}
		return result;
	};

	public static JsArray create(boolean... values) {
		JsArray result = JavaScriptObject.createArray().cast();
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				result.push(values[i]);
			}
		}
		return result;
	};

	/**
	 * Not directly instantiable. All subclasses must also define a protected,
	 * empty, no-arg constructor.
	 */
	protected JsArray() {
	}

	// Object entry

	public final native Object get(int index) /*-{
		return this[index];
	}-*/;

	public final native JsArray set(int index, Object value) /*-{
		this[index] = value;
		return this;
	}-*/;

	public final native JsArray push(Object value) /*-{
		this[this.length] = value;
		return this;
	}-*/;

	// JsObject entry

	@SuppressWarnings("unchecked")
	public final <T extends JsObject> T getJsObject(int index) {
		Object o = get(index);
		return o != null && o instanceof JavaScriptObject ? (T) o : null;
	}

	public final native JsArray set(int index, JsObject value) /*-{
		this[index] = value;
		return this;
	}-*/;

	public final native JsArray push(JsObject value) /*-{
		this[this.length] = value;
		return this;
	}-*/;

	// String entry

	// Integer property

	public final native int getInteger(int index, int defaultValue) /*-{
		return this[index] || defaultValue;
	}-*/;

	public final native JsArray set(int index, int value) /*-{
		this[index] = value;
		return this;
	}-*/;

	public final native JsArray push(int value) /*-{
		this[this.length] = value;
		return this;
	}-*/;

	// Double property

	public final double getDouble(int index) {
		return super.getNumber(index);
	};

	public final native double getDouble(int index, double defaultValue) /*-{
		return this[index] || defaultValue;
	}-*/;

	// Boolean property

	public final native boolean getBoolean(int index, boolean defaultValue) /*-{
		return this[index] || defaultValue;
	}-*/;

}
