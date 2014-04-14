package it.ms.gwt_example.client.main;

import it.ms.gwt_example.client.Presenter;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;

public final class MainPresenter implements Presenter {

    public static MainPresenter instance(){

        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        // TODO add the real view here
        private static final MainPresenter INSTANCE = new MainPresenter();
    }

    private MainPresenter(){

        // TODO add the real view here
        // prevents control over instantiation
    }

    @Override
    public IsWidget view() {

        return new Label("Main page");
    }
}
