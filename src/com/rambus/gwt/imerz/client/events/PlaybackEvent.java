package com.rambus.gwt.imerz.client.events;

import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;

import com.google.gwt.core.client.GWT;

public class PlaybackEvent {
	public static final String QUALIFIER = "com.rambus.syncstream.displayclient";
	public static final String EVENT = "Playback";
	public static final String TOPIC = QUALIFIER + "." + EVENT;
	
	public static PlaybackEvent createPauseEvent(boolean pause) {
		JsArray args = JsArray.create();
		args.push("pause");
		args.push(pause);

		JsObject eventObj = JsObject.create();
		eventObj.put("qualifier", QUALIFIER);
		eventObj.put("event", EVENT);
		eventObj.put("args", args);

		IMerzEvent event = eventObj.cast();
		return new PlaybackEvent(event);
	}
	
	public static PlaybackEvent createMediatimeEvent(double mediatime) {
		JsArray args = JsArray.create();
		args.push("mediatime");
		args.push(mediatime);

		JsObject eventObj = JsObject.create();
		eventObj.put("qualifier", QUALIFIER);
		eventObj.put("event", EVENT);
		eventObj.put("args", args);

		IMerzEvent event = eventObj.cast();
		return new PlaybackEvent(event);
	}

	public static PlaybackEvent createVolumeEvent(double volume) {
		JsArray args = JsArray.create();
		args.push("volume");
		args.push(volume);

		JsObject eventObj = JsObject.create();
		eventObj.put("qualifier", QUALIFIER);
		eventObj.put("event", EVENT);
		eventObj.put("args", args);

		IMerzEvent event = eventObj.cast();
		return new PlaybackEvent(event);
	}

	private final IMerzEvent event;

	public PlaybackEvent(IMerzEvent event) {
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

	public boolean execute(PlaybackController player) {
		JsArray args = event.getArgs();
		if (args.length() == 0) {
			return false;
		}

		JsObject mediaInfo0 = args.getJsObject(0);
		if (mediaInfo0 != null && mediaInfo0.hasProperty("player")
				&& mediaInfo0.hasProperty("url")) {
			player.setPlaylist(args);
			return true;
		}

		String cmd = args.getString(0);
		if ("play".equals(cmd)) {
			if (args.length() >= 2) {
				int playlistItem = args.getInteger(1, 0);
				if (args.length() >= 3) {
					double mediatime = args.getDouble(2, -1D);
					player.play(playlistItem, mediatime);
				} else {
					player.play(playlistItem, -1D);
				}
			} else {
				player.play(0, -1D);
			}
		} else if ("pause".equals(cmd)) {
			if (args.length() >= 2) {
				Boolean pause = args.getBoolean(1);
				if (pause != null) {
					player.pause(pause);
				}
			}
		} else if ("stop".equals(cmd)) {
			player.stop();
		} else if ("mediatime".equals(cmd)) {
			if (args.length() >= 2) {
				double mediatime = args.getDouble(1, -1D);
				if (mediatime != -1D) {
					player.setMediatime(mediatime);
				}
			}
		} else if ("rate".equals(cmd)) {
			if (args.length() >= 2) {
				double rate = args.getDouble(1, 0D);
				if (rate != 0D) {
					player.setRate(rate);
				}
			}
		} else if ("volume".equals(cmd)) {
			if (args.length() >= 2) {
				double volume = args.getDouble(1, -1D);
				if (volume >= 0D && volume <= 1D) {
					player.setVolume(volume);
				}
			}
		} else if ("mute".equals(cmd)) {
			if (args.length() >= 2) {
				Boolean mute = args.getBoolean(1);
				if (mute != null) {
					player.mute(mute);
				}
			}
		} else if ("next".equals(cmd)) {
			player.next();
		} else if ("previous".equals(cmd)) {
			player.previous();
		} else if ("move-to".equals(cmd)) {
			if (args.length() >= 2) {
				String device = args.getString(1);
				if (device != null && device.length() > 0) {
					if (args.length() >= 3) {
						Boolean do_switch = args.getBoolean(2);
						player.moveToDevice(device, do_switch);
					} else {
						player.moveToDevice(device, false);
					}
				}
			}
		} else {
			GWT.log("Invalid command: " + cmd);
			return false;
		}

		return true;
	}

}
