package it.ms.gwt_example.server.application.services;

import javax.inject.Named;

import it.ms.gwt_example.shared.services.LoginService;

@Named("loginService")
class LoginServiceImpl extends CService implements LoginService {

	@Override
	public boolean isAllowedAccess(final String username, final String password) {

		if (username == null) {
			throw new IllegalArgumentException("Username cannot be null");
		}
		if (password == null) {
			throw new IllegalArgumentException("Password cannot be null");
		}
		// TODO implement call to LDAP
		if (username.equals("michele")) {
			return true;
		}
		return false;
	}
}
