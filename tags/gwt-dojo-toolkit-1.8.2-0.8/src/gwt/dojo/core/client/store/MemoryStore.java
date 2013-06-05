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

import gwt.dojo.core.client.store.api.Store;

/**
 * This is a basic in-memory object store.
 */
public class MemoryStore extends Store {

	/**
	 * Module reference.
	 */
	public static final String MODULE = "dojo/store/Memory";

	/**
	 * data: Array (default: null).
	 * <p>
	 * The array of all the objects in the memory store.
	 */
	public static final String DATA = "data";

	/**
	 * idProperty: String (default: "id").
	 * <p>
	 * Indicates the property to use as the identity property. The values of
	 * this property should be unique.
	 */
	public static final String IDPROPERTY = "idProperty";

	/**
	 * JSNI constructor.
	 */
	protected MemoryStore() {
	}
}
