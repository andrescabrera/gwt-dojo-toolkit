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

/**
 * A container that can be flipped horizontally.
 * <p>
 * SwapView is a container widget that represents entire mobile device screen,
 * and can be swiped horizontally. When SwapView is swiped, it finds an adjacent
 * SwapView to open it.
 * 
 * @author ggeorg
 */
public class SwapView extends View implements IScrollableMixin {

	public static final String MODULE = "dojox/mobile/SwapView";

	public static native SwapView create() /*-{
		return new $wnd.dojox.mobile.SwapView();
	}-*/;

	protected SwapView() {
	}

	/**
	 * Moves to the next or previous view.
	 * 
	 * @param dir
	 */
	public final native void goTo(int dir) /*-{
		this.goTo(dir);
	}-*/;
}
