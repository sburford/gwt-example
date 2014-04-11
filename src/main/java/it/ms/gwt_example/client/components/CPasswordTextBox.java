package it.ms.gwt_example.client.components;

import com.google.gwt.user.client.ui.PasswordTextBox;

public final class CPasswordTextBox extends PasswordTextBox {

    @Override
    public String getValue() {

        String clearText = super.getValue();
        return encrypt(clearText);
    }

    private String encrypt(final String clearText) {

        // TODO encrypt (SHA512?)
        return clearText;
    }
}
