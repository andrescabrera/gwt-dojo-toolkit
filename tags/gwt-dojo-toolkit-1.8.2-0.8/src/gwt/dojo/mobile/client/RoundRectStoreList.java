/*
 * Copyright 2012, 2013 ArkaSoft LLC.
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
package gwt.dojo.mobile.client;

/**
 * A dojo/store-enabled version of RoundRectList.
 * <p>
 * {@code RoundRectStoreList} is an enhanced version of {@link RoundRectList}.
 * It can generate {@code ListItem}s according to the given dojo/store store.
 */
public class RoundRectStoreList extends RoundRectList implements IStoreListMixin {

	/**
	 * Module: {@code dojox/mobile/RoundRectStoreList}.
	 */
	public static final String MODULE = "dojox/mobile/RoundRectStoreList";

	/**
	 * JSNI required constructor.
	 */
	protected RoundRectStoreList() {
	}

}
