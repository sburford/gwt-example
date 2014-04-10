package it.ms.gwt_example.client.components;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public abstract class InheritableComposite extends Composite {

    protected InheritableComposite() {

        Widget content = createContent();
        initWidget(content);
    }

    protected abstract Widget createContent();
}
