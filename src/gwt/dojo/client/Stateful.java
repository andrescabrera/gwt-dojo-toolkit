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
package gwt.dojo.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

import gwt.dojo.client.util.JsObject;

/**
 * Base class for objects that provide named properties with optional
 * getter/setter control and the ability to watch for property changes.
 * 
 * @author ggeorg
 */
public class Stateful extends JsObject {

	public static final String MODULE = "dojo/Stateful";

	public static native Stateful create() /*-{
		return new $wnd.dojo.Stateful();
	}-*/;

	/**
	 * Not directly instantiable. All subclasses must also define a protected,
	 * empty, no-arg constructor.
	 */
	protected Stateful() {
	}

	// Object property

	public final native Stateful set(String property, Object value) /*-{
		this.set(property, value);
		return this;
	}-*/;

	// JavaScriptObject property

	public final native JsObject set(String property, JavaScriptObject value) /*-{
		this.set(property, value);
		return this;
	}-*/;

	// JsObject property

	public final native JsObject set(String property, JsObject value) /*-{
		this.set(property, value);
		return this;
	}-*/;
	
	// JavaScriptObject property

	public final native JsObject set(String property, Element value) /*-{
		this.set(property, value);
		return this;
	}-*/;

	// String property

	public final native Stateful set(String property, String value) /*-{
		this.set(property, value);
		return this;
	}-*/;

	// Integer property

	public final native Stateful set(String property, int value) /*-{
		this.set(property, value);
		return this;
	}-*/;

	// Double property

	public final native Stateful set(String property, double value) /*-{
		this.set(property, value);
		return this;
	}-*/;

	// Boolean property

	public final native Stateful set(String property, boolean value) /*-{
		this.set(property, value);
		return this;
	}-*/;

	// ---

	/**
	 * Watches a property for changes.
	 * 
	 * @param name
	 *            The property to watch.
	 * @param callback
	 *            The callback interface to execute when the property changes.
	 *            This will be called after the property has been changed.
	 * @return An object handle for the watch. The {@link WatchHandle#unwatch()}
	 *         method of this object can be used to discontinue watching this
	 *         property.
	 */
	public final native WatchHandle watch(String name, WatchCallback callback) /*-{
		var func = function(name, oldValue, newValue) {
			var event = {
				oldValue : oldValue,
				newValue : newValue
			};
			callback.@gwt.dojo.client.WatchCallback::callback(Lgwt/dojo/client/util/JsObject;Ljava/lang/String;Lgwt/dojo/client/PropertyChangeEvent;)(this, name, event);
		};
		this.watch(name, func);
	}-*/;

	/**
	 * Watches all properties for changes.
	 * 
	 * @param callback
	 *            The callback interface to execute when a property changes.
	 *            This will be called after a property has been changed.
	 * @return An object handle for the watch. The {@link WatchHandle#unwatch()}
	 *         method of this object can be used to discontinue watching all
	 *         properties.
	 */
	public final native WatchHandle watch(WatchCallback callback) /*-{
		var func = function(name, oldValue, newValue) {
			var event = {
				oldValue : oldValue,
				newValue : newValue
			};
			callback.@gwt.dojo.client.WatchCallback::callback(Lgwt/dojo/client/util/JsObject;Ljava/lang/String;Lgwt/dojo/client/PropertyChangeEvent;)(this, name, event);
		};
		this.watch(func);
	}-*/;

}
