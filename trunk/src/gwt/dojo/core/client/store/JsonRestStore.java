package gwt.dojo.core.client.store;

import gwt.dojo.core.client.JsObject;
import gwt.dojo.core.client.store.api.Store;

/**
 * This is a basic store for RESTful communication with a server through JSON
 * formatted data.
 */
public class JsonRestStore extends Store {

	public static final String MODULE = "dojo/store/JsonRest";

	/**
	 * Create a {@code JsonRestStore} instance.
	 * 
	 * @param options
	 *            This provides any configuration information that will be mixed
	 *            into the store.
	 * @return
	 */
	public static native JsonRestStore create(JsObject options) /*-{
		try {
			return new $wnd.dojo.store.JsonRest(options || {});
		} catch (e) {
			alert(e);
		}
	}-*/;

	/**
	 * headers: Object (default: null)
	 * <p>
	 * Additional headers to pass in all requests to the server. These can be
	 * overridden by passing additional headers to calls to the store.
	 */
	public static final String HEADERS = "headers";

	/**
	 * target: String (default: "")
	 * <p>
	 * The target base URL to use for all requests to the server. This string
	 * will be prepended to the id to generate the URL (relative or absolute)
	 * for requests sent to the server
	 */
	public static final String TARGET = "target";

	/**
	 * accepts: String (default: "application/javascript, application/json").
	 * <p>
	 * Defines the Accept header to use on HTTP requests.
	 */
	public static final String ACCEPTS = "accepts";

	protected JsonRestStore() {
	}
}
