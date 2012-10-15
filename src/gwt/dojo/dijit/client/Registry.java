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

import gwt.dojo.client.util.JsObject;

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
		return Registry.get()._byId(id);
	}
	
	/**
	 * Find a widget by it's corresponding DOM node.
	 * 
	 * @param node
	 *            The widget's DOM node.
	 * @return The widget or {@code null}.
	 */
	public static <T extends JsObject> T byNode(Node node) {
		return Registry.get()._byNode(node);
	};

	private static native Registry get() /*-{
		return $wnd.dijit.registry;
	}-*/;

	protected Registry() {
	}

	public final native <T extends JsObject> T _byId(String id) /*-{
		return this.byId(id);
	}-*/;

	/**
	 * Find a widget by it's corresponding DOM node.
	 * 
	 * @param node
	 *            The widget's DOM node.
	 * @return The widget or {@code null}.
	 */
	public final native <T extends JsObject> T _byNode(Node node) /*-{
		return this.byNode(node);
	}-*/;
}
