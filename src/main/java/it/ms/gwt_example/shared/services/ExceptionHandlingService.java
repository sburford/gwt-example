package it.ms.gwt_example.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("springGwtServices/exceptionHandlingService")
public interface ExceptionHandlingService extends RemoteService {

	void handleClientThrowable(Throwable throwable) throws IllegalArgumentException;
}
