package com.rambus.gwt.imerz.client.events;

import gwt.dojo.core.client.JsArray;

public interface PlaybackController {

	void setPlaylist(JsArray playlist);

	void play(int playlistItem, double mediatime);

	void pause(boolean pause);

	void stop();

	void setMediatime(double mediatime);

	void setRate(double rate);

	void setVolume(double volume);

	void mute(boolean mute);

	void next();

	void previous();

	void moveToDevice(String device, Boolean do_switch);

}
