package it.ms.gwt_example.server.application.services;

import javax.inject.Named;

import it.ms.gwt_example.shared.services.ExceptionHandlingService;

@Named("exceptionHandlingService")
class ExceptionHandlingServiceImpl extends CService implements ExceptionHandlingService {

	@Override
	public void handleClientThrowable(final Throwable throwable) {

		if (throwable == null) {
			throw new IllegalArgumentException("Throwable cannot be null");
		}
		// TODO properly log the throwable
		throwable.printStackTrace(System.out);
	}
}
