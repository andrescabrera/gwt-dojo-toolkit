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
package gwt.dojo.charting.client.plot2d;

import gwt.dojo.client.Dojo;
import gwt.dojo.client.util.JsObject;

public class StackedAreas extends Stacked {
	public static final String MODULE = "dojox/charting/plot2d/StackedAreas";

	public static JsObject ref() {
		return Dojo.require(MODULE);
	};

	protected StackedAreas() {
	}
}
