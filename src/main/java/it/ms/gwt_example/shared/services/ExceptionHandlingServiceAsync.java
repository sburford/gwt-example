package it.ms.gwt_example.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ExceptionHandlingServiceAsync {

	void handleClientThrowable(Throwable throwable, AsyncCallback<Void> callback);
}
