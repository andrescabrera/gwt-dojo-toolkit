# Introduction #

The Dojo Tree component is a powerful tool for visual presentation of hierarchical data. In this tutorial we will look at how to connect the tree to a store for quick and efficient data drill-down into nested data.

The first example uses a static tree with the data sourced from a single JSON file. This can be used to provide navigation through data. The second example expands on this design to add powerful features like drag and drop, and dynamic  tree manipulation. The final example shows how data can be be lazy-loaded.

# Tree with a Static Store #

A static store is well-suited for a tree with limited size. In this example, clicking on the tree nodes displays a related image.

The first step is to create the data. We will use the Memory store, which means that the store data is JSON-encoded, and can contain supporting information. In this case, the name is used to label each node of the tree. This tree has four items, and each has a name and an id.

```
{
    "name": "US Government",
    "id": "root",
    "children": [
        {
            "name": "Congress",
            "id": "congress"
        },
        {
            "name": "Executive",
            "id": "exec"
        },
        {
            "name": "Judicial",
            "id": "judicial"
        }
    ]
}
```

A tree is served data from an object implementing the [TreeModel](https://code.google.com/p/gwt-dojo-toolkit/source/browse/trunk/src/gwt/dojo/dijit/client/tree/TreeModel.java) abstract class (digit/tree/model interface). Usually, that object is an instance of [ObjectStoreModel](https://code.google.com/p/gwt-dojo-toolkit/source/browse/trunk/src/gwt/dojo/dijit/client/tree/ObjectStoreModel.java) (digit/tree/ObjectStoreModel), and it is fed by a [Store](https://code.google.com/p/gwt-dojo-toolkit/source/browse/trunk/src/gwt/dojo/core/client/store/api/Store.java) (dojo/store).

The code below creates a [MemoryStore](https://code.google.com/p/gwt-dojo-toolkit/source/browse/trunk/src/gwt/dojo/core/client/store/MemoryStore.java) (dojo/store/Memory store).

```
import gwt.dojo.core.client.Dojo;
import gwt.dojo.core.client.DojoCallback;
import gwt.dojo.core.client.DojoReady;
import gwt.dojo.core.client.DojoText;
import gwt.dojo.core.client.JSON;
import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;
import gwt.dojo.core.client.data.api.Item;
import gwt.dojo.core.client.store.MemoryStore;
import gwt.dojo.core.client.store.api.Store.GetChildrenCallback;
import gwt.dojo.dijit.client.Tree;
import gwt.dojo.dijit.client.Tree.OnClickCallback;
import gwt.dojo.dijit.client.Tree.OnLoadCallback;
import gwt.dojo.dijit.client.tree.ObjectStoreModel;
import gwt.dojo.dijit.client.tree.TreeModel.MayHaveChildrenCallback;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ImageElement;
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

		modules.push(DojoText.MODULE("./data/static.json"));
		modules.push(JSON.MODULE);
		modules.push(MemoryStore.MODULE);
		modules.push(ObjectStoreModel.MODULE);
		modules.push(Tree.MODULE);
		modules.push(DojoReady.MODULE);

		Dojo.require(modules, this);
	}

	@Override
	public void callback(JsArray arguments) {
		JsObject staticData = JSON.parse(arguments.getString(0), false);

		// set up the store to get the tree data
		JsObject storeOptions = JsObject.create();
		storeOptions.put(MemoryStore.DATA, JsArray.create(staticData));

		MemoryStore governmentStore = MemoryStore.create(storeOptions);
		governmentStore.setGetChildrenCallback(new GetChildrenCallback() {
			@Override
			public JsArray getChildren(JsObject object, JsObject queryOptions) {
				return (object != null) ? object.getJsArray("children") : JsArray.create();
			}
		});

		// set up the model, assigning governmentStore, and assigning method to
		// identify leaf nodes of tree
		JsObject modelOptions = JsObject.create();
		modelOptions.put(ObjectStoreModel.STORE, governmentStore);
		modelOptions.put(ObjectStoreModel.QUERY, JsObject.create("id", "root"));

		ObjectStoreModel governmentModel = ObjectStoreModel.create(modelOptions);
		governmentModel.setMayHaveChildrenCallback(new MayHaveChildrenCallback() {
			@Override
			public boolean mayHaveChildren(Item item) {
				return item.hasProperty("children");
			}
		});

		// set up the tree, assigning governmentModel
		JsObject treeOptions = JsObject.create();
		treeOptions.put(Tree.MODEL, governmentModel);

		Tree governmentTree = Tree.create(treeOptions);		
		governmentTree.placeAt("divTree");
		governmentTree.startup();
		
		final ImageElement img = Document.get().getElementById("image").cast();
		governmentTree.setOnLoad(new OnLoadCallback() {
			@Override
			public void onLoad() {
				img.setSrc("images/root.jpg");
			}
		});
		governmentTree.setOnClick(new OnClickCallback() {
			@Override
			public void onClick(JsObject item, JsObject treeNode, NativeEvent event) {
				img.setSrc("images/" + item.getString("id") + ".jpg");
			}
		});
	}
}
```

> Note how we had to implemented two method callbacks ourselves:

  1. GetChildrenCallback - to return a list of children for a given item
  1. MayHaveChildrenCallback - in its simplest form this always returns true, but it can return false if you can tell just by looking at an item that it couldn't possibly have any children.

[View Demo](http://ggeorg.arkasoft.com/wiki-tree-store-1/)