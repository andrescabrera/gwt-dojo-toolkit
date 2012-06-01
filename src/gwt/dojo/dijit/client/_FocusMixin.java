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

/**
 * Mixin to widget to provide {@code _onFocus()} and {@code _onBlur()} methods
 * that fire when a widget or it's descendants get/lose focus.
 * 
 * @author ggeorg
 */
public interface _FocusMixin {

	/**
	 * focused: [readonly] Boolean
	 * <p>
	 * This widget or a widget it containes has focus, or it "active" because it
	 * was recently clicked.
	 */
	static final String FOCUSED = "focused";

}
