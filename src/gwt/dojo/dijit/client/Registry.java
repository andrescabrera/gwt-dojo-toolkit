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

import gwt.dojo.core.client.JsObject;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;

public class Registry extends JsObject {

	public static final String MODULE = "dijit/registry";

	/**
	 * Find a widget by it's id.
	 * 
	 * @param id
	 *            The widget's id.
	 * @return The widget or {@code null}.
	 */
	public static <T extends JsObject> T byId(String id) {
		Registry ref = JsObject.ref(Registry.MODULE);
		return ref._byId(id);
	}

	/**
	 * Find a widget by it's corresponding DOM node.
	 * 
	 * @param node
	 *            The widget's DOM node.
	 * @return The widget or {@code null}.
	 */
	public static <T extends JsObject> T byNode(Node node) {
		Registry ref = JsObject.ref(Registry.MODULE);
		return ref._byNode(node);
	};

	/**
	 * Generates a unique id for a given {@code widgetType}.
	 * 
	 * @param widgetType
	 * @return
	 */
	public static String getUniqueId(String widgetType) {
		Registry ref = JsObject.ref(Registry.MODULE);
		return ref._getUniqueId(widgetType);
	}

	/**
	 * Returns the widget whose DOM tree contains the specified DOMNode, or
	 * {@code null} if the node is not contained within the DOM tree of any
	 * widget.
	 * 
	 * @param node
	 */
	public static <T extends _WidgetBase> T getEnclosingWidget(Element node) {
		Registry ref = JsObject.ref(Registry.MODULE);
		return ref._getEnclosingWidget(node);
	}

	protected Registry() {
	}

	public final native <T extends JsObject> T _byId(String id) /*-{
		return this.byId(id);
	}-*/;

	public final native <T extends JsObject> T _byNode(Node node) /*-{
		return this.byNode(node);
	}-*/;

	private final native String _getUniqueId(String widgetType) /*-{
		return this.getUniqueId(widgetType);
	}-*/;

	private final native <T extends _WidgetBase> T _getEnclosingWidget(
			Element node) /*-{
		return this.getEnclosingWidget(node);
	}-*/;
}
