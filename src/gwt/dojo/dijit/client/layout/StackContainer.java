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
package gwt.dojo.dijit.client.layout;

import gwt.dojo.dijit.client._WidgetBase;

/**
 * A container that has multiple children, but shows only one child at a time.
 * 
 * @author ggeorg
 */
public class StackContainer extends _LayoutWidget {

	public static final String MODULE = "dijit/layout/StackContainer";

	protected StackContainer() {
	}

	public final native void selectChild(String id, boolean animate) /*-{
		this.selectChild(id);
	}-*/;

	public final native void selectChild(_WidgetBase widget, boolean animate) /*-{
		this.selectChild(widget, animate);
	}-*/;

	public final native void forward() /*-{
		this.forward();
	}-*/;

	public final native void back() /*-{
		this.back();
	}-*/;

}
