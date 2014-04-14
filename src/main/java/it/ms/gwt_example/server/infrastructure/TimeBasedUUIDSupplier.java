package it.ms.gwt_example.server.infrastructure;

import java.util.UUID;

import javax.inject.Named;

import it.ms.gwt_example.server.domain.UUIDSupplier;

@Named("uuidSupplier")
public final class TimeBasedUUIDSupplier implements UUIDSupplier {

	public static TimeBasedUUIDSupplier getInstance() {

		return InstanceHolder.INSTANCE;
	}

	private static final class InstanceHolder {

		private static final TimeBasedUUIDSupplier INSTANCE = new TimeBasedUUIDSupplier();
	}

	private TimeBasedUUIDSupplier() {

		// prevents instantiation
	}

	@Override
	public UUID get() {

		return convertUUID(new com.eaio.uuid.UUID());
	}

	private UUID convertUUID(final com.eaio.uuid.UUID uuid) {

		return UUID.fromString(uuid.toString());
	}
}
