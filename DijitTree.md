# Introduction #

The trees we see in User Interfaces help sort out long, hierarchical lists. Dojo makes simple trees easy, and complicated trees possible. In particular, you can:

  * Connect your tree to and Dojo store, with or without a single root item, and with various ways to express parent/child relations.
  * Nest items to an arbitrary depth ... each branch is independently expandable.
  * Apply different icons to different leaf or branch items
  * Setup a global handler for when a user clicks or double clicks a particular nodes.
  * Tree will automatically reflect changes made to the underlying data store (when connected to the data store through the ObjectStoreModel, or legacy TreeStoreModel or ForestStoreModel).
  * Allow nodes to be dragged and dropped through the familiar Dojo DnD API.
  * Drag and drop onto the tree, which updates the data store indirectly.

# Details #

To understand how to use a Tree, you need to be aware of three components that feed each other:

## Tree ##

The Tree widget itself is merely a view of the data. It's in charge of displaying the data and handling user events only.

The Tree is a black-box in the sense that the developer generally won’t be dealing with individual nodes of the Tree. Rather, there are just onClick() etc. notifications, which refer to the item that was clicked. Item is usually an item in a dojo.store that the tree is connected to.

Note also that a Tree has an idea of a currently selected item, such as the currently opened folder in a mail program.

## Model ##

The real power comes in the tree model, which represents the hierarchical data that the tree will display. Tree can interface to any class implementing the model API, but typically interfaces through the ObjectStoreModel, which itself interfaces with the powerful dojo.store API.

It’s important to note that the tree is merely a ‘’‘view’‘’ onto the model. The model is in charge of tasks like connecting to the data source (often on the server), lazy loading, and notifying the tree of changes to the data. It’s also in charge of handle drop operations, when someone drags and drops an item onto the tree.

To put it another way, you cannot “delete data from the tree” or “insert data into the tree” directly, but rather you must update the model.

Note also that each item in your Tree needs a different identifier (the value of the identifier has to be unique). It’s the same concept as a primary key in a database.

## Data Stores ##

Although not required, usually the model interfaces with a dojo.store.

There can be many different types of stores, such as stores that work from XML vs. stores that work from JSON, stores that execute on the client vs. stores that pass through to the server, stores that load data as it’s needed or stores that load all the data on initialization, etc. All the stores, though, have the same API, so they can be connected to with the ObjectStoreModel.

# A Simple Tree Example #