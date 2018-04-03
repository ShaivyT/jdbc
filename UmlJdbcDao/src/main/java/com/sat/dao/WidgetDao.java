package com.sat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sat.model.HeadingWidget;
import com.sat.model.HtmlWidget;
import com.sat.model.ImageWidget;
import com.sat.model.Utility;
import com.sat.model.Widget;
import com.sat.model.YoutubeWidget;

public class WidgetDao {
	
	public static WidgetDao instance = null;
	public static WidgetDao getInstance() {
		if(instance == null) {
			instance = new WidgetDao();
		}
		return instance;
	}
	
	private WidgetDao() {}
	
	public int createWidgetForPage(int pageId, Widget widget) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "";
			if(widget instanceof HeadingWidget) {
				sql = "INSERT into Widget (Name,Type,Width,Height,CssClass,CssStyle,Text,Order,PageId,Size) VALUES (?,?,?,?,?,?,?,?,?,?)";
			}
			else if(widget instanceof HtmlWidget) {
				sql = "INSERT into Widget (Name,Type,Width,Height,CssClass,CssStyle,Text,Order,PageId,Html) VALUES (?,?,?,?,?,?,?,?,?,?)";
			}
			else if(widget instanceof ImageWidget) {
				sql = "INSERT into Widget (Name,Type,Width,Height,CssClass,CssStyle,Text,Order,PageId,Src) VALUES (?,?,?,?,?,?,?,?,?,?)";
			}
			else if(widget instanceof YoutubeWidget) {
				sql = "INSERT into Widget (Name,Type,Width,Height,CssClass,CssStyle,Text,Order,PageId,Url,Shareable,Expandable) "
						+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			}
			
			statement = connection.prepareStatement(sql);
			statement.setString(1, widget.getName());
			statement.setString(2, widget.getType());
			statement.setInt(3,widget.getWidth());
			statement.setInt(4, widget.getHeight());
			statement.setString(5,widget.getCssClass());
			statement.setString(6,widget.getCssStyle());
			statement.setString(7,widget.getText());
			statement.setInt(8,widget.getOrder());
			statement.setInt(9,pageId);
			
			if(widget instanceof HeadingWidget) {
				statement.setInt(10,((HeadingWidget) widget).getSize());
			}
			else if(widget instanceof HtmlWidget) {
				statement.setString(10,((HtmlWidget) widget).getHtml());
			}
			else if(widget instanceof ImageWidget) {
				statement.setString(10,((ImageWidget)widget).getSrc());
			}
			else if(widget instanceof YoutubeWidget) {
				statement.setString(10,((YoutubeWidget)widget).getUrl());
				statement.setBoolean(11,((YoutubeWidget)widget).isShareable());
				statement.setBoolean(12,((YoutubeWidget)widget).isExpandable());
			}
			
			key = statement.executeUpdate();
			statement.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return key;
	}
	
	public Collection<Widget> findAllWidgets(){
		List<Widget> allWidgets = new ArrayList<Widget>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "SELECT * FROM Widget";
			statement = connection.prepareStatement(sql);
			results = statement.executeQuery(); 
			while(results.next()) {
				
				int id=results.getInt("id");
				String name = results.getString("Name");
				String type = results.getString("Type");
				int width = results.getInt("Width");
				int height = results.getInt("Height");
				String cssClass = results.getString("CssClass");
				String cssStyle = results.getString("CssStyle");
				String text = results.getString("Text");
				int order = results.getInt("Order");
				int pageId = results.getInt("PageId");
				int size = results.getInt("Size");
				String html = results.getString("Html");
				String src = results.getString("Src");
				String url = results.getString("Url");
				boolean shareable = results.getBoolean("Shareable");
				boolean expandable = results.getBoolean("Expandable");
				
				
				Widget widget = new Widget();
				if(type.equals("heading")) {
					widget = new HeadingWidget(id,name,type,width,height,cssClass,cssStyle,text,order,pageId,size);
				}
				else if(type.equals("html")) {
					widget = new HtmlWidget(id,name,type,width,height,cssClass,cssStyle,text,order,pageId,html);
				}
				else if(type.equals("image")) {
					widget = new ImageWidget(id,name,type,width,height,cssClass,cssStyle,text,order,pageId,src);
				}
				else if(type.equals("youtube")) {
					widget = new YoutubeWidget(id,name,type,width,height,cssClass,cssStyle,text,order,
							pageId,url,shareable,expandable);
				}
				
				allWidgets.add(widget);
			}
			System.out.println(allWidgets);
			
			statement.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return allWidgets;
	}
	
	public Widget findWidgetById(int widgetId) {
		Widget w = new Widget();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "SELECT * FROM Widget WHERE id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, widgetId);
			results = statement.executeQuery(); 
			if(results.next()) {				
				int id=results.getInt("id");
				String name = results.getString("Name");
				String type = results.getString("Type");
				int width = results.getInt("Width");
				int height = results.getInt("Height");
				String cssClass = results.getString("CssClass");
				String cssStyle = results.getString("CssStyle");
				String text = results.getString("Text");
				int order = results.getInt("Order");
				int pageId = results.getInt("PageId");
				int size = results.getInt("Size");
				String html = results.getString("Html");
				String src = results.getString("Src");
				String url = results.getString("Url");
				boolean shareable = results.getBoolean("Shareable");
				boolean expandable = results.getBoolean("Expandable");
				
				if(type.equals("heading")) {
					w = new HeadingWidget(id,name,type,width,height,cssClass,cssStyle,text,order,pageId,size);
				}
				else if(type.equals("html")) {
					w = new HtmlWidget(id,name,type,width,height,cssClass,cssStyle,text,order,pageId,html);
				}
				else if(type.equals("image")) {
					w = new ImageWidget(id,name,type,width,height,cssClass,cssStyle,text,order,pageId,src);
				}
				else if(type.equals("youtube")) {
					w = new YoutubeWidget(id,name,type,width,height,cssClass,cssStyle,text,order,
							pageId,url,shareable,expandable);
				}
			}else {
				System.out.println("Website not found by id: " + widgetId);
			}			
			statement.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return w;
	}
	
	public Widget findWidgetByName(String widgetName) {
		Widget w = new Widget();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "SELECT * FROM Widget WHERE Name = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, widgetName);
			results = statement.executeQuery(); 
			if(results.next()) {				
				int id=results.getInt("id");
				String name = results.getString("Name");
				String type = results.getString("Type");
				int width = results.getInt("Width");
				int height = results.getInt("Height");
				String cssClass = results.getString("CssClass");
				String cssStyle = results.getString("CssStyle");
				String text = results.getString("Text");
				int order = results.getInt("Order");
				int pageId = results.getInt("PageId");
				int size = results.getInt("Size");
				String html = results.getString("Html");
				String src = results.getString("Src");
				String url = results.getString("Url");
				boolean shareable = results.getBoolean("Shareable");
				boolean expandable = results.getBoolean("Expandable");
				
				if(type.equals("heading")) {
					w = new HeadingWidget(id,name,type,width,height,cssClass,cssStyle,text,order,pageId,size);
				}
				else if(type.equals("html")) {
					w = new HtmlWidget(id,name,type,width,height,cssClass,cssStyle,text,order,pageId,html);
				}
				else if(type.equals("image")) {
					w = new ImageWidget(id,name,type,width,height,cssClass,cssStyle,text,order,pageId,src);
				}
				else if(type.equals("youtube")) {
					w = new YoutubeWidget(id,name,type,width,height,cssClass,cssStyle,text,order,
							pageId,url,shareable,expandable);
				}
			}else {
				System.out.println("Website not found by name: " + widgetName);
			}			
			statement.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return w;
	}
	
	public Collection<Widget> findWidgetsForPage(int pageId){
		List<Widget> allWidgets = new ArrayList<Widget>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "SELECT * FROM Widget WHERE pageId=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pageId);
			results = statement.executeQuery(); 
			while(results.next()) {
				int id=results.getInt("id");
				String name = results.getString("Name");
				String type = results.getString("Type");
				int width = results.getInt("Width");
				int height = results.getInt("Height");
				String cssClass = results.getString("CssClass");
				String cssStyle = results.getString("CssStyle");
				String text = results.getString("Text");
				int order = results.getInt("Order");
				//int pageId = results.getInt("PageId");
				int size = results.getInt("Size");
				String html = results.getString("Html");
				String src = results.getString("Src");
				String url = results.getString("Url");
				boolean shareable = results.getBoolean("Shareable");
				boolean expandable = results.getBoolean("Expandable");
				
				
				Widget widget = new Widget();
				if(type.equals("heading")) {
					widget = new HeadingWidget(id,name,type,width,height,cssClass,cssStyle,text,order,pageId,size);
				}
				else if(type.equals("html")) {
					widget = new HtmlWidget(id,name,type,width,height,cssClass,cssStyle,text,order,pageId,html);
				}
				else if(type.equals("image")) {
					widget = new ImageWidget(id,name,type,width,height,cssClass,cssStyle,text,order,pageId,src);
				}
				else if(type.equals("youtube")) {
					widget = new YoutubeWidget(id,name,type,width,height,cssClass,cssStyle,text,order,
							pageId,url,shareable,expandable);
				}
				
				allWidgets.add(widget);
			}
			System.out.println(allWidgets);
			
			statement.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return allWidgets;
	}
	
	public int updateWidget(int widgetId, Widget widget) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "";
			if(widget instanceof HeadingWidget) {
				sql = "UPDATE Widget SET Name=?,Type=?,Width=?,Height=?,CssClass=?,CssStyle=?,Text=?,Order=?,PageId=?,Size=? WHERE id=?";
			}
			else if(widget instanceof HtmlWidget) {
				sql = "UPDATE Widget SET Name=?,Type=?,Width=?,Height=?,CssClass=?,CssStyle=?,Text=?,Order=?,PageId=?,Html=? WHERE id=?";
			}
			else if(widget instanceof ImageWidget) {
				sql = "UPDATE Widget SET Name=?,Type=?,Width=?,Height=?,CssClass=?,CssStyle=?,Text=?,Order=?,PageId=?,Src=? WHERE id=?";
			}
			else if(widget instanceof YoutubeWidget) {
				sql = "UPDATE Widget SET Name=?,Type=?,Width=?,Height=?,CssClass=?,CssStyle=?,Text=?,Order=?,PageId=?,Url=?,Shareable=?,Expandable=? WHERE id=?";
			}
			
			statement = connection.prepareStatement(sql);
			statement.setString(1, widget.getName());
			statement.setString(2, widget.getType());
			statement.setInt(3,widget.getWidth());
			statement.setInt(4, widget.getHeight());
			statement.setString(5,widget.getCssClass());
			statement.setString(6,widget.getCssStyle());
			statement.setString(7,widget.getText());
			statement.setInt(8,widget.getOrder());
			statement.setInt(9,widget.getPageId());
			
			if(widget instanceof HeadingWidget) {
				statement.setInt(10,((HeadingWidget) widget).getSize());
				statement.setInt(11,widgetId);
			}
			else if(widget instanceof HtmlWidget) {
				statement.setString(10,((HtmlWidget) widget).getHtml());
				statement.setInt(11,widgetId);
			}
			else if(widget instanceof ImageWidget) {
				statement.setString(10,((ImageWidget)widget).getSrc());
				statement.setInt(11,widgetId);
			}
			else if(widget instanceof YoutubeWidget) {
				statement.setString(10,((YoutubeWidget)widget).getUrl());
				statement.setBoolean(11,((YoutubeWidget)widget).isShareable());
				statement.setBoolean(12,((YoutubeWidget)widget).isExpandable());
				statement.setInt(13,widgetId);
			}
			
			key = statement.executeUpdate();
			statement.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return key;
	}
	
	public int deleteWidget(int widgetId) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "DELETE from Widget WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,widgetId);
			key = statement.executeUpdate();
			statement.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return key;	
	}
}
