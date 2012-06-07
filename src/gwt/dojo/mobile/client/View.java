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

import gwt.dojo.dijit.client.IContained;
import gwt.dojo.dijit.client.IContainer;
import gwt.dojo.dijit.client._WidgetBase;

public class View extends _WidgetBase implements IContainer, IContained {

	public static final String MODULE = "dojox/mobile/View";

	public static native View create() /*-{
		return new $wnd.dojox.mobile.View();
	}-*/;

	protected View() {
	}

	/**
	 * Method to perform the various types of view transitions, such as fade,
	 * slide, and flip.
	 * 
	 * @param moveTo
	 *            The id of the transition destination view which resides in the
	 *            current page.
	 *            <p>
	 *            TODO
	 * 
	 * @param dir
	 *            The transition direction. If 1, transition forward. If -1,
	 *            transition backward. For example, the slide transition slides
	 *            the view from right to left when dir == 1, and from left to
	 *            right when dir == -1.
	 * @param transition
	 *            A type of animated transition effect. You can choose from the
	 *            standard transition types, "slide", "fade", "flip", or from
	 *            the extended transition types, "cover", "coverv", "dissolve",
	 *            "reveal", "revealv", "scaleIn", "scaleOut", "slidev", "swirl",
	 *            "zoomIn", "zoomOut". If "none" is specified, transition occurs
	 *            immediately without animation.
	 */
	public final native void performTransition(String moveTo, int dir,
			String transition) /*-{
		this.performTransition(moveTo, dir, transition);
	}-*/;

	/**
	 * Find the currently showing view from any sibling views.
	 * 
	 * @return The currently showing view.
	 */
	public final native View getShowingView() /*-{
		return this.getShowingView();
	}-*/;

	/**
	 * Shows this view without a transition animation.
	 */
	public final native void show() /*-{
		this.show();
	}-*/;

}
