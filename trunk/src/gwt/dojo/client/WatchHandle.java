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
package gwt.dojo.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The {@link #unwatch()} of this object can be used to discontinue watching a
 * property for changes.
 * 
 * @author ggeorg
 */
public class WatchHandle extends JavaScriptObject {

	protected WatchHandle() {
	}

	public final native void unwatch() /*-{
		this.unwatch();
	}-*/;
}
