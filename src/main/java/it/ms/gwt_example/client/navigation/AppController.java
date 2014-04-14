package it.ms.gwt_example.client.navigation;

import com.google.common.base.Strings;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ClosingEvent;
import com.google.gwt.user.client.Window.ClosingHandler;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

import it.ms.gwt_example.client.CAsyncCallback;
import it.ms.gwt_example.client.Messages;
import it.ms.gwt_example.client.ServiceFacade;
import it.ms.gwt_example.shared.Constants;
import it.ms.gwt_example.shared.UserDTO;

public final class AppController implements ValueChangeHandler<String> {

	private static final ClosingHandler WINDOW_CLOSING_HANDLER = new ClosingHandler() {

		@Override
		public void onWindowClosing(final ClosingEvent event) {

			event.setMessage(Messages.instance().applicationOnLeavingMessage());
		}
	};

	public static AppController instance() {

		return InstanceHolder.INSTANCE;
	}

	private static class InstanceHolder {

		private static final AppController INSTANCE = new AppController();
	}

	private Panel contentPanel;

	private AppController() {

		// prevents control over instantiation
		startHistoryHandling();
		setUpWindowClosingHandling();
		setUpEventHandling();
	}

	private void startHistoryHandling() {

		Historian.instance().addValueChangeHandler(this);
	}

	private void setUpWindowClosingHandling() {

		Window.addWindowClosingHandler(WINDOW_CLOSING_HANDLER);
	}

	private void setUpEventHandling() {

		// TODO see if useful
	}

	public void startApplication(final Panel contentPanel) {

		this.contentPanel = contentPanel;
        checkActiveSessionPresence();
	}

	private void checkActiveSessionPresence() {

		String sessionID = Cookies.getCookie(Constants.COOKIE_SESSION_ID);
		if (sessionID != null) {
			ServiceFacade.instance().sessionManagement().validate(sessionID, new CAsyncCallback<UserDTO>() {

				@Override
				public void onSuccess(final UserDTO user) {

					if (user != null) {
						// TODO check if you need to display user's info
						Historian.instance().goToPage(Page.MAIN);
					} else {
						Historian.instance().goToPage(Page.LOGIN);
					}
				}
			});
		} else {
			Historian.instance().goToPage(Page.LOGIN);
		}
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {

		String tokenStr = (event.getValue() != null) ? event.getValue().trim().toUpperCase() : null;
		Page token = (!Strings.isNullOrEmpty(tokenStr)) ? Page.valueOf(tokenStr) : Page.LOGIN;
		contentPanel.clear();
		Widget page = PagesMapping.instance().pageFor(token);
		contentPanel.add(page);
	}
}
