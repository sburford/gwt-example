package it.ms.gwt_example.server.application.services;

import javax.inject.Named;

import it.ms.gwt_example.shared.services.ExceptionHandlingService;

@Named("exceptionHandlingService")
class ExceptionHandlingServiceImpl extends CService implements ExceptionHandlingService {

	@Override
	public void handleClientThrowable(final Throwable throwable) {

		// TODO properly log the throwable
		throwable.printStackTrace(System.out);
	}
}
