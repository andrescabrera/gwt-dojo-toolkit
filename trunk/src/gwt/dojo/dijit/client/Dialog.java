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

public class Dialog extends _WidgetBase {

	public static final String MODULE = "dijit/Dialog";

	public static native Dialog create() /*-{
		return new $wnd.dijit.Dialog();
	}-*/;

	/**
	 * Default constructor.
	 */
	protected Dialog() {
	}

	/**
	 * Display the dialog.
	 * <p>
	 * TODO: return deferred object that resolves when the display animation is
	 * complete.
	 */
	public final native void show() /*-{
		this.show();
	}-*/;

	/**
	 * Hide the dialog.
	 * <p>
	 * TODO: return deferred object that resolves when the display animation is
	 * complete.
	 */
	public final native void hide() /*-{
		this.hide();
	}-*/;

}
