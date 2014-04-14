package it.ms.gwt_example.client.navigation;

import com.google.common.base.Strings;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

public final class Historian {

	public static Historian instance() {

		return InstanceHolder.INSTANCE;
	}

	private static final class InstanceHolder {

		private static final Historian INSTANCE = new Historian();
	}

	private Historian() {

		// prevents control over instantiation
	}

	public void addValueChangeHandler(final ValueChangeHandler<String> handler) {

		History.addValueChangeHandler(handler);
	}

	public void goToPage(final Page page) {

		String token = History.getToken();
		Page currentPage = (!Strings.isNullOrEmpty(token)) ? Page.valueOf(token) : null;
		if (page == currentPage) {
			History.fireCurrentHistoryState();
		} else {
			History.newItem(page.toString());
		}
	}
}
