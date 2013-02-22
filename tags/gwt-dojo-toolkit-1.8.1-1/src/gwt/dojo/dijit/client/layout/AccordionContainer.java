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
 * Holds a set of panes where every pane's title is visible, but only one pane's
 * content is visible at a time, and switching between panes is visualized by
 * sliding the other panes up/down.
 * 
 * @author ggeorg
 */
public class AccordionContainer extends StackContainer {

	public static final String MODULE = "dijit/layout/AccordionContainer";

	public static native AccordionContainer create() /*-{
		return new $wnd.dijit.layout.AccordionContainer();
	}-*/;

	protected AccordionContainer() {
	}

}