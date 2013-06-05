/*
 * Copyright 2012, 2013 ArkaSoft LLC.
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
package gwt.dojo.core.client._base;

import gwt.dojo.core.client.DojoCallback;
import gwt.dojo.core.client.DojoGenericCallback;
import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;

/**
 * Provides enhancements to native {@link JsArray} functions which may not be
 * available.
 */
public class Array extends JsObject {

	/**
	 * Module: "dojo/_base/array".
	 */
	public static final String MODULE = "dojo/_base/array";

	/**
	 * Locates the first index of the provided value in the passed array. If the
	 * value is not found, -1 is returned.
	 * <p>
	 * This method corresponds to the JavaScript 1.6 Array.indexOf method, with
	 * one difference: when run over sparse arrays, the Dojo function invokes
	 * the callback for every index whereas JavaScript 1.6's indexOf skips the
	 * holes in the sparse array. For details on this method, see:
	 * 
	 * <pre>
	 * https://developer.mozilla.org/en/Core_JavaScript_1.5_Reference/Objects/Array/indexOf
	 * </pre>
	 * 
	 * @return The first index of the provided value in the passed array,
	 *         {@code -1} if the value is not found.
	 */
	public static final int indexOf(JsArray arr, Object object) {
		Array arrayRef = JsObject.ref(Array.MODULE);
		return arrayRef._indexOf(arr, object, 0, false);
	}

	/**
	 * Locates the first index of the provided value in the passed array. If the
	 * value is not found, -1 is returned.
	 * <p>
	 * This method corresponds to the JavaScript 1.6 Array.indexOf method, with
	 * one difference: when run over sparse arrays, the Dojo function invokes
	 * the callback for every index whereas JavaScript 1.6's indexOf skips the
	 * holes in the sparse array. For details on this method, see:
	 * 
	 * <pre>
	 * https://developer.mozilla.org/en/Core_JavaScript_1.5_Reference/Objects/Array/indexOf
	 * </pre>
	 * 
	 * @return The first index of the provided value in the passed array,
	 *         {@code -1} if the value is not found.
	 */
	public static final int indexOf(JsArray arr, Object object, int fromIndex) {
		Array arrayRef = JsObject.ref(Array.MODULE);
		return arrayRef._indexOf(arr, object, fromIndex, false);
	}

	/**
	 * Locates the first index of the provided value in the passed array. If the
	 * value is not found, -1 is returned.
	 * <p>
	 * This method corresponds to the JavaScript 1.6 Array.indexOf method, with
	 * one difference: when run over sparse arrays, the Dojo function invokes
	 * the callback for every index whereas JavaScript 1.6's indexOf skips the
	 * holes in the sparse array. For details on this method, see:
	 * 
	 * <pre>
	 * https://developer.mozilla.org/en/Core_JavaScript_1.5_Reference/Objects/Array/indexOf
	 * </pre>
	 * 
	 * @return The first index of the provided value in the passed array,
	 *         {@code -1} if the value is not found.
	 */
	public static final int indexOf(JsArray arr, Object object, int fromIndex,
			boolean findLast) {
		Array arrayRef = JsObject.ref(Array.MODULE);
		return arrayRef._indexOf(arr, object, fromIndex, findLast);
	}

	/**
	 * Locates the last index of the provided value in the passed array. If the
	 * value is not found, -1 is returned.
	 * <p>
	 * This method corresponds to the JavaScript 1.6 Array.lastIndexOf method,
	 * with one difference: when run over sparse arrays, the Dojo function
	 * invokes the callback for every index whereas JavaScript 1.6's lastIndexOf
	 * skips the holes in the sparse array. For details on this method, see:
	 * 
	 * <pre>
	 * https://developer.mozilla.org/en/Core_JavaScript_1.5_Reference/Objects/Array/lastIndexOf
	 * </pre>
	 * 
	 * @param arr
	 * @param object
	 * @return The last index of the provided value in the passed array,
	 *         {@code -1} if the value is not found.
	 */
	public static final int lastIndexOf(JsArray arr, Object object) {
		Array arrayRef = JsObject.ref(Array.MODULE);
		return arrayRef._lastIndexOf(arr, object, 0);
	}

	/**
	 * Locates the last index of the provided value in the passed array. If the
	 * value is not found, -1 is returned.
	 * <p>
	 * This method corresponds to the JavaScript 1.6 Array.lastIndexOf method,
	 * with one difference: when run over sparse arrays, the Dojo function
	 * invokes the callback for every index whereas JavaScript 1.6's lastIndexOf
	 * skips the holes in the sparse array. For details on this method, see:
	 * 
	 * <pre>
	 * https://developer.mozilla.org/en/Core_JavaScript_1.5_Reference/Objects/Array/lastIndexOf
	 * </pre>
	 * 
	 * @param arr
	 * @param object
	 * @param fromIndex
	 * @return The first last of the provided value in the passed array,
	 *         {@code -1} if the value is not found.
	 */
	public static final int lastIndexOf(JsArray arr, Object object,
			int fromIndex) {
		Array arrayRef = JsObject.ref(Array.MODULE);
		return arrayRef._lastIndexOf(arr, object, fromIndex);
	}

	/**
	 * For every item in arr, callback is invoked. Return values are ignored. If
	 * you want to break out of the loop, consider using array.every() or
	 * array.some(). forEach does not allow breaking out of the loop over the
	 * items in arr.
	 * 
	 * @param arr
	 * @param callback
	 */
	public static final void forEach(JsArray arr, DojoCallback<JsArray> callback) {
		Array arrayRef = JsObject.ref(Array.MODULE);
		arrayRef._forEach(arr, callback, arr);
	}

	/**
	 * For every item in arr, callback is invoked. Return values are ignored. If
	 * you want to break out of the loop, consider using array.every() or
	 * array.some(). forEach does not allow breaking out of the loop over the
	 * items in arr.
	 * 
	 * @param arr
	 * @param callback
	 */
	public static final <T> void forEach(JsArray arr, DojoCallback<T> callback,
			T thisObject) {
		Array arrayRef = JsObject.ref(Array.MODULE);
		arrayRef._forEach(arr, callback, thisObject);
	}

	public static final <T, V> JsArray map(JsArray arr,
			DojoGenericCallback<T, V> callback, T thisObject) {
		Array arrayRef = JsObject.ref(Array.MODULE);
		return arrayRef._map(arr, callback, thisObject);
	}

	/**
	 * Not directly instantiable.
	 * <p>
	 * All subclasses must also define a protected, empty, no-arg constructor.
	 */
	protected Array() {
	}

	private final native int _indexOf(JsArray arr, Object object,
			int fromIndex, boolean findLast) /*-{
		return this.indexOf(arr, object, fromIndex, findLast);
	}-*/;

	private final native int _lastIndexOf(JsArray arr, Object object,
			int fromIndex) /*-{
		return this.lastIndexOf(arr, object, fromIndex);
	}-*/;

	private final native <T> void _forEach(JsArray arr,
			DojoCallback<T> callback, T thisObject) /*-{
		var callbackFcn = function() {
			try {
				@gwt.dojo.core.client.Dojo::doDojoCallback(Ljava/lang/Object;Lgwt/dojo/core/client/DojoCallback;Lgwt/dojo/core/client/JsArray;)(this,callback,arguments);
			} catch (e) {
				alert("Error in forEach: " + e);
			}
		};
		this.forEach(arr, callback ? callbackFcn : null, thisObject);
	}-*/;

	private final native <T, V> JsArray _map(JsArray arr,
			DojoGenericCallback<T, V> callback, T thisObject) /*-{
		var callbackFcn = function() {
			try {
				return @gwt.dojo.core.client.Dojo::doDojoCallback(Ljava/lang/Object;Lgwt/dojo/core/client/DojoGenericCallback;Lgwt/dojo/core/client/JsArray;)(this,callback,arguments);
			} catch (e) {
				alert("Error in map: " + e);
				return null;
			}
		};
		return this.map(arr, callback ? callbackFcn : null, thisObject);
	}-*/;

}
