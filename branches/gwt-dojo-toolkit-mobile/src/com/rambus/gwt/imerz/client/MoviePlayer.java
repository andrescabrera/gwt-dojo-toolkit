package com.rambus.gwt.imerz.client;

import gwt.dojo.core.client.JsObject;
import gwt.dojo.core.client.SubscribeCallback;
import gwt.dojo.core.client.SubscribeHandle;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class MoviePlayer extends JavaScriptObject {

	private static native MoviePlayer ref() /*-{
		return $wnd.MoviePlayer;
	}-*/;

	public static SubscribeHandle onCompletion(SubscribeCallback callback) {
		MoviePlayer player = ref();
		if (player != null) {
			return ref().onCompletionImpl(callback);
		} else {
			throw new NullPointerException("MoviePlayer not found");
		}
	}

	public static SubscribeHandle onError(SubscribeCallback callback) {
		MoviePlayer player = ref();
		if (player != null) {
			return ref().onErrorImpl(callback);
		} else {
			throw new NullPointerException("MoviePlayer not found");
		}
	}

	public static void load(String url) {
		MoviePlayer player = ref();
		if (player != null) {
			ref().loadImpl(url);
		} else {
			throw new NullPointerException("MoviePlayer not found");
		}
	};

	public static void play() {
		MoviePlayer player = ref();
		if (player != null) {
			ref().playImpl(Double.NaN, Double.NaN);
		} else {
			throw new NullPointerException("MoviePlayer not found");
		}
	}

	public static void play(double starttime) {
		MoviePlayer player = ref();
		if (player != null) {
			ref().playImpl(starttime, Double.NaN);
		} else {
			throw new NullPointerException("MoviePlayer not found");
		}
	}

	public static void play(double starttime, double endtime) {
		MoviePlayer player = ref();
		if (player != null) {
			ref().playImpl(starttime, endtime);
		} else {
			throw new NullPointerException("MoviePlayer not found");
		}
	}

	public static void pause(boolean pause) {
		MoviePlayer player = ref();
		if (player != null) {
			ref().pauseImpl(pause);
		} else {
			throw new NullPointerException("MoviePlayer not found");
		}
	}

	public static void stop() {
		MoviePlayer player = ref();
		if (player != null) {
			ref().stopImpl();
		} else {
			throw new NullPointerException("MoviePlayer not found");
		}
	}

	public static void setMediatime(double mediatime) {
		MoviePlayer player = ref();
		if (player != null) {
			ref().setMediatimeImpl(mediatime);
		} else {
			throw new NullPointerException("MoviePlayer not found");
		}
	}

	public static void setRate(double rate) {
		MoviePlayer player = ref();
		if (player != null) {
			ref().setRateImpl(rate);
		} else {
			throw new NullPointerException("MoviePlayer not found");
		}
	}

	public static void setVolume(double volume) {
		MoviePlayer player = ref();
		if (player != null) {
			ref().setVolumeImpl(volume);
		} else {
			throw new NullPointerException("MoviePlayer not found");
		}
	}

	public static void mute(boolean mute) {
		MoviePlayer player = ref();
		if (player != null) {
			ref().muteImpl(mute);
		} else {
			throw new NullPointerException("MoviePlayer not found");
		}
	}

	public static void getStatus(AsyncCallback<JsObject> callback) {
		MoviePlayer player = ref();
		if (player != null) {
			ref().getStatusImpl(callback);
		} else {
			throw new NullPointerException("MoviePlayer not found");
		}
	}

	protected MoviePlayer() {
	}

	private final native SubscribeHandle onCompletionImpl(
			SubscribeCallback callback) /*-{
		var fcn = function(e) {
			@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/SubscribeCallback;Ljava/lang/String;Lgwt/dojo/core/client/JsArray;)(callback, e.type, []);
		};

		return this.onCompletion(fcn);
	}-*/;

	private final native SubscribeHandle onErrorImpl(SubscribeCallback callback) /*-{
		var fcn = function(e) {
			@gwt.dojo.core.client.Dojo::doCallback(Lgwt/dojo/core/client/SubscribeCallback;Ljava/lang/String;Lgwt/dojo/core/client/JsArray;)(callback, e.type, [ e[0] ]);
		};

		return this.onError(fcn);
	}-*/;

	private final native void loadImpl(String url) /*-{
		this.load(url);
	}-*/;

	public final native void playImpl(double starttime, double endtime) /*-{
		this.play(starttime, endtime);
	}-*/;

	public final native void pauseImpl(boolean pause) /*-{
		this.pause(pause);
	}-*/;

	public final native void stopImpl() /*-{
		this.stop();
	}-*/;

	public final native void setMediatimeImpl(double mediatime) /*-{
		this.setMediatime(mediatime);
	}-*/;

	public final native void setRateImpl(double rate) /*-{
		this.setRate(rate);
	}-*/;

	public final native void setVolumeImpl(double volume) /*-{
		this.setVolume(volume);
	}-*/;

	public final native void muteImpl(boolean mute) /*-{
		this.mute(mute);
	}-*/;

	public final native void getStatusImpl(AsyncCallback<JsObject> callback) /*-{
		var success = function(o) {
			@gwt.dojo.core.client.Dojo::doCallback(Lcom/google/gwt/user/client/rpc/AsyncCallback;Ljava/lang/Object;)(callback, o);
		};
		
		var fail = function(o) {
			@gwt.dojo.core.client.Dojo::doCallback(Lcom/google/gwt/user/client/rpc/AsyncCallback;Ljava/lang/String;)(callback,JSON.stringify(o));
		};
		
		this.getStatus(success, fail);
	}-*/;
}
