package com.rambus.gwt.imerz.client.events;

import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;

public class PlaybackStatusEvent {
	public static final String QUALIFIER = "com.rambus.syncstream.displayclient";
	public static final String EVENT = "PlaybackStatus";
	public static final String TOPIC = QUALIFIER + "." + EVENT;

	public static PlaybackStatusEvent create(JsObject playbackStatus) {
		JsObject eventObj = JsObject.create();
		eventObj.put("qualifier", QUALIFIER);
		eventObj.put("event", EVENT);
		eventObj.put("args", playbackStatus);
		IMerzEvent event = eventObj.cast();
		return new PlaybackStatusEvent(event);
	}

	public static PlaybackStatusEvent create(boolean register) {
		JsObject eventObj = JsObject.create();
		eventObj.put("qualifier", QUALIFIER);
		eventObj.put("event", EVENT);
		eventObj.put("args",
				JsArray.create(register ? "register" : "un-register"));
		IMerzEvent event = eventObj.cast();
		return new PlaybackStatusEvent(event);
	}

	private final IMerzEvent event;

	public PlaybackStatusEvent(IMerzEvent event) {
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
