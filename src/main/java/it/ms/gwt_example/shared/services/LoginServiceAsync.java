package it.ms.gwt_example.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {

	void isAllowedAccess(String username, String password, AsyncCallback<Boolean> callback);
}
