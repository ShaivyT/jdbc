package com.sat.model;

public class HeadingWidget extends Widget {
	
	
	public HeadingWidget() {
		super();
	}

	public HeadingWidget(int size) {
		super();
		this.size = size;
	}
	
	public HeadingWidget(String name, String type, String text, int order, int size) {
		super(name, type, text, order);
		this.size = size;
	}
	
	
	
	public HeadingWidget(int id, String name, String type, int width, int height, String cssClass, String cssStyle,
			String text, int order, int pageId, int size) {
		super(id, name, type, width, height, cssClass, cssStyle, text, order, pageId);
		this.size = size;
	}

	@Override
	public String toString() {
		return "HeadingWidget [size=" + size + "]";
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private int size;
	
}
