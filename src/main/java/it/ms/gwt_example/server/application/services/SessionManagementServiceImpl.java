package it.ms.gwt_example.server.application.services;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.google.common.base.Strings;

import it.ms.gwt_example.server.domain.UUIDSupplier;
import it.ms.gwt_example.shared.Constants.Session;
import it.ms.gwt_example.shared.UserDTO;
import it.ms.gwt_example.shared.services.SessionManagementService;

@Named("sessionManagementService")
final class SessionManagementServiceImpl extends CService implements SessionManagementService {

	@Inject
	private UUIDSupplier uuidSupplier;

	@Override
	public String create(final UserDTO user) {

		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		HttpSession session = request().getSession(true);
		session.setMaxInactiveInterval(Session.MAX_INACTIVE_INTERVAL_MINUTES);
		String sessionID = uuidSupplier.get().toString();
		session.setAttribute(sessionID, user);
		return sessionID;
	}

	@Override
	public UserDTO validate(final String sessionID) {

		if (Strings.isNullOrEmpty(sessionID)) {
			throw new IllegalArgumentException("SessionID cannot be null or empty");
		}
		HttpSession session = request().getSession(false);
		if (session == null) {
			return null;
		}
		return (UserDTO) session.getAttribute(sessionID);
	}

	@Override
	public void invalidateSession() {

		HttpSession session = request().getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}
}
