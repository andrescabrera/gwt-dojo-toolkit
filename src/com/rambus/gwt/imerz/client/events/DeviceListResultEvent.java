package com.rambus.gwt.imerz.client.events;

public class DeviceListResultEvent {
	public static final String QUALIFIER = "com.rambus.syncstream.displayclient";
	public static final String EVENT = "DeviceListResult";
	public static final String TOPIC = QUALIFIER + "." + EVENT;
	
	private final IMerzEvent event;

	public DeviceListResultEvent(IMerzEvent event) {
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
