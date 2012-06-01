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
package gwt.dojo.dijit.client;

import gwt.dojo.client.EventCallback;
import gwt.dojo.client.EventHandle;
import gwt.dojo.client.Stateful;
import gwt.dojo.client.util.JsObject;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;

public class _WidgetBase extends Stateful {

	public static _WidgetBase cast(JsObject o) {
		return o.cast();
	}

	public static Stateful byId(String id) {
		return Registry.get().byId(id);
	}

	/**
	 * id: [const] String
	 * <p>
	 * A unique, opaque ID string that can be assigned by users or by the
	 * system. If the developer passes an ID which is known not to be unique,
	 * the specified ID is ignored and the system-generated ID is used instead.
	 */
	public static final String ID = "id";

	/**
	 * domNode: [readonly] DomNode
	 * <p>
	 * This is our visible representation of the widget!
	 */
	public static final String DOMNODE = "domNode";

	/**
	 * containerNode: [readonly] DomNode
	 * <p>
	 * Designates where children of the source DOM node will be placed.
	 */
	public static final String CONTAINERNODE = "containerNode";

	/**
	 * Default constructor.
	 */
	protected _WidgetBase() {
	}

	/**
	 * Processing after the DOM fragment is added to the document.
	 * <p>
	 * Called after a widget and its children have been created and added to the
	 * page, and all related widgets have finished their {@code create()} cycle
	 * up to {@code postCreate()}. This is useful for composite widgets that
	 * need to control or layout sub-widgets. Many layout widgets can use this
	 * as a wiring phase.
	 */
	public final native void startup() /*-{
		this.startup();
	}-*/;

	/**
	 * Destroy this widget and its descendants.
	 * <p>
	 * This is the generic "destructor" function that all widget users should
	 * call to cleanly discard with a widget. Once a widget is destroyed, it is
	 * removed from the manager object.
	 * 
	 * @param preserveDom
	 *            If {@code true}, this method will leave the original DOM
	 *            structure alone of descendant Widgets. Note: this will not
	 *            work with _Templated widgets.
	 */
	public final native void destroyRecursive(boolean preserveDom) /*-{
		this.destroyRecursive(preserveDom);
	}-*/;

	/**
	 * Destroy this widget, but not its descendants. This method will, however,
	 * destroy internal widgets such as those used within a template.
	 * 
	 * @param preserveDom
	 *            If {@code true}, this method will leave the original DOM
	 *            structure alone. Note: this will not work with _Templated
	 *            widgets.
	 */
	public final native void destroy(boolean preserveDom) /*-{
		this.destroy(preserveDom);
	}-*/;

	/**
	 * Recursively destroy the children of this widget and their descendants.
	 * 
	 * @param preserveDom
	 *            If {@code true}, the {@code preserveDom} attribute is passed
	 *            to all descendant widget's {@code #ddestroy(boolean)} method.
	 *            Not for use with _Templated widgets.
	 */
	public final native void destroyDescendants(boolean preserveDom) /*-{
		this.destroyDescendants(preserveDom);
	}-*/;

	/**
	 * Call specified callback function when event occurs, ex:
	 * {@code myWidget.on("click", ...)}.
	 * 
	 * @param type
	 *            The event type.
	 * @param callback
	 *            The specified callback function.
	 * @return A handle which can be used to remove this event.
	 */
	public final native EventHandle on(String type, EventCallback callback) /*-{
		var func = function(e) {
			callback.@gwt.dojo.client.EventCallback::callback(Lgwt/dojo/client/util/JsObject;Lcom/google/gwt/dom/client/NativeEvent;)(this,e);
		};
		return this.on(type, func);
	}-*/;

	/**
	 * Returns a string that represents the widget.
	 * <p>
	 * When a widget is cast to a string, this method will be used to generate
	 * the output.
	 */
	// @Override
	// public native String toString() /*-{
	// return this.toString();
	// }-*/;

	/**
	 * Returns all the widgets contained by this widget, i.e., all widgets
	 * underneath {@code containerNode}. Does not return nested widgets, nor
	 * widgets that are part of this widget's template.
	 * 
	 * @return All the widgets contained by this widget.
	 */
	public final native <T extends JsObject> JsArray<T> getChildren() /*-{
		return this.getChildren();
	}-*/;

	/**
	 * Returns the parent widget of this widget.
	 * 
	 * @return The parent widget of this widget.
	 */
	public final native <T extends JsObject> T getParent() /*-{
		return this.getParent();
	}-*/;

	/**
	 * Return {@code true} if this widget can currently be focused.
	 * 
	 * @return {@code true} if this widget can currently be focused.
	 */
	public final native boolean isFocusable() /*-{
		return this.isFocusable();
	}-*/;

	/**
	 * Place this widget's {@code domNode} reference somewhere in the DOM.
	 * <p>
	 * A convenience method provided in all widgets, providing a simple
	 * shorthand mechanism to put an existing (or newly created) widget
	 * somewhere in the DOM, and allow chaining.
	 * 
	 * @param id
	 *            The id of a {@code domNode}.
	 * @param position
	 *            The position argument accepts a string just as
	 *            domConstruct.place does, one of: "first", "last", "before", or
	 *            "after".
	 * @return {@code this} to allow chaining.
	 */
	public final native _WidgetBase placeAt(String id, int position) /*-{
		this.placeAt(id, position);
		return this;
	}-*/;

	/**
	 * Place this widget's {@code domNode} reference somewhere in the DOM.
	 * <p>
	 * A convenience method provided in all widgets, providing a simple
	 * shorthand mechanism to put an existing (or newly created) widget
	 * somewhere in the DOM, and allow chaining.
	 * 
	 * @param domNode
	 *            A {@code domNode} reference.
	 * @param position
	 *            The position argument accepts a string just as
	 *            domConstruct.place does, one of: "first", "last", "before", or
	 *            "after".
	 * @return {@code this} to allow chaining.
	 */
	public final native _WidgetBase placeAt(Element domNode, String position) /*-{
		this.placeAt(domNode, position);
		return this;
	}-*/;

	/**
	 * Place this widget's {@code domNode} reference somewhere in the DOM.
	 * <p>
	 * A convenience method provided in all widgets, providing a simple
	 * shorthand mechanism to put an existing (or newly created) widget
	 * somewhere in the DOM, and allow chaining.
	 * 
	 * @param widget
	 *            A reference to a widget.
	 * @param index
	 *            If the widget reference has a {@code addChild} method, it will
	 *            be called passing this widget instance into that method,
	 *            supplying the optional position index.
	 * @return {@code this} to allow chaining.
	 */
	public final _WidgetBase placeAt(_WidgetBase widget, int index) {
		return placeAt(widget, index);
	}

	/**
	 * Place this widget's {@code domNode} reference somewhere in the DOM.
	 * <p>
	 * A convenience method provided in all widgets, providing a simple
	 * shorthand mechanism to put an existing (or newly created) widget
	 * somewhere in the DOM, and allow chaining.
	 * 
	 * @param id
	 *            A reference to a widget.
	 * @return {@code this} to allow chaining.
	 */
	public final native _WidgetBase placeAt(String id) /*-{
		this.placeAt(id);
		return this;
	}-*/;

}
