package it.ms.gwt_example.client;

import it.ms.gwt_example.client.login.LoginView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public final class Gwt_example implements EntryPoint {

	public void onModuleLoad() {

        VerticalPanel vertical = new VerticalPanel();
        vertical.setWidth("100%");
        vertical.setHeight("100%");
        vertical.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        // TODO de-comment this if you want the whole application to be vertically centered
//        vertical.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

        vertical.add(new LoginView());

        RootLayoutPanel.get().add(vertical);
        startHistoryHandling();
        setUpEventHandling();
	}

    private void startHistoryHandling() {

    }

    private void setUpEventHandling() {

    }
}
