package it.ms.gwt_example.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class CAsyncCallback<T> implements AsyncCallback<T> {

	@Override
	public void onFailure(final Throwable caught) {

		// TODO call server to log exception
		Window.alert("Error during RPC - Stack trace: \n" + caught.getMessage());
	}
}
