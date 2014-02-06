package it.unibz.inf.corner.client;

import java.util.ArrayList;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;

public class OntologiesAndSourcesTable extends FlexTable {

	public static final String VIEW_DELETE_COLOR = "grey";
	public static final String TITLE_BG_COLOR = "grey";
	public static final String FORM_BORDER = "2px solid grey";
	public static final String VIEW_DELETE_PADDING = "0px 10px 0px 10px";
	public static final String BORDER_RADIUS = "10px";

	int startViewDelCol;

	public OntologiesAndSourcesTable(int startViewDelCol) {
		super();
		sinkEvents(Event.ONMOUSEOVER);
		this.startViewDelCol = startViewDelCol;
	}

	@Override
	public void onBrowserEvent(Event event) {
		switch (DOM.eventGetType(event)) {
		case Event.ONMOUSEOVER:
			Element from = Element.as(event.getRelatedEventTarget());
			Element to = Element.as(event.getCurrentEventTarget());
			
			break;
		default:
			break;
		}
	}

	void giveFormStyle(String formTitle, ArrayList<CheckBox> oList,
			String baseStyle, int startViewDelCol) {
		this.setStyleName(baseStyle);
		for (int i = 1; i <= 3; i++) {
			this.setWidget(i, 0, oList.get(i - 1));
			this.setText(i, startViewDelCol, "view");
			this.setText(i, startViewDelCol + 1, "delete");
			this.getCellFormatter().getElement(i, 0).getStyle()
					.setProperty("maxWidth", "30%");
			this.getCellFormatter().getElement(i, startViewDelCol).getStyle()
					.setProperty("padding", VIEW_DELETE_PADDING);
			this.getCellFormatter().getElement(i, startViewDelCol).getStyle()
					.setProperty("fontStyle", "italic");
			this.getCellFormatter().getElement(i, startViewDelCol).getStyle()
					.setProperty("color", VIEW_DELETE_COLOR);
			this.getCellFormatter().getElement(i, startViewDelCol + 1)
					.getStyle().setProperty("color", VIEW_DELETE_COLOR);
			this.getCellFormatter().getElement(i, startViewDelCol + 1)
					.getStyle().setProperty("fontStyle", "italic");
			this.getCellFormatter().getElement(i, startViewDelCol + 1)
					.getStyle().setProperty("padding", VIEW_DELETE_PADDING);
		}
		this.setText(0, 0, formTitle);
		this.getCellFormatter().getElement(0, 0).getStyle()
				.setProperty("padding", VIEW_DELETE_PADDING);
		

		this.getCellFormatter().getElement(0, 0).getStyle()
				.setProperty("backgroundColor", TITLE_BG_COLOR);
		this.getColumnFormatter().getElement(0).getStyle()
				.setProperty("borderLeft", FORM_BORDER);
		this.getColumnFormatter().getElement(startViewDelCol + 1).getStyle()
				.setProperty("borderRight", FORM_BORDER);
		this.getRowFormatter().getElement(1).getStyle()
				.setProperty("borderTop", FORM_BORDER);
		this.getRowFormatter().getElement(this.getRowCount() - 1).getStyle()
				.setProperty("borderBottom", FORM_BORDER);

		this.getCellFormatter().getElement(0, 0).getStyle()
				.setProperty("borderLeft", "hidden");
		
//		 this.getCellFormatter().getElement(0,
//				 0).getStyle().setProperty("border", "2px grey");
				this.getCellFormatter().getElement(0, 0).getStyle()
						.setProperty("borderTopLeftRadius", BORDER_RADIUS);
				this.getCellFormatter().getElement(0, 0).getStyle()
						.setProperty("borderTopRightRadius", BORDER_RADIUS);

	}
}
