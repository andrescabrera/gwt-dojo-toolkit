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
	 * fixedHeader: String
	 * <p>
	 * Id of the fixed header.
	 */
	static final String FIXEDHEADER = "fixedHeader";

	/**
	 * fixedFooter: String
	 * <p>
	 * Id of the fixed footer.
	 */
	static final String FIXEDFOOTER = "fixedFooter";

	/**
	 * scrollDir: String (default: "v")
	 * <p>
	 * v: vertical, h: horizontal, vh: both, f: flip
	 */
	static final String SCROLLDIR = "scrollDir";
	
}
