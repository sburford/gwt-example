package it.ms.gwt_example.client.login.model;

public final class UserCredentials {

	private final String username;
	private final String password;

	public UserCredentials(final String username, final String password) {

		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
