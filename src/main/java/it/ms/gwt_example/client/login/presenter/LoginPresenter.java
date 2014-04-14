package it.ms.gwt_example.client.login.presenter;

import com.google.gwt.user.client.ui.IsWidget;

import it.ms.gwt_example.client.Presenter;
import it.ms.gwt_example.client.login.LoginView;

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
	}

	public static interface LoginDisplay extends IsWidget {

	}

	@Override
	public IsWidget view() {

		return view;
	}
}
