package it.ms.gwt_example.client.navigation;

import it.ms.gwt_example.client.Presenter;
import it.ms.gwt_example.client.login.presenter.LoginPresenter;
import it.ms.gwt_example.client.main.MainPresenter;

final class PagesMapping {

	public static PagesMapping instance() {

		return InstanceHolder.INSTANCE;
	}

	private static final class InstanceHolder {

		private static final PagesMapping INSTANCE = new PagesMapping();
	}

	private PagesMapping() {

		// prevents control over instantiation
	}

	public Presenter responsibleFor(final Page token) {

		if (token == null) {
			throw new IllegalArgumentException("PageToken cannot be null");
		}
		final Presenter presenter;
		switch (token) {

			case LOGIN:
				presenter = LoginPresenter.instance();
				break;
			case MAIN:
				presenter = MainPresenter.instance();
				break;
			default:
				throw new IllegalStateException("Invalid PageToken " + token);
		}
		return presenter;
	}
}
