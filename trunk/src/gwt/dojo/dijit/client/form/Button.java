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
package gwt.dojo.dijit.client.form;

/**
 * Button widget. Basically the same thing as a normal HTML button, but with
 * special styling.
 * <p>
 * Buttons can display a label, an icon, or both. A label should always be
 * specified (through innerHTML) or the label attribute. It can be hidden via
 * {@code showLabel=false}.
 * 
 * @author ggeorg
 */
public class Button extends _FormWidget implements IButtonMixin {

	public static final String MODULE = "dijit/form/Button";

	/**
	 * duration: Number (1000)
	 * <p>
	 * Duration of selection, milliseconds or -1 for no post-click CSS styling.
	 */
	public static final String DURATION = "duration";

	/**
	 * showLabel: Boolean
	 * <p>
	 * Set this to {@code true} to hide the label text and display only the
	 * icon. (If {@code showLabel=false} then {@code iconClass} must be
	 * specified). Especially useful for toolbars. If {@code showLabel=true},
	 * the label will become the title (a.k.a. tooltip/hint) of the icon.
	 * <p>
	 * The exception case is for computers in high-contrast mode, where the
	 * label will still be displayed, since the icon doesn't appear.
	 */
	public static final String SHOWLABEL = "showLabel";

	/**
	 * Class to apply to DOMNode in button to make it display an icon.
	 */
	public static final String ICONCLASS = "iconClass";

	/**
	 * Default constructor.
	 */
	protected Button() {
	}

}
