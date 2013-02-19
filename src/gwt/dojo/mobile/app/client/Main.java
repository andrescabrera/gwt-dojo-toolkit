package gwt.dojo.mobile.app.client;

import gwt.dojo.core.client.DOMReady;
import gwt.dojo.core.client.Dojo;
import gwt.dojo.core.client.DojoCallback;
import gwt.dojo.core.client.DojoOn;
import gwt.dojo.core.client.EventCallback;
import gwt.dojo.core.client.EventHandle;
import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;
import gwt.dojo.core.client.MessageHub;
import gwt.dojo.core.client.SubscribeCallback;
import gwt.dojo.core.client.SubscribeHandle;
import gwt.dojo.core.client.store.JsonRestStore;
import gwt.dojo.core.client.store.MemoryStore;
import gwt.dojo.mobile.app.client.controllers.ChannelSearchViewController;
import gwt.dojo.mobile.app.client.controllers.MainViewController;
import gwt.dojo.mobile.app.client.controllers.PlayerViewController;
import gwt.dojo.mobile.app.client.controllers.SettingsViewController;
import gwt.dojo.mobile.client.DeviceTheme;
import gwt.dojo.mobile.client.MobileAll;
import gwt.dojo.mobile.client.MobileParser;
import gwt.dojo.mobile.client.SimpleDialog;
import gwt.dojo.mobile.client.View;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ClosingEvent;
import com.google.gwt.user.client.Window.ClosingHandler;
import com.rambus.gwt.imerz.client.Cordova;
import com.rambus.gwt.imerz.client.IMerzAccess;
import com.rambus.gwt.imerz.client.events.DeviceListResultEvent;
import com.rambus.gwt.imerz.client.events.IMerzEvent;
import com.rambus.gwt.imerz.client.events.PlaybackEvent;
import com.rambus.gwt.imerz.client.events.PlaybackStatusEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main implements EntryPoint, DojoCallback, CloseHandler<Window>,
		ClosingHandler {
	// private final static String

	@SuppressWarnings("unused")
	private MainViewController mainViewController;
	@SuppressWarnings("unused")
	private ChannelSearchViewController channelSearchViewController;
	@SuppressWarnings("unused")
	private PlayerViewController playerViewController;
	@SuppressWarnings("unused")
	private SettingsViewController settingsViewController;

	private SubscribeHandle playbackHandler = null;
	private SubscribeHandle playbackStatusHandler = null;
	private SubscribeHandle deviceListQueryResultHandler = null;

	private EventHandle deviceReadyHandler = null;
	private EventHandle pauseHandler;
	private EventHandle resumeHandler;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		JsArray modules = JsArray.create();
		modules.push(MemoryStore.MODULE);
		modules.push(JsonRestStore.MODULE);
		modules.push(MobileParser.MODULE);
		modules.push(DeviceTheme.MODULE);
		modules.push(MobileAll.MODULE);
		modules.push(SimpleDialog.MODULE);
		modules.push(DOMReady.MODULE);
		Dojo.require(modules, this);
	}

	@Override
	public void callback(JsArray arguments) {

		MessageHub.subscribe("/dojox/mobile/startView",
				new SubscribeCallback() {
					@Override
					public void callback(String topic, JsArray message) {
						handleViewTransition(topic, message);
					}
				});

		MessageHub.subscribe("/dojox/mobile/beforeTransitionIn",
				new SubscribeCallback() {
					@Override
					public void callback(String topic, JsArray message) {
						handleViewTransition(topic, message);
					}
				});

		MessageHub.subscribe("/dojox/mobile/afterTransitionIn",
				new SubscribeCallback() {
					@Override
					public void callback(String topic, JsArray message) {
						handleViewTransition(topic, message);
					}
				});

		MessageHub.subscribe("/dojox/mobile/beforeTransitionOut",
				new SubscribeCallback() {
					@Override
					public void callback(String topic, JsArray message) {
						handleViewTransition(topic, message);
					}
				});

		MessageHub.subscribe("/dojox/mobile/afterTransitionOut",
				new SubscribeCallback() {
					@Override
					public void callback(String topic, JsArray message) {
						handleViewTransition(topic, message);
					}
				});

		// View controllers
		mainViewController = new MainViewController();
		channelSearchViewController = new ChannelSearchViewController();
		playerViewController = new PlayerViewController();
		settingsViewController = new SettingsViewController();

		// Parse the page for widgets!
		MobileParser.parse();

		// Startup after device is ready...
		deviceReadyHandler = Cordova.onDeviceReady(new EventCallback() {
			@Override
			public void callback(JsObject source, NativeEvent event) {
				startup();
			}
		});

		pauseHandler = Cordova.onPause(new EventCallback() {
			@Override
			public void callback(JsObject source, NativeEvent event) {

			}
		});

		resumeHandler = Cordova.onResume(new EventCallback() {
			@Override
			public void callback(JsObject source, NativeEvent event) {

			}
		});

		Cordova.setOnOrientationChange(new EventCallback() {
			@Override
			public void callback(JsObject source, NativeEvent event) {
				Window.alert("Orientation: " + Cordova.getOrientation());
			}
		});

		// In case we need to cleanup before exit...
		Window.addCloseHandler(this);
		Window.addWindowClosingHandler(this);
	}

	/**
	 * Re-publish transition with: topic = topic + / + view.id
	 */
	protected void handleViewTransition(String topic, JsArray message) {
		try {
			final View view = message.getJsObject(0);
			final StringBuilder sb = new StringBuilder();
			sb.append(topic).append('/').append(view.getString(View.ID));
			Scheduler.get().scheduleDeferred(new ScheduledCommand() {
				@Override
				public void execute() {
					MessageHub.publish(sb.toString(), view);
				}
			});
		} catch (Exception e) {
			GWT.log("Error in '" + topic + "' handler", e);
		}
	}

	/**
	 * Called by cordova's {@code deviceready} event handler.
	 */
	protected void startup() {

		playbackHandler = IMerzAccess.subscribe(PlaybackEvent.TOPIC,
				new SubscribeCallback() {
					@Override
					public void callback(String topic, JsArray message) {
						String sender = getSender(message);
						String messageBody = getMessageBody(message);
						if (messageBody != null) {
							IMerzEvent evt = IMerzEvent.create(messageBody);
							if (evt != null) {
								MessageHub.publish(topic, sender,
										new PlaybackEvent(evt));
							}
						}
					}
				});

		playbackStatusHandler = IMerzAccess.subscribe(
				PlaybackStatusEvent.TOPIC, new SubscribeCallback() {
					@Override
					public void callback(String topic, JsArray message) {
						String sender = getSender(message);
						String messageBody = getMessageBody(message);
						if (messageBody != null) {
							IMerzEvent evt = IMerzEvent.create(messageBody);
							if (evt != null) {
								MessageHub.publish(topic, sender,
										new PlaybackStatusEvent(evt));
							}
						}
					}
				});

		deviceListQueryResultHandler = IMerzAccess.subscribe(
				DeviceListResultEvent.TOPIC, new SubscribeCallback() {
					@Override
					public void callback(String topic, JsArray message) {
						String sender = getSender(message);
						String messageBody = getMessageBody(message);
						if (messageBody != null) {
							IMerzEvent evt = IMerzEvent.create(messageBody);
							if (evt != null) {
								MessageHub.publish(topic, sender,
										new DeviceListResultEvent(evt));
							}
						}
					}
				});
	}

	private String getSender(JsArray message) {
		return message.length() > 1 ? message.getString(1) : null;
	}

	private String getMessageBody(JsArray message) {
		return message.length() > 0 ? message.getString(0) : null;
	}

	/**
	 * Do clean before exit.
	 */
	@Override
	public void onClose(CloseEvent<Window> event) {
		if (deviceReadyHandler != null) {
			deviceReadyHandler.remove();
			deviceReadyHandler = null;
		}
		if (pauseHandler != null) {
			pauseHandler.remove();
			pauseHandler = null;
		}
		if (resumeHandler != null) {
			resumeHandler.remove();
			resumeHandler = null;
		}
		if (playbackHandler != null) {
			playbackHandler.remove();
			playbackHandler = null;
		}
		if (playbackStatusHandler != null) {
			playbackStatusHandler.remove();
			playbackStatusHandler = null;
		}
		if (deviceListQueryResultHandler != null) {
			deviceListQueryResultHandler.remove();
			deviceListQueryResultHandler = null;
		}
	}

	@Override
	public void onWindowClosing(ClosingEvent event) {
		//
	}

}
