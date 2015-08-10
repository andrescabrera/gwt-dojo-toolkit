# Introduction #

Separation of concerns is a fundamental aspect of good programming. Keeping presentation distinct from the data model is a key separation to employ. The Dojo object store architecture establishes a consistent interface for data interaction inspired by the HTML5 object store API.

The Dojo Object Store interface allows you to develop and use well-encapulsated components that can be easily connected to various data providers. Dojo Object Store is an API, and has multiple implementations called stores. Stores include a simple in-memory store, a JSON/REST store, legacy dojo.data stores, and store wrappers that provide additional functionality.

# Getting Started #

The easiest store to get started is the [MemoryStore](https://code.google.com/p/gwt-dojo-toolkit/source/browse/trunk/src/gwt/dojo/core/client/store/MemoryStore.java) (dojo/store/Memory). We can simply provide an array of objects to the constructor, and we can start interacting with it. Once the store is created, we can query it with the `query` method. An easy way to query is to provide an object with name/value pairs that indicate the required values of matched objects. The `query` method always returns an object or array with a `forEach` method (as well as `map` and `filter`):

```
import gwt.dojo.core.client.Dojo;
import gwt.dojo.core.client.DojoCallback;
import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;
import gwt.dojo.core.client.store.MemoryStore;
import gwt.dojo.core.client.store.api.Store.ForEachCallback;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwt_dojo_demo implements EntryPoint, DojoCallback {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		JsArray modules = JsArray.create();
		modules.push(MemoryStore.MODULE);
		Dojo.require(modules, this);
	}

	@Override
	public void callback(JsArray arguments) {
		JsObject storeOptions = JsObject.create();
		storeOptions.put(MemoryStore.DATA, getEmployees());
		storeOptions.put(MemoryStore.IDPROPERTY, "name");

		MemoryStore employeeStore = MemoryStore.create(storeOptions);

		JsObject query = JsObject.create("department", "sales");
		employeeStore.query(query).forEach(new ForEachCallback() {
			@Override
			public void forEach(JsObject item) {
				Window.alert(item.getString("name"));
			}
		});
	}

	// It's just JavaScript
	private native JsArray getEmployees() /*-{
		return [
        	    {name:"Jim", department:"accounting"},
        	    {name:"Bill", department:"engineering"},
        	    {name:"Mike", department:"sales"},
        	    {name:"John", department:"sales"}
        	];
	}-*/;
}
```

This will call an alert with the name of employee in the sales department.

We could also go on to create new objects in the store, and delete objects:

```
// add a new employee
JsObject newEmployee = JsObject.create();
newEmployee.put("name", "George");
newEmployee.put("department", "accounting");
employeeStore.add(newEmployee);

// remove Bill
employeeStore.remove("Bill");
```

We can retrieve objects and update them. Objects in the store are simple plain JavaScript objects, so we can directly access and modify the properties (when you modify properties, make sure you do a store() to save the changes):

```
// retrieve object with the name "Jim"
JsObject jim = employeeStore.byId("Jim");
// show the department property
Window.alert("Jim's department is " + jim.getString("department"));
// update his department
jim.put("department", "engineering");
// and store the change
employeeStore.store(jim);
```

Going back to querying, we can add additional parameters to a query. These additional parameters allow us to limit the query to a specific number of objects, or to sort the objects, using the second argument to the query method. This second argument can be an object with `start` and `count` properties that define the limit on the number f objects returned. Limiting the result set can be critical for large-scale data sets that are used by paging-capable widgets (like the grid), where new pages of data are requested on demand. The second argument can also include a sort property, to specify the property and direction to sort on in the query:

```
JsObject query = JsObject.create("department", "sales");

SortInformation sortInformation0 = SortInformation.create();
sortInformation0.put(SortInformation.ATTRIBUTE, "department");
sortInformation0.put(SortInformation.DESCENDING, false);

QueryOptions queryOptions = QueryOptions.create();
queryOptions.put(QueryOptions.SORT, JsArray.create(sortInformation0));
queryOptions.put(QueryOptions.START, 0);
queryOptions.put(QueryOptions.COUNT, 10);

employeeStore.query(query, queryOptions)
	.map(new MapCallback() {
		@Override
		public JsObject map(JsObject item) {
			return JsObject.create("name", item.getString("name"));
		}
	}).forEach(new ForEachCallback() {
		@Override
		public void forEach(JsObject item) {
			Window.alert(item.toJson());
		}
	});
```

The Memory store is a synchronous store, which means it directly returns the results of an action (`byId` returns the object).