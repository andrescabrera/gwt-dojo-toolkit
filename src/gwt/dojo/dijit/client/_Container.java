/*
 * Copyright 2012 ArkaSoft LLC.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package gwt.dojo.dijit.client;

import gwt.dojo.client.util.JsObject;

/**
 * Mixin for widgets that contain a set of widget children.
 * 
 * @author ggeorg
 */
public class _Container extends JsObject {

	public static _Container cast(IContainer widget) {
		assert widget instanceof _WidgetBase : "Not a widget";
		return ((_WidgetBase) widget).cast();
	}

	protected _Container() {
	}

	/**
	 * Makes the given widget a child of this widget.
	 * <p>
	 * Inserts specified child widget's dom node as a child of this widget's
	 * container node, and possible does other processing (such as layout).
	 * 
	 * @param widget
	 */
	public final native void addChild(_WidgetBase widget) /*-{
		this.addChild(widget);
	}-*/;

	/**
	 * Makes the given widget a child of this widget.
	 * <p>
	 * Inserts specified child widget's dom node as a child of this widget's
	 * container node, and possible does other processing (such as layout).
	 * 
	 * @param widget
	 * @param insertIndex
	 */
	public final native void addChild(_WidgetBase widget, int insertIndex) /*-{
		this.addChild(widget, insertIndex);
	}-*/;

	/**
	 * Removes the passed widget instance from this but does not destroy it. You
	 * can also pass in an integer indicating the index within the container to
	 * remove.
	 * 
	 * @param childIndex
	 */
	public final native void removeChild(int childIndex) /*-{
		this.removeChild(childIndex);
	}-*/;

	/**
	 * Removes the passed widget instance from this but does not destroy it. You
	 * can also pass in an integer indicating the index within the container to
	 * remove.
	 * 
	 * @param child
	 */
	public final native void removeChild(_WidgetBase child) /*-{
		this.removeChild(child);
	}-*/;

	/**
	 * Returns true if widget has children, i.e. if this.containerNode contains
	 * something.
	 * 
	 * @return
	 */
	public final native boolean hasChildren() /*-{
		return this.hasChildren();
	}-*/;

	/**
	 * Gets the index of the child in this container or -1 if not found.
	 * 
	 * @param child
	 * @return
	 */
	public final native int getIndexOfChild(_WidgetBase child) /*-{
		this.getIndexOfChild(child);
	}-*/;

}
