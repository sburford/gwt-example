package it.ms.gwt_example.shared;

public final class UserDTO extends DTO {

	private String username;

	public UserDTO(final String username) {

		this.username = username;
	}

	protected UserDTO() {

		// for serialization purposes
		this.username = null;
	}

	public String username() {

		return username;
	}
}
