/*
 * Copyright 2012 ArkaSoft LLC.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package gwt.dojo.core.client.store;

import gwt.dojo.core.client.JsObject;
import gwt.dojo.core.client.store.api.Store;

/**
 * The observable {@link Store} wrapper takes a store and stes an observable
 * method on results that can be used to monitor results for changes.
 * <p>
 * TODO Example:
 */
public class ObservableStore extends Store {

	public static final String MODULE = "dojo/store/Observable";

	protected ObservableStore() {}
	
	public static final ObservableStore create(Store store) {
		ObservableStore observableStore = JsObject.ref(ObservableStore.MODULE);
		return observableStore._create(store);
	}
	
	private final native ObservableStore _create(Store store) /*-{
		return this(store);
	}-*/;
	
}