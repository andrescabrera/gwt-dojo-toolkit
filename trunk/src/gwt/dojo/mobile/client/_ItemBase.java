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

import gwt.dojo.core.client.DojoCallback;
import gwt.dojo.dijit.client.IContained;
import gwt.dojo.dijit.client.IContainer;
import gwt.dojo.dijit.client._WidgetBase;

/**
 * A base class for item classes (e.g. {@link ListItem}, {@link IconItem},
 * etc.).
 * <p>
 * {@code _ItemBase} is a base class for widgets that have capability to make a
 * view transition when clicked.
 */
public class _ItemBase extends _WidgetBase implements IContainer, IContained {

	/**
	 * icon: String
	 * <p>
	 * An icon image to display. The value can be either a path for an image
	 * file or a class name of a DOM button. If icon is not specified, the
	 * iconBase parameter of the parent widget is used.
	 */
	public static final String ICON = "icon";

	/**
	 * iconPos: String
	 * <p>
	 * The position of an aggregated icon. IconPos is comma separated values
	 * like top,left,width,height (ex. "0,0,29,29"). If iconPos is not
	 * specified, the iconPos parameter of the parent widget is used.
	 */
	public static final String ICONPOS = "iconPos";

	/**
	 * alt: String
	 * <p>
	 * An alternate text for the icon image.
	 */
	public static final String ALT = "alt";

	/**
	 * href: String
	 * <p>
	 * A URL of another web page to go to.
	 */
	public static final String HREF = "href";

	/**
	 * hrefTarget: String
	 * <p>
	 * A target that specifies where to open a page specified by href. The value
	 * will be passed to the 2nd argument of window.open().
	 */
	public static final String HREFTARGET = "hrefTarget";

	/**
	 * moveTo: String
	 * <p>
	 * The id of the transition destination view which resides in the current
	 * page.
	 * <p>
	 * If the value has a hash sign ('#') before the id (e.g. #view1) and the
	 * dojo/hash module is loaded by the user application, the view transition
	 * updates the hash in the browser URL so that the user can bookmark the
	 * destination view. In this case, the user can also use the browser's
	 * back/forward button to navigate through the views in the browser history.
	 * <p>
	 * If null, transitions to a blank view. If '#', returns immediately without
	 * transition.
	 */
	public static final String MOVETO = "moveTo";

	/**
	 * clickable: Boolean
	 * <p>
	 * If {@code true}, this item becomes clickable even if a transition
	 * destination (moveTo, etc.) is not specified.
	 */
	public static final String CLICKABLE = "clickable";

	/**
	 * url: String
	 * <p>
	 * A URL of an html fragment page or JSON data that represents a new view
	 * content. The view content is loaded with XHR and inserted in the current
	 * page. Then a view transition occurs to the newly created view. The view
	 * is cached so that subsequent requests would not load the content again.
	 */
	public static final String URL = "url";

	/**
	 * urlTarget: String
	 * <p>
	 * Node id under which a new view will be created according to the url
	 * parameter. If not specified, The new view will be created as a sibling of
	 * the current view.
	 */
	public static final String URLTARGET = "urlTarget";

	/**
	 * back: Boolean
	 * <p>
	 * If {@code true}, {@code history.back()} is called when clicked.
	 */
	public static final String BACK = "back";

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
	 * transitionDir: Number (default: 1)
	 * <p>
	 * The transition direction. If 1, transition forward. If -1, transition
	 * backward. For example, the slide transition slides the view from right to
	 * left when dir == 1, and from left to right when dir == -1.
	 */
	public static final String TRANSITIONDIR = "transitionDir";

	/**
	 * transitionOptions: JsObject
	 * <p>
	 * A hash object that holds transition options.
	 */
	public static final String TRANSITIONOPTIONS = "transitionOptions";

	/**
	 * callback: Function|String
	 * <p>
	 * A callback function that is called when the transition has been finished.
	 * A function reference, or name of a function in context.
	 * <p>
	 * TODO: verify that 'String' option is valid.
	 * 
	 * @see #setCallback(DojoCallback)
	 */
	public static final String CALLBACK = "callback";

	/**
	 * label: String
	 * <p>
	 * A label of the item. If the label is not specified, innerHTML is used as
	 * a label.
	 */
	public static final String LABEL = "label";

	/**
	 * toggle: Boolean
	 * <p>
	 * If {@code true}, the item acts like a toggle button.
	 */
	public static final String TOGGLE = "toggle";

	/**
	 * selected: Boolean
	 * <p>
	 * If {@code true}, the item is highlighted to indicate it is selected.
	 */
	public static final String SELECTED = "selected";

	/**
	 * tabIndex: String
	 * <p>
	 * Tabindex setting for the item so users can hit the tab key to focus on
	 * it.
	 */
	public static final String TABINDEX = "tabIndex";

	/**
	 * Default constructor.
	 */
	protected _ItemBase() {
	}

	/**
	 * 
	 * @param callback
	 */
	public final native void setCallback(DojoCallback<?> callback) /*-{
		var callbackFcn = function() {
			try {
				@gwt.dojo.core.client.Dojo::doDojoCallback(Ljava/lang/Object;Lgwt/dojo/core/client/DojoCallback;Lgwt/dojo/core/client/JsArray;)(this, callback, _arguments);
			} catch (ex) {
				alert("Error in callback: " + ex);
			}
		};

		this.set("callback", callback ? callbackFcn : null);
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
