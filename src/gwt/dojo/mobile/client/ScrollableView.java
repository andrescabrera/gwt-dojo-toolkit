/*
 * Copyright 2012, 2013 ArkaSoft LLC.
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

import gwt.dojo.dijit.client._WidgetBase;

/**
 * A container that has a touch scrolling capability.
 * <p>
 * {@code ScrollableView} is a subclass of View (dojox/mobile/View). Unlike the
 * base {@link View} class, {@code ScrollableView}'s {@code domNode} always
 * stays at the top of the screen and its height is "100%" of the screen. Inside
 * this fixed {@code domNode}, the {@code containerNode} scrolls. The browser's
 * default scrolling behavior is disabled, and the scrolling mechanism is
 * reimplemented in JavaScript. Thus the user does not need to use the
 * two-finger operation to scroll the inner DIV ({@code containerNode}). The
 * main purpose of this widget is to realize fixed-positioned header and/or
 * footer bars.
 */
public class ScrollableView extends View implements IScrollableMixin {

	public static final String MODULE = "dojox/mobile/ScrollableView";

	protected ScrollableView() {
	}

	/**
	 * Adds a view local fixed bar to this widget.
	 * <p>
	 * This method can be used to programmatically add a view local fixed bar to
	 * {@code ScrollableView}. The bar is appended to this widget's
	 * {@code domNode}. The addChild API cannot be used for this purpose,
	 * because it adds the given widget to containerNode.
	 * 
	 * @param widget
	 *            The widget to add.
	 */
	public final native void addFixedBar(_WidgetBase widget) /*-{
		this.addFixedBar(widget);
	}-*/;
}
