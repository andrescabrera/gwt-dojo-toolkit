package gwt.dojo.dijit.client.tree;

/**
 * Implements dijit/tree/model connecting dijit/Tree to a dojo/store/api/Store
 * that implements {@code getChildern()}.
 * <p>
 * If {@code getChildren()} returns an array with an observer() method, then it
 * TODO complete javadoc
 */
public class ObjectStoreModel extends TreeModel {

	public static final String MODULE = "dijit/tree/ObjectStoreModel";

	/**
	 * store: dojo/store/api/Store (default: null)
	 * <p>
	 * Underlying store.
	 */
	public static final String STORE = "store";

	/**
	 * labelAttr: String (default: "name").
	 * <p>
	 * Get label for tree node from this attribute.
	 */
	public static final String LABELATTR = "labelAttr";

	/**
	 * root: [readonly] Object
	 * <p>
	 * Pointer to the root item from the dojo/store/api/Store (read only, not a
	 * parameter)
	 */
	public static final String ROOT = "root";

	/**
	 * query: anything
	 * <p>
	 * Specifies datastore query to return the root item for the tree. Must only
	 * return a single item. Alternately can just pass in pointer to root item.
	 * <p>
	 * example: {id:'ROOT'}
	 */
	public static final String QUERY = "query";

	protected ObjectStoreModel() {
	}

}
