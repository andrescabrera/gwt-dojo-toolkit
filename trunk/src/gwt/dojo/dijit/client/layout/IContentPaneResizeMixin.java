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
 * Provides resize functionality of {@code ContentPane}. If there's a single
 * layout widget child then it will call {@code resize()} with the same
 * dimensions as the {@code ContentPane}. Otherwise just calls resize on each
 * child.
 * 
 * @author ggeorg
 */
public interface IContentPaneResizeMixin {

	/**
	 * doLayout: Boolean
	 * <p>
	 * If {@code false} don't adjust size of children; if {@code true} if there
	 * is a single visible child widget, set it's size to however big the
	 * {@code ContentPane} is.
	 */
	static final String DOLAYOUT = "doLayout";

}
