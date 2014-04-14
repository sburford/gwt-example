package it.ms.gwt_example.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.shared.UmbrellaException;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import it.ms.gwt_example.client.navigation.AppController;

public final class Gwt_example implements EntryPoint {

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

		AppController appController = AppController.instance();

		Panel contentPanel = createContentPanel();
		RootLayoutPanel.get().add(contentPanel);

		appController.startApplication(contentPanel);
	}

	private Panel createContentPanel() {

		VerticalPanel contentPanel = new VerticalPanel();
		contentPanel.setWidth("100%");
		contentPanel.setHeight("100%");
		contentPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		// de-comment this if you want the whole application to be vertically centered
		// vertical.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		return contentPanel;
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
