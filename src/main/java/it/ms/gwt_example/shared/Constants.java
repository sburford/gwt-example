package it.ms.gwt_example.shared;

public final class Constants {

	public static final class Cookies {

		public static final String SESSION_ID = "sessionID";

		public static final String USERNAME = "username";

		private Cookies() {

			// prevents instantiation
		}
	}

	public static final class Session {

		public static final int MAX_INACTIVE_INTERVAL_MINUTES = 60;

		private Session() {

			// prevents instantiation
		}
	}

	private Constants() {

		// prevents instantiation
	}
}
