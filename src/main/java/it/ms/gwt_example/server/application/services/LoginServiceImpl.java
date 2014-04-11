package it.ms.gwt_example.server.application.services;

import org.springframework.stereotype.Service;

import it.ms.gwt_example.shared.services.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Override
    public boolean isAllowedAccess(final String username, final String password) {

        // TODO implement call to LDAP
        if (username.equals("michele")){
            return true;
        }
        return false;
    }
}
