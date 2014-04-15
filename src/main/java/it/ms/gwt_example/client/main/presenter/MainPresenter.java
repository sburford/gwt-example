package it.ms.gwt_example.client.main.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.IsWidget;

import it.ms.gwt_example.client.CAsyncCallback;
import it.ms.gwt_example.client.Presenter;
import it.ms.gwt_example.client.ServiceFacade;
import it.ms.gwt_example.client.main.view.MainView;
import it.ms.gwt_example.client.navigation.Historian;
import it.ms.gwt_example.client.navigation.Page;
import it.ms.gwt_example.shared.Constants;

// TODO modify in the future as required
public final class MainPresenter implements Presenter {

	private static final ClickHandler LOGOUT_CLICK_HANDLER = new ClickHandler() {

		@Override
		public void onClick(final ClickEvent clickEvent) {

			ServiceFacade.instance().sessionManagement().invalidateSession(new CAsyncCallback<Void>() {

				@Override
				public void onSuccess(final Void result) {

					Historian.instance().goToPage(Page.LOGIN);
				}
			});
		}
	};

	public static MainPresenter instance() {

		return InstanceHolder.INSTANCE;
	}

	private static class InstanceHolder {
		// TODO add the real view here
		private static final MainPresenter INSTANCE = new MainPresenter();
	}

	private MainPresenter() {

		// TODO add the real view here
		// prevents control over instantiation
	}

	@Override
	public IsWidget view() {

		MainDisplay view = new MainView();
		view.addLogoutButtonClickHandler(LOGOUT_CLICK_HANDLER);
		String username = Cookies.getCookie(Constants.Cookies.USERNAME);
		view.setUsername(username);
		return view;
	}

	public static interface MainDisplay extends IsWidget {

		void setUsername(String username);

		void addLogoutButtonClickHandler(ClickHandler handler);
	}
}
