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

public class JsArray extends JavaScriptObject {

	public static <T extends JsArray> T create() {
		return JavaScriptObject.createArray().cast();
	};

	public static JsArray create(Object... objs) {
		JsArray result = JavaScriptObject.createArray().cast();
		if (objs != null) {
			for (int i = 0; i < objs.length; i++) {
				result.push(objs[i]);
			}
		}
		return result;
	};

	public static JsArray create(double... numbers) {
		JsArray result = JavaScriptObject.createArray().cast();
		if (numbers != null) {
			for (int i = 0; i < numbers.length; i++) {
				result.push(numbers[i]);
			}
		}
		return result;
	};
	
	public static JsArray create(String... strings) {
		JsArray result = JavaScriptObject.createArray().cast();
		if (strings != null) {
			for (int i = 0; i < strings.length; i++) {
				result.push(strings[i]);
			}
		}
		return result;
	};

	public static <T extends JsArray> T cast(JavaScriptObject array) {
		return array.cast();
	}

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

	public final String getString(int index) {
		Object o = get(index);
		return o != null && o instanceof String ? (String) o : null;
	}

	public final native JsArray set(int index, String value) /*-{
		this[index] = value;
		return this;
	}-*/;

	public final native JsArray push(String value) /*-{
		this[this.length] = value;
		return this;
	}-*/;

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

	public final native double getDouble(int index, double defaultValue) /*-{
		return this[index] || defaultValue;
	}-*/;

	public final native JsArray set(int index, double value) /*-{
		this[index] = value;
		return this;
	}-*/;

	public final native JsArray push(double value) /*-{
		this[this.length] = value;
		return this;
	}-*/;

	// Boolean property

	public final native boolean getBoolean(int index, boolean defaultValue) /*-{
		return this[index] || defaultValue;
	}-*/;

	public final native JsArray set(int index, boolean value) /*-{
		this[index] = value;
		return this;
	}-*/;

	public final native JsArray push(boolean value) /*-{
		this[this.length] = value;
		return this;
	}-*/;

	// ---

	/**
	 * Gets the length of the array.
	 * 
	 * @return the array length
	 */
	public final native int length() /*-{
		return this.length;
	}-*/;

	/**
	 * Reset the length of the array.
	 * 
	 * @param newLength
	 *            the new length of the array
	 */
	public final native void setLength(int newLength) /*-{
		this.length = newLength;
	}-*/;

}
