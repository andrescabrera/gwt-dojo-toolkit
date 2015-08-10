# Introduction #

SwapView is a container widget which represents an entire mobile device screen, and can be swiped horizontally. SwapView is a subclass of [View](MobileView.md). SwapView allows the user to swipe the screen left or right to move between the views. When SwapView is swiped, it finds an adjacent SwapView to open. When the transition is done, a topic “/dojox/mobile/viewChanged” is published.

# Constructor Parameters #

| Parameter | Type | Default | Description |
|:----------|:-----|:--------|:------------|
| selected  | boolean | false   | If true, this view is displayed at startup time. |

# Details #

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages