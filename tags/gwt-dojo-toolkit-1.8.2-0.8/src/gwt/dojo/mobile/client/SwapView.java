/*
 * Copyright 2012, 2013 ArkaSoft LLC.
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
 * A container that can be swiped horizontally.
 * <p>
 * {@ code SwapView} is a container widget that represents entire mobile device
 * screen, and can be swiped horizontally. {@code SwapView} is a subclass of
 * {@link View}. {@code SwapView} allows the user to swipe the screen left or
 * right to move between the views. When {@code SwapView} is swiped, it finds an
 * adjacent {@code SwapView} to open. When the transition is done, a topic
 * {@code /dojox/mobile/viewChanged} is published.
 */
public class SwapView extends View implements IScrollableMixin {

	public static final String MODULE = "dojox/mobile/SwapView";

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
