package gwt.dojo.dijit.client.tree;

import gwt.dojo.dijit.client.IContained;
import gwt.dojo.dijit.client.IContainer;
import gwt.dojo.dijit.client.ICssStateMixin;
import gwt.dojo.dijit.client.ITemplatedMixin;
import gwt.dojo.dijit.client._WidgetBase;

/**
 * Single node within a tree. This class is used internally by Tree and should
 * not accessed directly.
 */
public class TreeNode extends _WidgetBase implements ITemplatedMixin,
		IContainer, IContained, ICssStateMixin {

	/**
	 * item: [const] Item
	 * <p>
	 * The dojo.data entry this tree represents
	 */
	public static final String ITEM = "item";

	/**
	 * label: String (default: "")
	 * <p>
	 * Text of this tree node.
	 */
	public static final String LABEL = "label";

	/**
	 * isExpanded: [readonly] Boolean
	 * <p>
	 * This node is currently expanded (ie, opened)
	 */
	public static final String ISEXPANDED = "isExpanded";

	/**
	 * indent: Integer (default: 0)
	 * <p>
	 * Levels from this node to the root node
	 */
	public static final String INDENT = "indent";

	// TODO templateString

	// TODO baseClass

	// TODO cssStateNodes

	protected TreeNode() {
	}

	/**
	 * Show my children.
	 * 
	 * @return Deferred that fires when expansion is complete.
	 */
//	public final native Deferred expand() /*-{
//		return this.expand();
//	}-*/;

	/**
	 * Collapse this node (if it's expanded).
	 */
	public final native void collapse() /*-{
		this.collapse();
	}-*/;

	// TODO setChildItems

	// TODO getTreePath

	// TODO getIdentity

	// TODO removeChild

	// TODO makeExpandable

	/**
	 * A Tree has a (single) currently selected node. Mark that this node
	 * is/isn't that currently selected node.
	 * <p>
	 * In particular, setting a node as selected involves setting tabIndex so
	 * that when user tabs to the tree, focus will go to that node (only).
	 * 
	 * @param selected
	 *            Mark that this node is/isn't that currently selected node.
	 */
	public final native void setSelected(boolean selected) /*-{
		this.setSelected(selected);
	}-*/;

	/**
	 * A Tree has a (single) node that's focusable. Mark that this node is/isn't
	 * that currently focsuable node.
	 * <p>
	 * ???
	 * 
	 * @param focusable
	 */
	public final native void setFocusable(boolean focusable) /*-{
		this.setFocusable(focusable);
	}-*/;
}
