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

import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;

import com.google.gwt.dom.client.Element;

public class MobileParser extends JsObject {

	public static final String MODULE = "dojox/mobile/parser";

	protected MobileParser() {
		// Required by JSNI
	}

	public static JsArray/* <JsObject> */parse() {
		MobileParser mobileParser = JsObject.ref(MobileParser.MODULE);
		return mobileParser._parse();
	}

	private final native JsArray/* <JsObject> */_parse() /*-{
		try {
			return this.parse();
		} catch (e) {
			alert(e); // TODO throw exception that we can catch from Java
		}
	}-*/;

	public static JsArray/* <JsObject> */parse(Element node) {
		MobileParser mobileParser = JsObject.ref(MobileParser.MODULE);
		return mobileParser._parse(node);
	}

	public final native JsArray/* <JsObject> */_parse(Element node) /*-{
		try {
			return this.parse(node);
		} catch (e) {
			alert(e); // TODO throw exception that we can catch from Java
		}
	}-*/;
}
