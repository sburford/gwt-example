package it.ms.gwt_example.client;

import com.google.gwt.i18n.client.Messages;

public interface ApplicationMessages extends Messages {

	// Login
	@Key("pages.login.username.label")
	String loginUsernameLabel();

	@Key("pages.login.password.label")
	String loginPasswordLabel();

	@Key("pages.login.signInButton.label")
	String loginSignInButtonLabel();

	// Application
	@Key("application.onLeaving.message")
	String applicationOnLeavingMessage();
}
