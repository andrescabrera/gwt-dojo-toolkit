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
 * Mixin to provide widget functionality corresponding to an HTML checkbox.
 * 
 * @author ggeorg
 */
public interface _CheckBoxMixin {

	/**
	 * value: String (default: "on")
	 * <p>
	 * As an initialization parameter, equivalent to value field on normal
	 * checkbox (if checked, the value is passed as the value when form is
	 * submitted).
	 */
	static final String VALUE = "value";

	/**
	 * readOnly: Boolean (default: false)
	 * <p>
	 * Should this widget respond to user input? In markup, this is specified as
	 * "readOnly". Similar to disabled except readOnly form values are
	 * submitted.
	 */
	static final String READONLY = "readOnly";
	
	/**
	 * Reset the widget's value to what it was at initialization time.
	 */
	void reset();
}
