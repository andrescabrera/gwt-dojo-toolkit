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

import gwt.dojo.client.util.JsArray;
import gwt.dojo.client.util.JsObject;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Window;

/**
 * Base class for all Dijit widgets.
 * 
 * @author ggeorg
 */
public class _WidgetController {

	/**
	 * Widget factory method.
	 * 
	 * @return An un-initialized widget.
	 */
	public static class _WidgetControllerFactory {
		private static _WidgetControllerFactory instance = null;

		public static _WidgetControllerFactory get() {
			if (instance == null) {
				instance = new _WidgetControllerFactory();
			}
			return instance;
		}

		protected _WidgetControllerFactory() {
		}
		
		protected native JsObject create() /*-{
			
		}-*/;
		
		protected JsArray getSuperClass() {
			return JsArray.create("dijit/_WidgetBase");
		}

		protected native JsObject init(JsObject obj) /*-{
			var widget = obj._controller = @gwt.dojo.dijit.client._WidgetController::new()();

			// params: Object|null
			// srcNodeRef: DOMNode|String?
			obj.constructor = function(params, srcNodeRef) {
				widget.@gwt.dojo.dijit.client._WidgetController::constructor(Lgwt/dojo/dijit/client/_WidgetBase;Lgwt/dojo/client/util/JsObject;Lcom/google/gwt/dom/client/Element;)(this, params, srcNodeRef);
			};

			obj.postMixInProperties = function() {
				widget.@gwt.dojo.dijit.client._WidgetController::postMixInProperties()();
			};

			obj.buildRendering = function() {
				widget.@gwt.dojo.dijit.client._WidgetController::buildRendering()();
				this.inherited(arguments);
			};

			obj.postCreate = function() {
				widget.@gwt.dojo.dijit.client._WidgetController::postCreate()();
			};

			// preserveDom: Boolean
			obj.destroyRecursive = function(preserveDom) {
				widget.@gwt.dojo.dijit.client._WidgetController::destroyRecursive(Z)(preserveDom);
				this.inherited(preserveDom);
			};

			// preserveDom: Boolean
			obj.destroy = function(preserveDom) {
				widget.@gwt.dojo.dijit.client._WidgetController::destroy(Z)(preserveDom);
				this.inherited(preserveDom);
			};

			// preserveDom: Boolean
			obj.destroyRendering = function(preserveDom) {
				widget.@gwt.dojo.dijit.client._WidgetController::destroyRendering(Z)(preserveDom);
			};

			// preserveDom: Boolean
			obj.destroyDescendants = function(preserveDom) {
				widget.@gwt.dojo.dijit.client._WidgetController::destroyDescendants(Z)(preserveDom);
				this.inherited(preserveDom);
			};

			return obj;

		}-*/;
	}
	
	// ////////////////////////////////////////////////////////////////////////

	private _WidgetBase widgetBase;

	protected _WidgetController() {
	}

	// ///////// INITIALIZATION METHODS ///////////////////////////////////////

	protected void constructor(_WidgetBase widgetBase, JsObject params,
			Element srcNodeRef) {
		this.widgetBase = widgetBase;
		Window.alert("contructor: " + params.toJson() + "---" + srcNodeRef);
	}

	/**
	 * Called after the parameters to the widget have been read-in, but before
	 * the widget template is instantiated. Especially useful to set properties
	 * that are referenced in the widget template.
	 */
	protected void postMixInProperties() {
		Window.alert("postMixInProperties:");
	}

	/**
	 * Construct the UI for this widget, setting this.domNode. Most widgets will
	 * mixin `dijit._TemplatedMixin`, which implements this method.
	 */
	protected void buildRendering() {
		Window.alert("buildRendering:");
	}

	/**
	 * Called after a widget and its children have been created and added to the
	 * page, and all related widgets have finished their create() cycle, up
	 * through postCreate(). This is useful for composite widgets that need to
	 * control or layout sub-widgets. Many layout widgets can use this as a
	 * wiring phase.
	 */
	protected void postCreate() {
		Window.alert("postCreate:");
	}

	// ///////// DESTROY FUNCTIONS ////////////////////////////////////////////

	/**
	 * Destroy this widget and its descendants.
	 * <p>
	 * This is the generic "destructor" function that all widget users should
	 * call to cleanly discard with a widget. Once a widget is destroyed, it is
	 * removed from the manager object.
	 * 
	 * @param preserveDom
	 *            If {@code true}, this method will leave the original DOM
	 *            structure alone. Note: This will not yet work with _Templated
	 *            widgets.
	 */
	public final void destroyRecursive(boolean preserveDom) {
		widgetBase.destroyDescendants(preserveDom);
	}

	/**
	 * Destroy this widget, but not its descendants. This method will, however,
	 * destroy internal widgets such as those used within a template.
	 * 
	 * @param preserveDom
	 *            If {@code true}, this method will leave the original DOM
	 *            structure alone. Note: This will not yet work with _Templated
	 *            widgets.
	 */
	public void destroy(boolean preserveDom) {
		widgetBase.destroy(preserveDom);
	}

	/**
	 * Destroys the DOM nodes associated with this widget.
	 * 
	 * @param preserveDom
	 *            If {@code true}, this method will leave the original DOM
	 *            structure alone. Note: This will not yet work with _Templated
	 *            widgets.
	 */
	protected void destroyRendering(boolean preserveDom) {
		widgetBase.destroyRendering(preserveDom);
	}

	/**
	 * Recursively destroy the children of this widget and their descendants.
	 * 
	 * @param preserveDom
	 *            If {@code true}, this method will leave the original DOM
	 *            structure alone. Note: This will not yet work with _Templated
	 *            widgets.
	 */
	public void destroyDescendants(boolean preserveDom) {
		widgetBase.destroyDescendants(preserveDom);
	}

	// ////////////////GET/SET, CUSTOM SETTERS, ETC. //////////////////////////

	/**
	 * Returns
	 */
	@Override
	public String toString() {
		return widgetBase.toJson();
	}

}
