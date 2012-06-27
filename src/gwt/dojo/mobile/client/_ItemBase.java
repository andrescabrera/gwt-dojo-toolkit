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

public class _ItemBase extends _WidgetBase implements IContainer, IContained {

	/**
	 * label: String
	 * <p>
	 * A label of the item. If the label is not specified, innerHTML is used as
	 * a label.
	 */
	public static final String LABEL = "label";

	/**
	 * moveTo: String
	 * <p>
	 * The id of the transition destination view which resides in the current
	 * page.
	 * <p>
	 * If the value has a hash sign ('#') before the id (e.g. #view1) and the
	 * {@code dojo.hash} module is loaded by the user application, the view
	 * transition updates the hash in the browser URL so that the user can
	 * bookmark the destination view. In this case, the user can also use the
	 * browser's back/forward button to navigate through the views in the
	 * browser history.
	 * <p>
	 * If null, transitions to a blank view. If '#', returns immediately without
	 * transition.
	 */
	public static final String MOVETO = "moveTo";

	/**
	 * Default constructor.
	 */
	protected _ItemBase() {
	}

	/**
	 * Makes this widget in the selected state.
	 */
	public final native void select() /*-{
		this.select(true);
	}-*/;

	/**
	 * Makes this widget in the selected state.
	 */
	public final native void select(boolean selected) /*-{
		this.select(selected);
	}-*/;

	/**
	 * Makes this widget in the deselected state.
	 */
	public final native void deselect() /*-{
		this.deselect();
	}-*/;

	/**
	 * Performs a view transition.
	 * <p>
	 * Given a transition destination, this method performs a view transition.
	 * This method is typically called when this item is clicked.
	 */
	public final native void transitionTo(String id) /*-{
		this.transitionTo(id);
	}-*/;

}
