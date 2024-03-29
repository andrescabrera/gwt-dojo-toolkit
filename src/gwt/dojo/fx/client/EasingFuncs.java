package gwt.dojo.fx.client;

import gwt.dojo.core.client.Dojo;
import gwt.dojo.core.client.JsObject;

/**
 * Collection of easing functions to use.
 * <p>
 * TODO
 */
public class EasingFuncs extends JsObject {
	public static final String MODULE = "dojo/fx/easing";
	
	public static final JsObject LINEAR = EasingFuncs.ref().getJsObject("linear");
	public static final JsObject QUADIN = EasingFuncs.ref().getJsObject("quadIn");
	
	public static final JsObject BOUNCEINOUT = EasingFuncs.ref().getJsObject("bounceInOut");

	private static EasingFuncs ref() {
		return Dojo.require(MODULE);
	}

	protected EasingFuncs() {
	}
}
