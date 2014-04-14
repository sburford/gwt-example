package it.ms.gwt_example.shared;

public final class User extends GWTDto {

	private String username;

	public User(final String username) {

		this.username = username;
	}

	protected User() {

		// for serialization purposes
		this.username = null;
	}

	public String getUsername() {

		return username;
	}
}
