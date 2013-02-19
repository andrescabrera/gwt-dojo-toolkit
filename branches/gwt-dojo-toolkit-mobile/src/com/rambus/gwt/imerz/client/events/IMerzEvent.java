package com.rambus.gwt.imerz.client.events;

import gwt.dojo.core.client.JsObject;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

public class IMerzEvent extends JsObject {

	public static IMerzEvent create(String jsonString) {
		try {
			JSONValue v = JSONParser.parseLenient(jsonString);
			JSONObject o = v.isObject();
			if (o != null) {
				return o.getJavaScriptObject().cast();
			} else {
				return null;
			}
		} catch (Exception e) {
			GWT.log("Error in JSON", e);
			return null;
		}
	}

	protected IMerzEvent() {
	}

	public final native String getQualifier() /*-{
		return this.qualifier;
	}-*/;

	public final native String getEvent() /*-{
		return this.event;
	}-*/;

	public final native <T extends JavaScriptObject> T getArgs() /*-{
		return this.args;
	}-*/;

}
