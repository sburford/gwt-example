package it.ms.gwt_example.client.login.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
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

import it.ms.gwt_example.client.Messages;
import it.ms.gwt_example.client.components.CPasswordTextBox;
import it.ms.gwt_example.client.components.HFlowPanel;
import it.ms.gwt_example.client.components.VFlowPanel;
import it.ms.gwt_example.client.login.LoginResources;
import it.ms.gwt_example.client.login.model.UserCredentials;
import it.ms.gwt_example.client.login.presenter.LoginPresenter.LoginDisplay;

public final class LoginView extends Composite implements LoginDisplay {

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

    private TextBox usernameField;
	private PasswordTextBox passwordField;
	private Button signInButton;

	public LoginView() {

        DockPanel panel = new DockPanel();
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		panel.setSpacing(5);

		Image logo = new Image(resources.logo());
		panel.add(logo.asWidget(), DockPanel.NORTH);

		Panel vertical = createCredentialsPanel();
		panel.add(vertical, DockPanel.CENTER);

		signInButton = new Button(Messages.instance().loginSignInButtonLabel());
		panel.add(signInButton, DockPanel.SOUTH);

		defineComponentsBehaviour();

		initWidget(panel);
	}

	private Panel createCredentialsPanel() {

		FlowPanel vertical = new VFlowPanel();

		FlowPanel usernameRow = new HFlowPanel();
		Label usernameLabel = new Label(Messages.instance().loginUsernameLabel());
		usernameField = new TextBox();
		usernameRow.add(usernameLabel);
		usernameRow.add(usernameField);
		vertical.add(usernameRow);

		FlowPanel passwordRow = new HFlowPanel();
		Label passwordLabel = new Label(Messages.instance().loginPasswordLabel());
		passwordField = new CPasswordTextBox();
		passwordRow.add(passwordLabel);
		passwordRow.add(passwordField);
		vertical.add(passwordRow);

		return vertical;
	}

	@Override
	public void addSignInClickHandler(final ClickHandler handler) {

		signInButton.addClickHandler(handler);
	}

	@Override
	public UserCredentials userCredentials() {

		return new UserCredentials(usernameField.getValue(), passwordField.getValue());
	}

	@Override
	public void displayInvalidCredentialsMessage() {

		Window.alert(Messages.instance().loginErrorsInvalidCredentials());
		passwordField.setValue(null);
	}

	private void defineComponentsBehaviour() {

		ClickerOnEnterKey enterKeyHandler = new ClickerOnEnterKey(signInButton);
		usernameField.addKeyPressHandler(enterKeyHandler);
		passwordField.addKeyPressHandler(enterKeyHandler);
	}
}
