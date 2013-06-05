package gwt.dojo.mobile.client;

/**
 * Mixin for widgets to generate the list items corresponding to the dojo/store
 * data provider object.
 * <p>
 * By mixing this class into the widgets, the list item nodes are generated as
 * the child nodes of the widget and automatically / regenerated whenever the
 * corresponding data items are modified.
 */
public interface IStoreListMixin extends IStoreMixin {

	/**
	 * append: Boolean (false).
	 * <p>
	 * If true, refresh() does not clear the existing items.
	 */
	public static final String APPEND = "append";
	
	// TODO itemMap
	
}
