package gwt.dojo.mobile.app.client.controllers;

import gwt.dojo.core.client.EventCallback;
import gwt.dojo.core.client.EventHandle;
import gwt.dojo.core.client.JsObject;
import gwt.dojo.dijit.client.Registry;
import gwt.dojo.mobile.client.ToolBarButton;

import java.util.logging.Logger;

import com.google.gwt.dom.client.NativeEvent;

public class SettingsViewController extends ViewController {
	private final Logger LOG = Logger.getLogger("SettingsViewController");

	private final EventCallback doneBtnClickHandler = new EventCallback() {
		@Override
		public void callback(JsObject source, NativeEvent event) {
			LOG.fine("doneBtnClickHandler.callback");
			if (isShowingView()) {
				performTransition("main", 1, "slide");
			}
		}
	};
	private EventHandle doneBtnClick = null;

	public SettingsViewController() {
		super("settings");
	}

	@Override
	protected void beforeTransitionIn() {
		LOG.fine("beforeTransitionIn: " + getViewId());
		ToolBarButton doneBtn = Registry.byId("settings-done-btn");
		doneBtnClick = doneBtn.on("click", doneBtnClickHandler);
	}

	@Override
	protected void afterTransitionOut() {
		LOG.fine("afterTransitionOut: " + getViewId());
		if (doneBtnClick != null) {
			doneBtnClick.remove();
			doneBtnClick = null;
		}
	}
}
