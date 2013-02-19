package gwt.dojo.mobile.app.client.controllers;

import gwt.dojo.core.client.DOM;
import gwt.dojo.core.client.DojoOn;
import gwt.dojo.core.client.EventCallback;
import gwt.dojo.core.client.EventHandle;
import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;
import gwt.dojo.core.client.MessageHub;
import gwt.dojo.core.client.PropertyChangeEvent;
import gwt.dojo.core.client.Stateful;
import gwt.dojo.core.client.SubscribeCallback;
import gwt.dojo.core.client.SubscribeHandle;
import gwt.dojo.core.client.WatchCallback;
import gwt.dojo.core.client.store.MemoryStore;
import gwt.dojo.dijit.client.Registry;
import gwt.dojo.dijit.client._WidgetBase;
import gwt.dojo.mobile.client.EdgeToEdgeStoreList;
import gwt.dojo.mobile.client.Heading;
import gwt.dojo.mobile.client.IStoreListMixin;
import gwt.dojo.mobile.client.ListItem;
import gwt.dojo.mobile.client.SimpleDialog;
import gwt.dojo.mobile.client.Slider;
import gwt.dojo.mobile.client.TabBarButton;
import gwt.dojo.mobile.client.ToolBarButton;
import gwt.dojo.mobile.client._StoreListMixin;

import java.util.logging.Logger;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rambus.gwt.imerz.client.IMerzAccess;
import com.rambus.gwt.imerz.client.MoviePlayer;
import com.rambus.gwt.imerz.client.events.DeviceListResultEvent;
import com.rambus.gwt.imerz.client.events.PlaybackController;
import com.rambus.gwt.imerz.client.events.PlaybackEvent;
import com.rambus.gwt.imerz.client.events.PlaybackStatusEvent;
import com.rambus.gwt.imerz.client.events.QueryEvent;

public class PlayerViewController extends ViewController implements
		PlaybackController {
	private static final Logger LOG = Logger.getLogger("PlayerViewController");

	private final Timer playbackStatusTimer = new Timer() {
		@Override
		public void run() {
			MoviePlayer.getStatus(new AsyncCallback<JsObject>() {
				@Override
				public void onFailure(Throwable caught) {
					LOG.severe("statusTimer: " + caught.getMessage());
				}

				@Override
				public void onSuccess(JsObject result) {
					LOG.fine(result.toJson());
					PlaybackStatusEvent event = PlaybackStatusEvent
							.create(result);
					IMerzAccess.send(event.toString());

					if (moveToDevice != null) {
						Window.alert(moveToDevice + " " + moveToDoSwitch);
						moveToDevice = null;
						moveToDoSwitch = false;
					}
				}
			});
		}
	};

	// ------------------------------------------------------------------------
	// PlaybackEvent handler.
	// ------------------------------------------------------------------------

	private final SubscribeCallback playbackEventHandler = new SubscribeCallback() {
		@Override
		public void callback(String topic, JsArray message) {
			String sender = getSender(message);
			PlaybackEvent playbackEvent = getPlaybackEvent(message);
			if (playbackEvent != null) {
				if (!playbackEvent.execute(PlayerViewController.this)) {
					LOG.severe("playbackEventSC: failed (sender: " + sender
							+ ")");
				}
			}
		}

		private String getSender(JsArray message) {
			return message != null && message.length() > 0 ? message
					.getString(0) : null;
		}

		private PlaybackEvent getPlaybackEvent(JsArray message) {
			Object o = message != null && message.length() > 1 ? message.get(1)
					: null;
			if (o != null && o instanceof PlaybackEvent) {
				return (PlaybackEvent) o;
			} else {
				return null;
			}
		}
	};

	// ------------------------------------------------------------------------
	// PlaybackStatusEvent handler.
	// ------------------------------------------------------------------------

	private final SubscribeCallback playbackStatusEventHandler = new SubscribeCallback() {
		@Override
		public void callback(String topic, JsArray message) {
			String sender = getSender(message);

			if (deviceSelectorListItem != null) {
				String deviceId = deviceSelectorListItem.getString("deviceId");
				if (deviceId != null && !deviceId.equals(sender)) {
					return;
				}
			} else if (sender != null) {
				return;
			}

			PlaybackStatusEvent playbackStatusEvent = getPlaybackStatusEvent(message);
			if (playbackStatusEvent != null) {
				JsObject argsObj = playbackStatusEvent.getEvent().getArgs();
				if (argsObj == null || argsObj.isArray()) {
					return;
				}

				boolean paused = argsObj.getBoolean("paused");
				if (paused) {
					DOM.byId("player-play-paused").setClassName("paused");
					TabBarButton btn = Registry
							.byId("controls-btn-play-pause-btn");
					btn.set("icon", "images/playback_start.png");
					btn.set("pause", false);
				} else {
					DOM.byId("player-play-paused").setClassName("play");
					TabBarButton btn = Registry
							.byId("controls-dlg-play-pause-btn");
					btn.set("icon", "images/playback_pause.png");
					btn.set("pause", true);
				}

				boolean mediatimeSet = false;
				if (argsObj.hasProperty("mediatime")) {
					double mediatime = argsObj.getDouble("mediatime");
					double duration = argsObj.hasProperty("duration") ? argsObj
							.getDouble("duration") : Double.NaN;

					if (!Double.isNaN(mediatime)
							&& !Double.isNaN(newMediatimeValue)
							&& !Double.isNaN(duration) && duration > mediatime) {
						mediatime = newMediatimeValue * duration;

						newMediatimeValue = Double.NaN;
						mediatimeSliderUpdating = false;

						PlaybackEvent playbackEvent = PlaybackEvent
								.createMediatimeEvent(mediatime);
						IMerzAccess.send(sender, playbackEvent.toString());
					}

					if (!Double.isNaN(mediatime)) {
						DOM.byId("player-mediatime").setInnerText(
								format(mediatime));
						DOM.byId("controls-dlg-mediatime").setInnerText(
								format(mediatime));

						if (!Double.isNaN(duration) && duration > mediatime) {
							if (!mediatimeSliderUpdating) {
								Slider slider = Registry
										.byId("controls-dlg-mediatime-slider");
								slider.set(Slider.VALUE, (int) Math
										.round(100D * (mediatime / duration)));
								slider.set(Slider.DISABLED, false);
							}
						} else {
							Slider slider = Registry
									.byId("controls-dlg-mediatime-slider");
							slider.set(Slider.VALUE, 0);
							slider.set(Slider.DISABLED, true);
						}
						mediatimeSet = true;
					}
				}

				if (!mediatimeSet) {
					DOM.byId("player-mediatime").setInnerText(format(0));
					DOM.byId("controls-dlg-mediatime").setInnerText(format(0));
					Slider slider = Registry
							.byId("controls-dlg-mediatime-slider");
					slider.set(Slider.VALUE, 0);
					slider.set(Slider.DISABLED, true);
				}

				boolean durationSet = false;
				if (argsObj.hasProperty("duration")) {
					double duration = argsObj.getDouble("duration");
					if (!Double.isNaN(duration)) {
						// DOM.byId("player-duration").setInnerText(
						// format(mediatime));
						DOM.byId("controls-dlg-duration").setInnerText(
								format(duration));
						durationSet = true;
					}
				}

				if (!durationSet) {
					DOM.byId("controls-dlg-duration").setInnerText(format(0));
				}

				boolean volumeSet = false;
				if (argsObj.hasProperty("volume")) {
					double volume = argsObj.getDouble("volume");
					if (!Double.isNaN(newVolumeValue)) {
						volume = newVolumeValue;

						volumeSliderUpdating = false;
						newVolumeValue = Double.NaN;

						PlaybackEvent playbackEvent = PlaybackEvent
								.createVolumeEvent(volume);
						IMerzAccess.send(sender, playbackEvent.toString());
					}

					if (!Double.isNaN(volume)) {
						int value = (int) Math.round(volume * 100D);
						DOM.byId("controls-dlg-volume").setInnerText(
								String.valueOf(value));

						if (!volumeSliderUpdating) {
							Slider slider = Registry
									.byId("controls-dlg-volume-slider");
							slider.set(Slider.VALUE, value);
							slider.set(Slider.DISABLED, false);
						}

						volumeSet = true;
					}
				}

				if (!volumeSet) {
					DOM.byId("controls-dlg-volume").setInnerText(
							String.valueOf(0));

					Slider slider = Registry.byId("controls-dlg-volume-slider");
					slider.set(Slider.VALUE, 0);
					slider.set(Slider.DISABLED, true);
				}
			}
		}

		private String getSender(JsArray message) {
			return message != null && message.length() > 0 ? message
					.getString(0) : null;
		}

		private PlaybackStatusEvent getPlaybackStatusEvent(JsArray message) {
			Object o = message != null && message.length() > 1 ? message.get(1)
					: null;
			if (o != null && o instanceof PlaybackStatusEvent) {
				return (PlaybackStatusEvent) o;
			} else {
				return null;
			}
		}
	};

	private SubscribeHandle playbackStatusHandle = null;

	// ------------------------------------------------------------------------
	// Done button event handler
	// ------------------------------------------------------------------------

	private final EventCallback doneBtnClickHandler = new EventCallback() {
		@Override
		public void callback(JsObject source, NativeEvent event) {
			LOG.fine("doneBtnClickHandler.callback");
			if (isShowingView()) {
				performTransition("main", -1, "none");
			}
		}
	};
	private EventHandle doneBtnClick = null;

	// ------------------------------------------------------------------------
	// Controls button event handler
	// ------------------------------------------------------------------------

	private final EventCallback controlsBtnClickHandler = new EventCallback() {
		@Override
		public void callback(JsObject source, NativeEvent event) {
			LOG.fine("controlsBtnClickHandler.callback");
			if (isShowingView()) {
				SimpleDialog controlsDlg = getControlsDlg();
				if (controlsDlg != null) {
					String title = getHeading().getString(Heading.LABEL)
							+ " Controls";
					DOM.byId("controls-dlg-title").setInnerHTML(title);
					controlsDlg.show();
				}
			}
		}
	};
	private EventHandle controlsBtnClick = null;

	// ------------------------------------------------------------------------
	// MediatimeSlider touch start event handler
	// ------------------------------------------------------------------------

	private final EventCallback mediatimeSliderTouchStartHandler = new EventCallback() {
		@Override
		public void callback(JsObject source, NativeEvent event) {
			LOG.fine("mediatimeSliderTouchStartHandler.callback");
			if (isShowingView()) {
				mediatimeSliderUpdating = true;
			}
		}
	};

	private EventHandle mediatimeSliderTouchStart = null;

	// ------------------------------------------------------------------------
	// VolumeSlider touch end event handler
	// ------------------------------------------------------------------------

	private final EventCallback mediatimeSliderTouchEndHandler = new EventCallback() {
		@Override
		public void callback(JsObject source, NativeEvent event) {
			LOG.fine("mediatimeSliderTouchEndHandler.callback");
			if (isShowingView()) {
				Slider slider = Registry.byId("controls-dlg-mediatime-slider");
				if (slider != null) {
					newMediatimeValue = slider.getDouble(Slider.VALUE) / 100D;
				}
			}
		}
	};

	private EventHandle mediatimeSliderTouchEnd = null;

	// ------------------------------------------------------------------------
	// VolumeSlider touch start event handler
	// ------------------------------------------------------------------------

	private final EventCallback volumeSliderTouchStartHandler = new EventCallback() {
		@Override
		public void callback(JsObject source, NativeEvent event) {
			LOG.fine("volumeSliderTouchStartHandler.callback");
			if (isShowingView()) {
				volumeSliderUpdating = true;
			}
		}
	};

	private EventHandle volumeSliderTouchStart = null;

	// ------------------------------------------------------------------------
	// VolumeSlider touch end event handler
	// ------------------------------------------------------------------------

	private final EventCallback volumeSliderTouchEndHandler = new EventCallback() {
		@Override
		public void callback(JsObject source, NativeEvent event) {
			LOG.fine("volumeSliderTouchEndHandler.callback");
			if (isShowingView()) {
				Slider slider = Registry.byId("controls-dlg-volume-slider");
				if (slider != null) {
					newVolumeValue = slider.getDouble(Slider.VALUE) / 100D;
				}
			}
		}
	};

	private EventHandle volumeSliderTouchEnd = null;

	// ------------------------------------------------------------------------
	// VolumeSlider touch end event handler
	// ------------------------------------------------------------------------

	private final EventCallback controlsPlayPauseBtnClickHandler = new EventCallback() {
		@Override
		public void callback(JsObject source, NativeEvent event) {
			LOG.fine("volumeSliderTouchEndHandler.callback");
			if (isShowingView()) {
				ToolBarButton btn = Registry
						.byId("controls-dlg-play-pause-btn");
				if (btn != null) {
					boolean pause = btn.getBoolean("pause");
					PlaybackEvent playbackEvent = PlaybackEvent
							.createPauseEvent(pause);
					Window.alert(playbackEvent + "-----------"
							+ deviceSelectorListItem);
					// String recipient =
					// deviceSelectorListItem.getString("deviceId");
					// Window.alert(recipient+" "+playbackEvent.toString());
					// IMerzAccess.send(recipient, playbackEvent.toString());
				}
			}
		}
	};

	private EventHandle controlsPlayPauseBtnClick = null;

	// ------------------------------------------------------------------------
	// DeviceSelector button event handler
	// ------------------------------------------------------------------------

	private final EventCallback deviceSelectorBtnClickHandler = new EventCallback() {
		private SubscribeHandle deviceListSubscribeHandle = null;

		private final SubscribeCallback deviceListHandler = new SubscribeCallback() {
			@Override
			public void callback(String topic, JsArray message) {
				try {
					DeviceListResultEvent event = getDeviceListResultEvent(message);
					JsArray deviceList = event.getEvent().getArgs();

					JsArray data = JsArray.create();
					for (int i = 0, n = deviceList.length(); i < n; i++) {
						JsObject device = deviceList.getJsObject(i);
						if (device != null) {
							String deviceId = device.getString("deviceId");
							String deviceType = device.getString("deviceType");
							String deviceName = device.getString("deviceName");
							String service = device.getString("service");
							if (i == 0) {
								device.put("label", deviceName);
								data.push(device);
								continue;
							}
							if (deviceType != null
									&& deviceType.startsWith("MediaStation/2")) {
								if (i == 1) {
									JsObject category = JsObject.create();
									category.put("label", "REMOTE");
									category.put("header", true);
									data.push(category);
								}
								device.put("label", deviceName);
								data.push(device);
							}
						}
					}

					// TODO is this the only way we get access to a store?
					EdgeToEdgeStoreList list = getDeviceSeletorList();
					if (list != null) {
						MemoryStore store = list
								.getJsObject(IStoreListMixin.STORE);
						store.put(MemoryStore.DATA, data);

						_StoreListMixin.cast(list).refresh();

						SimpleDialog dlg = getDeviceSeletorDlg();
						if (dlg != null) {
							dlg.show();
						}
					}
				} finally {
					if (deviceListSubscribeHandle != null) {
						deviceListSubscribeHandle.remove();
						deviceListSubscribeHandle = null;
					}
				}
			}

			private DeviceListResultEvent getDeviceListResultEvent(
					JsArray message) {
				Object o = message != null && message.length() > 1 ? message
						.get(1) : null;
				if (o != null && o instanceof DeviceListResultEvent) {
					return (DeviceListResultEvent) o;
				} else {
					return null;
				}
			}
		};

		@Override
		public void callback(JsObject source, NativeEvent event) {
			LOG.fine("deviceSelectorBtnClickHandler.callback");
			if (isShowingView()) {
				deviceListSubscribeHandle = MessageHub.subscribe(
						DeviceListResultEvent.TOPIC, deviceListHandler);
				IMerzAccess.send(QueryEvent.create("device-list").toString());
			}
		}
	};
	private EventHandle deviceSelectorBtnClick = null;

	// ------------------------------------------------------------------------
	// Device selector list item event handler
	// ------------------------------------------------------------------------

	private final EventCallback deviceSelectorListItemClickHandler = new EventCallback() {
		@Override
		public void callback(JsObject source, NativeEvent event) {
			try {
				String id = source.getString("id");
				if (id != null) {
					JsObject o = Registry.byId(source.getString("id"));
					if (o != null && o instanceof ListItem) {
						ListItem listItem = o.cast();
						if (isShowingView()) {
							getView().set("deviceSelectorListItem", listItem);
						}
					}
				}
			} finally {
				SimpleDialog dlg = getDeviceSeletorDlg();
				if (dlg != null) {
					dlg.hide();
				}
			}
		}
	};
	private EventHandle deviceSelectorListItemClick = null;

	// ------------------------------------------------------------------------

	private JsObject deviceSelectorListItem;

	private boolean mediatimeSliderUpdating = false;
	private double newMediatimeValue = Double.NaN;

	private boolean volumeSliderUpdating = false;
	private double newVolumeValue = Double.NaN;

	public PlayerViewController() {
		super("player");

		MessageHub.subscribe(PlaybackEvent.TOPIC, playbackEventHandler);

		MoviePlayer.onCompletion(new SubscribeCallback() {
			@Override
			public void callback(String topic, JsArray message) {
				Window.alert("onCompletion");

				playbackStatusTimer.cancel();
			}
		});

		MoviePlayer.onError(new SubscribeCallback() {
			@Override
			public void callback(String topic, JsArray message) {
				Window.alert("onError: " + message.getString(0));

				playbackStatusTimer.cancel();
			}
		});

		// Should run after parse...
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				getView().watch("deviceSelectorListItem", new WatchCallback() {
					@Override
					public void callback(Stateful source, String name,
							PropertyChangeEvent event) {
						JsObject oldDeviceSelectorListItem = event
								.getJsObject(PropertyChangeEvent.OLDVALUE);

						if (oldDeviceSelectorListItem != null) {
							// Send PlaybackStatus event 'register' to remote
							// device...
							PlaybackStatusEvent playbackStatusEvent = PlaybackStatusEvent
									.create(false);
							IMerzAccess.send(deviceSelectorListItem
									.getString("deviceId"), playbackStatusEvent
									.toString());
						}

						deviceSelectorListItem = event
								.getJsObject(PropertyChangeEvent.VALUE);

						if (deviceSelectorListItem != null) {
							Heading heading = getHeading();
							if (heading != null) {
								heading.set(heading.LABEL,
										deviceSelectorListItem
												.getString("deviceName"));
							}

							if (isShowingView()) {
								// Send PlaybackStatus event 'register' to
								// remote device...
								PlaybackStatusEvent playbackStatusEvent = PlaybackStatusEvent
										.create(true);
								IMerzAccess.send(deviceSelectorListItem
										.getString("deviceId"),
										playbackStatusEvent.toString());
							}
						}
					}
				});
			}
		});
	}

	protected SimpleDialog getDeviceSeletorDlg() {
		return Registry.byId("device-selector-dlg");
	}

	protected SimpleDialog getControlsDlg() {
		return Registry.byId("controls-dlg");
	}

	protected EdgeToEdgeStoreList getDeviceSeletorList() {
		return Registry.byId("device-selector-list");
	}

	protected Heading getHeading() {
		return Registry.byId("player-heading");
	}

	@Override
	protected void beforeTransitionIn() {
		LOG.fine("beforeTransitionIn: " + getViewId());

		if (deviceSelectorListItem != null) {
			// Send PlaybackStatus event 'register' to remote device...
			PlaybackStatusEvent playbackStatusEvent = PlaybackStatusEvent
					.create(true);
			IMerzAccess.send(deviceSelectorListItem.getString("deviceId"),
					playbackStatusEvent.toString());
		}

		playbackStatusHandle = MessageHub.subscribe(PlaybackStatusEvent.TOPIC,
				playbackStatusEventHandler);

		ToolBarButton doneBtn = Registry.byId("player-done-btn");
		doneBtnClick = doneBtn.on("click", doneBtnClickHandler);

		ToolBarButton controlsBtn = Registry.byId("player-controls-btn");
		controlsBtnClick = controlsBtn.on("click", controlsBtnClickHandler);

		Slider mediatimeSlider = Registry.byId("controls-dlg-mediatime-slider");
		mediatimeSliderTouchStart = mediatimeSlider.on("touchstart",
				mediatimeSliderTouchStartHandler);
		mediatimeSliderTouchEnd = mediatimeSlider.on("touchend",
				mediatimeSliderTouchEndHandler);

		Slider volumeSlider = Registry.byId("controls-dlg-volume-slider");
		volumeSliderTouchStart = volumeSlider.on("touchstart",
				volumeSliderTouchStartHandler);
		volumeSliderTouchEnd = volumeSlider.on("touchend",
				volumeSliderTouchEndHandler);

		ToolBarButton controlsPlayPauseBtn = Registry
				.byId("controls-btn-play-pause-btn");
		controlsPlayPauseBtnClick = controlsPlayPauseBtn.on("click",
				controlsPlayPauseBtnClickHandler);

		ToolBarButton deviceSelectorBtn = Registry
				.byId("player-device-selector-btn");
		deviceSelectorBtnClick = deviceSelectorBtn.on("click",
				deviceSelectorBtnClickHandler);

		// Add 'click' handler to deviceSeltor's list.
		EdgeToEdgeStoreList list = getDeviceSeletorList();
		if (list != null) {
			deviceSelectorListItemClick = DojoOn.on(
					list.getElement(_WidgetBase.DOMNODE), ".mblListItem:click",
					deviceSelectorListItemClickHandler);
		}
	}

	@Override
	protected void afterTransitionOut() {
		LOG.fine("afterTransitionOut: " + getViewId());

		if (deviceSelectorListItem != null) {
			// Send PlaybackStatus event 'register' to remote device...
			PlaybackStatusEvent playbackStatusEvent = PlaybackStatusEvent
					.create(false);
			IMerzAccess.send(deviceSelectorListItem.getString("deviceId"),
					playbackStatusEvent.toString());
		}

		if (playbackStatusHandle != null) {
			playbackStatusHandle.remove();
			playbackStatusHandle = null;
		}

		if (doneBtnClick != null) {
			doneBtnClick.remove();
			doneBtnClick = null;
		}

		if (controlsBtnClick != null) {
			controlsBtnClick.remove();
			controlsBtnClick = null;
		}

		if (mediatimeSliderTouchStart != null) {
			mediatimeSliderTouchStart.remove();
			mediatimeSliderTouchStart = null;
		}

		if (mediatimeSliderTouchEnd != null) {
			mediatimeSliderTouchEnd.remove();
			mediatimeSliderTouchEnd = null;
		}

		if (volumeSliderTouchStart != null) {
			volumeSliderTouchStart.remove();
			volumeSliderTouchStart = null;
		}

		if (volumeSliderTouchEnd != null) {
			volumeSliderTouchEnd.remove();
			volumeSliderTouchEnd = null;
		}

		if (controlsPlayPauseBtnClick != null) {
			controlsPlayPauseBtnClick.remove();
			controlsPlayPauseBtnClick = null;
		}

		if (deviceSelectorBtnClick != null) {
			deviceSelectorBtnClick.remove();
			deviceSelectorBtnClick = null;
		}

		if (deviceSelectorListItemClick != null) {
			deviceSelectorListItemClick.remove();
			deviceSelectorListItemClick = null;
		}
	}

	public static String format(double seconds) {
		int hh = (int) (seconds / 3600.0); // get hour
		int mm = (int) ((seconds % 3600.0) / 60.0); // get minutes
		int ss = hh > 0 ? 0 : (int) (seconds % 60); // get seconds

		StringBuilder sb = new StringBuilder();
		if (hh > 0) {
			sb.append(getDoubleDigit(hh)).append(":")
					.append(getDoubleDigit(mm));
		} else {
			sb.append(getDoubleDigit(mm)).append(":")
					.append(getDoubleDigit(ss));
		}
		return sb.toString();
	}

	protected static String getDoubleDigit(int i) {
		String newI = null;
		switch (i) {
		case 0:
			newI = "00";
			break;
		case 1:
			newI = "01";
			break;
		case 2:
			newI = "02";
			break;
		case 3:
			newI = "03";
			break;
		case 4:
			newI = "04";
			break;
		case 5:
			newI = "05";
			break;
		case 6:
			newI = "06";
			break;
		case 7:
			newI = "07";
			break;
		case 8:
			newI = "08";
			break;
		case 9:
			newI = "09";
			break;
		default:
			newI = Integer.toString(i % 100);
		}
		return newI;
	}

	// ------------------------------------------------------------------------
	// Player Implementation
	// ------------------------------------------------------------------------

	private JsArray playlist = null;
	private boolean canPlayTypes = false;

	private int playlistItem = -1;

	private String moveToDevice = null;
	private Boolean moveToDoSwitch = false;

	@Override
	public void setPlaylist(JsArray playlist) {
		if (this.playlist != null) {
			stop();
		}

		this.playlist = playlist;

		for (int i = 0, n = playlist.length(); i < n; i++) {
			JsObject mediaItem = playlist.getJsObject(i);
			if (!(mediaItem != null && mediaItem.hasProperty("player") && mediaItem
					.hasProperty("url"))) {
				return;
			}
		}

		this.canPlayTypes = true;
	}

	@Override
	public void play(int playlistItem, double mediatime) {
		try {
			if (!canPlayTypes) {
				// TODO send PlaybackStatus with error message...
				return;
			}

			if (playlistItem < 0 || playlistItem >= playlist.length()) {
				// TODO send PlaybackStatus with error message...
				return;
			}

			MoviePlayer.stop();

			this.playlistItem = playlistItem;

			JsObject mediaItem = playlist.getJsObject(playlistItem);
			final String url = mediaItem.getString("url");

			Window.alert(url + "#" + mediatime);

			MoviePlayer.load(url);
			MoviePlayer.play(mediatime);

			playbackStatusTimer.scheduleRepeating(1000);

		} catch (Exception e) {
			Window.alert("" + e);
		}
	}

	@Override
	public void pause(boolean pause) {
		MoviePlayer.pause(pause);
	}

	@Override
	public void stop() {
		MoviePlayer.stop();

		playbackStatusTimer.cancel();

		playlist = null;
		canPlayTypes = false;

		playlistItem = -1;
	}

	@Override
	public void setMediatime(double mediatime) {
		MoviePlayer.setMediatime(mediatime);
	}

	@Override
	public void setRate(double rate) {
		MoviePlayer.setRate(rate);
	}

	@Override
	public void setVolume(double volume) {
		MoviePlayer.setVolume(volume);
	}

	@Override
	public void mute(boolean mute) {
		MoviePlayer.mute(mute);
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub

	}

	@Override
	public void previous() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveToDevice(String device, Boolean doSwitch) {
		moveToDevice = device;
		moveToDoSwitch = doSwitch;
	}

}
