package it.ms.gwt_example.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import it.ms.gwt_example.shared.UserDTO;

@RemoteServiceRelativePath("springGwtServices/sessionManagementService")
public interface SessionManagementService extends RemoteService {

	/**
	 * Create the session for a given {@link it.ms.gwt_example.shared.UserDTO}.
	 * 
	 * @param user
	 *            the {@link it.ms.gwt_example.shared.UserDTO}
	 * @return the session ID
	 */
	String create(UserDTO user) throws IllegalArgumentException;

	/**
	 * Retrieve the {@link it.ms.gwt_example.shared.UserDTO} related to a given sessionID.
	 * 
	 * @param sessionID
	 *            the session ID associated with a {@link it.ms.gwt_example.shared.UserDTO}
	 * @return the {@link it.ms.gwt_example.shared.UserDTO} found or {@code null}
	 */
	UserDTO validate(String sessionID) throws IllegalArgumentException;

	/**
	 * Invalidate the current active session, if present.
	 */
	void invalidateSession();
}
