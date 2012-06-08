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

import gwt.dojo.client.Dojo;
import gwt.dojo.client.util.JsArray;
import gwt.dojo.client.util.JsObject;

import com.google.gwt.dom.client.Element;

public class Parser extends JsObject {

	public static final String MODULE = "dojox/mobile/parser";

	public static  Parser ref() {
		return Dojo.require(MODULE);
	}

	protected Parser() {
	}

	public final native JsArray/*<JsObject>*/ parse() /*-{
		return this.parse();
	}-*/;

	public final native JsArray/*<JsObject>*/ parse(Element node) /*-{
		return this.parse(node);
	}-*/;
}