package it.ms.gwt_example.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public final class Gwt_example implements EntryPoint {

	public void onModuleLoad() {

		Label greetings = new Label("Greetings!");
		RootPanel.get().add(greetings);
	}
}
