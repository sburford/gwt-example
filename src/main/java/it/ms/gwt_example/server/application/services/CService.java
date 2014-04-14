package it.ms.gwt_example.server.application.services;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
abstract class CService {

	@Inject
	private HttpServletRequest request;

	protected final HttpServletRequest request() {

		return request;
	}
}
