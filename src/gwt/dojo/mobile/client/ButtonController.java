package gwt.dojo.mobile.client;

import gwt.dojo.client.util.JsArray;
import gwt.dojo.client.util.JsObject;
import gwt.dojo.dijit.client._WidgetController;

public class ButtonController extends _WidgetController {

	public static class ButtonControllerFactory {
		private static ButtonControllerFactory instance = null;
		
		public static ButtonControllerFactory get() {
			if (instance == null) {
				instance = new ButtonControllerFactory();
			}
			return instance;
		}
		
		private ButtonControllerFactory() {
		}
		
		private JsArray getSuperClass() {
			return JsArray.create("dojox/mobile/Button");
		}
		
		private native JsObject init(JsObject obj) /*-{
			var widget = obj._controller = @gwt.dojo.dijit.client._WidgetController::new()();
		}-*/;
	}
	
	// ////////////////////////////////////////////////////////////////////////
	
	private Button button;
	
	protected ButtonController() {
	}
}
