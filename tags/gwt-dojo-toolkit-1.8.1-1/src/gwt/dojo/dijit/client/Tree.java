package gwt.dojo.dijit.client;

import gwt.dojo.core.client.JsObject;

import com.google.gwt.dom.client.NativeEvent;

/**
 * This widget displays hierarchical data from a store.
 */
public class Tree extends _WidgetBase implements ITemplatedMixin {

	public interface OnLoadCallback {
		void onLoad();
	}
	
	public interface OnClickCallback {
		void onClick(JsObject item, JsObject treeNode, NativeEvent event);
	}

	public static final String MODULE = "dijit/Tree";

	public static Tree create() {
		return Tree.create(null);
	}

	public static native Tree create(JsObject options) /*-{
		try {
			return new $wnd.dijit.Tree(options || {});
		} catch (e) {
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

	/**
	 * Called when tree finishes loading and expanding.
	 * <p>
	 * If persist == true the loading may encompass many levels of fetches from
	 * the data store, each asynchronous. Waits for all to finish.
	 */
	public final native void setOnLoad(OnLoadCallback callback) /*-{
		this['onLoad'] = function() {
			callback.@gwt.dojo.dijit.client.Tree.OnLoadCallback::onLoad()();
		};
	}-*/;

	/**
	 * Callback when a tree node is clicked.
	 * 
	 * @param callback
	 */
	public final native void setOnClick(OnClickCallback callback) /*-{
		this['onClick'] = function(item, treeNode, event) {
			callback.@gwt.dojo.dijit.client.Tree.OnClickCallback::onClick(Lgwt/dojo/core/client/JsObject;Lgwt/dojo/core/client/JsObject;Lcom/google/gwt/dom/client/NativeEvent;)(item, treeNode, event);
		}
	}-*/;

}
