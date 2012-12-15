package gwt.dojo.core.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * A function that provides core event listening functionality. With this
 * function you can provide a target, event type, and listener to be notified of
 * future matching events that are fired.
 */
public class DojoOn extends JsObject {

	/**
	 * Module reference.
	 */
	public static final String MODULE = "dojo/on";

	public static final DojoOn ref() {
		return ref(MODULE);
	}

	protected DojoOn() {
	}

	public final native EventHandle on(Element node, String event,
			EventCallback callback) /*-{
		var func = function(e) {
			@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/EventCallback;Lgwt/dojo/core/client/JsObject;Lcom/google/gwt/dom/client/NativeEvent;)(callback, this, e);
		};
		return this(node, event, func);
	}-*/;

	public final native EventHandle on(Element node, JavaScriptObject event,
			EventCallback callback) /*-{
		var func = function(e) {
			@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/EventCallback;Lgwt/dojo/core/client/JsObject;Lcom/google/gwt/dom/client/NativeEvent;)(callback, this, e);
		};
		return this(node, event, func);
	}-*/;

}
