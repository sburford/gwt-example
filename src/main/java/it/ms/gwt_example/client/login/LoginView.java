package it.ms.gwt_example.client.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

import it.ms.gwt_example.client.PageToken;
import it.ms.gwt_example.client.components.CPasswordTextBox;
import it.ms.gwt_example.client.components.HFlowPanel;
import it.ms.gwt_example.client.components.VFlowPanel;

public final class LoginView extends Composite {

	private static final LoginResources resources = GWT.create(LoginResources.class);

	private static final class ClickerOnEnterKey implements KeyPressHandler {

		private final Button button;

		private ClickerOnEnterKey(final Button button) {

			this.button = button;
		}

		@Override
		public void onKeyPress(final KeyPressEvent event) {

			if (event.getCharCode() == KeyCodes.KEY_ENTER) {
				button.click();
			}
		}
	}

	private DockPanel panel;
	private TextBox usernameField;
	private PasswordTextBox passwordField;
	private Button signInButton;

	public LoginView() {

		panel = new DockPanel();
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		panel.setSpacing(5);

		Image logo = new Image(resources.logo());
		panel.add(logo.asWidget(), DockPanel.NORTH);

		Panel vertical = createCredentialsPanel();
		panel.add(vertical, DockPanel.CENTER);

		signInButton = new Button("Sign In");
        panel.add(signInButton, DockPanel.SOUTH);

        defineComponentsBehaviour();

		initWidget(panel);
	}

    private Panel createCredentialsPanel() {

		FlowPanel vertical = new VFlowPanel();

		FlowPanel usernameRow = new HFlowPanel();
		Label usernameLabel = new Label("Username");
		usernameField = new TextBox();
		usernameRow.add(usernameLabel);
		usernameRow.add(usernameField);
		vertical.add(usernameRow);

		FlowPanel passwordRow = new HFlowPanel();
		Label passwordLabel = new Label("Password");
		passwordField = new CPasswordTextBox();
		passwordRow.add(passwordLabel);
		passwordRow.add(passwordField);
		vertical.add(passwordRow);

		return vertical;
	}

    private void defineComponentsBehaviour() {

        ClickerOnEnterKey enterKeyHandler = new ClickerOnEnterKey(signInButton);
        usernameField.addKeyPressHandler(enterKeyHandler);
        passwordField.addKeyPressHandler(enterKeyHandler);

        signInButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {

                String username = usernameField.getValue();
                String password = passwordField.getValue();
                Window.alert("Username: " + username + " - Password:" + password);
                History.newItem(PageToken.MAIN.toString());
            }
        });
    }
}
