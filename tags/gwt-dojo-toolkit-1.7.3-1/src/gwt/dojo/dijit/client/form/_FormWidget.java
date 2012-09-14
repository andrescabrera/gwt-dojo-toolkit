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

import gwt.dojo.dijit.client.ICssStateMixin;
import gwt.dojo.dijit.client.ITemplatedMixin;
import gwt.dojo.dijit.client._Widget;

/**
 * Base class for widgets corresponding to native HTML elements such as
 * <checkbox> or <button>, which can be children of a <form> node or a
 * {@link Form} widget.
 * <p>
 * All those widgets should have these attributes just like native HTML input
 * elements. You can set them during widget construction or afterwards.
 * 
 * @author ggeorg
 */
public class _FormWidget extends _Widget implements ITemplatedMixin,
		ICssStateMixin, IFormWidgetMixin {

	protected _FormWidget() {
	}

}
