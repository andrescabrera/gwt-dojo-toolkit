package gwt.dojo.mobile.app.client.controllers;

import gwt.dojo.core.client.DOM;
import gwt.dojo.core.client.DojoOn;
import gwt.dojo.core.client.EventCallback;
import gwt.dojo.core.client.EventHandle;
import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;
import gwt.dojo.core.client.MessageHub;
import gwt.dojo.core.client.SubscribeCallback;
import gwt.dojo.core.client.SubscribeHandle;
import gwt.dojo.core.client.store.MemoryStore;
import gwt.dojo.dijit.client.Registry;
import gwt.dojo.dijit.client._WidgetBase;
import gwt.dojo.mobile.client.EdgeToEdgeStoreList;
import gwt.dojo.mobile.client.IStoreListMixin;
import gwt.dojo.mobile.client.ListItem;
import gwt.dojo.mobile.client.SimpleDialog;
import gwt.dojo.mobile.client.ToolBarButton;
import gwt.dojo.mobile.client.View;
import gwt.dojo.mobile.client._StoreListMixin;

import java.util.logging.Logger;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.Window;
import com.rambus.gwt.imerz.client.IMerzAccess;
import com.rambus.gwt.imerz.client.events.DeviceListResultEvent;
import com.rambus.gwt.imerz.client.events.QueryEvent;

public class MainViewController extends ViewController {
	private final Logger LOG = Logger.getLogger("MainViewController");

	// ------------------------------------------------------------------------
	// Channel search event handler
	// ------------------------------------------------------------------------

	private final EventCallback channelSearchBtnClickHandler = new EventCallback() {
		@Override
		public void callback(JsObject source, NativeEvent event) {
			LOG.fine("channelSearchBtnClickHandler.callback");
			if (isShowingView()) {
				performTransition("channel-search", 1, "slide");
			}
		}
	};
	private EventHandle channelSearchBtnClick = null;

	// ------------------------------------------------------------------------
	// Device selector event handler
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
						View player = Registry.byId("player");
						if (isShowingView() && player != null) {
							player.set("deviceSelectorListItem", listItem);
							performTransition("player", 1, "none");
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

	public MainViewController() {
		super("main");
	}

	protected SimpleDialog getDeviceSeletorDlg() {
		return Registry.byId("device-selector-dlg");
	}

	protected EdgeToEdgeStoreList getDeviceSeletorList() {
		return Registry.byId("device-selector-list");
	}

	@Override
	protected void onStartView() {
		hideLoadDiv();

		beforeTransitionIn();
	}

	@Override
	protected void beforeTransitionIn() {
		LOG.fine("beforeTransitionIn: " + getViewId());

		ToolBarButton channelsSearchBtn = Registry
				.byId("main-channel-search-btn");
		channelSearchBtnClick = channelsSearchBtn.on("click",
				channelSearchBtnClickHandler);

		ToolBarButton deviceSelectorBtn = Registry
				.byId("main-device-selector-btn");
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
	protected void afterTransitionIn() {
		Registry.byId("carousel1").getElement(_WidgetBase.DOMNODE).getStyle().setDisplay(Display.BLOCK);
	}
	
	@Override
	protected void beforeTransitionOut() {
		Registry.byId("carousel1").getElement(_WidgetBase.DOMNODE).getStyle().setDisplay(Display.NONE);
	}

	@Override
	protected void afterTransitionOut() {
		LOG.fine("afterTransitionOut: " + getViewId());

		if (channelSearchBtnClick != null) {
			channelSearchBtnClick.remove();
			channelSearchBtnClick = null;
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

	/**
	 * Hide #loadDiv element.
	 */
	protected void hideLoadDiv() {
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				Element loadDiv = DOM.byId("loadDiv");
				if (loadDiv != null) {
					loadDiv.getStyle().setDisplay(Display.NONE);
				}
			}
		});
	}
}
