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

import gwt.dojo.dijit.client._WidgetBase;
import gwt.dojo.dijit.client.form.IFormValueMixin;

public class Slider extends _WidgetBase implements IFormValueMixin {
	
	public static final String MODULE = "dojox/mobile/Slider";
	
	public static final String VALUE = "value";
	public static final String MIN = "min";
	public static final String MAX = "max";
	public static final String STEP = "step";
	public static final String FLIP = "flip";
	public static final String ORIENTATION = "orientation";
	public static final String HALO = "halo";
	
	public static native Slider create() /*-{
		return new $wnd.dojox.mobile.Slider();
	}-*/;
	
	protected Slider() {
	}

}