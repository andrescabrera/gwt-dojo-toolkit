
package gwt.dojo.mobile.app.client;

import gwt.dojo.core.client.Dojo;
import gwt.dojo.core.client.DojoCallback;
import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;
import gwt.dojo.core.client.MessageHub;
import gwt.dojo.core.client.SubscribeCallback;
import gwt.dojo.mobile.client.Parser;
import gwt.dojo.mobile.client.View;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main implements EntryPoint, DojoCallback {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// Load the widget parser and mobile base
		Dojo.require(JsArray.create("dojox/mobile/parser",
				"dojox/mobile/deviceTheme", "dojox/mobile/compat",
				"dojox/mobile"), this);
	}

	@Override
	public void callback(JsArray arguments) {
		MessageHub.subscribe(View.TOPIC_STARTVIEW, new SubscribeCallback() {
			@Override
			public void callback(String topic, JsArray message) {
				hideLoadDiv();
			}
		});

		// Parse the page for widgets!
		Parser.parse();
	}

	protected void hideLoadDiv() {
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				Element loadDiv = Document.get().getElementById("loadDiv");
				if (loadDiv != null) {
					loadDiv.removeFromParent();
				}
			}
		});
	}

}
