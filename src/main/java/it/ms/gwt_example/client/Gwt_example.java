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
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ClosingEvent;
import com.google.gwt.user.client.Window.ClosingHandler;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import it.ms.gwt_example.client.login.LoginView;

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

		content = new VerticalPanel();
		content.setWidth("100%");
		content.setHeight("100%");
		content.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		// de-comment this if you want the whole application to be vertically centered
		// vertical.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		content.add(new LoginView());

		RootLayoutPanel.get().add(content);
		startHistoryHandling();
		setUpEventHandling();
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

		History.addValueChangeHandler(this);
		History.fireCurrentHistoryState();

		Window.addWindowClosingHandler(new ClosingHandler() {

			public void onWindowClosing(final ClosingEvent event) {

				event.setMessage(Messages.instance().applicationOnLeavingMessage());
			}
		});
	}

	private void setUpEventHandling() {

	}

	@Override
	public void onValueChange(final ValueChangeEvent<String> event) {

		String tokenStr = (event.getValue() != null) ? event.getValue().trim().toUpperCase() : null;
		PageToken token = (!Strings.isNullOrEmpty(tokenStr)) ? PageToken.valueOf(tokenStr) : PageToken.LOGIN;
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
