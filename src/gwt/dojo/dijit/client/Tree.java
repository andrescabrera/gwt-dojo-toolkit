package gwt.dojo.dijit.client;

import gwt.dojo.core.client.JsObject;

/**
 * This widget displays hierarchical data from a store.
 */
public class Tree extends _WidgetBase implements ITemplatedMixin {

	public static final String MODULE = "dijit/Tree";

	public static Tree create() {
		return Tree.create(null);
	}

	public static native Tree create(JsObject options) /*-{
		try {
			return new $wnd.dijit.Tree(options || {});
		} catch(e) {
			alert(e);
		}
	}-*/;

	/**
	 * model: dijit/tree/model
	 * <p>
	 * Interface to read tree data, get notifications of changes to tree data,
	 * and for handling drop operations (i.e drag and drop onto the tree)
	 */
	public static final String MODEL = "model";

	/**
	 * showRoot: [const] Boolean
	 * <p>
	 * Should the root node be displayed, or hidden?
	 */
	public static final String SHOWROOT = "showRoot";

	protected Tree() {
	}

}
