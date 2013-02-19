package com.rambus.gwt.imerz.client.events;

import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;

public class QueryEvent {
	public static final String QUALIFIER = "com.rambus.syncstream.displayclient";
	public static final String EVENT = "Query";
	public static final String TOPIC = QUALIFIER + "." + EVENT;

	public static QueryEvent create(String query) {
		JsObject eventObj = JsObject.create();
		eventObj.put("qualifier", QUALIFIER);
		eventObj.put("event", EVENT);
		eventObj.put("args", JsArray.create(query));
		IMerzEvent event = eventObj.cast();
		return new QueryEvent(event);
	}

	private final IMerzEvent event;

	public QueryEvent(IMerzEvent event) {
		assert QUALIFIER.equals(event.getQualifier());
		assert EVENT.equals(event.getEvent());
		this.event = event;
	}

	public IMerzEvent getEvent() {
		return event;
	}

	@Override
	public String toString() {
		return event.toJson();
	}

}
