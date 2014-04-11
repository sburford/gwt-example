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

    @Key("pages.login.errors.invalidCredentials")
    String loginErrorsInvalidCredentials();

	// Application
	@Key("application.onLeaving.message")
	String applicationOnLeavingMessage();
}
