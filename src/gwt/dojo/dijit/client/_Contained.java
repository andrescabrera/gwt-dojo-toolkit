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

import gwt.dojo.client.util.JsObject;

/**
 * Mixin for widgets that are children of a container widget.
 * 
 * @author ggeorg
 */
public class _Contained extends _WidgetBase {

	public static _Container cast(IContained widget) {
		assert widget instanceof _WidgetBase : "Not a widget";
		return ((_WidgetBase) widget).cast();
	}

	/**
	 * Not directly instantiable.
	 */
	protected _Contained() {
	}

	/**
	 * Returns {@code null} if this is the first child of the parent, otherwise
	 * returns the next element sibling to the "left".
	 * 
	 * @return
	 */
	public final native JsObject getPreviousSibling() /*-{
		return this.getPreviousSibling();
	}-*/;

	/**
	 * Returns {@code null} if this is the last child of the parent, otherwise
	 * returns the next element sibling to the "right".
	 * 
	 * @return
	 */
	public final native JsObject getNextSibling() /*-{
		return this.getNextSibling();
	}-*/;

	/**
	 * Returns the index of this widget within its container parent. It returns
	 * -1 if the parent does not exist, or if the parent is not a
	 * {@link _Container}.
	 * 
	 * @return
	 */
	public final native int getIndexInParent() /*-{
		return this.getIndexInParent();
	}-*/;

}
