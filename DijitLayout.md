# Introduction #

Creating dynamic and interactive layouts is a challenge common to any graphical user interface. We have a lot of ability to create layout with HTML and CSS. Where CSS leaves off, Dojo picks up with a set of extensible widgets as a part of Dijit - Dojo's UI framework. In this tutorial, we'll explain how Dijit addresses common layout needs and see how easy it can be to create even complex layouts with just a few flexible widgets.

# Getting Started #

You can manage layout of the entire page, or just a small part of it. For this tutorial, we'll be developing a desktop application-like UI layout, with some controls and content being fixed on the page. It should end up looking like this:

| What you'll be creating |
|:------------------------|
| ![http://dojotoolkit.org/documentation/tutorials/1.8/dijit_layout/images/appLayout.png](http://dojotoolkit.org/documentation/tutorials/1.8/dijit_layout/images/appLayout.png) |

Dijit provides a small collection of flexible widgets to meet common layout requirements like this. We'll prepare the ground with some HTML and CSS, then introduce those widgets to build up a typical application layout.

```
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<link type="text/css" rel="stylesheet" href="Gwt_dojo_demo.css">
		<title>Web Application Starter Project</title>
		<script>
			var dojoConfig = {
				async: true,
				parseOnLoad: true
			}
		</script>
		<script type="text/javascript" src="gwt_dojo_demo/gwt_dojo_demo.nocache.js"></script>
	</head>
	<body class="claro">
		<div id="appLayout" class="demoLayout">
			<div class="centerPanel">
				<div>
					<h4>Group 1 Content</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
					sed do eiusmod tempor incididunt ut labore et dolore magna 
					aliqua. Ut enim ad minim veniam, quis nostrud exercitation 
					ullamco laboris nisi ut aliquip ex ea commodo consequat. 
					Duis aute irure dolor in reprehenderit in voluptate velit 
					esse cillum dolore eu fugiat nulla pariatur. Excepteur sint 
					occaecat cupidatat non proident, sunt in culpa qui officia 
					deserunt mollit anim id est laborum.</p>
				</div>
				<div>
					<h4>Group 2 Content</h4>
				</div>
				<div>
					<h4>Group 3 Content</h4>
				</div>
			</div>
		
			<div class="edgePanel">Header content (top)</div>
			<div id="leftCol" class="edgePanel">Sidebar content (left)</div>
		</div>
	</body>
</html>
```

Notice in the `dojoConfig` variable in the script tag we've set `parseOnLoad` to `true`. This tells Dojo to run the parser automatically to "widgetize" the elements it finds. Given that we're fully relying on the parser, we have no need for `dojo/domReady!` or anything like that - we're just loading what we use.

The markup has our top, sidebar and center wrapped in handy divs, and we've got the GWT `script` tag already in place. Also in the projects **.gwt.xml file we load the Claro theme and the get-dojo-toolkit's Dijit module:**

```
<inherits name='gwt.dojo.dijit.Dijit' />
<inherits name='gwt.dojo.dijit.ClaroTheme' />
```

In the `<body>`, notice the `claro` class which is necessary to apply the Claro CSS theme to the contents. Omitting it is a common gotcha.

The application's stylesheet has just a few rules that we'll need as we define the layout:

```
html, body {
    height: 100%;
    margin: 0;
    overflow: hidden;
    padding: 0;
}
 
#appLayout {
    height: 100%;
}
#leftCol {
    width: 14em;
}
 
.claro .demoLayout .edgePanel {
    background-color: #d0e9fc;
}
 
#viewsChart {
    width: 550px;
    height: 550px;
}
```

To get the desired arrangement and behavior of content regions, we want the layout to fill the viewport.  We explicitly set the document and the outermost element to 100% of the viewport height. `overflow: hidden` is used as we don't want a document scrollbar; scrolling will happen as necessary in the different regions of out layout. We've given the DIV that will become the left column a fixed width in `em`. The other fixed regions will derive their size from their initial content.

# Adding Widgets #

To implement the layout, we'll be using three widget classes from Dijit: [BorderContainer](BorderContainer.md), [TabContainer](TabContainer.md) and [ContentPane](ContentPane.md).

To get started, let's add a `require` call to load these dependencies:

```
import gwt.dojo.core.client.Dojo;
import gwt.dojo.core.client.DojoCallback;
import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.Parser;
import gwt.dojo.dijit.client.layout.BorderContainer;
import gwt.dojo.dijit.client.layout.ContentPane;
import gwt.dojo.dijit.client.layout.TabContainer;

import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwt_dojo_demo implements EntryPoint, DojoCallback {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		JsArray modules = JsArray.create();
		modules.push(Parser.MODULE);
		modules.push(BorderContainer.MODULE);
		modules.push(TabContainer.MODULE);
		modules.push(ContentPane.MODULE);
		Dojo.require(modules, this);
	}

	@Override
	public void callback(JsArray arguments) {

	}
}
```

Notice that we have also explicitly loaded the dojo/parser module. This is of monumental importance; despite popular misconception, dojo/parser does not load automatically when parseOnLoad is set to true, and never has.

The widget classes will now load in the background, and the parser will walk over the DOM. But nothing is actually going to happen yet - we need to create those layout widgets.

For example, we'll be using the markup or **declerative way** of instantiating the widgets. The `data-dojo-` attributes on each element provide instruction for Dojo parser on what widget class to instantiate, and hold the properties to configure the widget instance with.

```
	<body class="claro">
	
		<div id="appLayout" class="demoLayout"
			 data-dojo-type="dijit/layout/BorderContainer"
			 data-dojo-props="design: 'headline'">

			<div class="centerPanel"
				 data-dojo-type="dijit/layout/ContentPane"
				 data-dojo-props="region: 'center'">
				<div>
					<h4>Group 1 Content</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
					sed do eiusmod tempor incididunt ut labore et dolore magna 
					aliqua. Ut enim ad minim veniam, quis nostrud exercitation 
					ullamco laboris nisi ut aliquip ex ea commodo consequat. 
					Duis aute irure dolor in reprehenderit in voluptate velit 
					esse cillum dolore eu fugiat nulla pariatur. Excepteur sint 
					occaecat cupidatat non proident, sunt in culpa qui officia 
					deserunt mollit anim id est laborum.</p>
				</div>
				<div>
					<h4>Group 2 Content</h4>
				</div>
				<div>
					<h4>Group 3 Content</h4>
				</div>
			</div>
		
			<div class="edgePanel"
				 data-dojo-type="dijit/layout/ContentPane"
				 data-dojo-props="region: 'top'">Header content (top)</div>
				 
			<div id="leftCol" class="edgePanel"
				 data-dojo-type="dijit/layout/ContentPane"
				 data-dojo-props="region: 'left', splitter: true">Sidebar content (left)</div>
			
		</div>

	</body>
```

**[View Demo](http://ggeorg.arkasoft.com/wiki-layout-1/)**

The outer `appLayout` element has been configured as a `BorderContainer`, and the child divs are each `ContentPane`s. This gives us a full-screen flexible layout. Go ahead and try resizing your demo window, to see how the left region stays a fixed width, while the center/right region sizes to fit. You may also notice a handle on the vertical divider, between the left and center regions, which allows you to manually set their relative widths.

This is what we mean by dynamic and interactive layout. We'll get to adding in the tab-strip shown in the initial demo, but first let's back up and look a bit closer at the individual layout widgets and their use.

# BorderContainer #

[BorderContainer](https://code.google.com/p/gwt-dojo-toolkit/source/browse/trunk/src/gwt/dojo/dijit/client/layout/BorderContainer.java) allows you to define a layout subdivided into regions. The `center` region is always flexible and auto-sized, while the other regions are fixed in size: `top`, `bottom`, `leading`, `trailing`, `left` or `right`.

![http://dojotoolkit.org/documentation/tutorials/1.8/dijit_layout/images/borderContainer.png](http://dojotoolkit.org/documentation/tutorials/1.8/dijit_layout/images/borderContainer.png)

All Dijit widgets support internationalization (i18n), so Dijit can't assume left-to-right flow of content and controls on the page. For left-to-right locales (e.g. Arabic, Hebrew), it is reversed. That being said, you can use `left` and `right` as appropriate to ensure that sections are always on the side of your choosing, regardless of locale. use what fits your content logically.

Each region is represented by a child widget, as we saw in the App Layout example. All Dijit widgets support the `region` property, so in principle, you can use any widget in these positions, though clearly some will work better than others. The fixed-size regions (all but `center`) can have a end-user-moveable divider associated with them by setting a `splitter` property.

When using BorderContainer, the initial sizes or regions are specified in the normal manner using CSS - using rulers in a stylesheet or as inline style. Note that although you can set an initial size of say, 50%, it will be converted to `px` as it renders, so relative proportions in percentage units are not maintained as the BorderContainer is resized. The center region should not be given style height or width; it will always occupy whatever space remains.

Up to now as we've been building out layout, all the regions were `ContentPane`s - a very general purpose content-loading and content-containing widget, but as we saw in the first App Layout where a TabContainer occupied the center region, that needn't be so. In fact, BorderContainer works quite happily as a region in a BorderContainer.