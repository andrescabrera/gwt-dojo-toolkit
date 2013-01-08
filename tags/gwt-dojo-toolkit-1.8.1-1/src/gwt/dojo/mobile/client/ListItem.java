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

public class ListItem extends _ItemBase {

	public static final String MODULE = "dojox/mobile/ListItem";

	/**
	 * rightText: String
	 * <p>
	 * A right-aligned text to display on the item.
	 */
	public static final String RIGHTTEXT = "rightText";

	/**
	 * rightIcon: String
	 * <p>
	 * An icon to display at the right hand side of the item. The value can be
	 * either a path for an image file or a class name of a DOM button.
	 */
	public static final String RIGHTICON = "rightIcon";

	/**
	 * rightIcon2: String
	 * <p>
	 * An icon to display at the left of the rightIcon. The value can be either
	 * a path for an image file or a class name of a DOM button.
	 */
	public static final String RIGHTICON2 = "rightIcon2";

	/**
	 * anchorLabel: Boolean
	 * <p>
	 * If true, the label text becomes a clickable anchor text. When the user
	 * clicks on the text, the onAnchorLabelClicked handler is called. You can
	 * override or connect to the handler and implement any action. The handler
	 * has no default action.
	 */
	public static final String ANCHORLABEL = "anchorLabel";

	/**
	 * noArrow: Boolean
	 * <p>
	 * If true, the right hand side arrow is not displayed.
	 */
	public static final String NOARROW = "noArrow";

	/**
	 * selected: Boolean
	 * <p>
	 * If true, the item is highlighted to indicate it is selected.
	 */
	public static final String SELECTED = "selected";

	/**
	 * checked: Boolean
	 * <p>
	 * If true, a check mark is displayed at the right of the item.
	 */
	public static final String CHECKED = "checked";

	/**
	 * arrowClass: String
	 * <p>
	 * An icon to display as a check mark. The value can be either a path for an
	 * image file or a class name of a DOM button.
	 */
	public static final String ARROWCLASS = "arrowClass";

	/**
	 * variableHeight: Boolean
	 * <p>
	 * If true, the height of the item varies according to its content. In dojo
	 * 1.6 or older, the "mblVariableHeight" class was used for this purpose. In
	 * dojo 1.7, adding the mblVariableHeight class still works for backward
	 * compatibility.
	 */
	public static final String VARIABLEHEIGHT = "variableHeight";
	
	/**
	 * rightIconTitle: String
	 * <p>
	 * An alt text for the right icon.
	 */
	public static final String RIGHTICONTITLE = "rightIconTitle";
	
	/**
	 * rightIcon2Title: String
	 * <p>
	 * An alt text for the right icon2.
	 */
	public static final String RIGHTICON2TITLE = "rightIcon2Title";

	public static native ListItem create() /*-{
		return new $wnd.dojox.mobile.ListItem();
	}-*/;

	protected ListItem() {
	}

}
