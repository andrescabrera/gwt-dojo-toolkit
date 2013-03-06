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
package gwt.dojo.mobile.client;

import gwt.dojo.core.client.JsObject;

/**
 * A progress indication widget.
 * <p>
 * ProgressIndicator is a round spinning graphical representation that indicates
 * the current task is on-going.
 * 
 * @author ggeorg
 */
public class ProgressIndicator extends JsObject {

	public static final String MODULE = "dojox/mobile/ProgressIndicator";

	private static ProgressIndicator instance = null;

	public static ProgressIndicator get() {
		if (instance == null) {
			JsObject ref = JsObject.ref(ProgressIndicator.MODULE);
			instance = _get(ref);
		}
		return instance;
	}

	private static native ProgressIndicator _get(JsObject ref) /*-{
		return ref.getInstance();
	}-*/;

	public static void start() {
		instance.startImpl();
	};

	public static void stop() {
		instance.stopImpl();
	};

	public static void setImage(String file) {
		instance.setImageImpl(file);
	};

	protected ProgressIndicator() {
	}

	private final native void startImpl() /*-{
		this.start();
	}-*/;

	private final native void stopImpl() /*-{
		this.stop();
	}-*/;

	private final native void setImageImpl(String file) /*-{
		this.setImage(file);
	}-*/;
}
