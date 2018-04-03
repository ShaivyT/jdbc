package com.sat.model;

public class HtmlWidget extends Widget{
	
	public HtmlWidget() {
		super();
	}

	public HtmlWidget(String html) {
		super();
		this.html = html;
	}
	
	public HtmlWidget(String name, String type,	String text, int order) {
		super(name, type, text, order);
	}
	
	public HtmlWidget(int id, String name, String type, int width, int height, String cssClass, String cssStyle,
			String text, int order, int pageId, String html) {
		super(id, name, type, width, height, cssClass, cssStyle, text, order, pageId);
		this.html = html;
	}

	@Override
	public String toString() {
		return "HtmlWidget [html=" + html + "]";
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	private String html;

}
