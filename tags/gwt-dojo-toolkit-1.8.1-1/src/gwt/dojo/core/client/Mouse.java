package gwt.dojo.core.client;

public class Mouse extends JsObject {

	public static final String MODULE = "dojo/mouse";

	public static Mouse ref() {
		return JsObject.ref(MODULE);
	}

	/**
	 * enter: Synthetic Event
	 * <p>
	 * This is an extension event for the mouseenter that IE provides, emulating
	 * the behavior on other browsers.
	 */
	public static final String ENTER = "enter";

	/**
	 * leave: Synthetic Event
	 * <p>
	 * This is an extension event for the mouseleave that IE provides, emulating
	 * the behavior on other browsers.
	 */
	public static final String LEAVE = "leave";

	/**
	 * wheel: Normalized Mouse Wheel Event
	 * <p>
	 * This is an extension event for the mousewheel that non-Mozilla browsers
	 * provide, emulating the behavior on Mozilla based browsers.
	 */
	public static final String WHEEL = "wheel";

	protected Mouse() {
	}
	
}
