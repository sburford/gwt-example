package it.ms.gwt_example.client.components;

import com.google.gwt.dom.client.Style.Display;

public class HFlowPanel extends AlignedFlowPanel {

	@Override
	protected Display display() {

		return Display.INLINE_BLOCK;
	}
}