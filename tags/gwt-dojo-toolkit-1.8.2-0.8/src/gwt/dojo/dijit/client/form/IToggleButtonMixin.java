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
 * A mixin to provide functionality to allow a button that can be in two states
 * (checked or not).
 * 
 * @author ggeorg
 */
public interface IToggleButtonMixin {

	/**
	 * checked: Boolean
	 * <p>
	 * Corresponds to the native HTML <input> element's attribute. In markup,
	 * specified as "checked='checked'" or just "checked". {@code true} if the
	 * button is depressed, or the checkbox is checked, or the radio button is
	 * selected, etc.
	 */
	static final String CHECKED = "checked";

}
