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
 * Interface for widgets to have touch scrolling capability.
 * <p>
 * Mobile WebKit browsers do not allow scrolling inner DIV's (for instance, on
 * iOS you need the two-finger operation to scroll them). That means you cannot
 * have fixed-positioned header/footer bars. To solve this issue, this module
 * disables the browser's default scrolling behavior, and rebuilds its own
 * scrolling machinery by handling touch events. In the module,
 * {@code  this.domNode} has height "100%" and is fixed to the window, and
 * {@code this.containerNode} scrolls. If you place a bar outside of
 * {@this.containerNode}, then it will be fixed-positioned while
 * {@code this.containerNode} is scrollable.
 * 
 * @author ggeorg
 */
public interface IScrollableMixin {

	/**
	 * fixedHeader: String (default: "")
	 * <p>
	 * Id of the fixed header.
	 */
	static final String FIXEDHEADER = "fixedHeader";

	/**
	 * fixedFooter: String (default: "")
	 * <p>
	 * Id of the fixed footer.
	 */
	static final String FIXEDFOOTER = "fixedFooter";

	/**
	 * scrollableParams: Object (default: null)
	 * <p>
	 * Parameters for dojox/mobile/scrollable.init().
	 */
	public static final String SCROLLABLEPARAMS = "scrollableParams";

	/**
	 * allowNestedScrolls: Boolean (default: true)
	 * <p>
	 * Flag to allow scrolling in nested containers, e.g. to allow
	 * {@code ScrollableView} in a {@link SwapView}.
	 */
	public static final String ALLOWNESTEDSCROLLS = "allowNestedScrolls";

	// scrollable.js

	/**
	 * fixedHeaderHeight: Number (default: 0)
	 * <p>
	 * Height of a fixed header.
	 */
	static final String FIXEDHEADERHEIGHT = "fixedHeaderHeight";

	/**
	 * fixedFooterHeight: Number (default: 0)
	 * <p>
	 * Height of a fixed footer.
	 */
	static final String FIXEDFOOTERHEIGHT = "fixedFooterHeight";

	/**
	 * scrollBar: Boolean (default: true)
	 * <p>
	 * Show scroll bar or not.
	 */
	static final String SCROLLBAR = "scrollBar";

	/**
	 * scrollDir: String (default: "v")
	 * <p>
	 * v: vertical, h: horizontal, vh: both, f: flip
	 */
	static final String SCROLLDIR = "scrollDir";

	/**
	 * weight: Number (default: 0.6)
	 * <p>
	 * Frictional drag.
	 */
	static final String WEIGHT = "weight";

	/**
	 * fadeScrollBar: Boolean (default: true)
	 */
	static final String FADESCROLLBAR = "fadeScrollBar";

	/**
	 * disableFlashScrollBar: Boolean (default: false)
	 */
	static final String DISABLEFLASHSCROLLBAR = "disableFlashScrollBar";

	/**
	 * threshold: Number (default: 4)
	 * <p>
	 * Drag threshold value in pixels.
	 */
	static final String THRESHOLD = "threshold";

	/**
	 * constraint: Boolean (default: true);
	 * <p>
	 * bounce back to the content area
	 */
	static final String CONSTRAINT = "constraint";

	/**
	 * touchNode: DOMNode
	 * <p>
	 * A node that will have touch event handlers.
	 */
	static final String TOUCHNODE = "touchNode";

	/**
	 * propagatable: Boolean (default: true)
	 * <p>
	 * Let touchstart event propagate up
	 */
	static final String PROPAGATABLE = "propagatable";

	/**
	 * dirLock: Boolean (default: false)
	 * <p>
	 * Disable the move handler if scroll starts in the unexpected direction.
	 */
	static final String DIRLOCK = "dirLock";

	/**
	 * height: String (default: "")
	 * <p>
	 * Explicitly specified height of this widget (ex. "300px").
	 */
	static final String HEIGHT = "height";

	/**
	 * scrollType: Number
	 * <ul>
	 * <li>1: use -webkit-transform:translate3d(x,y,z) style, use
	 * -webkit-animation for slide anim</li>
	 * <li>2: use top/left style</li>
	 * <li>3: use -webkit-transform:translate3d(x,y,z) style, use
	 * -webkit-transition for slide anim</li>
	 * <li>0: use default value (2 in case of Android < 3, 3 if iOS6, otherwise
	 * 1)</li>
	 * </ul>
	 */
	static final String SCROLLTYPE = "scrollType";
}
