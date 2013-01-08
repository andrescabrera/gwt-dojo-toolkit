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
package gwt.dojo.charting.client;

import gwt.dojo.core.client.JsObject;

/**
 * A base class that is used to build other elements of a chart, such as a
 * series.
 * 
 * @author ggeorg
 */
public class Element extends JsObject {

	@SuppressWarnings("unchecked")
	public static Element create() {
		throw new IllegalArgumentException("no chart");
	};

	public static native Element create(Chart chart) /*-{
		return new $wnd.dojox.charting.Element(chart);
	}-*/;

	protected Element() {
	}

}
