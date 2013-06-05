package gwt.dojo.core.client.promise;

import gwt.dojo.core.client.JsObject;

/**
 * The public interface to a deferred. All promises in Dojo are instances of
 * this class.
 */
public abstract class Promise extends JsObject {

	public interface ThenCallback {
		void callback(JsObject item);
	}

	public static final String MODULE = "dojo/promise/Promise";

	protected Promise() {
	}

	/**
	 * Add new callbacks to the promise.
	 * 
	 * @param callback
	 *            Callback to be invoked when the promise is resolved. Receives
	 *            the resolution value.
	 */
	public final native void then(ThenCallback callback) /*-{
		var callbackFcn = function(item) {
			callback.@gwt.dojo.core.client.promise.Promise.ThenCallback::callback(Lgwt/dojo/core/client/JsObject;)(item);
		}
		this.then(callbackFcn);
	}-*/;

	/**
	 * Inform the deferred it may cancel its asynchronous operation.
	 * <p>
	 * Inform the deferred it may cancel its asynchronous operation. The
	 * deferred's (optional) canceler is invoked and the deferred will be left
	 * in a rejected state. Can affect other promises that originate with the
	 * same deferred.
	 * 
	 * @param reason
	 *            A message that may be sent to the deferred's canceler,
	 *            explaining why it's being canceled.
	 * @return Returns the rejection reason if the deferred was canceled
	 *         normally.
	 */
	public final native String cancel(String reason) /*-{
		this.cancel(reason);
	}-*/;

	/**
	 * Inform the deferred it may cancel its asynchronous operation.
	 * <p>
	 * Inform the deferred it may cancel its asynchronous operation. The
	 * deferred's (optional) canceler is invoked and the deferred will be left
	 * in a rejected state. Can affect other promises that originate with the
	 * same deferred.
	 * 
	 * @param reason
	 *            A message that may be sent to the deferred's canceler,
	 *            explaining why it's being canceled.
	 * @param strict
	 *            If strict, will throw an error if the deferred has already
	 *            been fulfilled and consequently cannot be canceled.
	 * @return Returns the rejection reason if the deferred was canceled
	 *         normally.
	 */
	public final native void cancel(String reason, boolean strict) /*-{
		this.cancel(reason, strict);
	}-*/;

	/**
	 * Checks whether the promise has been resolved.
	 * 
	 * @return
	 */
	public final boolean isResolved() throws UnsupportedOperationException {
		if (!hasProperty("isResolved")) {
			throw new UnsupportedOperationException("Promise.isResolved()");
		}
		return isResolvedImpl();
	};

	private final native boolean isResolvedImpl() /*-{
		return this.isResolved();
	}-*/;

	/**
	 * Checks whether the promise has been rejected.
	 * 
	 * @return
	 */
	public final boolean isRejected() {
		if (!hasProperty("isRejected")) {
			throw new UnsupportedOperationException("Promise.isRejected()");
		}
		return isResolvedImpl();
	};

	private final native boolean isRejectedImpl() /*-{
		return this.isRejected();
	}-*/;

	/**
	 * Checks whether the promise has been resolved or rejected.
	 * 
	 * @return
	 */
	public final boolean isFulfilled() {
		if (!hasProperty("isFulfilled")) {
			throw new UnsupportedOperationException("Promise.isFulfilled()");
		}
		return this.isFulfilledImpl();
	};

	private final native boolean isFulfilledImpl() /*-{
		return this.isFulfilled();
	}-*/;

	/**
	 * Checks whether the promise has been canceled.
	 * 
	 * @return
	 */
	public final boolean isCanceled() {
		if (!hasProperty("isCanceled")) {
			throw new UnsupportedOperationException("Promise.isCanceled()");
		}
		return this.isCanceledImpl();
	};

	private final native boolean isCanceledImpl() /*-{
		return this.isCanceled();
	}-*/;

	// TODO always

	// TODO otherwise
}
