package it.ms.gwt_example.client.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.DockPanel.DockLayoutConstant;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

import it.ms.gwt_example.client.components.HFlowPanel;
import it.ms.gwt_example.client.components.VFlowPanel;

// public final class LoginView extends InheritableComposite {
public final class LoginView extends Composite {

	private static final LoginResources resources = GWT.create(LoginResources.class);

	private DockPanel panel;
	private TextBox username;
	private PasswordTextBox password;

	// @Override
	// protected Widget createContent() {
	//
	// panel = new DockLayoutPanel(Unit.PX);
	// addComponents(panel);
	// return panel;
	// }

	public LoginView() {

		panel = new DockPanel();
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        panel.setSpacing(5);

		Image logo = new Image(resources.logo());
		panel.add(logo.asWidget(), DockPanel.NORTH);

		FlowPanel vertical = new VFlowPanel();

		FlowPanel usernameRow = new HFlowPanel();
		Label usernameLabel = new Label("Username");
		username = new TextBox();
		usernameRow.add(usernameLabel);
		usernameRow.add(username);
		vertical.add(usernameRow);

		FlowPanel passwordRow = new HFlowPanel();
		Label passwordLabel = new Label("Password");
		password = new PasswordTextBox();
		passwordRow.add(passwordLabel);
		passwordRow.add(password);
		vertical.add(passwordRow);
        panel.add(vertical, DockPanel.CENTER);

        Button signInButton = new Button("Sign In");
        panel.add(signInButton, DockPanel.SOUTH);

		initWidget(panel);
	}

	private void addComponents(final DockLayoutPanel content) {

		FlowPanel vertical = new FlowPanel();

		Image logo = new Image(resources.logo());
		vertical.add(logo);

		FlowPanel usernameRow = new HFlowPanel();
		Label usernameLabel = new Label("Username");
		username = new TextBox();
		usernameRow.add(usernameLabel);
		usernameRow.add(username);
		vertical.add(usernameRow);

		FlowPanel passwordRow = new HFlowPanel();
		Label passwordLabel = new Label("Password");
		password = new PasswordTextBox();
		passwordRow.add(passwordLabel);
		passwordRow.add(password);
		vertical.add(passwordRow);

		Button signInButton = new Button("Sign In");
		vertical.add(signInButton);

		content.add(vertical);
	}
}
