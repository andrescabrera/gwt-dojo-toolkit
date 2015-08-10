# Introduction #

View is a container widget which represents an entire mobile device screen. One html page can have multiple Views, but only one View is visible at a time. The user can navigate through views with animated transition effects.

# Constructor Parameters #

| Parameter | Type | Default | Description |
|:----------|:-----|:--------|:------------|
| selected  | boolean | false   | If true, the view is displayed at startup time. |
| keepScrollPos | boolean | true    | If true, the scroll position is kept when transition occurs between views. |
| tag       | string | "div"   | A name of html tag to create as domNode. |

# Usage #

View is a container which represents the device screen. You should place all the contents in a View. There may be one or more Views in a page. If no views have selected=true, the first view is displayed at startup time.

Views can be nested to form a group of views.

# Examples #

## Declarative example ##

In this example, there are two Views, "view1" and "view2", and the user can move the views back and forth.

```
<div id="view1" data-dojo-type="dojox.mobile.View">
  <h1 data-dojo-type="dojox.mobile.Heading">View 1</h1>
  <ul data-dojo-type="dojox.mobile.RoundRectList">
    <li data-dojo-type="dojox.mobile.ListItem"
        data-dojo-props='icon:"images/i-icon-1.png",
                         moveTo:"view2",
                         transition:"slide"'>Go To View 2</li>
  </ul>
</div>

<div id="view2" data-dojo-type="dojox.mobile.View">
  <h1 data-dojo-type="dojox.mobile.Heading"
      data-dojo-props='back:"View 1",
                       moveTo:"view1"'>View 2</h1>
</div>
```

![http://dojotoolkit.org/reference-guide/1.8/_images/View-anim.gif](http://dojotoolkit.org/reference-guide/1.8/_images/View-anim.gif)

## Programmatic example ##

```
View view1 = View.create(null, "view1");

Heading heading1 = Heading.create(JsObject.create().put(Heading.LABEL, "View 1"));
_Container.cast(view1).addChild(heading1);

RoundRectCategory categ1 = RoundRectCategory.create(JsObject.create().put(RoundRectCategory.LABEL, "Documents"));
_Container.cast(view1).addChild(categ1);

RoundRectList list1 = RoundRectList.create();
_Container.cast(view1).addChild(list1);

for (int i = 1; i <= 3; i++) {
	JsObject liOptions = JsObject.create();
	liOptions.put(ListItem.LABEL, "Document " + i);
	liOptions.put(ListItem.ICON, "images/icon-" + i + ".png");
	liOptions.put(ListItem.MOVETO, "view2");
	ListItem item = ListItem.create(liOptions);
	_Container.cast(list1).addChild(item);
}

view1.startup();
```
```
<body>
	<div id="view1"></div>
</body>
```