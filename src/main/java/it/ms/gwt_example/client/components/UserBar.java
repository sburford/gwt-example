package it.ms.gwt_example.client.components;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import it.ms.gwt_example.client.Messages;

public class UserBar extends Composite {

	private TextBox usernameField;
	private Button logoutButton;

	public UserBar() {

		DockPanel panel = new DockPanel();
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		panel.setSpacing(5);

		Panel username = createUsername();
		panel.add(username, DockPanel.WEST);

		logoutButton = new Button(Messages.instance().logoutButtonLabel());
		panel.add(logoutButton, DockPanel.EAST);

		initWidget(panel);
	}

	private Panel createUsername() {

		FlowPanel username = new HFlowPanel();
		Label usernameLabel = new Label(Messages.instance().loginUsernameLabel());
		usernameField = new TextBox();
        usernameField.setReadOnly(true);
		username.add(usernameLabel);
		username.add(usernameField);
		return username;
	}

	public void setUsername(final String username) {

		usernameField.setValue(username);
	}

	public void addLogoutButtonClickHandler(final ClickHandler handler) {

		logoutButton.addClickHandler(handler);
	}
}
