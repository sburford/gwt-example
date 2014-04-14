package it.ms.gwt_example.client.login.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.IsWidget;

import it.ms.gwt_example.client.CAsyncCallback;
import it.ms.gwt_example.client.Presenter;
import it.ms.gwt_example.client.ServiceFacade;
import it.ms.gwt_example.client.login.LoginView;
import it.ms.gwt_example.client.navigation.Historian;
import it.ms.gwt_example.client.navigation.Page;
import it.ms.gwt_example.shared.Constants;
import it.ms.gwt_example.shared.UserDTO;

public class LoginPresenter implements Presenter {

	private final LoginDisplay view;

	public static LoginPresenter instance() {

		return InstanceHolder.INSTANCE;
	}

	private static class InstanceHolder {

		private static final LoginPresenter INSTANCE = new LoginPresenter(new LoginView());
	}

	private LoginPresenter(final LoginDisplay view) {

		// prevents control over instantiation
		this.view = view;
        defineComponentsBehaviour(view);
	}

    private void defineComponentsBehaviour(final LoginDisplay view) {

        view.addSignInClickHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {

                final String username = view.username();
                String password = view.password();
                ServiceFacade.instance().login().isAllowedAccess(username, password, new CAsyncCallback<Boolean>() {

                    @Override
                    public void onSuccess(final Boolean allowed) {

                        if (allowed == null) {
                            throw new IllegalStateException("Login RPC call should never return null");
                        }
                        if (allowed) {
                            UserDTO user = new UserDTO(username);
                            ServiceFacade.instance().sessionManagement().create(user, new CAsyncCallback<String>() {

                                @Override
                                public void onSuccess(final String sessionID) {

                                    Cookies.setCookie(Constants.COOKIE_SESSION_ID, sessionID);
                                    Historian.instance().goToPage(Page.MAIN);
                                }
                            });
                        } else {
                            view.displayInvalidCredentialsMessage();
                        }
                    }
                });

            }
        });
    }

    public static interface LoginDisplay extends IsWidget {

        void addSignInClickHandler(ClickHandler handler);

        String username();

        String password();

        void displayInvalidCredentialsMessage();
    }

	@Override
	public IsWidget view() {

		return view;
	}
}
