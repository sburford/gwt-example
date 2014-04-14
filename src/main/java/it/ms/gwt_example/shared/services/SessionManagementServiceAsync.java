package it.ms.gwt_example.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import it.ms.gwt_example.shared.User;

public interface SessionManagementServiceAsync {

	/**
	 * Create the session for a given {@link it.ms.gwt_example.shared.User}.
	 * 
	 * @param user
	 *            the {@link it.ms.gwt_example.shared.User}
	 * @return the session ID
	 */
	void create(User user, AsyncCallback<String> async);

	/**
	 * Retrieve the {@link it.ms.gwt_example.shared.User} related to a given sessionID.
	 * 
	 * @param sessionID
	 *            the session ID associated with a {@link it.ms.gwt_example.shared.User}
	 * @return the {@link it.ms.gwt_example.shared.User} found or {@code null}
	 */
	void validate(String sessionID, AsyncCallback<User> async);
}
