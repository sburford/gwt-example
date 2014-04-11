package it.ms.gwt_example.client;

import com.google.gwt.core.client.GWT;

public final class Messages {

	private static final ApplicationMessages instance = GWT.create(ApplicationMessages.class);

	public static ApplicationMessages instance() {

		return instance;
	}

	private Messages() {

		// prevents control over instantiation
	}
}
