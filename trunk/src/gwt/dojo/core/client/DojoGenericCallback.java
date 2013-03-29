package gwt.dojo.core.client;

public interface DojoGenericCallback<T, V> {
	V callback(T context, JsArray arguments);
}
