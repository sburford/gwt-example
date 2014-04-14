package it.ms.gwt_example.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import it.ms.gwt_example.shared.User;

@RemoteServiceRelativePath("springGwtServices/sessionManagementService")
public interface SessionManagementService extends RemoteService {

	/**
	 * Create the session for a given {@link User}.
	 * 
	 * @param user
	 *            the {@link User}
	 * @return the session ID
	 */
	String create(User user) throws IllegalArgumentException;

	/**
	 * Retrieve the {@link User} related to a given sessionID.
	 * 
	 * @param sessionID
	 *            the session ID associated with a {@link User}
	 * @return the {@link User} found or {@code null}
	 */
	User validate(String sessionID) throws IllegalArgumentException;
}
