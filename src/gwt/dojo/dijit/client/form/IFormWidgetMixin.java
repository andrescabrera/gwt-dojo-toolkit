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
 * Mixin for widgets corresponding to native HTML elements such as <checkbox> or
 * <button>, which can be children of a <form> node or a {@link Form} widget.
 * <p>
 * All those widgets should have these attributes just like native HTML input
 * elements.
 * 
 * @author ggeorg
 */
public interface IFormWidgetMixin {

	/**
	 * name: String
	 * <p>
	 * Name used when submitting form; same as "name" attribute or plain HTML
	 * elements.
	 */
	static final String NAME = "name";

	/**
	 * alt: String
	 * <p>
	 * Corresponds to the native HTML <input> element's attribute.
	 */
	static final String ALT = "alt";

	/**
	 * value: String
	 * <p>
	 * Corresponds to the native HTML <input> element's attribute.
	 */
	static final String VALUE = "value";

	/**
	 * type: [const] String
	 * <p>
	 * Corresponds to the native HTML <input> element's attribute.
	 */
	static final String TYPE = "type";

	/**
	 * tabIndex: Integer (0)
	 * <p>
	 * Order fields are traversed when user hits the tab key.
	 */
	static final String TABINDEX = "tabIndex";

	/**
	 * disabled: Boolean (false)
	 * <p>
	 * Should this widget respond to user input? In markup, this is specified as
	 * "disabled='disabled'", or just "disabled".
	 */
	static final String DISABLED = "disabled";

	/**
	 * intermediateChanges: Boolean (false)
	 * <p>
	 * Fires {@code onChange} for each value change or only on demand.
	 */
	static final String INTERMEDIATECHANGES = "intermediateChanges";

	/**
	 * scrollOnFocus: Boolean (true)
	 * <p>
	 * On focus, should this widget scroll into view?
	 */
	static final String SCROLLONFOCUS = "scrollOnFocus";

}
