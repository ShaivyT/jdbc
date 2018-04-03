package com.sat.model;

public class YoutubeWidget extends Widget {
	private String url;
	private boolean shareable;
	private boolean expandable;
	
	
	
	public YoutubeWidget() {
		super();
	}
	public YoutubeWidget(String url, boolean shareable, boolean expandable) {
		super();
		this.url = url;
		this.shareable = shareable;
		this.expandable = expandable;
	}
	 // name,type,width,height,order,src
	public YoutubeWidget(String name, String type, int width, int height, int order, String url) {
		super(name, type, width, height,order);
		this.url = url;
	}
	
	public YoutubeWidget(int id, String name, String type, int width, int height, String cssClass, String cssStyle,
			String text, int order, int pageId, String url, boolean shareable, boolean expandable) {
		super(id, name, type, width, height, cssClass, cssStyle, text, order, pageId);
		this.url = url;
		this.shareable = shareable;
		this.expandable = expandable;
	}
	
	@Override
	public String toString() {
		return "YoutubeWidget [url=" + url + ", shareable=" + shareable + ", expandable=" + expandable + "]";
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isShareable() {
		return shareable;
	}
	public void setShareable(boolean shareable) {
		this.shareable = shareable;
	}
	public boolean isExpandable() {
		return expandable;
	}
	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}
	
	
}
