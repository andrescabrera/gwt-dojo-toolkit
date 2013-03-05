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
package gwt.dojo.mobile.client;

import gwt.dojo.core.client.JsObject;
import gwt.dojo.dijit.client._WidgetBase;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Mixin for widgets to have touch scrolling capability.
 */
public class _ScrollableMixin extends JavaScriptObject {

	/**
	 * 
	 * @param widget
	 * @return
	 */
	public static _ScrollableMixin cast(IScrollableMixin widget) {
		assert widget instanceof _WidgetBase : "Not a widget";
		return ((_WidgetBase) widget).cast();
	}

	protected _ScrollableMixin() {
	}

	/**
	 * Scrolls the pane until the searching node is in the view.
	 * 
	 * @param node
	 *            A DOM node to be searched for view.
	 */
	public final native void scrollIntoView(Element node) /*-{
		this.scrollIntoView(node);
	}-*/;

	/**
	 * Scrolls the pane until the searching node is in the view.
	 * 
	 * @param node
	 *            A DOM node to be searched for view.
	 * @param alignWithTop
	 *            If {@code true}, aligns the node at the top of the pane. If
	 *            {@code false}, aligns the node at the bottom of the pane.
	 */
	public final native void scrollIntoView(Element node, boolean alignWithTop) /*-{
		this.scrollIntoView(node, alignWithTop);
	}-*/;

	/**
	 * Scrolls the pane until the searching node is in the view.
	 * 
	 * @param node
	 *            A DOM node to be searched for view.
	 * @param alignWithTop
	 *            If {@code true}, aligns the node at the top of the pane. If
	 *            {@code false}, aligns the node at the bottom of the pane.
	 * @param duration
	 *            Duration of scrolling in seconds. (ex. 0.3).
	 */
	public final native void scrollIntoView(Element node, boolean alignWithTop,
			double duration) /*-{
		this.scrollIntoView(node, alignWithTop, duration);
	}-*/;

	/**
	 * Sets the given node as selectable or unselectable.
	 */
	public final native void setSelectable(Element node, boolean selectable) /*-{
		this.setSelectable(node, selectable);
	}-*/;

	/**
	 * Scrolls to the given position to{x:value,y:value}
	 */
	public final native void scrollTo(JsObject to) /*-{
		this.scrollTo(to);
	}-*/;

	/**
	 * Scrolls to the given position with the slide animation.
	 * 
	 * @param to
	 *            The scroll destination position. An object with x and/or y.
	 *            ex. {x:0, y:-5}, {y:-29}, etc.
	 * @param duration
	 *            Duration of scrolling in seconds. (ex. 0.3).
	 * @param easing
	 *            The name of easing effect which webkit supports. "ease",
	 *            "linear", "ease-in", "ease-out", etc.
	 */
	public final native void slideTo(JsObject to, double duration, String easing) /*-{
		this.slideTo(to, duration, easing);
	}-*/;

}
