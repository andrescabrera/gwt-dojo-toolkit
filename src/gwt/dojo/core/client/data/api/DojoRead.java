package gwt.dojo.core.client.data.api;

public interface DojoRead {

	/**
	 * Returns a single attribute value. Returns {@code defaultValue} is and
	 * only {@code item} does not have a value for the given attribute. Returns
	 * {@code null} if and only if the item does not have a value for the given
	 * attribute (which is the same as saying the item does not have the
	 * attribute).
	 * 
	 * @param item
	 *            The item to access values on.
	 * @param attribute
	 *            The attribute to access represented as a string.
	 * @param defaultValue
	 *            Optional default value to use for the {@code getValue} return
	 *            if the attribute does not exist of has no value.
	 * @return A literal, an item, null, or undefined (never an array).
	 */
	Object getValue(Item item, String attribute, Object defaultValue);
}
