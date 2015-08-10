The Dijit module includes Dojo's extensive UI library of widgets and components. Some examples of these widgets include dialog boxes, calendars, color palettes, tooltips, and trees. It also includes a set of form controls that provide much more functionality than the standard HTML form controls, as well as complete layout management options.

In **gwt-dojo-toolkit** Dijit is a separate GWT module. To use it add the following lines in your application's .gwt.xml file.

```
<inherits name='gwt.dojo.dijit.Dijit' />
<inherits name='gwt.dojo.dijit.ClaroTheme' />
```

# Dijit Basics #

You can use Dijit in one of two ways: **declaratively** by using special attributes inside of regular HTML tags, and **programmatically** through GWT Java (you are welcome to mix-and-match the two styles). You have the same options either way.

```
import gwt.dojo.core.client.Dojo;
import gwt.dojo.core.client.DojoCallback;
import gwt.dojo.core.client.DojoReady;
import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;
import gwt.dojo.dijit.client.Dialog;

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
		modules.push(DojoReady.MODULE);
		modules.push(Dialog.MODULE);
		Dojo.require(modules, this);
	}

	@Override
	public void callback(JsArray arguments) {
		// create a "hidden" Dialog:
		JsObject options = JsObject.create();
		options.put(Dialog.ID, "someId");
		options.put(Dialog.TITLE, "Hello Dijit");
		Dialog myDialog = Dialog.create(options);
		myDialog.startup();
		
		// Hint: In order to open the dialog, you have to call
		//myDialog.show();
	}
}
```

is identical to:

```
<div data-dojo-type="dijit/Dialog" title="Hello Dijit!" id="someId"></div>
```

The declarative method requires you include the [Parser](https://code.google.com/p/gwt-dojo-toolkit/source/browse/trunk/src/gwt/dojo/core/client/Parser.java) (dojo/parser) and have either `dojoConfig.parseOnLoad` set to `true`, or you manually call `Parser.parse()` when you would like the widgets (aka: Dijits) to be created.

Dijit stores all active widgets in the [Registry](Registry.md) (digit/registry), and uses id's as unique qualifiers. `Registry.byId()` returns the instance (widget) from a passed ID, allowing you access to all methods and properties within:

```
import gwt.dojo.core.client.Dojo;
import gwt.dojo.core.client.DojoCallback;
import gwt.dojo.core.client.DojoReady;
import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.Parser;
import gwt.dojo.dijit.client.Dialog;
import gwt.dojo.dijit.client.Registry;

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
		modules.push(DojoReady.MODULE);
		modules.push(Registry.MODULE);
		modules.push(Dialog.MODULE);
		Dojo.require(modules, this);
	}

	@Override
	public void callback(JsArray arguments) {
		// DOM.byId("someId") would only be a normal domNode.
		Dialog myDialog = Registry.byId("someId");
		myDialog.set(Dialog.CONTENT, "<p>I am some content.</p>");
		myDialog.show();
	}
}
```

If you need a reference to the actual Node used to display the widget, Dijit stores it as a property in the instance: `DOMNODE`. You can use this property for styling, positioning, or other DOM manipulation.

When creating widgets programmatically, pass an `id:""` parameter:

```
JsObject options = JsObject.create();
options.put(Dialog.ID, "someId");
options.put(Dialog.TITLE, "Hello Dijit");
Dialog myDialog = Dialog.create(options);
```

Otherwise, a unique ID will be generated for you:

```
JsObject options = JsObject.create();
//options.put(Dialog.ID, "someId");
options.put(Dialog.TITLE, "Hello Dijit");
Dialog myDialog = Dialog.create(options);

Window.alert(myDialog.getString(Dialog.ID));
```

All Dijits follow the same programmatic convention. Create a new instance, pass an object-hash or properties, and supply an optional "source node reference".

TODO

This will cause the creator to use the node with `id="makeADialog"`, and turn it into a Dialog.

# Attributes #

Widgets have attributes much like DOM nodes. The attributes are one of the two main interfaces to programmatically interact with the widget.

## set() and get() ##

In general attributes can be both set at initialization and modified after the widget is created, although some attributes, like `id` and `type`, which are marked [const](const.md), can only be set at initialization. Other attributes, like "focused", which are marked [readonly](readonly.md), can only be read.

This basically mirrors how vanilla HTML DOM nodes work, although the syntax is a bit different. Specifically, to get/set attributes after initialization, you need to use the get() and set() methods:

```
// set title
myTitlePane.set('title', 'hello world');

// find out if button is disabled
boolean dis = myButton.getBoolean('disabled');
```

## watch() ##

Attributes can also be monitored for changes. For example:

```

```

## Common Attributes of Dijits ##

## Events ##

## Themes ##

## Dijit i18n/a11y ##

## Locating Widgets ##