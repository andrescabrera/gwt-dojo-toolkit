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

import gwt.dojo.dijit.client.IContained;
import gwt.dojo.dijit.client.IContainer;
import gwt.dojo.dijit.client._WidgetBase;

/**
 * 
 * @author ggeorg
 */
public class _LayoutWidget extends _WidgetBase implements IContainer, IContained {

	/**
	 * Default constructor.
	 */
	protected _LayoutWidget() {
	}

	/**
	 * Call this to resize a widget, or after its size has changed.
	 * 
	 * @param changeSize
	 * @param resultSize
	 */
	public final native void resize(Object changeSize, Object resultSize) /*-{
		this.resize(changeSize, resultSize);
	}-*/;

}
