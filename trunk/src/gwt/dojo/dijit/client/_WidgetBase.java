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

import gwt.dojo.core.client.AspectCallback;
import gwt.dojo.core.client.AspectHandle;
import gwt.dojo.core.client.EventCallback;
import gwt.dojo.core.client.EventHandle;
import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;
import gwt.dojo.core.client.Stateful;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Base class for Dijit widgets.
 * <p>
 * ({@link _WidgetController} extends this class adding support for various
 * features needed by desktop.
 * 
 * @author ggeorg
 */
public class _WidgetBase extends Stateful {

	public static _WidgetBase cast(JsObject o) {
		return o.cast();
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
	 * lang: [const] String
	 * <p>
	 * Rarely used. Overrides the default Dojo locale used to render this
	 * widget, as defined by the <a
	 * href="http://www.w3.org/TR/html401/struct/dirlang.html#adef-lang">[HTML
	 * LANG]</a> attribute. Value must be among the list of locales specified
	 * during by the Dojo bootstrap, formatted according to <a
	 * href="http://www.ietf.org/rfc/rfc3066.txt">[RFC 3066]</a> (like en-us).
	 */
	public static final String LANG = "lang";

	/**
	 * dir: [cont] String
	 * <p>
	 * Bi-directional support, as defined by the <a
	 * href="http://www.w3.org/TR/html401/struct/dirlang.html#adef-dir">[HTML
	 * DIR]</a> attribute. Either left-to-right "ltr" or right-to-left "rtl". If
	 * undefined, widgets renders in page's default direction.
	 */
	public static final String DIR = "dir";

	/**
	 * textDir: String
	 * <p>
	 * Bi-directional support, the main variable which is responsible for the
	 * direction of the text. The text direction can be different than the GUI
	 * direction by using this parameter in creation of a widget.
	 * <p>
	 * Allowed values:
	 * <ol>
	 * <li>"ltr"</li>
	 * <li>"rtl"</li>
	 * <li>"auto" - contextual the direction of a text defined by first strong
	 * letter.</li>
	 * </ol>
	 * By default is as the page direction.
	 */
	public static final String TEXTDIR = "textDir";

	/**
	 * class: String
	 * <p>
	 * HTML class attribute.
	 */
	public static final String CLASS = "class";

	/**
	 * style: String|Object
	 * <p>
	 * HTML style attribute as cssText string or name/value hash.
	 */
	public static final String STYLE = "style";

	/**
	 * title: String
	 * <p>
	 * HTML title attribute.
	 * <p>
	 * For form widgets this specifies a tooltip to display when hovering over
	 * the widget (just like the native HTML title attribute).
	 * <p>
	 * For TitlePane or for when this widget is a child of a TabContainer,
	 * AccordionContainer, etc., it's used to specify the tab label, accordion
	 * pane title, etc.
	 */
	public static final String TITLE = "title";

	/**
	 * tooltip: String
	 * <p>
	 * When this widget's title attribute is used to for a tab label, accordion
	 * pane title, etc., this specifies the tooltip to appear when the mouse is
	 * hovered over that text.
	 */
	public static final String TOOLTIP = "tooltip";

	/**
	 * srcNodeRef: [readonly] DomNode
	 * <p>
	 * Pointer to original DOM node.
	 */
	public static final String SRCNODEREF = "srcNodeRef";

	/**
	 * domNode: [readonly] DomNode
	 * <p>
	 * This is our visible representation of the widget! Other DOM Nodes may by
	 * assigned to other properties, usually through the template system's
	 * data-dojo-attach-point syntax, but the domNode property is the canonical
	 * "top level" node in widget UI.
	 */
	public static final String DOMNODE = "domNode";

	/**
	 * containerNode: [readonly] DomNode
	 * <p>
	 * Designates where children of the source DOM node will be placed.
	 */
	public static final String CONTAINERNODE = "containerNode";

	/**
	 * Not directly instantiable. All subclasses must also define a protected,
	 * empty, no-arg constructor.
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
		try {
			this.startup();
		} catch (e) {
			alert(e);
		}
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
	 * Destroys the DOM nodes associated with this widget.
	 * 
	 * @param preserveDom
	 *            If {@code true}, this method will leave the original DOM
	 *            structure alone. Note: this will not work with _Templated
	 *            widgets.
	 */
	protected final native void destroyRendering(boolean preserveDom) /*-{
		this.destroyRendering(preserveDom);
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
	 * @param event
	 *            The event type.
	 * @param callback
	 *            The specified callback function.
	 * @return A handle which can be used to remove this event.
	 */
	public final native EventHandle on(String event, EventCallback callback) /*-{
		var func = function(e) {
			try {
				@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/EventCallback;Lgwt/dojo/core/client/JsObject;Lcom/google/gwt/dom/client/NativeEvent;)(callback, this, e);
			} catch (ex) {
				alert("Error in event callback: " + ex);
			}
		};
		return this.on(event, func);
	}-*/;

	/**
	 * Call specified callback function when event occurs...
	 * 
	 * @param event
	 * @param callback
	 * @return
	 */
	public final native EventHandle on(JavaScriptObject event,
			EventCallback callback) /*-{
		var func = function(e) {
			try {
				@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/EventCallback;Lgwt/dojo/core/client/JsObject;Lcom/google/gwt/dom/client/NativeEvent;)(callback, this, e);
			} catch (ex) {
				alert("Error in event callback: " + ex);
			}
		};
		return this.on(event, func);
	}-*/;

	/**
	 * 
	 * @param event
	 * @param callback
	 * @return
	 */
	public final native AspectHandle on(String event, AspectCallback callback) /*-{
		var func = function(e) {
			try {
				@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/AspectCallback;Lgwt/dojo/core/client/JsObject;Lgwt/dojo/core/client/JsArray;)(callback,arguments);
			} catch (ex) {
				alert("Error in aspect callback: " + ex);
			}
		};
		return this.on(event, func);
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
	public final native JsArray getChildren() /*-{
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
