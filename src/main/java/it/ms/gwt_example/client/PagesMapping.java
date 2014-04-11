package it.ms.gwt_example.client;

import it.ms.gwt_example.client.login.LoginView;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public final class PagesMapping {

	public static PagesMapping instance() {

		return InstanceHolder.INSTANCE;
	}

	private static final class InstanceHolder {

		private static final PagesMapping INSTANCE = new PagesMapping();
	}

	private PagesMapping() {

		// prevents control over instantiation
	}

    public Widget pageFor(final PageToken token){

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
                page = new Label("Main page");
                break;
            default:
                throw new IllegalStateException("Invalid PageToken " + token);
        }
        return page;
    }
}
