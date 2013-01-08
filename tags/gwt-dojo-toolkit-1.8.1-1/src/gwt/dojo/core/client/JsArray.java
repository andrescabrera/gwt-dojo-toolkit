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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;

public class JsArray extends JavaScriptObject {
	
	public static JsArray create() {
		return JavaScriptObject.createArray().cast();
	}
	
	public static JsArray create(Object... values) {
		return JsArray.create().push(values);
	}
	
	public static JsArray create(int... values) {
		return JsArray.create().push(values);
	}
	
	public static JsArray create(double... values) {
		return JsArray.create().push(values);
	}
	
	public static JsArray create(boolean... values) {
		return JsArray.create().push(values);
	}

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

	public final JsArray push(Object... values) {
		JsArray result = this;
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				this.push(values[i]);
			}
		}
		return result;
	}

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
	
	public final JsArray push(JsObject... values) {
		JsArray result = this;
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				this.push(values[i]);
			}
		}
		return result;
	}

	// String entry

	public final native String getString(int index) /*-{
		return String(this[index]);
	}-*/;

	public final native JsArray set(int index, String value) /*-{
		this[index] = value;
		return this;
	}-*/;

	public final native JsArray push(String value) /*-{
		this[this.length] = value;
		return this;
	}-*/;
	
	public final JsArray push(String... values) {
		JsArray result = this;
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				this.push(values[i]);
			}
		}
		return result;
	}

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
	
	public final JsArray push(int... values) {
		JsArray result = this;
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				this.push(values[i]);
			}
		}
		return result;
	}

	// Double property

	public final native double getDouble(int index) /*-{
		return Number(this[index]);
	}-*/;

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
	
	public final JsArray push(double... values) {
		JsArray result = this;
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				this.push(values[i]);
			}
		}
		return result;
	}

	// Boolean property

	public final native boolean getBoolean(int index) /*-{
		return Boolean(this[index]);
	}-*/;

	public final native boolean getBoolean(int index, boolean defaultValue) /*-{
		return this[index] || defaultValue;
	}-*/;

	public final native void set(int index, boolean value) /*-{
		this[index] = value;
	}-*/;

	public final native JsArray push(boolean value) /*-{
		this[this.length] = value;
		return this;
	}-*/;
	
	public final JsArray push(boolean... values) {
		JsArray result = this;
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				this.push(values[i]);
			}
		}
		return result;
	}

	/**
	 * Converts a JsObject into a JSON representation that can be used to
	 * communicate with a JSON service.
	 */
	public final String toJson() {
		return new JSONArray(this).toString();
	}

	/**
	 * Convert each element of the array to a String and join them with a comma
	 * separator. The value returned from this method may vary between browsers
	 * based on how JavaScript values are converted into strings.
	 */
	public final String join() {
		// As per JS spec
		return join(",");
	}

	/**
	 * Convert each element of the array to a String and join them with a comma
	 * separator. The value returned from this method may vary between browsers
	 * based on how JavaScript values are converted into strings.
	 */
	public final native String join(String separator) /*-{
		return this.join(separator);
	}-*/;

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
	
	// ------------------------------------------------------------------------
	
	  /**
	   * Shifts the first value off the array.
	   * 
	   * @return the shifted boolean
	   */
	  public final native boolean shiftBoolean() /*-{
	    return Boolean(this.shift());
	  }-*/;

	  /**
	   * Shifts the first value off the array.
	   * 
	   * @return the shifted double
	   */
	  public final native double shiftNumber() /*-{
	    return Number(this.shift());
	  }-*/;

	  /**
	   * Shifts the first value off the array.
	   * 
	   * @return the shifted {@link JavaScriptObject}
	   */
	  public final native <T extends JavaScriptObject> T shiftObject() /*-{
	    return Object(this.shift());
	  }-*/;

	  /**
	   * Shifts the first value off the array.
	   * 
	   * @return the shifted String
	   */
	  public final native String shiftString() /*-{
	    return String(this.shift());
	  }-*/;

	  /**
	   * Shifts a boolean onto the beginning of the array.
	   * 
	   * @param value the value to the stored
	   */
	  public final native void unshift(boolean value) /*-{
	    this.unshift(value);
	  }-*/;

	  /**
	   * Shifts a double onto the beginning of the array.
	   * 
	   * @param value the value to store
	   */
	  public final native void unshift(double value) /*-{
	    this.unshift(value);
	  }-*/;

	  /**
	   * Shifts a {@link JavaScriptObject} onto the beginning of the array.
	   * 
	   * @param value the value to store
	   */
	  public final native void unshift(JavaScriptObject value) /*-{
	    this.unshift(value);
	  }-*/;

	  /**
	   * Shifts a String onto the beginning of the array.
	   * 
	   * @param value the value to store
	   */
	  public final native void unshift(String value) /*-{
	    this.unshift(value);
	  }-*/;


}
