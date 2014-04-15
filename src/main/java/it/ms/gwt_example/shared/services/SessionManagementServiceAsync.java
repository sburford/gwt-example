package it.ms.gwt_example.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import it.ms.gwt_example.shared.UserDTO;

public interface SessionManagementServiceAsync {

	/**
	 * Create the session for a given {@link it.ms.gwt_example.shared.UserDTO}.
	 * 
	 * @param user
	 *            the {@link it.ms.gwt_example.shared.UserDTO}
	 * @return the session ID
	 */
	void create(UserDTO user, AsyncCallback<String> callback);

	/**
	 * Retrieve the {@link it.ms.gwt_example.shared.UserDTO} related to a given sessionID.
	 * 
	 * @param sessionID
	 *            the session ID associated with a {@link it.ms.gwt_example.shared.UserDTO}
	 * @return the {@link it.ms.gwt_example.shared.UserDTO} found or {@code null}
	 */
	void validate(String sessionID, AsyncCallback<UserDTO> callback);

	void invalidateSession(AsyncCallback<Void> callback);
}
