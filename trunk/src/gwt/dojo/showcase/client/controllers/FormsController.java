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
package gwt.dojo.showcase.client.controllers;

import gwt.dojo.client.Dojo;
import gwt.dojo.client.EventCallback;
import gwt.dojo.client.RequireCallback;
import gwt.dojo.client.util.JsObject;
import gwt.dojo.dijit.client._WidgetBase;
import gwt.dojo.mobile.client.Button;
import gwt.dojo.mobile.client.ListItem;
import gwt.dojo.mobile.client.Slider;
import gwt.dojo.showcase.client.Showcase;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.FormElement;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;

public class FormsController implements Controller, EventCallback {

	private final Showcase showcase;

	public FormsController(Showcase showcase) {
		this.showcase = showcase;
	}

	@Override
	public void callback(final JsObject source, NativeEvent event) {
		Dojo.require(new RequireCallback() {
			@Override
			public void callback(final JsObject arguments) {
				ListItem listItem = source.cast();
				listItem.set("controller", FormsController.this);
				showcase.showView(listItem);
			}
		}, "dojox/mobile/TextBox", "dojox/mobile/TextArea",
				"dojox/mobile/CheckBox", "dojox/mobile/RadioButton",
				"dojox/mobile/Slider");
	}

	@Override
	public void activate(ListItem listItem) {
		Slider slider = Slider.byId("alertSlider");
		slider.on("focus", new EventCallback() {
			@Override
			public void callback(JsObject source, NativeEvent event) {
				Window.alert("focus");
			}
		});
		Button resetBtn = Button.byId("resetBtn");
		resetBtn.on("click", new EventCallback() {
			@Override
			public void callback(JsObject source, NativeEvent event) {
				// roll back all form inputs
				FormElement form = Document.get().getElementById("testForm")
						.cast();
				form.reset();

				try {
					_WidgetBase.byId("alertSwitch").set("value", "off");
					_WidgetBase.byId("alertSlider").set("value", 0);
					_WidgetBase.byId("alert-all").set("checked", false);
					_WidgetBase.byId("alert-urgent").set("checked", true);
				} catch (Exception e) {
					Window.alert("" + e);
				}
			}
		});
	}
}
