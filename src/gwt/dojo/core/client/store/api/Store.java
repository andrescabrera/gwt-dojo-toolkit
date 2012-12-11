package gwt.dojo.core.client.store.api;

import com.google.gwt.core.client.JavaScriptObject;

import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;

/**
 * This is an abstract API that provider implementations conform to.
 */
public abstract class Store extends JsObject {

	public interface GetChildrenCallback<T extends Store> {
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
		JsArray getChildren(T store, JsObject object, JsObject queryOptions);
	}

	public interface ForEachCallback {
		void forEach(JsObject item);
	}

	public interface MapCallback {
		JsObject map(JsObject item);
	}

	/**
	 * Directives passed to put() and add() handlers for guiding the update and
	 * creation of stored objects.
	 */
	public static class PutDirectives extends JsObject {
		/**
		 * Create a new {@code PutDirectives} instance.
		 * 
		 * @return {@code PutDirectives} instance.
		 */
		public static PutDirectives create() {
			return JavaScriptObject.createObject().cast();
		}

		/**
		 * id: String|Number?
		 * <p>
		 * Indicates the identity of the object if a new object is created.
		 */
		public static final String ID = "id";

		/**
		 * before: Object?
		 * <p>
		 * If the collection of objects in the store has a natural ordering,
		 * this indicates that the created or updated object should be placed
		 * before the object specified by the value of this property. A value of
		 * null indicates that the object should be last.
		 */
		public static final String BEFORE = "before";

		/**
		 * parent: Object?,
		 * <p>
		 * If the store is hierarchical (with single parenting) this property
		 * indicates the new parent of the created or updated object.
		 */
		public static final String PARENT = "parent";

		/**
		 * overwrite: Boolean?
		 * <p>
		 * If this is provided as a boolean it indicates that the object should
		 * or should not overwrite an existing object. A value of true indicates
		 * that a new object should not be created, the operation should update
		 * an existing object. A value of false indicates that an existing
		 * object should not be updated, a new object should be created (which
		 * is the same as an add() operation). When this property is not
		 * provided, either an update or creation is acceptable.
		 */
		public static final String OVERWRITE = "overwrite";

		/**
		 * JSNI constructor.
		 */
		protected PutDirectives() {
		}
	}

	/**
	 * An object describing what attribute to sort on, and the direction of the
	 * sort.
	 */
	public static class SortInformation extends JsObject {
		/**
		 * Create a new {@code SortInformation} instance.
		 * 
		 * @return {@code SortInformation} instance.
		 */
		public static SortInformation create() {
			return JavaScriptObject.createObject().cast();
		}

		/**
		 * attribute: String
		 * <p>
		 * The name of the attribute to sort on.
		 */
		public static final String ATTRIBUTE = "attribute";

		/**
		 * descending: Boolean
		 * <p>
		 * The direction of the sort. Default is false.
		 */
		public static final String DESCENDING = "descending";

		/**
		 * JSNI constructor.
		 */
		protected SortInformation() {
		}
	}

	/**
	 * Optional object with additional parameters for query results.
	 */
	public static class QueryOptions extends JsObject {
		/**
		 * Create a new {@code QueryOptions} instance.
		 * 
		 * @return {@code QueryOptions} instance.
		 */
		public static QueryOptions create() {
			return JavaScriptObject.createObject().cast();
		}

		/**
		 * sort: Store.SortInformation[]?
		 * <p>
		 * A list of attributes to sort on, as well as direction
		 * <p>
		 * For example: [{attribute:"price, descending: true}]
		 * <p>
		 * If the sort parameter is omitted, then the natural order of the store
		 * may be applied if there is a natural order.
		 */
		public static final String SORT = "sort";

		/**
		 * start: Number?
		 * <p>
		 * The first result to begin iteration on
		 */
		public static final String START = "start";

		/**
		 * count: Number?
		 * <p>
		 * The number of how many results should be returned.
		 */
		public static final String COUNT = "count";

		/**
		 * JSNI constructor.
		 */
		protected QueryOptions() {
		}
	}

	/**
	 * This is an object returned from
	 * {@link Store#query(JsObject, QueryOptions)} calls that provides access to
	 * the results of a query. Queries may be executed asynchronously.
	 */
	public static class QueryResults extends JsObject {
		/**
		 * total: Number|Promise?
		 * <p>
		 * This property should be included in if the query options included the
		 * "count" property limiting the result set. This property indicates the
		 * total number of objects matching the query (as if "start" and "count"
		 * weren't present). This may be a promise if the query is asynchronous.
		 */
		public static final String TOTAL = "total";

		/**
		 * JSNI constructor.
		 */
		protected QueryResults() {
		}

		public final native void setForEachCallback(ForEachCallback callback) /*-{
			var callbackFcn = function(item) {
				callback.@gwt.dojo.core.client.store.api.Store.ForEachCallback::forEach(Lgwt/dojo/core/client/JsObject;)(item);
			};
			this.forEach(callbackFcn);
		}-*/;

		public final native QueryResults setMapCallback(MapCallback callback) /*-{
			var callbackFcn = function(item) {
				return callback.@gwt.dojo.core.client.store.api.Store.MapCallback::map(Lgwt/dojo/core/client/JsObject;)(item);
			};
			return this.map(callbackFcn);
		}-*/;
	}

	/**
	 * This is an object returned from {@link Store#transaction()} calls that
	 * represents the current transaction.
	 */
	public static class Transaction extends JsObject {
		/**
		 * JSNI constructor.
		 */
		protected Transaction() {
		}

		/**
		 * Commits the transaction. This may throw an error if it fails. Of if
		 * the operation is asynchronous, it may return a promise that
		 * represents the eventual success or failure of the commit.
		 */
		public final native void commit() /*-{
			this.commit();
		}-*/;

		/**
		 * Aborts the transaction. This may throw an error if it fails. Of if
		 * the operation is asynchronous, it may return a promise that
		 * represents the eventual success or failure of the abort.
		 */
		public final native void abort() /*-{
			this.abort();
		}-*/;
	}

	/**
	 * idProperty: String (default: "id")
	 * <p>
	 * If the store has a single primary key, this indicates the property to use
	 * as the identity property. The values of this property should be unique.
	 */
	public static final String IDPROPERTY = "idProperty";

	// TODO queryEngine

	protected Store() {
	}

	/**
	 * Retrieves an object by its identity.
	 * 
	 * @param id
	 *            The identity to use to lookup the object.
	 * @return The object in the store that matches the given id.
	 */
	public final native JsObject byId(Object id) /*-{
		return this.get(id);
	}-*/;

	/**
	 * Returns an object's identity.
	 * 
	 * @return The object to get the identity from.
	 */
	public final native Object getIdentity() /*-{
		return this.getIdentity();
	}-*/;

	/**
	 * Stores an object.
	 * 
	 * @param object
	 *            The object to store.
	 * @return Number|String (???)
	 */
	public final native Object store(JsObject object) /*-{
		return this.put(object);
	}-*/;

	/**
	 * Stores an object.
	 * 
	 * @param object
	 *            The object to store.
	 * @param directives
	 *            Additional directives for storing objects.
	 * @return Number|String (???)
	 */
	public final native Object store(JsObject object, PutDirectives directives) /*-{
		return this.put(object, directives);
	}-*/;

	/**
	 * Creates an object, throws an error if the object already exists.
	 * 
	 * @param object
	 *            The object to store.
	 * @return Number|String (???)
	 */
	public final native Object add(JsObject object) /*-{
		return this.add(object);
	}-*/;

	/**
	 * Creates an object, throws an error if the object already exists.
	 * 
	 * @param object
	 *            The object to store.
	 * @param directives
	 *            Additional directives for creating objects.
	 * @return Number|String (???)
	 */
	public final native Object add(JsObject object, PutDirectives directives) /*-{
		return this.add(object, directives);
	}-*/;

	/**
	 * Deletes an object by its identity.
	 * 
	 * @param id
	 *            The identity to use to delete the object.
	 */
	public final native void remove(Object id) /*-{
		this.remove(id);
	}-*/;

	/**
	 * Queries the store for objects. This does not alter the store, but returns
	 * a set of data from the store.
	 * 
	 * @param query
	 *            The query to use for retrieving objects from the store.
	 * @return The results of the query, extended with iterative methods.
	 */
	public final native QueryResults query(JsObject query) /*-{
		return this.query(query);
	}-*/;

	/**
	 * Queries the store for objects. This does not alter the store, but returns
	 * a set of data from the store.
	 * 
	 * @param query
	 *            The query to use for retrieving objects from the store.
	 * @param options
	 *            The optional arguments to apply to the result-set.
	 * @return The results of the query, extended with iterative methods.
	 */
	public final native QueryResults query(JsObject query, QueryOptions options) /*-{
		return this.query(query, options);
	}-*/;

	/**
	 * Starts a new transaction.
	 * <p>
	 * Note that a store user might not call transaction() prior to using put,
	 * delete, etc. in which case these operations effectively could be thought
	 * of as "auto-commit" style actions.
	 * 
	 * @return This represents the new current transaction.
	 */
	public final native Transaction transaction() /*-{
		return this.transaction();
	}-*/;

	public final native <T extends Store> void setGetChildrenCallback(
			GetChildrenCallback<T> cb) /*-{
		this['getChildren'] = function(object, queryOptions) {
			return cb.@gwt.dojo.core.client.store.api.Store.GetChildrenCallback::getChildren(Lgwt/dojo/core/client/store/api/Store;Lgwt/dojo/core/client/JsObject;Lgwt/dojo/core/client/JsObject;)(this, object, queryOptions);
		};
	}-*/;

	// TODO setGetMeatadata
}
