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

/**
 * A non-templated widget that animates up from the bottom, overlaying the
 * current content.
 * 
 * @author ggeorg
 */
public class Overlay extends _WidgetBase {

	public static final String MODULE = "dojox/mobile/Overlay";

	public static native Overlay create() /*-{
		return new $wnd.dojox.mobile.Overlay();
	}-*/;

	protected Overlay() {
	}

}
