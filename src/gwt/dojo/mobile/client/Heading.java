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

import gwt.dojo.core.client.JsObject;
import gwt.dojo.dijit.client.IContained;
import gwt.dojo.dijit.client.IContainer;
import gwt.dojo.dijit.client._WidgetBase;

public class Heading extends _WidgetBase implements IContainer, IContained {

	public static final String MODULE = "dojox/mobile/Heading";

	public static Heading create() {
		return JsObject.create(MODULE, JsObject.create());
	};

	public static Heading create(JsObject options) {
		return JsObject.create(MODULE, options);
	};

	public static Heading create(JsObject options, String nodeRef) {
		return JsObject.create(MODULE, options, nodeRef);
	};

	/**
	 * back: String
	 * <p>
	 * A label for the navigational control to return to the previous View.
	 */
	public static final String BACK = "back";

	/**
	 * href: String
	 * <p>
	 * A URL to open when the navigational control is pressed.
	 */
	public static final String HREF = "href";

	/**
	 * moveTo: String
	 * <p>
	 * The id of the transition destination view which resides in the current
	 * page.
	 * <p>
	 * If the value has a hash sign ('#') before the id (e.g. #view1) and the
	 * dojo.hash module is loaded by the user application, the view transition
	 * updates the hash in the browser URL so that the user can bookmark the
	 * destination view. In this case, the user can also use the browser's
	 * back/forward button to navigate through the views in the browser history.
	 * <p>
	 * If null, transitions to a blank view. If '#', returns immediately without
	 * transition.
	 */
	public static final String MOVETO = "moveTo";

	/**
	 * transition: String
	 * <p>
	 * A type of animated transition effect. You can choose from the standard
	 * transition types, "slide", "fade", "flip", or from the extended
	 * transition types, "cover", "coverv", "dissolve", "reveal", "revealv",
	 * "scaleIn", "scaleOut", "slidev", "swirl", "zoomIn", "zoomOut". If "none"
	 * is specified, transition occurs immediately without animation.
	 */
	public static final String TRANSITION = "transition";

	/**
	 * label: String
	 * <p>
	 * A title text of the heading. If the label is not specified, the innerHTML
	 * of the node is used as a label.
	 */
	public static final String LABEL = "label";

	/**
	 * iconBase: String
	 * <p>
	 * The default icon path for child items.
	 */
	public static final String ICONBASE = "iconBase";

	/**
	 * backProp: Object
	 * <p>
	 * Properties for the back button.
	 */
	public static final String BACKPROP = "backProp";

	/**
	 * fixed: String
	 * <p>
	 * "top" or "bottom".
	 */
	public static final String FIXED = "fixed";

	protected Heading() {
	}

}
