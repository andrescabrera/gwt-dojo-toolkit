package gwt.dojo.mobile.app.client.controllers;

import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.MessageHub;
import gwt.dojo.core.client.SubscribeCallback;
import gwt.dojo.dijit.client.Registry;
import gwt.dojo.dijit.client._WidgetBase;
import gwt.dojo.mobile.client.ProgressIndicator;
import gwt.dojo.mobile.client.View;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public abstract class ViewController {

	private final String viewId;

	public ViewController(String viewId) {
		this.viewId = viewId;

		MessageHub.subscribe("/dojox/mobile/startView/" + viewId,
				new SubscribeCallback() {
					@Override
					public void callback(String topic, JsArray message) {
						onStartView();
					}
				});

		MessageHub.subscribe("/dojox/mobile/beforeTransitionIn/" + viewId,
				new SubscribeCallback() {
					@Override
					public void callback(String topic, JsArray message) {
						beforeTransitionIn();
					}
				});

		MessageHub.subscribe("/dojox/mobile/afterTransitionIn/" + viewId,
				new SubscribeCallback() {
					@Override
					public void callback(String topic, JsArray message) {
						afterTransitionIn();
					}
				});

		MessageHub.subscribe("/dojox/mobile/beforeTransitionOut/" + viewId,
				new SubscribeCallback() {
					@Override
					public void callback(String topic, JsArray message) {
						beforeTransitionOut();
					}
				});

		MessageHub.subscribe("/dojox/mobile/afterTransitionOut/" + viewId,
				new SubscribeCallback() {
					@Override
					public void callback(String topic, JsArray message) {
						afterTransitionOut();
					}
				});
	}

	public String getViewId() {
		return viewId;
	}

	protected View getView() {
		return Registry.byId(getViewId());
	}

	protected boolean isShowingView() {
		View view = getView();
		return view == view.getShowingView();
	}

	protected void performTransition(String moveTo, int dir, String transition) {
		getView().getShowingView().performTransition(moveTo, dir, transition);
	}

	protected void onStartView() {
		// do nothing
	}

	protected void beforeTransitionIn() {
		// do nothing
	}

	protected void afterTransitionIn() {
		// do nothing
	}

	protected void beforeTransitionOut() {
		// do nothing
	}

	protected void afterTransitionOut() {
		// do nothing
	}

	/**
	 * Show or hide global progress indicator.
	 */
	protected void showProgressIndicator(boolean show) {
		ProgressIndicator prog = ProgressIndicator.get();
		prog.stop();

		Element domNode = prog.getElement(_WidgetBase.DOMNODE);

		if (show) {
			Document.get().getBody().appendChild(domNode);
			prog.start();
		} else {
			domNode.removeFromParent();
		}
	}
}
