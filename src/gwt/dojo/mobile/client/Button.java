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

import gwt.dojo.dijit.client.Registry;
import gwt.dojo.dijit.client._WidgetBase;
import gwt.dojo.dijit.client.form.IButtonMixin;
import gwt.dojo.dijit.client.form.IFormWidgetMixin;

public class Button extends _WidgetBase implements IFormWidgetMixin,
		IButtonMixin {

	public static final String MODULE = "dojox/mobile/Button";

	public static Button byId(String string) {
		return Registry.get().byId(string);
	}

	public static native Button create() /*-{
		return new $wnd.dojox.mobile.Button();
	}-*/;

	/**
	 * Not directly instantiable. All subclasses must also define a protected,
	 * empty, no-arg constructor.
	 */
	protected Button() {
	}

}
