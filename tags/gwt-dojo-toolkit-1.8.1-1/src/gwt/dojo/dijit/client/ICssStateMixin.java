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
 * Mixin for widgets to set CSS classes on the widget DOM nodes depending on
 * hover/mouse press/focus state changes, and also higher-level state changes
 * such becoming disabled or selected.
 * 
 * @author ggeorg
 */
public interface ICssStateMixin {

	/**
	 * hovering: [readonly] Boolean
	 * <p>
	 * {@code true} if cursor is over this widget.
	 */
	static final String HOVERING = "hovering";

	/**
	 * active: [readonly] Boolean
	 * <p>
	 * {@code true} if mouse was pressed while over this widget, and hasn't been
	 * released yet.
	 */
	static final String ACTIVE = "active";

}
