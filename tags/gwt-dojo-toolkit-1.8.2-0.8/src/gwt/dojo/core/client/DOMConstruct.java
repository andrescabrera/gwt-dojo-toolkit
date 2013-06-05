package gwt.dojo.core.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Dojo DOM construction API.
 */
public class DOMConstruct extends JavaScriptObject {

	/**
	 * Module reference.
	 */
	public static final String MODULE = "dojo/dom-construct";

	/**
	 * Create an element, allowing for attribute decoration and placement.
	 * <p>
	 * A DOM element creation function. A shorthand method for creating a node
	 * or a fragment, and allowing for a convenient attribute setting step, as
	 * well as an optional DOM placement reference.
	 * <p>
	 * Attributes are set by passing the object through {@link Dojo#setAttr}.
	 * <p>
	 * Placement is done via {@link DojoPlace}, assuming the new node to be ...
	 * TODO
	 * 
	 * @param tag
	 *            A string of the element to create (eg: "div", "a", "p", "li",
	 *            "script", "br").
	 * @param attrs
	 *            An object-hash of attributes to set on the newly created node.
	 *            Can be null, if you don't want to set any attributes/styles.
	 *            See: {@link Dojo#setAttr} for a description of available
	 *            attributes.
	 * @param refNode
	 *            Optional reference node. Used by {@link DojoPlace} to place
	 *            the newly created node somewhere in the DOM relative to
	 *            refNode.
	 * @return
	 */
	public static <T extends Element> T create(String tag, JsObject attrs,
			Element refNode) {
		return DOMConstruct.ref()._create(tag, attrs, refNode, "last");
	}

	/**
	 * Create an element, allowing for attribute decoration and placement.
	 * <p>
	 * A DOM element creation function. A shorthand method for creating a node
	 * or a fragment, and allowing for a convenient attribute setting step, as
	 * well as an optional DOM placement reference.
	 * <p>
	 * Attributes are set by passing the object through {@link Dojo#setAttr}.
	 * <p>
	 * Placement is done via {@link DojoPlace}, assuming the new node to be ...
	 * TODO
	 * 
	 * @param tag
	 *            A string of the element to create (eg: "div", "a", "p", "li",
	 *            "script", "br").
	 * @param attrs
	 *            An object-hash of attributes to set on the newly created node.
	 *            Can be null, if you don't want to set any attributes/styles.
	 *            See: {@link Dojo#setAttr} for a description of available
	 *            attributes.
	 * @param refNode
	 *            Optional reference node. Used by {@link DojoPlace} to place
	 *            the newly created node somewhere in the DOM relative to
	 *            refNode.
	 * @param pos
	 *            The location in the child nodes collection of {@code refNode}.
	 * @return
	 */
	public static final <T extends Element> T create(String tag,
			JsObject attrs, Element refNode, int pos) {
		return DOMConstruct.ref()._create(tag, attrs, refNode, pos);
	}

	/**
	 * Create an element, allowing for attribute decoration and placement.
	 * <p>
	 * A DOM element creation function. A shorthand method for creating a node
	 * or a fragment, and allowing for a convenient attribute setting step, as
	 * well as an optional DOM placement reference.
	 * <p>
	 * Attributes are set by passing the object through {@link Dojo#setAttr}.
	 * <p>
	 * Placement is done via {@link DojoPlace}, assuming the new node to be ...
	 * TODO
	 * 
	 * @param tag
	 *            A string of the element to create (eg: "div", "a", "p", "li",
	 *            "script", "br").
	 * @param attrs
	 *            An object-hash of attributes to set on the newly created node.
	 *            Can be null, if you don't want to set any attributes/styles.
	 *            See: {@link Dojo#setAttr} for a description of available
	 *            attributes.
	 * @param refNode
	 *            Optional reference node. Used by {@link DojoPlace} to place
	 *            the newly created node somewhere in the DOM relative to
	 *            refNode.
	 * @param pos
	 *            Optional positional reference. Can be set to "first", "after",
	 *            "before", "last" (default), "replace" or "only" to further
	 *            control the placement of the new node relative to the refNode
	 *            ('refNode' is required if a 'pos' is specified).
	 * @return
	 */
	public static final <T extends Element> T create(String tag,
			JsObject attrs, Element refNode, String pos) {
		return DOMConstruct.ref()._create(tag, attrs, refNode, pos);
	}

	/**
	 * Create an element, allowing for attribute decoration and placement.
	 * <p>
	 * A DOM element creation function. A shorthand method for creating a node
	 * or a fragment, and allowing for a convenient attribute setting step, as
	 * well as an optional DOM placement reference.
	 * <p>
	 * Attributes are set by passing the object through {@link Dojo#setAttr}.
	 * <p>
	 * Placement is done via {@link DojoPlace}, assuming the new node to be ...
	 * TODO
	 * 
	 * @param tag
	 *            A string of the element to create (eg: "div", "a", "p", "li",
	 *            "script", "br").
	 * @param attrs
	 *            An object-hash of attributes to set on the newly created node.
	 *            Can be null, if you don't want to set any attributes/styles.
	 *            See: {@link Dojo#setAttr} for a description of available
	 *            attributes.
	 * @param refNodeId
	 *            Optional reference node ID. Used by {@link DojoPlace} to place
	 *            the newly created node somewhere in the DOM relative to
	 *            refNode.
	 * @return
	 */
	public static final <T extends Element> T create(String tag,
			JsObject attrs, String refNodeId) {
		return DOMConstruct.ref()._create(tag, attrs, refNodeId, "last");
	}

	/**
	 * Create an element, allowing for attribute decoration and placement.
	 * <p>
	 * A DOM element creation function. A shorthand method for creating a node
	 * or a fragment, and allowing for a convenient attribute setting step, as
	 * well as an optional DOM placement reference.
	 * <p>
	 * Attributes are set by passing the object through {@link Dojo#setAttr}.
	 * <p>
	 * Placement is done via {@link DojoPlace}, assuming the new node to be ...
	 * TODO
	 * 
	 * @param tag
	 *            A string of the element to create (eg: "div", "a", "p", "li",
	 *            "script", "br").
	 * @param attrs
	 *            An object-hash of attributes to set on the newly created node.
	 *            Can be null, if you don't want to set any attributes/styles.
	 *            See: {@link Dojo#setAttr} for a description of available
	 *            attributes.
	 * @param refNodeId
	 *            Optional reference node ID. Used by {@link DojoPlace} to place
	 *            the newly created node somewhere in the DOM relative to
	 *            refNode.
	 * @param pos
	 *            The location in the child nodes collection of {@code refNode}.
	 * @return
	 */
	public static final <T extends Element> T create(String tag,
			JsObject attrs, String refNodeId, int pos) {
		return DOMConstruct.ref()._create(tag, attrs, refNodeId, pos);
	}

	/**
	 * Create an element, allowing for attribute decoration and placement.
	 * <p>
	 * A DOM element creation function. A shorthand method for creating a node
	 * or a fragment, and allowing for a convenient attribute setting step, as
	 * well as an optional DOM placement reference.
	 * <p>
	 * Attributes are set by passing the object through {@link Dojo#setAttr}.
	 * <p>
	 * Placement is done via {@link DojoPlace}, assuming the new node to be ...
	 * TODO
	 * 
	 * @param tag
	 *            A string of the element to create (eg: "div", "a", "p", "li",
	 *            "script", "br").
	 * @param attrs
	 *            An object-hash of attributes to set on the newly created node.
	 *            Can be null, if you don't want to set any attributes/styles.
	 *            See: {@link Dojo#setAttr} for a description of available
	 *            attributes.
	 * @param refNodeId
	 *            Optional reference node ID. Used by {@link DojoPlace} to place
	 *            the newly created node somewhere in the DOM relative to
	 *            refNode.
	 * @param pos
	 *            Optional positional reference. Can be set to "first", "after",
	 *            "before", "last" (default), "replace" or "only" to further
	 *            control the placement of the new node relative to the refNode
	 *            ('refNode' is required if a 'pos' is specified).
	 * @return
	 */
	public static final <T extends Element> T create(String tag,
			JsObject attrs, String refNodeId, String pos) {
		return DOMConstruct.ref()._create(tag, attrs, refNodeId, pos);
	}

	/**
	 * Removes a node from its parent, clobbering it and all of its children.
	 * 
	 * @param node
	 *            A DOM node reference of the element to be destroyed.
	 */
	public static final void destroy(Element node) {
		DOMConstruct.ref()._destroy(node);
	}

	/**
	 * Removes a node from its parent, clobbering it and all of its children.
	 * 
	 * @param node
	 *            A DOM node ID of the element to be destroyed.
	 */
	public static final void destroy(String id) {
		DOMConstruct.ref()._destroy(id);
	}

	/**
	 * Safely removes all children of the node.
	 * 
	 * @param node A reference to a DOM node.
	 */
	public static final void empty(Element node) {
		DOMConstruct.ref()._empty(node);
	}

	/**
	 * Safely removes all children of the node.
	 * 
	 * @param node A DOM node ID.
	 */
	public static final void empty(String id) {
		DOMConstruct.ref()._empty(id);
	}

	/**
	 * Attempt to insert node into the DOM, choosing from various positioning
	 * options.
	 * 
	 * @param node
	 *            The node reference to place relative to {@code refNode}.
	 * @param refNode
	 *            The node reference to use as basis for placement.
	 * @return The inserted DOM node.
	 */
	public static final Element place(Element node, Element refNode) {
		return DOMConstruct.ref()._place(node, refNode, "last");
	}

	/**
	 * Attempt to insert node into the DOM, choosing from various positioning
	 * options.
	 * 
	 * @param node
	 *            The node reference to place relative to {@code refNode}.
	 * @param refNode
	 *            The node reference to use as basis for placement.
	 * @param position
	 *            The location in the child nodes collection of {@code refNode}.
	 * @return The inserted DOM node.
	 */
	public static final Element place(Element node, Element refNode,
			int position) {
		return DOMConstruct.ref()._place(node, refNode, position);
	}

	/**
	 * Attempt to insert node into the DOM, choosing from various positioning
	 * options.
	 * <p>
	 * The accepted values are for {@code position} are:
	 * 
	 * <ul>
	 * <li>before</li>
	 * <li>after</li>
	 * <li>replace</li>
	 * <li>only</li>
	 * <li>first</li>
	 * <li>last</li>
	 * </ul>
	 * 
	 * @param node
	 *            The node reference to place relative to {@code refNode}.
	 * @param refNode
	 *            The node reference to use as basis for placement.
	 * @param position
	 *            The position of node relative to {@code refNode}.
	 * 
	 * @return The inserted DOM node.
	 */
	public static final Element place(Element node, Element refNode,
			String position) {
		return DOMConstruct.ref()._place(node, refNode, position);
	}

	/**
	 * Attempt to insert node into the DOM, choosing from various positioning
	 * options.
	 * 
	 * @param node
	 *            The node reference to place relative to {@code refNode}.
	 * @param refNodeId
	 *            The node ID reference to use as basis for placement.
	 * 
	 * @return The inserted DOM node.
	 */
	public static final Element place(Element node, String refNodeId) {
		return DOMConstruct.ref()._place(node, refNodeId, "last");
	}

	/**
	 * Attempt to insert node into the DOM, choosing from various positioning
	 * options.
	 * 
	 * @param node
	 *            The node reference to place relative to {@code refNode}.
	 * @param refNodeId
	 *            The node ID to use as basis for placement.
	 * @param position
	 *            The location in the child nodes collection of {@code refNode}.
	 * @return The inserted DOM node.
	 */
	public static final Element place(Element node, String refNodeId,
			int position) {
		return DOMConstruct.ref()._place(node, refNodeId, position);
	}

	/**
	 * Attempt to insert node into the DOM, choosing from various positioning
	 * options.
	 * <p>
	 * The accepted values are for {@code position} are:
	 * 
	 * <ul>
	 * <li>before</li>
	 * <li>after</li>
	 * <li>replace</li>
	 * <li>only</li>
	 * <li>first</li>
	 * <li>last</li>
	 * </ul>
	 * 
	 * @param node
	 *            The node reference to place relative to {@code refNode}.
	 * @param refNodeId
	 *            The node ID reference to use as basis for placement.
	 * @param position
	 *            The position of node relative to {@code refNode}.
	 * 
	 * @return The inserted DOM node.
	 */
	public static final Element place(Element node, String refNodeId,
			String position) {
		return DOMConstruct.ref()._place(node, refNodeId, position);
	}

	private static final DOMConstruct ref() {
		return JsObject.ref(MODULE);
	}

	protected DOMConstruct() {
	}

	private final native <T extends Element> T _create(String tag,
			JsObject attrs, Element refNode, int pos) /*-{
		return this.create(tag, attrs, refNode, pos);
	}-*/;

	// ------------------------------------------------------------------------

	private final native <T extends Element> T _create(String tag,
			JsObject attrs, Element refNode, String pos) /*-{
		return this.create(tag, attrs, refNode, pos);
	}-*/;

	private final native <T extends Element> T _create(String tag,
			JsObject attrs, String refNodeId, int pos) /*-{
		return this.create(tag, attrs, refNodeId, pos);
	}-*/;

	private final native <T extends Element> T _create(String tag,
			JsObject attrs, String refNodeId, String pos) /*-{
		return this.create(tag, attrs, refNodeId, pos);
	}-*/;

	private final native void _destroy(Element node) /*-{
		this.destroy(node);
	}-*/;

	private final native void _destroy(String id) /*-{
		this.destroy(id);
	}-*/;

	private final native void _empty(Element node) /*-{
		this.empty(node);
	}-*/;

	private final native void _empty(String id) /*-{
		this.empty(id);
	}-*/;

	private final native Element _place(Element node, Element refNode,
			int position) /*-{
		return this.place(node, refNode, position);
	}-*/;

	private final native Element _place(Element node, Element refNode,
			String position) /*-{
		return this.place(node, refNode, position);
	}-*/;

	private final native Element _place(Element node, String refNodeId,
			int position) /*-{
		return this.place(node, refNodeId, position);
	}-*/;

	private final native Element _place(Element node, String refNodeId,
			String position) /*-{
		return this.place(node, refNodeId, position);
	}-*/;

}
