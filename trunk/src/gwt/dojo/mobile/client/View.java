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
import gwt.dojo.core.client.JsArray;
import gwt.dojo.dijit.client.IContained;
import gwt.dojo.dijit.client.IContainer;
import gwt.dojo.dijit.client._WidgetBase;

/**
 * A widget that represents a view that occupies the full screen.
 * <p>
 * View acts as a container for any HTML and/or widgets. An entire HTML page can
 * have multiple View widgets and the user can navigate through the views back
 * and forth without page transitions.
 */
public class View extends _WidgetBase implements IContainer, IContained {

	public static final String MODULE = "dojox/mobile/View";

	/**
	 * selected: Boolean (default: {@code false})
	 * <p>
	 * If {@code true}, the view is displayed at startup time.
	 */
	public static final String SELECTED = "selected";

	/**
	 * keepScrollPos: Boolean (default: {@code true})
	 * <p>
	 * If {@code true}, the scroll position is kept when transition occurs
	 * between views.
	 */
	public static final String KEEPSCROLLPOS = "keepScrollPos";

	public static final String TOPIC_STARTVIEW = "/dojox/mobile/startView";
	public static final String TOPIC_BEFORETRANSITIONIN = "/dojox/mobile/beforeTransitionIn";
	public static final String TOPIC_AFTERTRANSITIONIN = "/dojox/mobile/afterTransitionIn";
	public static final String TOPIC_BEFORETRANSITIONOUT = "/dojox/mobile/beforeTransitionOut";
	public static final String TOPIC_AFTERTRANSITIONOUT = "/dojox/mobile/afterTransitionOut";

	protected View() {
	}

	/**
	 * Calls {@code resize()} of each child widget.
	 */
	public final native void resize() /*-{
		this.resize();
	}-*/;

	/**
	 * Method to perform the various types of view transitions, such as fade,
	 * slide, and flip.
	 * 
	 * @param moveTo
	 *            The id of the transition destination view which resides in the
	 *            current page.
	 *            <p>
	 *            If the value has a hash sign ('#') before the id (e.g. #view1)
	 *            and the dojo/hash module is loaded by the user application,
	 *            the view transition updates the hash in the browser URL so
	 *            that the user can bookmark the destination view. In this case,
	 *            the user can also use the browser's back/forward button to
	 *            navigate through the views in the browser history.
	 *            <p>
	 *            If {@code null}, transitions to a blank view.
	 *            <p>
	 *            If '#', returns immediately without transition.
	 * @param dir
	 *            The transition direction. If 1, transition forward. If -1,
	 *            transition backward. For example, the slide transition slides
	 *            the view from right to left when transitionDir == 1, and from
	 *            left to right when transitionDir == -1.
	 * @param transition
	 *            A type of animated transition effect. You can choose from the
	 *            standard transition types, "slide", "fade", "flip", or from
	 *            the extended transition types, "cover", "coverv", "dissolve",
	 *            "reveal", "revealv", "scaleIn", "scaleOut", "slidev", "swirl",
	 *            "zoomIn", "zoomOut", "cube", and "swap". If "none" is
	 *            specified, transition occurs immediately without animation.
	 */
	public final native void performTransition(String moveTo, int dir,
			String transition) /*-{
		this.performTransition(moveTo, dir, transition);
	}-*/;

	/**
	 * Method to perform the various types of view transitions, such as fade,
	 * slide, and flip.
	 * 
	 * @param moveTo
	 *            The id of the transition destination view which resides in the
	 *            current page.
	 *            <p>
	 *            If the value has a hash sign ('#') before the id (e.g. #view1)
	 *            and the dojo/hash module is loaded by the user application,
	 *            the view transition updates the hash in the browser URL so
	 *            that the user can bookmark the destination view. In this case,
	 *            the user can also use the browser's back/forward button to
	 *            navigate through the views in the browser history.
	 *            <p>
	 *            If {@code null}, transitions to a blank view.
	 *            <p>
	 *            If '#', returns immediately without transition.
	 * @param dir
	 *            The transition direction. If 1, transition forward. If -1,
	 *            transition backward. For example, the slide transition slides
	 *            the view from right to left when transitionDir == 1, and from
	 *            left to right when transitionDir == -1.
	 * @param transition
	 *            A type of animated transition effect. You can choose from the
	 *            standard transition types, "slide", "fade", "flip", or from
	 *            the extended transition types, "cover", "coverv", "dissolve",
	 *            "reveal", "revealv", "scaleIn", "scaleOut", "slidev", "swirl",
	 *            "zoomIn", "zoomOut", "cube", and "swap". If "none" is
	 *            specified, transition occurs immediately without animation.
	 * @param context
	 *            The object that the callback function will receive as
	 *            {@code this}.
	 * @param callback
	 *            A callback function that is called when the transition has
	 *            finished.
	 */
	public final native <T> void performTransition(String moveTo, int dir,
			String transition, T context, DojoCallback<T> callback) /*-{
		var callbackFcn = function() {
			try {
				@gwt.dojo.core.client.Dojo::doDojoCallback(Ljava/lang/Object;Lgwt/dojo/core/client/DojoCallback;Lgwt/dojo/core/client/JsArray;)(this, callback, arguments);
			} catch (ex) {
				alert("Error in callback: " + ex);
			}
		};

		this.performTransition(moveTo, dir, transition, context,
				callback ? callbackFcn : null);
	}-*/;

	/**
	 * Return {@code true} if this view is visible.
	 * 
	 * @return {@code true} if this view is visible.
	 */
	public final native boolean isVisible() /*-{
		return this.isVisible();
	}-*/;

	/**
	 * Return {@code true} if this view is visible.
	 * 
	 * @param checkAncestors
	 *            If {@code true}, in addition to its own visibility, also
	 *            checks the ancestors visibility to see if the view is actually
	 *            being shown or not.
	 * @return {@code true} if this view is visible.
	 */
	public final native boolean isVisible(boolean checkAncestors) /*-{
		return this.isVisible(checkAncestors);
	}-*/;

	/**
	 * Find the currently showing view from any sibling views.
	 * <p>
	 * Note that depending on the ancestor view's visibility, the found view may
	 * not be actually shown.
	 * 
	 * @return The currently showing view.
	 */
	public final native View getShowingView() /*-{
		return this.getShowingView();
	}-*/;

	/**
	 * Returns an array of the sibling views.
	 * 
	 * @return an array of the sibling views.
	 */
	public final native JsArray/* <View> */getSiblingViews() /*-{
		return this.getSiblingViews();
	}-*/;

	/**
	 * Shows this view without a transition animation.
	 */
	public final native void show() /*-{
		this.show();
	}-*/;

	/**
	 * Shows this view without a transition animation.
	 * 
	 * @param noEvent
	 * @param doNotHideOthers
	 */
	public final native void show(boolean noEvent, boolean doNotHideOthers) /*-{
		this.show(noEvent, doNotHideOthers);
	}-*/;

	/**
	 * Hides this view without a transition animation.
	 */
	public final native void hide() /*-{
		this.hide();
	}-*/;

}
