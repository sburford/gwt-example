package it.ms.gwt_example.client.main.view;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;

import it.ms.gwt_example.client.components.UserBar;
import it.ms.gwt_example.client.main.presenter.MainPresenter.MainDisplay;

public class MainView extends Composite implements MainDisplay {

	private final UserBar userBar;

	public MainView() {

		DockPanel panel = new DockPanel();
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		panel.setSpacing(5);

		userBar = new UserBar();
		panel.add(userBar, DockPanel.NORTH);

		// TODO change here with real UI
		panel.add(new Label("Main page"), DockPanel.CENTER);

		initWidget(panel);
	}

	@Override
	public void setUsername(final String username) {

		userBar.setUsername(username);
	}

	@Override
	public void addLogoutButtonClickHandler(final ClickHandler handler) {

		userBar.addLogoutButtonClickHandler(handler);
	}
}
