package gwt.dojo.mobile.client;

/**
 * Mixin for widgets to enable dojo/store data store.
 * <p>
 * By mixing this class into widget , it can get data through a dojo/store data
 * store.
 */
public interface IStoreMixin {

	/**
	 * store: Object
	 * <p>
	 * Reference to data provider object used by this widget.
	 */
	public static final String STORE = "store";

	/**
	 * query: Object
	 * <p>
	 * A query that can be passed to 'store' to initially filter the items.
	 */
	public static final String QUERY = "query";

	/**
	 * queryOptions: Object
	 * <p>
	 * An optional parameter for the query.
	 */
	public static final String QUERYOPTIONS = "queryOptions";

	/**
	 * labelProperty: String (default: "label")
	 * <p>
	 * A property name (a property in the dojo/store item) that specifies that
	 * item's label.
	 */
	public static final String LABELPROPERTY = "labelProperty";

	/**
	 * childrenProperty: String (default: "children")
	 * <p>
	 * A property name (a property in the dojo/store item) that specifies that
	 * item's children.
	 */
	public static final String CHILDRENPROPERTY = "childrenProperty";
}
