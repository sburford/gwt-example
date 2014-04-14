package it.ms.gwt_example.client;

public final class IgnoringAsyncCallback<T> extends CAsyncCallback<T> {

	@Override
	public void onSuccess(final T result) {

		// nothing meaningful here
	}
}
