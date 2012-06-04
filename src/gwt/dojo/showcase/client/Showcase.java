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
package gwt.dojo.showcase.client;

import gwt.dojo.client.ConnectCallback;
import gwt.dojo.client.Dojo;
import gwt.dojo.client.EventCallback;
import gwt.dojo.client.RequireCallback;
import gwt.dojo.client.SubscribeCallback;
import gwt.dojo.client.TopicEvent;
import gwt.dojo.client.util.JsArray;
import gwt.dojo.client.util.JsObject;
import gwt.dojo.dijit.client.IContainer;
import gwt.dojo.dijit.client.Registry;
import gwt.dojo.dijit.client._Container;
import gwt.dojo.dijit.client._WidgetBase;
import gwt.dojo.mobile.client.EdgeToEdgeCategory;
import gwt.dojo.mobile.client.EdgeToEdgeList;
import gwt.dojo.mobile.client.Heading;
import gwt.dojo.mobile.client.ListItem;
import gwt.dojo.mobile.client.Parser;
import gwt.dojo.mobile.client.ProgressIndicator;
import gwt.dojo.mobile.client.ScrollableView;
import gwt.dojo.mobile.client.ToolBarButton;
import gwt.dojo.mobile.client.View;
import gwt.dojo.showcase.client.controllers.Controller;
import gwt.dojo.showcase.client.controllers.FormsController;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Showcase implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Dojo.require(JsArray.create("dojox/mobile/deviceTheme", "dojox/mobile",
				"dojox/mobile/parser", "dojox/mobile/compat",
				"dojox/mobile/Button", "dojox/mobile/ToolBarButton",
				"dojox/mobile/FixedSplitter", "dojox/mobile/ScrollableView",
				"dojox/mobile/ProgressIndicator",
				"dojox/mobile/FixedSplitterPane", "dojox/mobile/SwapView",
				"dojox/mobile/TabBar", "dojo/domReady!"),
				new RequireCallback() {
					@Override
					public void callback(JsObject arguments) {
						startup(arguments);
					}
				});
	}

	protected void startup(JsObject arguments) {
		Parser.ref().parse();

		{
			// initialize view with two splitter panes
			// define layout, show leftPane and hide navButton
			Document.get().getElementById("leftPane").addClassName("navPane");
			Document.get().getElementById("navButton").addClassName("hidden");
		}

		initNavList();

		Dojo.subscribe("showView", new SubscribeCallback() {
			@Override
			public void callback(JsObject source, TopicEvent event) {
				final ListItem listItem = source.cast();
				showView(listItem);
			}
		});

		// workaround for flash during loading due to auto hide address bar
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				Document.get().getElementById("loadDiv").getStyle()
						.setVisibility(Visibility.HIDDEN);
			}
		});
	}

	private final EventCallback onNavItemClick = new EventCallback() {
		@Override
		public void callback(JsObject source, NativeEvent event) {
			final ListItem listItem = source.cast();
			showView(listItem);
		}
	};

	private void initNavList() {
		ScrollableView navView = ScrollableView.byId("navigation");

		EdgeToEdgeCategory cat = EdgeToEdgeCategory.create();
		cat.set("label", "Controls");
		_Container.cast((IContainer) navView).addChild(cat);

		EdgeToEdgeList list = EdgeToEdgeList.create();
		list.set("id", "controls").set("iconBase",
				"images/navigation_list_all_29.png");
		_Container.cast(navView).addChild(list);

		ListItem item = ListItem.create();
		item.set("viewId", "buttons").set("label", "Buttons")
				.set("iconPos", "0,0,29,29")
				.set("demourl", "views/buttons.html").set("moveTo", "#");
		item.on("click", onNavItemClick);
		_Container.cast(list).addChild(item);

		item = ListItem.create();
		item.set("viewId", "forms").set("label", "Forms")
				.set("iconPos", "29,0,29,29")
				.set("demourl", "views/forms.html").set("moveTo", "#");
		item.on("click", new FormsController(this));
		_Container.cast(list).addChild(item);

		item = ListItem.create();
		item.set("viewId", "mobileSwitches").set("label", "Switches")
				.set("iconPos", "29,0,29,29")
				.set("demourl", "views/mobileSwitches.html").set("moveTo", "#");
		item.on("click", onNavItemClick);
		_Container.cast(list).addChild(item);

		item = ListItem.create();
		item.set("viewId", "flippableView").set("label", "Flippable")
				.set("iconPos", "58,0,29,29")
				.set("demourl", "views/flippableViews.html").set("moveTo", "#");
		item.on("click", onNavItemClick);
		_Container.cast(list).addChild(item);

		item = ListItem.create();
		item.set("viewId", "icons").set("label", "Icons")
				.set("iconPos", "87,0,29,29");
		_Container.cast(list).addChild(item);

		item = ListItem.create();
		item.set("viewId", "tabBar").set("label", "Tab Bar")
				.set("iconPos", "116,0,29,29")
				.set("demourl", "views/tabBar.html").set("moveTo", "#");
		item.on("click", onNavItemClick);
		_Container.cast(list).addChild(item);

		item = ListItem.create();
		item.set("viewId", "headings").set("label", "Headings")
				.set("iconPos", "145,0,29,29");
		_Container.cast(list).addChild(item);

		item = ListItem.create();
		item.set("viewId", "list").set("label", "Lists")
				.set("iconPos", "203,0,29,29")
				.set("demourl", "views/lists.html").set("moveTo", "#");
		item.on("click", onNavItemClick);
		_Container.cast(list).addChild(item);

		cat = EdgeToEdgeCategory.create();
		cat.set("label", "Effects");
		_Container.cast(navView).addChild(cat);

		list = EdgeToEdgeList.create();
		list.set("id", "effects").set("iconBase",
				"images/navigation_list_all_29.png");
		_Container.cast(navView).addChild(list);

		item = ListItem.create();
		item.set("viewId", "mobileTransitions").set("label", "Transitions")
				.set("iconPos", "290,0,29,29");
		_Container.cast(list).addChild(item);

		item = ListItem.create();
		item.set("viewId", "css3").set("label", "CSS 3")
				.set("iconPos", "406,0,29,29");
		_Container.cast(list).addChild(item);

		cat = EdgeToEdgeCategory.create();
		cat.set("label", "Data");
		_Container.cast(navView).addChild(cat);

		list = EdgeToEdgeList.create();
		list.set("id", "dataList").set("iconBase",
				"images/navigation_list_all_29.png");
		_Container.cast(navView).addChild(list);
	}

	/**
	 * Show or hide global progress indicator.
	 * 
	 * @param show
	 */
	private void showProgressIndicator(boolean show) {
		ProgressIndicator prog = ProgressIndicator.get();
		// TODO: remove this workaround
		prog.stop();
		if (show) {
			Element domNode = prog.getJavaScriptObject("domNode");
			Document.get().getElementById("rightPane").appendChild(domNode);
			prog.start();
		}
	}

	// flag indicating whether there's transition
	private boolean inTransitionOrLoading = false;

	/**
	 * Show the view of each show case.
	 * 
	 * @param listItem
	 */
	public void showView(ListItem listItem) {
		if (inTransitionOrLoading) {
			return;
		}
		showProgressIndicator(false);

		String viewId = listItem.getString("viewId");
		if (Registry.get().byId(viewId) != null) {
			// inTransitionOrLoading = true;
			listItem.transitionTo(viewId);
		} else {
			// inTransitionOrLoading = true;
			loadAndSwitchView(listItem);
		}
	}

	private void loadAndSwitchView(final ListItem listItem) {

		final RequestCallback requestCallback = new RequestCallback() {
			@Override
			public void onResponseReceived(Request request, Response response) {
				if (200 == response.getStatusCode()) {
					try {
						// Process the response in response.getText()

						// fillInDemoSource();
						DivElement rightPane = Document.get()
								.getElementById("rightPane").cast();
						DivElement tmpContainer = Document.get()
								.createDivElement();
						tmpContainer.setInnerHTML(response.getText());
						rightPane.appendChild(tmpContainer);
						JsArray ws = Parser.ref().parse(tmpContainer);
						for (int i = 0, n = ws.length(); i < n; i++) {
							if (ws.getJsObject(i).hasProperty("startup")) {
								_WidgetBase.cast(ws.getJsObject(i)).startup();
							}
						}

						// reparent
						rightPane.removeChild(tmpContainer);
						NodeList<Node> children = tmpContainer.getChildNodes();
						for (int i = 0, n = children.getLength(); i < n; i++) {
							Element elem = tmpContainer.getChild(i).cast();
							rightPane.appendChild(elem);
						}

						showProgressIndicator(false);
						Scheduler.get().scheduleDeferred(
								new ScheduledCommand() {
									@Override
									public void execute() {
										initView(listItem);
										listItem.transitionTo(listItem
												.getString("viewId"));
										// triggreTransition(listItem,
										// listItem.getString("id"));
									}
								});
					} catch (Exception e) {
						Window.alert("Error: " + e);
					}
				} else {
					// Handle the error. Can get the status text from
					// response.getStatusText()
					onError(request, new RequestException("HTTP Error: "
							+ response.getStatusCode()));
				}
			}

			@Override
			public void onError(Request request, Throwable exception) {
				Window.alert("Failed to load demo.");
				showProgressIndicator(false);
				inTransitionOrLoading = false;
			}
		};

		showProgressIndicator(true);

		String url = listItem.getString("demourl");
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
				URL.encode(url));

		Request request = null;
		try {
			request = builder.sendRequest(null, requestCallback);
		} catch (RequestException e) {
			requestCallback.onError(request, e);
		}
	}

	protected void initView(final ListItem listItem) {
		View view = View.byId(listItem.getString("viewId"));

		final String viewType = listItem.hasProperty("viewType") ? listItem
				.getString("viewType") : "demo";

		Dojo.connect(view, "onAfterTransitionIn", view,
				new ConnectCallback<JsObject>() {
					@Override
					public void callback(JsObject source, JsObject arguments) {
						inTransitionOrLoading = false;
						Element headerLabel = Document.get().getElementById(
								"headerLabel");
						Element header = Document.get()
								.getElementById("header");
						Element sourceButton = Document.get().getElementById(
								"sourceButton");
						Element navButton = Document.get().getElementById(
								"navButton");

						if ("demo".equals(viewType)) {
							// after transition in, set the header, source
							// button and load the source code of current view.
							headerLabel.setInnerHTML(listItem
									.getString("label"));
							ToolBarButton srcBtn = ToolBarButton
									.byId("sourceButton");
							srcBtn.set("backTo", listItem.getString("viewId"));
							srcBtn.select(true);
							sourceButton.setInnerHTML(srcBtn.getBoolean(
									"selected", false) ? "Demo" : "Source");

							// set the header's moveTo attribute to "navigation"
							Heading heading = Heading.byNode(header);
							heading.set("moveTo", "navigation");
							// restore sourceButton if applicable
							if (sourceButton.getClassName().contains("hidden")) {
								sourceButton.removeClassName("hidden");
							}
							// if leftPane is hidden restore navButton if
							// applicable
							// TODO
							// Document.get().getElementById("htmlContent").setInnerHTML(getDemoHtml());
							// dom.byId("jsContent").innerHTML =
							// getDemoJs(args.id);
						} else {

						}

						if (listItem.hasProperty("controller")) {
							GWT.runAsync(new RunAsyncCallback() {
								@Override
								public void onFailure(Throwable reason) {
									Window.alert("Failed to load controller for: "
											+ listItem.getString("id"));
								}

								@Override
								public void onSuccess() {
									Controller controller = (Controller) listItem
											.get("controller");
									controller.activate(listItem);
								}
							});
						}
					}
				});

	}

}
