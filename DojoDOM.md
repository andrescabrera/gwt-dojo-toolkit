# Introduction #

In this tutorial, you'll learn about how to use Dojo to manipulate the DOM in a single, cross-browser way. Using basic DOM knowledge and only a few Dojo functions, you will be able to efficiently create, read, update and delete elements in the page on the fly.

# Getting Started #

As far as browser-based JavaScript is concerned, the Document Object Model (DOM) is the glass that we paint on to put content and user interface in front or our users. If we want to augment, replace or add to the HTML once loaded into the browser, JavaScript and the DOM is how it's done. Dojo aims to make working with DOM easy and efficient by providing a handful of convenience functions that fill some awkward cross-browser incompatibilities and make common operations simpler and less verbose.

To explore those functions we will be manipulating a simple page containing an unordered list with elements in it:

```
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Demo: DOM Functions</title>
		<script>
			var dojoConfig = {
				async: true,
				parseOnLoad: true
			}
		</script>
		<script type="text/javascript" src="gwt_dojo_demo/gwt_dojo_demo.nocache.js"></script>
	</head>
	<body>
		<ul id="list">
			<li id="one">One</li>
			<li id="two">Two</li>
			<li id="three">Three</li>
			<li id="four">Four</li>
			<li id="five">Five</li>
		</ul>
	</body>
</html>
```

The page already has the GWT script tag, and you should recognize the Dojo config block. All code that manipulates the DOM must wait until the DOM is ready before it can be executed, this will happen in GWT EntryPoint class.

# Retrieval #

First things first: we need to know how to get elements from the DOM, in order to work with them. The easiest way to do that is by using [DOM](DOM.md) (dojo/dom) resource's `byId` method. When you pass an ID to `DOM.byId`, you will receive the DOM node object with that ID. If no matching node is found, a `null` value will be returned.

This is the equivalent of `Document.get().getElementById`, but is shorter to type. Let's look at an example:

```
import gwt.dojo.core.client.DOM;
import gwt.dojo.core.client.Dojo;
import gwt.dojo.core.client.DojoCallback;
import gwt.dojo.core.client.DojoReady;
import gwt.dojo.core.client.JsArray;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwt_dojo_demo implements EntryPoint, DojoCallback {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		JsArray modules = JsArray.create();
		modules.push(DOM.MODULE);
		modules.push(DojoReady.MODULE);
		Dojo.require(modules, this);
	}

	@Override
	public void callback(JsArray arguments) {
		Element one = DOM.byId("one");
		one.setInnerHTML("One has been set");
		
		Element two = DOM.byId("two");
		two.setInnerHTML("Two has been set as well");
	}
}
```

# Creation #

Another thing you will be doing often is creating elements. Dojo doesn't prevent you from using the `Document.get().createElement` method to create elements, but creating the element and setting all the necessary attributes and properties on it can be verbose.

The arguments to `DOMConstruct.create` are as follows: node name as a string, properties of the node as an object, an optional parent or sibling node, and an optional position if reference to the parent or sibling node (which defaults to "last"). It returns the new DOM element node. Lets take a look at an example:

```
import gwt.dojo.core.client.DOM;
import gwt.dojo.core.client.DOMConstruct;
import gwt.dojo.core.client.Dojo;
import gwt.dojo.core.client.DojoCallback;
import gwt.dojo.core.client.DojoReady;
import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.UListElement;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwt_dojo_demo implements EntryPoint, DojoCallback {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		JsArray modules = JsArray.create();
		modules.push(DOMConstruct.MODULE);
		modules.push(DojoReady.MODULE);
		Dojo.require(modules, this);
	}

	@Override
	public void callback(JsArray arguments) {
		UListElement list = DOM.byId("list");

		JsObject attr0 = JsObject.create("innerHTML", "Six");
		DOMConstruct.create("li", attr0, list);

		JsObject attr1 = JsObject.create("innerHTML", "Seven");
		attr1.put("className", "seven");
		attr1.put("style", JsObject.create("fontWeight", "bold"));
		DOMConstruct.create("li", attr1, list);

		DOMConstruct.create("li", JsObject.create("innerHTML", "Three and a half"),  "three", "after");
	}
}
```

A simple list item is created with the content of "Six" and appended to the list. Next, another list item is created with the content of "Seven", its `className` is set to "seven", it's styled so it has a bold font, and then appended to the list. Finally, a list item is created with the contents "Three and a half" and is inserted after the list item with the ID "three".

# Placement #

If you already have a node and want to place that node, you will need to use `DOMConstruct.place`. The arguments are as follows: a DOM node to place, a DOM node or string ID of a node to use as a reference, and an optional position as a string which defaults to "last" if not provided. This is very similar to what we saw in `DOMConstruct.create`. For our example, we have added a few buttons to the page:

```
<button id="moveFirst">The first item</button>
<button id="moveBeforeTwo">Before Two</button>
<button id="moveAfterFour">After Four</button>
<button id="moveLast">The last item</button>
```

The example defines functions which move the third node around the list using `DOMConstruct.place`:

```
import gwt.dojo.core.client.DOM;
import gwt.dojo.core.client.DOMConstruct;
import gwt.dojo.core.client.Dojo;
import gwt.dojo.core.client.DojoCallback;
import gwt.dojo.core.client.DojoOn;
import gwt.dojo.core.client.DojoReady;
import gwt.dojo.core.client.EventCallback;
import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.NativeEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwt_dojo_demo implements EntryPoint, DojoCallback {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		JsArray modules = JsArray.create();
		modules.push(DOMConstruct.MODULE);
		modules.push(DojoOn.MODULE);
		modules.push(DojoReady.MODULE);
		Dojo.require(modules, this);
	}

	@Override
	public void callback(JsArray arguments) {
		final LIElement three = DOM.byId("three");

		DojoOn.on(DOM.byId("moveFirst"), "click", new EventCallback() {
			@Override
			public void callback(JsObject source, NativeEvent event) {
				DOMConstruct.place(three, "list", "first");
			}
		});

		DojoOn.on(DOM.byId("moveBeforeTwo"), "click", new EventCallback() {
			@Override
			public void callback(JsObject source, NativeEvent event) {
				DOMConstruct.place(three, "two", "before");
			}
		});

		DojoOn.on(DOM.byId("moveAfterFour"), "click", new EventCallback() {
			@Override
			public void callback(JsObject source, NativeEvent event) {
				DOMConstruct.place(three, "four", "after");
			}
		});

		DojoOn.on(DOM.byId("moveLast"), "click", new EventCallback() {
			@Override
			public void callback(JsObject source, NativeEvent event) {
				DOMConstruct.place(three, "list");
			}
		});
	}
}
```

[View Demo](http://ggeorg.arkasoft.com/wiki-dom-construct-1/)

The possible values for the placement argument are "before", "after", "replace", "only", "first", and "last". Please see the [reference guide for domConstruct.place](http://dojotoolkit.org/reference-guide/1.8/dojo/dom-construct.html#dojo-dom-construct-place) for more details as to what each placement option does, though the names are decently intuitive.

# Destruction #

Most often you'll be creating nodes, but occasionally, you'll want to remove nodes as well. There are two ways to do this in Dojo: `DOMConstruct.destroy` which will destroy a node and all of its children, while `DOMConstruct.empty` will only destroy the children of a given node. Both take a DOM node or a string ID of a node as their only argument. We're going to add two more buttons to our page:

```
<button id="destroyFirst">Destroy the first list item</button>
<button id="destroyAll">Destroy all list items</button>
```

```
import gwt.dojo.core.client.DOM;
import gwt.dojo.core.client.DOMConstruct;
import gwt.dojo.core.client.Dojo;
import gwt.dojo.core.client.DojoCallback;
import gwt.dojo.core.client.DojoOn;
import gwt.dojo.core.client.DojoReady;
import gwt.dojo.core.client.EventCallback;
import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.UListElement;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwt_dojo_demo implements EntryPoint, DojoCallback {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		JsArray modules = JsArray.create();
		modules.push(DOMConstruct.MODULE);
		modules.push(DojoOn.MODULE);
		modules.push(DojoReady.MODULE);
		Dojo.require(modules, this);
	}

	@Override
	public void callback(JsArray arguments) {
		DojoOn.on(DOM.byId("destroyFirst"), "click", new EventCallback() {
			@Override
			public void callback(JsObject source, NativeEvent event) {
				UListElement list = DOM.byId("list");
				NodeList<Element> items = list.getElementsByTagName("li");
				
				if(items.getLength() > 0) {
					DOMConstruct.destroy(items.getItem(0));
				}
			}
		});

		DojoOn.on(DOM.byId("destroyAll"), "click", new EventCallback() {
			@Override
			public void callback(JsObject source, NativeEvent event) {
				DOMConstruct.empty("list");
			}
		});
	}
}
```

[View Demo](http://ggeorg.arkasoft.com/wiki-dom-construct-2/)

The first button will destroy the first item in the list on each click. The second empties the list