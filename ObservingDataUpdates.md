Dojo also comes with a store wrapper/layer for adding support for notification events of data changes. The query result sets returned from a Observable store will include a observer function than can be used to monitor for changes. The observe function provides indication of the previous and new index values of changed objects to properly update result arrays.

```
import gwt.dojo.core.client.Dojo;
import gwt.dojo.core.client.DojoCallback;
import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;
import gwt.dojo.core.client.store.MemoryStore;
import gwt.dojo.core.client.store.ObservableStore;
import gwt.dojo.core.client.store.api.Store.ForEachCallback;
import gwt.dojo.core.client.store.api.Store.ObserveCallback;
import gwt.dojo.core.client.store.api.Store.ObserverHandle;
import gwt.dojo.core.client.store.api.Store.QueryResults;

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
		modules.push(ObservableStore.MODULE);
		Dojo.require(modules, this);
	}

	@Override
	public void callback(JsArray arguments) {
		JsObject storeOptions = JsObject.create();
		storeOptions.put(MemoryStore.DATA, getEmployees());
		storeOptions.put(MemoryStore.IDPROPERTY, "name");

		MemoryStore employeeStore = MemoryStore.create(storeOptions);

		// create the initial Observable store
		ObservableStore store = ObservableStore.create(employeeStore);

		JsObject query = JsObject.create("department", "sales");
		QueryResults results = store.query(query);

		// do something with the initial result set
		results.forEach(new ForEachCallback() {
			@Override
			public void forEach(JsObject item) {
				Window.alert(item.getString("name"));
			}
		});

		// now listen for any changes
		ObserverHandle observeHandle = results.observe(new ObserveCallback() {
			@Override
			public void observe(JsObject object, int removedFrom,
					int insertedInto) {
				if (removedFrom > -1) {
					// existing object removed
					Window.alert("removeRow: " + removedFrom);
				}
				if (insertedInto > -1) {
					// new or updated object inserted
					Window.alert("insertRow: " + insertedInto);
				}
			}
		});

		// add a new employee
		//
		// this will *not* trigger a observe event, since the object does not
		// match the query constraint (query was for department = 'sales')
		JsObject newEmployee = JsObject.create();
		newEmployee.put("name", "George");
		newEmployee.put("department", "accounting");
		store.add(newEmployee);

		// add a new sales employee
		//
		// this will trigger an addition to the result set (the observe listener
		// will be called)
		JsObject newSalesEmployee = JsObject.create();
		newSalesEmployee.put("name", "Roger");
		newSalesEmployee.put("department", "sales");
		store.add(newSalesEmployee);

		// remove Bill & Mike
		//
		// the second remove will trigger an observe event.
		store.remove("Bill");
		store.remove("Mike");

		// retrieve object with the name "Jim"
		JsObject jim = store.byId("Jim");
		// show the department property
		Window.alert("Jim's department is " + jim.getString("department"));
		// update his department to sales (the observe listener will be called)
		jim.put("department", "sales");
		// and store the change
		store.store(jim);

		// done observing, any further modifications will not trigger our
		// listener
		observeHandle.cancel();
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