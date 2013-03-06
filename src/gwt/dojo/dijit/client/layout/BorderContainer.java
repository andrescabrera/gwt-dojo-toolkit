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

/**
 * Provides layout in up to 5 regions, a mandatory center with optional borders
 * along its 4 sides.
 * 
 * @author ggeorg
 */
public class BorderContainer extends _LayoutWidget {

	public static final String MODULE = "dijit/layout/BorderContainer";

	/**
	 * design: String (default: "headline")
	 * <p>
	 * Which design is used for the layout:
	 * <ul>
	 * <li>"headline" (default) where the top and bottom extend the full width
	 * of the container</li>
	 * <li>"sidebar" where the left and right sides extend from top to bottom.</li>
	 * </ul>
	 */
	public static final String DESIGN = "design";

	/**
	 * gutters: [const] Boolean
	 * <p>
	 * Give each pane a border and margin. Margin determined by
	 * domNode.paddingLeft. When false, only resizable panes have a gutter (i.e.
	 * draggable splitter) for resizing.
	 */
	public static final String GUTTERS = "gutters";

	/**
	 * liveSplitters: [const] Boolean
	 * <p>
	 * Specifies whether splitters resize as you drag (true) or only upon
	 * mouseup (false).
	 */
	public static final String LIVESPLITTERS = "liveSplitters";

	/**
	 * persist: Boolean
	 * <p>
	 * Save splitter positions in a cookie.
	 */
	public static final String PERSIST = "persist";

	/**
	 * Default constructor.
	 */
	protected BorderContainer() {
	}

}
