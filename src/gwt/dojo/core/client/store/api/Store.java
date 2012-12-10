package gwt.dojo.core.client.store.api;

import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;

public abstract class Store extends JsObject {

	public interface GetChildrenCallback {
		/**
		 * Retrieves the children of an object.
		 * 
		 * @param object
		 *            The object to find the children of.
		 * @param queryOptions
		 *            Additional options to apply to the retrieval of the
		 *            children.
		 * @return A result (Store.QueryResults) set of the children of the
		 *         parent object.
		 */
		JsArray getChildren(JsObject object, JsObject queryOptions);
	}

	protected Store() {
	}

	public final native void setGetChildrenCallback(GetChildrenCallback cb) /*-{
		this['getChildren'] = function(object, queryOptions) {
			return cb.@gwt.dojo.core.client.store.api.Store.GetChildrenCallback::getChildren(Lgwt/dojo/core/client/JsObject;Lgwt/dojo/core/client/JsObject;)(object, queryOptions);
		};
	}-*/;
}
