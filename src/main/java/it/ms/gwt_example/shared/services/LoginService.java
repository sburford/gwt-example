package it.ms.gwt_example.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("springGwtServices/loginService")
public interface LoginService extends RemoteService {

	boolean isAllowedAccess(String username, String password) throws IllegalArgumentException;
}
