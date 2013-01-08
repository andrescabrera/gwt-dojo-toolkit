package gwt.dojo.core.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Core dojo DOM API.
 */
public class DOM extends JavaScriptObject {

	/**
	 * Module reference.
	 */
	public static final String MODULE = "dojo/dom";

	/**
	 * Returns DOM node with matching {@code id} attribute or {@code null} if
	 * not found.
	 * 
	 * @param id
	 *            A string to match an HTML id attribute.
	 * @return DOM node.
	 */
	public static final <T extends Element> T byId(String id) {
		return DOM.ref()._byId(id);
	}

	public static final boolean isDescendant(Element node, Element ancestor) {
		return false;
	}

	private static final DOM ref() {
		return JsObject.ref(MODULE);
	}

	protected DOM() {
	}

	private final native <T extends Element> T _byId(String id) /*-{
		return this.byId(id);
	}-*/;
}
