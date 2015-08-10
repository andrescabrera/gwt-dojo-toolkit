# Introduction #

The Dojo Mobile package (dojox/mobile) provides a number of widgets that can be used to build applications for mobile devices such as iPhone, Android, or BlackBerry. These widgets work best with WebKit-based browsers, such as Safari or Chrome, since WebKit-specific CSS3 features are extensively used. However, a compatibility module (dojox/mobile/compat), is available, which simulates some of the CSS3 features used, even on non-CSS3 browsers.

Dojo Mobile is designed to be as lightweight as possible. It only has a few dependencies on other dojo modules. Also it has its own very small parser that is a subset of the core dojo.parser, but has enough capability to bootstrap your application.

# Structuring Your Mobile Application #

A sample GWT Dojo Mobile Application can be found at:

https://code.google.com/p/gwt-dojo-toolkit/source/browse/branches/gwt-dojo-toolkit-mobile/

Please use that as a skeleton application for this tutorial.

Just do:

```
svn -co http://gwt-dojo-toolkit.googlecode.com/svn/branches/gwt-dojo-toolkit-mobile/ gwt-dojo-toolkit-mobile
```

and add it to eclipse.

First, Dojo Mobile has to be added to your GWT Application Module file. Below you see the contents of Application.gwt.xml from gwt-dojo-toolkit-mobile application:

```
<?xml version="1.0" encoding="UTF-8"?>
<module rename-to='gwt_dojo_toolkit_mobile'>
	<!-- Inherit the core Web Toolkit stuff. -->
	<inherits name='com.google.gwt.user.User' />

	<!-- Other module inherits -->
	<inherits name='gwt.dojo.mobile.Mobile'/>

	<!-- Specify the app entry point class. -->
	<entry-point class='gwt.dojo.mobile.app.client.Main' />

	<!-- Specify the paths for translatable code -->
	<source path='client' />
</module>
```

Next, like any web application, it's important that the structure of the HTML page is intelligently designed. Important to include are:

  * The proper DOCTYPE
  * Mobile-specific META tags (see: [Mobile Safari Supported Meta Tags](http://developer.apple.com/library/safari/#documentation/appleapplications/reference/SafariHTMLRef/Articles/MetaTags.html))
  * A BODY element which will contain the views

Consider the following a template to start your mobile application with:
```
<!doctype html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		
		<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no"/>
		<meta name="apple-mobile-web-app-capable" content="yes" />
		
		<link type="text/css" rel="stylesheet" href="application.css">
		
		<title>GWT Dojo Mobile Demo Application</title>
		
		<script>
		dojoConfig= {
			async: true
		};
		</script>
		
		<script type="text/javascript" src="gwt_dojo_toolkit_mobile/gwt_dojo_toolkit_mobile.nocache.js"></script>
	</head>
	<body>
		<!-- application will go here -->
	</body>
</html>
```

Including Dojo happens automatically by GWT Dojo Toolkit. The only thing needed is adding:

```
<script>
dojoConfig= {
	async: true
};
</script>
```

just before:

```
<script type="text/javascript" src="gwt_dojo_toolkit_mobile/gwt_dojo_toolkit_mobile.nocache.js"></script>
```

That configuration option causes Dojo 1.7 to switch into “baseless” mode (also known as “async mode” or “AMD mode”). In this mode, modules like fx, xhr, and query aren’t loaded automatically. In fact, in this mode, the only thing that gets loaded automatically is the module loader itself. This enables you to truly require only what you need, making code written with Dojo 1.7 smaller and faster than code written with other, more monolithic libraries.

Note also, that NO Dojo related CSS theme is loaded.  Dojo Mobile (since 1.6) provides a dojox/mobile/deviceTheme resource to include theme resources based on User Agent detection. That means we don't have to hardcode a theme in our HTML page.

Finally, the EntryPoint class should require Dojo modules for use. Modules in Dojo 1.7 are identified by a string that closely resembles a file path. For example, “my/module/id” is a Dojo 1.7 module identifier. In fact, these identifiers are used to map directly to JavaScript files, which means that a request to load the module “my/module/id” will cause the loader to load whatever module is defined in my/module/id.js.

In order to actually require modules for use, Dojo.require() is provided by the Dojo loader. Dojo.require() takes two arguments: a list of module IDs that must be loaded, and a callback method that is executed once those dependencies have been loaded. This is usually easier to understand by looking at our EntryPoint class:

```
package gwt.dojo.mobile.app.client;

import gwt.dojo.client.Dojo;
import gwt.dojo.client.RequireCallback;
import gwt.dojo.client.util.JsArray;
import gwt.dojo.client.util.JsObject;
import gwt.dojo.mobile.client.Parser;

import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main implements EntryPoint, RequireCallback {

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
	public void callback(JsObject arguments) {
		// Parse the page for widgets!
		Parser.ref().parse();
	}
}
```

NOTE: Requiring dojox/mobile/compat is not necessary but is certainly best practice if your mobile web application should cater to multiple devices. Its functionality is not baked into dojox/mobile's base to keep dojox/mobile as compact as possible.

# Adding Widgets To The Page #

Before we start creating widgets, let's review a few of the widgets dojox/mobile proves:

  * **View** - A view is a virtual "page" within a mobile app. It scrolls to the left and right and the page can be any number of views deep.
  * **ScrollingView** - Allows for a header and/or footer to be anchored to the top or bottom allowing the middle content portion to be scrolled.
  * **Button** - A simple button.
  * **Switch** - An on/off toggling switch.
  * **Heading** - A simple heading.
  * **ListItem** - A basic list item.
  * **TabBar & TabBarButton** - Tabbed content management.

Now, let's create a basic mobile web application with two views and headings; a few list items, and a switch. To do so, we need to modify the HTML page and add the following lines in the HTML body:

```
<div id="general" data-dojo-type="dojox.mobile.View">
    <h1 data-dojo-type="dojox.mobile.Heading">General</h1>
    <ul data-dojo-type="dojox.mobile.RoundRectList">
        <li data-dojo-type="dojox.mobile.ListItem">
            Airplane Mode
            <!-- the switch -->
            <div class="mblItemSwitch" data-dojo-type="dojox.mobile.Switch"></div>
        </li>
        <li data-dojo-type="dojox.mobile.ListItem" data-dojo-props="rightText:'mac'">
            Wi-Fi
        </li>
        <li data-dojo-type="dojox.mobile.ListItem" data-dojo-props="rightText:'AcmePhone'">
            Carrier
        </li>
        <li data-dojo-type="dojox.mobile.ListItem" data-dojo-props="moveTo:'about'">
            About
        </li>
    </ul>
</div>
 
<div id="about" data-dojo-type="dojox.mobile.View">
    <h1 data-dojo-type="dojox.mobile.Heading" data-dojo-props="back:'General', moveTo:'general'">About</h1>
    <h2 data-dojo-type="dojox.mobile.RoundRectCategory">Generic Mobile Device</h2>
    <ul data-dojo-type="dojox.mobile.RoundRectList">
        <li data-dojo-type="dojox.mobile.ListItem" data-dojo-props="rightText:'AcmePhone'">
            Network                                            
        </li>                                                
        <li data-dojo-type="dojox.mobile.ListItem" data-dojo-props="rightText:'AcmePhone'">
            Line
        </li>
        <li data-dojo-type="dojox.mobile.ListItem" data-dojo-props="rightText:'1024'">
            Songs
        </li>
        <li data-dojo-type="dojox.mobile.ListItem" data-dojo-props="rightText:'10'">
            Videos
        </li>
        <li data-dojo-type="dojox.mobile.ListItem" data-dojo-props="rightText:'96'">
            Photos
        </li>
        <li data-dojo-type="dojox.mobile.ListItem" data-dojo-props="rightText:'2'">
            Applications
        </li>
        <li data-dojo-type="dojox.mobile.ListItem" data-dojo-props="rightText:'29.3 BG'">
            Capacity
        </li>
        <li data-dojo-type="dojox.mobile.ListItem" data-dojo-props="rightText:'28.0 BG'">
            Available
        </li>
        <li data-dojo-type="dojox.mobile.ListItem" data-dojo-props="rightText:'3.0 (7A341)'">
            Version
        </li>
    </ul>
</div>
```

| ![http://qrcode.kaywa.com/img.php?s=5&d=http%3A%2F%2Ftinyurl.com%2Fcxdnrzh&t=img.png](http://qrcode.kaywa.com/img.php?s=5&d=http%3A%2F%2Ftinyurl.com%2Fcxdnrzh&t=img.png) |
|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
**[View Demo](http://ggeorg.arkasoft.com/wiki-mobile-1/index.html)**

Congratulations, you've just created your first dojox/mobile web application! While your mobile web application will be more complex than our sample above, it's important to note that dojox/mobile provides the basic themes, widgets, methodology for creating multi-view web applications.


---


NOTE: There is a small cosmetic issue at startup. One possible fix for that is to add:
```
<div id="loadDiv" style="position:absolute; left:0px; top:0px; width:100%; height:100%; z-index:999; display:table; text-align:center; background-color: white;">
	<span style="display:table-cell; vertical-align:middle; font-size: 150%;"">Loading...</span>
</div>
```
just before the closing BODY tag in our HTML page.

The "loadDiv" will hide the UI declarations during the loading and parsing period. Once the application is started we need to hide it. To do that we do the following change in the application EntryPoint class:
```
	@Override
	public void callback(JsObject arguments) {
		// Parse the page for widgets!
		Parser.ref().parse();

		// Hide the "loadDiv" once the selected View is started.
		Dojo.subscribe("/dojox/mobile/startView", new SubscribeCallback() {
			@Override
			public void callback(JsObject source, TopicEvent event) {
				Document.get().getElementById("loadDiv").getStyle()
						.setVisibility(Visibility.HIDDEN);
			}
		});
	}
```

| ![http://qrcode.kaywa.com/img.php?s=5&d=http%3A%2F%2Ftinyurl.com%2Fcc4mqv3&t=img.png](http://qrcode.kaywa.com/img.php?s=5&d=http%3A%2F%2Ftinyurl.com%2Fcc4mqv3&t=img.png) |
|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
**[View Demo](http://ggeorg.arkasoft.com/wiki-mobile-2/index.html)**