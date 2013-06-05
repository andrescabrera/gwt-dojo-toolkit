package gwt.dojo.mobile.client;

/**
 * A dialog box for mobile.
 * <p>
 * When a {@code SimpleDialog} is created, it is initially hidden and not
 * displayed (display="none"). To show the dialog box, you need to get a
 * reference to the widget and to call show() method.
 * <p>
 * The contents can be arbitrary HTML, text, or widgets. Note, however, that the
 * widget is initially hidden. You need to be careful when you place something
 * that cannot be initialized under the hidden state.
 * <p>
 * {@code baseClass="mblSimpleDialog"}
 */
public class SimpleDialog extends Pane {

	public static final String MODULE = "dojox/mobile/SimpleDialog";

	/**
	 * top: String (default: "auto")
	 * <p>
	 * The top edge position of the widget. If "auto", the widget is placed at
	 * the center of the screen. Otherwise, the value (ex. "20px") is used as
	 * the top style of widget's domNode.
	 */
	public static final String TOP = "top";

	/**
	 * left: String (default: "auto")
	 * <p>
	 * The left edge position of the widget. If "auto", the widget is placed at
	 * the center of the screen. Otherwise, the value (ex. "20px") is used as
	 * the left style of widget's domNode.
	 */
	public static final String LEFT = "left";

	/**
	 * modal: Boolean (default: true)
	 * <p>
	 * If {@code true}, a translucent cover is added over the entire page to
	 * prevent the user from interacting with elements on the page.
	 */
	public static final String MODAL = "modal";

	/**
	 * closeButton: Boolean (default: false)
	 * <p>
	 * If {@code true}, a button to close the dialog box is displayed at the
	 * top-right corner.
	 */
	public static final String CLOSEBUTTON = "closeButton";

	/**
	 * closeButtonClass: String (default: "mblDomButtonSilverCircleRedCross")
	 * <p>
	 * A class name of a DOM button to be used as a close button.
	 */
	public static final String CLOSEBUTTONCLASS = "closeButtonClass";

	/**
	 * tabIndex: String (default: "0")
	 * <p>
	 * Tab index setting for the item so users can hit the tab key to focus on
	 * it.
	 */
	public static final String TABINDEX = "tabIndex";

	/**
	 * Default constructor.
	 */
	protected SimpleDialog() {
		// Required by JSNI.
	}
	
	/**
	 * Adds the transparent DIV cover.
	 */
	public final native void addCover() /*-{
		this.addCover();
	}-*/;
	
	/**
	 * Removes the transparent DIV cover.
	 */
	public final native void removeCover() /*-{
		this.removeCover();
	}-*/;
	
	// TODO onCloseButtonClick()
	
	/**
	 * Shows the dialog.
	 */
	public final native void show() /*-{
		this.show();
	}-*/;
	
	/**
	 * Hides the dialog.
	 */
	public final native void hide() /*-{
		this.hide();
	}-*/;

}
