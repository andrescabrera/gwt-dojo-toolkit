/*
 * Copyright 2012 ArkaSoft LLC.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package gwt.dojo.dijit.client.layout;

import gwt.dojo.dijit.client._WidgetBase;

/**
 * A widget containing an HTML fragment, specified inline or by uri. Fragment
 * may included widgets.
 * <p>
 * This widget embeds a document fragment in the page, specified either by uri,
 * javascript generated markup or DOM reference. Any widgets within this content
 * are instantiated and managed, but laid out according to the HTML structure.
 * Unlike IFRAME, {@code ContentPane} embeds a document fragment as would be
 * found inside the BODY tag of a full HTML document. It should not contain the
 * HTML, HEAD, or BODY tags.
 * 
 * @author ggeorg
 */
public class ContentPane extends _WidgetBase implements IContentPaneResizeMixin {

	public static final String MODULE = "dijit/layout/ContentPane";

	/**
	 * href: String (default: "")
	 * <p>
	 * The href of the content that displays now.
	 */
	public static final String HREF = "href";

	/**
	 * content: String || DomNode || NodeList || dijit._Widget (default: "")
	 * <p>
	 * The {@code innerHTML} of the {@code contentPane}.
	 */
	public static final String CONTENT = "content";

	/**
	 * extractContent: Boolean (default: false)
	 * <p>
	 * Extract visible content from inside of <body>...</body>. I.e. strip
	 * <html> and <head> (and it's contents) from the {@code href}.
	 */
	public static final String EXTRACTCONTENT = "extractContent";

	/**
	 * parseOnLoad: Boolean (default: false)
	 * <p>
	 * TODO
	 */
	public static final String PARSEONLOAD = "parseOnLoad";

	/**
	 * parserScope: String
	 * <p>
	 * TODO
	 */
	public static final String PARSERSCOPE = "parserScope";

	/**
	 * preventCache: Boolean (default: false)
	 * <p>
	 * Prevent caching of data from href's by appending a timestamp to the href.
	 */
	public static final String PREVENTCACHE = "preventCache";

	/**
	 * preload: Boolean (default: false)
	 * <p>
	 * Force load of data on initialization even if pane is hidden.
	 */
	public static final String PRELOAD = "preload";

	/**
	 * refreshOnShow: Boolean (deafult: false)
	 * <p>
	 * Refresh (re-download) content when pane goes from hidden to shown.
	 */
	public static final String REFRESHONSHOW = "refreshOnShow";

	/**
	 * loadingMessage: String
	 * <p>
	 * Message that shows while downloading.
	 */
	public static final String LOADINGMESSAGE = "loadingMessage";

	/**
	 * errorMessage: String
	 * <p>
	 * Message that shows if an error occurs.
	 */
	public static final String ERRORMESSAGE = "errorMessage";

	/**
	 * isLoaded: [readonly] Boolean
	 * <p>
	 * {@code true} if the {@code ContentPane} has data in it, either specified
	 * during initialization (via href or inline content), or set via
	 * set('content', ...) / set('href', ...)
	 * <p>
	 * {@code false} if it doesn't have any content, or if {@code ContentPane}
	 * is still in the process of downloading {@code href}.
	 */
	public static final String ISLOADED = "isLoaded";

	/**
	 * ioArgs: Object
	 * <p>
	 * TODO
	 */
	public static final String IOARGS = "ioArgs";

	// TODO onLoadDeferred: [readonly] dojo.Deferred

	/**
	 * Event hook, is called after everything is loaded and widgetified.
	 */
	public static final String ONLOAD = "onLoad";

	/**
	 * Event hook, is called before old content is cleared.
	 */
	public static final String ONUNLOAD = "onUnload";

	/**
	 * Called before download starts.
	 */
	public static final String ONDOWNLOADSTART = "onDownloadStart";

	/**
	 * Called on DOM faults, require faults etc. in content.
	 */
	public static final String ONCONTENTERROR = "onContentError";

	/**
	 * Called when download error occurs.
	 */
	public static final String ONDOWNLOADERROR = "onDownloadError";

	/**
	 * Default constructor.
	 */
	protected ContentPane() {
	}

	/**
	 * Cancels an in-flight download of content.
	 */
	public final native void cancel() /*-{
		this.cancel();
	}-*/;

	/**
	 * [Re]download contents of href and display.
	 * <p>
	 * TODO
	 */
	public final native void refresh() /*-{
		this.refresh();
	}-*/;
}
