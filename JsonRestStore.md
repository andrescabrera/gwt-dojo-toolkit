[JsonRestStore](JsonRestStore.md) (dojo/store/JsonRest) provides full read, write, and notification capabilities through standards based HTTP/REST interaction with the server using GET, PUT, POST, and DELETE commands.

To utilize the module, require in the module, create a new instance, pointing it at your RESTful service, and then perform your operations. This is also an example of an asynchronous store. The methods on an asynchronous store return [promises](http://dojotoolkit.org/documentation/tutorials/1.8/promises/). We can use a promise by providing a callback to the returned promise:

```
final JsonRestStore expensesStore = JsonRestStore.create(storeOptions);

// Get an object by identity.
QueryResults results = expensesStore.byId(0).cast();
results.then(new ThenCallback() {
	@Override
	public void callback(JsObject item) {
		Window.alert(item.toJson());
	}
});
```

# Example #

```
import gwt.dojo.core.client.Dojo;
import gwt.dojo.core.client.DojoCallback;
import gwt.dojo.core.client.JsArray;
import gwt.dojo.core.client.JsObject;
import gwt.dojo.core.client.store.JsonRestStore;
import gwt.dojo.core.client.store.MemoryStore;
import gwt.dojo.core.client.store.api.Store;
import gwt.dojo.core.client.store.api.Store.ForEachCallback;
import gwt.dojo.core.client.store.api.Store.QueryOptions;
import gwt.dojo.core.client.store.api.Store.QueryResults;
import gwt.dojo.core.client.store.api.Store.SortInformation;
import gwt.dojo.core.client.store.api.Store.StoreDirectives;
import gwt.dojo.core.client.store.api.Store.ThenCallback;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JsDate;
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
		modules.push(JsonRestStore.MODULE);
		Dojo.require(modules, this);
	}

	@Override
	public void callback(JsArray arguments) {
		JsObject storeOptions = JsObject.create();
		storeOptions.put(JsonRestStore.TARGET, "/expenses/");
		storeOptions.put(MemoryStore.IDPROPERTY, "id");

		final JsonRestStore expensesStore = JsonRestStore.create(storeOptions);

		// Get an object by identity.
		QueryResults results = expensesStore.byId(0).cast();
		results.then(new ThenCallback() {
			@Override
			public void callback(JsObject item) {
				Window.alert(item.toJson());
			}
		});

		// Query for objects with options
		JsObject query = JsObject.create("type", "Meals");

		SortInformation sortInformation0 = Store.createSortInformation();
		sortInformation0.put(SortInformation.ATTRIBUTE, "date");
		sortInformation0.put(SortInformation.DESCENDING, false);

		SortInformation sortInformation1 = Store.createSortInformation();
		sortInformation1.put(SortInformation.ATTRIBUTE, "amount");
		sortInformation1.put(SortInformation.DESCENDING, true);

		QueryOptions queryOptions = Store.createQueryOptions();
		queryOptions.put(QueryOptions.SORT,
				JsArray.create(sortInformation0, sortInformation1));
		queryOptions.put(QueryOptions.START, 0);
		queryOptions.put(QueryOptions.COUNT, 10);

		expensesStore.query(query, queryOptions).forEach(new ForEachCallback() {
			@Override
			public void callback(JsObject item) {
				Window.alert(item.toJson());
			}
		});

		// Store an object identified by identity
		JsObject newExpense = JsObject.create();
		newExpense.put("date", JsDate.create());
		newExpense.put("type", "Meal");
		newExpense.put("amount", 25.35D);

		StoreDirectives storeDirectives = Store.createStoreDirectives();
		storeDirectives.put(StoreDirectives.ID, 100);

		expensesStore.store(newExpense, storeDirectives);

		// Remove an object by ID
		expensesStore.remove(3);
	}
}
```

```
2010-03-28, Travel,     1286.90,    Ticket #145-XX-71903-09
2010-03-28, Meals,      34.12,      Took client out
2010-03-31, Meals,      27.00,      
2010-04-01, Meals,      12.55,      
2010-04-02, Meals,      18.86,      
2010-04-02, Parking,    30.00,      Cambridge Center parking
2010-04-03, Meals,      20.72,      
2010-04-06, Travel,     529.00,     Marriott reservation #DF-9982-BRN
```

```
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.HashMap;
import org.apache.pivot.collections.List;
import org.apache.pivot.json.JSONSerializer;
import org.apache.pivot.serialization.CSVSerializer;
import org.apache.pivot.serialization.SerializationException;
import org.apache.pivot.serialization.Serializer;
import org.apache.pivot.web.Query;
import org.apache.pivot.web.Query.Method;
import org.apache.pivot.web.QueryException;
import org.apache.pivot.web.server.QueryServlet;

public class ExpenseServlet extends QueryServlet {
	private static final long serialVersionUID = -4673679507554084396L;

	private List<Expense> expenses = null;
	private HashMap<Integer, Expense> expenseMap = new HashMap<Integer, Expense>();

	private static int nextID = 0;

	@Override
	@SuppressWarnings("unchecked")
	public void init() throws ServletException {
		CSVSerializer expenseSerializer = new CSVSerializer(Expense.class);
		expenseSerializer.setKeys("date", "type", "amount", "description");

		// Load the initial expense data
		InputStream inputStream = ExpenseServlet.class
				.getResourceAsStream("/expenses.csv");

		try {
			expenses = (List<Expense>) expenseSerializer
					.readObject(inputStream);
		} catch (IOException exception) {
			throw new ServletException(exception);
		} catch (SerializationException exception) {
			throw new ServletException(exception);
		}

		// Index the initial expenses
		for (Expense expense : expenses) {
			int id = nextID++;
			expense.setID(id);
			expenseMap.put(id, expense);
		}
	}

	@Override
	protected Object doGet(Path path) throws QueryException {
		Object value;

		// TODO: handle sort, ranges and filters according to:
		// http://livedocs.dojotoolkit.org/quickstart/rest

		if (path.getLength() == 0 || path.get(0).length() == 0) {
			
			synchronized(this) {
				value = new ArrayList<Expense>(expenses);
			}
			
		} else {

			// Get the ID of the expense to retrieve from the path
			int id = Integer.parseInt(path.get(0));

			// Get the expense data from the map
			synchronized (this) {
				value = expenseMap.get(id);
			}

			if (value == null) {
				throw new QueryException(Query.Status.NOT_FOUND);
			}
		}

		return value;
	}

	@Override
	protected URL doPost(Path path, Object value) throws QueryException {
		if (value == null) {
			throw new QueryException(Query.Status.BAD_REQUEST);
		}

		Expense expense = (Expense) value;

		// Add the expense to the list/map
		int id;
		synchronized (this) {
			id = nextID++;
			expense.setID(id);
			expenses.add(expense);
			expenseMap.put(id, expense);
		}

		// Return the location of the newly-created resource
		URL location = getLocation();
		try {
			location = new URL(location, Integer.toString(id));
		} catch (MalformedURLException exception) {
			throw new QueryException(Query.Status.INTERNAL_SERVER_ERROR);
		}

		return location;
	}

	@Override
	protected boolean doPut(Path path, Object value) throws QueryException {
		if (path.getLength() == 0 || value == null) {
			throw new QueryException(Query.Status.BAD_REQUEST);
		}

		// Get the ID of the expense to retrieve from the path
		int id = Integer.parseInt(path.get(0));

		// Create the new expense and bind the data to it
		Expense expense = (Expense) value;
		expense.setID(id);

		// Update the list/map
		Expense previousExpense;
		synchronized (this) {
			previousExpense = expenseMap.put(id, expense);
			expenses.remove(previousExpense);
			expenses.add(expense);
		}

		return (previousExpense == null);
	}

	@Override
	protected void doDelete(Path path) throws QueryException {
		if (path.getLength() == 0) {
			throw new QueryException(Query.Status.BAD_REQUEST);
		}

		// Get the ID of the expense to retrieve from the path
		int id = Integer.parseInt(path.get(0));

		// Update the list/map
		Expense expense;
		synchronized (this) {
			expense = expenseMap.remove(id);
			expenses.remove(expense);
		}

		if (expense == null) {
			throw new QueryException(Query.Status.NOT_FOUND);
		}
	}

	@Override
	protected Serializer<?> createSerializer(Method method, Path path)
			throws QueryException {
		return new JSONSerializer(Expense.class);
	}

}
```