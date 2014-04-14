package it.ms.gwt_example.client.navigation;

import it.ms.gwt_example.client.login.LoginView;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

final class PagesMapping {

	public static PagesMapping instance() {

		return InstanceHolder.INSTANCE;
	}

	private static final class InstanceHolder {

		private static final PagesMapping INSTANCE = new PagesMapping();
	}

	private PagesMapping() {

		// prevents control over instantiation
	}

    public Widget pageFor(final Page token){

        if (token == null){
            throw new IllegalArgumentException("PageToken cannot be null");
        }
        final Widget page;
        switch (token){

            case LOGIN:
                // TODO make it singleton
                page = new LoginView();
                break;
            case MAIN:
                // TODO make it singleton
                page = new Label("Main page");
                break;
            default:
                throw new IllegalStateException("Invalid PageToken " + token);
        }
        return page;
    }
}
