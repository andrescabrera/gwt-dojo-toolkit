package gwt.dojo.core.client;

import com.google.gwt.core.client.JavaScriptObject;

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

	public static final EventHandle on(JavaScriptObject object, String event,
			EventCallback callback) {
		DojoOn ref = JsObject.ref(DojoOn.MODULE);
		return ref._on(object, event, callback);
	}

	public static final EventHandle on(JavaScriptObject object,
			JavaScriptObject event, EventCallback callback) {
		DojoOn ref = JsObject.ref(DojoOn.MODULE);
		return ref._on(object, event, callback);
	}

	public static final AspectHandle on(JavaScriptObject object, String event,
			AspectCallback callback) {
		DojoOn ref = JsObject.ref(DojoOn.MODULE);
		return ref._on(object, event, callback);
	}

	protected DojoOn() {
	}

	private final native EventHandle _on(JavaScriptObject object, String event,
			EventCallback callback) /*-{
		var func = function(e) {
			try {
				@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/EventCallback;Lgwt/dojo/core/client/JsObject;Lcom/google/gwt/dom/client/NativeEvent;)(callback, this, e);
			} catch (ex) {
				alert("Error in event callback: " + ex);
			}
		};
		return this(object, event, func);
	}-*/;

	private final native EventHandle _on(JavaScriptObject object,
			JavaScriptObject event, EventCallback callback) /*-{
		var func = function(e) {
			try {
				@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/EventCallback;Lgwt/dojo/core/client/JsObject;Lcom/google/gwt/dom/client/NativeEvent;)(callback, this, e);
			} catch (ex) {
				alert("Error in event callback: " + ex);
			}
		};
		return this(object, event, func);
	}-*/;

	private final native AspectHandle _on(JavaScriptObject object,
			String event, AspectCallback callback) /*-{
		var func = function() {
			try {
				@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/AspectCallback;Lgwt/dojo/core/client/JsArray;)(callback,arguments);
			} catch (ex) {
				alert("Error in aspect callback: " + ex);
			}
		};
		return this(object, event, func);
	}-*/;

}
