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


/**
 * Provides aspect oriented programming functionality, allowing for one to add
 * before, around, or after advice on existing methods.
 * 
 * @author ggeorg
 */
public class Aspect extends JsObject {
	public static final String MODULE = "dojo/aspect";

	/**
	 * Return instance of {@code Aspect} class.
	 * 
	 * @return {@code Aspect} instance.
	 */
	public static Aspect ref() {
		return Dojo.require(MODULE);
	}

	/**
	 * Not directly instantiable.
	 */
	protected Aspect() {
	}

	/**
	 * Attach an "after" advice to a method. The {@link AspectCallback} will be
	 * executed after the original method is executed.
	 * 
	 * @param target
	 * @param methodName
	 * @param callback
	 * @return
	 */
	public final AspectHandle after(JsObject target, String methodName,
			AspectCallback callback) {
		return after(target, methodName, callback, false);
	}

	/**
	 * Attach an "after" advice to a method. The {@link AspectCallback} will be
	 * executed after the original method is executed.
	 * 
	 * @param target
	 * @param methodName
	 * @param callback
	 * @param receiveArguments
	 * @return
	 */
	public final native AspectHandle after(JsObject target, String methodName,
			AspectCallback callback, boolean receiveArguments) /*-{
		var func = function() {
			try {
				@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/AspectCallback;Lgwt/dojo/core/client/JsObject;Lgwt/dojo/core/client/JsArray;)(callback,arguments);
			} catch (ex) {
				alert("Error in aspect callback: " + ex);
			}
		};
		return this.after(target, methodName, func);
	}-*/;

	/**
	 * Attach a "before" advice to a method. The {@link AspectCallback} will be
	 * executed before the original method is executed.
	 * 
	 * @param target
	 * @param methodName
	 * @param callback
	 * @return
	 */
	public final native AspectHandle before(JsObject target, String methodName,
			AspectCallback callback) /*-{
		var func = function() {
			try {
				@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/AspectCallback;Lgwt/dojo/core/client/JsObject;Lgwt/dojo/core/client/JsArray;)(callback,arguments);
			} catch (ex) {
				alert("Error in aspect callback: " + ex);
			}
		};
		return this.before(target, methodName, func);
	}-*/;

	/**
	 * TODO
	 * 
	 * @param target
	 * @param methodName
	 * @param callback
	 * @return
	 */
	public final native AspectHandle around(JsObject target, String methodName,
			AspectCallback callback) /*-{
		var func = function() {
			try {
				@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/AspectCallback;Lgwt/dojo/core/client/JsObject;Lgwt/dojo/core/client/JsArray;)(callback,arguments);
			} catch (ex) {
				alert("Error in aspect callback: " + ex);
			}
		};
		return this.around(target, methodName, func);
	}-*/;

}
