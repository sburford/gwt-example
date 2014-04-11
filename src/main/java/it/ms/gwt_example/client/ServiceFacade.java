package it.ms.gwt_example.client;

import com.google.gwt.core.client.GWT;

import it.ms.gwt_example.shared.services.LoginService;
import it.ms.gwt_example.shared.services.LoginServiceAsync;

public final class ServiceFacade {

	public static ServiceFacade instance() {

		return InstanceHolder.INSTANCE;
	}

	private static final class InstanceHolder {

		private static final ServiceFacade INSTANCE = new ServiceFacade();
	}

	private static final LoginServiceAsync loginService = GWT.create(LoginService.class);

	private ServiceFacade() {

		// prevents control over instantiation
	}

	public LoginServiceAsync login() {

		return loginService;
	}
}
