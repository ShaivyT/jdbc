package com.sat.model;

public class ImageWidget extends Widget{
	
	public ImageWidget() {
		super();
	}

	public ImageWidget(String src) {
		super();
		this.src = src;
	}

	public ImageWidget(String name, String type, int width, int height, int order, String src) {
		super(name, type, width, height, order);
		this.src = src;
	}
	
	public ImageWidget(int id, String name, String type, int width, int height, String cssClass, String cssStyle,
			String text, int order, int pageId, String src) {
		super(id, name, type, width, height, cssClass, cssStyle, text, order, pageId);
		this.src = src;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	@Override
	public String toString() {
		return "ImageWidget [src=" + src + "]";
	}
	
	private String src;

}
