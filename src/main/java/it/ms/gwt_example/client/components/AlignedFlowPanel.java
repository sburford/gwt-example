package it.ms.gwt_example.client.components;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public abstract class AlignedFlowPanel extends FlowPanel {

	@Override
	public final void add(Widget widget) {

		styleFloat(widget);
		super.add(widget);
	}

	@Override
	public final void insert(IsWidget widget, int beforeIndex) {

		insert(widget.asWidget(), beforeIndex);
	}

	@Override
	public final void insert(Widget widget, int beforeIndex) {

		styleFloat(widget);
		super.insert(widget, beforeIndex);
	}

	private final void styleFloat(final Widget widget) {

        widget.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		widget.getElement().getStyle().setDisplay(display());
	}

	protected abstract Display display();
}
