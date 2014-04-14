package it.ms.gwt_example.client;

import com.google.common.base.Strings;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.UmbrellaException;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ClosingEvent;
import com.google.gwt.user.client.Window.ClosingHandler;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import it.ms.gwt_example.client.history.Historian;
import it.ms.gwt_example.shared.Constants;
import it.ms.gwt_example.shared.User;

public final class Gwt_example implements EntryPoint, ValueChangeHandler<String> {

	private VerticalPanel content;

	public void onModuleLoad() {

		setUpUncaughtExceptionHandling();
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {

				afterModuleLoaded();
			}
		});
	}

	private void afterModuleLoaded() {

		startHistoryHandling();
		setUpEventHandling();

		content = new VerticalPanel();
		content.setWidth("100%");
		content.setHeight("100%");
		content.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		// de-comment this if you want the whole application to be vertically centered
		// vertical.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		RootLayoutPanel.get().add(content);

		checkActiveSessionPresence();

		// History.newItem(PageToken.LOGIN.toString());
		// TODO check
		// content.add(new LoginView());
	}

	private void setUpUncaughtExceptionHandling() {

		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void onUncaughtException(final Throwable throwable) {

				Throwable unwrapped = unwrap(throwable);
				// TODO send the exception to the back-end for logging
			}
		});
	}

	private void startHistoryHandling() {

		Historian.instance().addValueChangeHandler(this);

		Window.addWindowClosingHandler(new ClosingHandler() {

			public void onWindowClosing(final ClosingEvent event) {

				event.setMessage(Messages.instance().applicationOnLeavingMessage());
			}
		});
	}

	private void checkActiveSessionPresence() {

		String sessionID = Cookies.getCookie(Constants.COOKIE_SESSION_ID);
		if (sessionID != null) {
			ServiceFacade.instance().sessionManagement().validate(sessionID, new CAsyncCallback<User>() {

				@Override
				public void onSuccess(final User user) {

					if (user != null) {
						// TODO check if you need to display user's info
						Historian.instance().goToPage(Page.MAIN);
						return;
					} else {
						Historian.instance().goToPage(Page.LOGIN);
					}
				}
			});
		} else {
			Historian.instance().goToPage(Page.LOGIN);
		}
	}

	private void setUpEventHandling() {

	}

	@Override
	public void onValueChange(final ValueChangeEvent<String> event) {

		String tokenStr = (event.getValue() != null) ? event.getValue().trim().toUpperCase() : null;
		Page token = (!Strings.isNullOrEmpty(tokenStr)) ? Page.valueOf(tokenStr) : Page.LOGIN;
		content.clear();
		Widget page = PagesMapping.instance().pageFor(token);
		content.add(page);
	}

	private Throwable unwrap(final Throwable throwable) {

		if (throwable instanceof UmbrellaException) {
			UmbrellaException ue = (UmbrellaException) throwable;
			if (ue.getCauses().size() == 1) {
				return unwrap(ue.getCauses().iterator().next());
			}
		}
		return throwable;
	}
}
