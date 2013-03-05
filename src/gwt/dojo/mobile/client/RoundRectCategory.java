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
import gwt.dojo.dijit.client.IContained;
import gwt.dojo.dijit.client._WidgetBase;

public class RoundRectCategory extends _WidgetBase implements IContained {

	public static final String MODULE = "dojox/mobile/RoundRectCategory";

	public static RoundRectCategory create() {
		return JsObject.create(MODULE, JsObject.create());
	};

	public static RoundRectCategory create(JsObject options) {
		return JsObject.create(MODULE, options);
	};

	public static RoundRectCategory create(JsObject options, String nodeRef) {
		return JsObject.create(MODULE, options, nodeRef);
	};
	
	public static final String LABEL = "label";

	protected RoundRectCategory() {
	}

}
