package gwt.dojo.dijit.client.tree;

import gwt.dojo.core.client.JsObject;
import gwt.dojo.core.client.data.api.Item;

public class TreeModel extends JsObject {

	public interface MayHaveChildrenCallback {
		/**
		 * Tells if an item has or may have children. Implementing logic here
		 * avoids showing +/- expand icon for nodes that we know don't have
		 * children. (For efficiency reasons we may not want to check if an
		 * element actually has children until user clicks the expando node).
		 * 
		 * @param item
		 * @return
		 */
		boolean mayHaveChildren(Item item);
	}

	protected TreeModel() {
	}

	public final native void setMayHaveChildrenCallback(
			MayHaveChildrenCallback cb) /*-{
		this['mayHaveChildren'] = function(item) {
			return cb.@gwt.dojo.dijit.client.tree.TreeModel.MayHaveChildrenCallback::mayHaveChildren(Lgwt/dojo/core/client/data/api/Item;)(item);
		};
	}-*/;
}
