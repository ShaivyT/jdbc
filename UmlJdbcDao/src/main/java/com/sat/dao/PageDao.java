package com.sat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sat.model.Page;
import com.sat.model.Utility;

public class PageDao {
	
	public static PageDao instance = null;
	public static PageDao getInstance() {
		if(instance == null) {
			instance = new PageDao();
		}
		return instance;
	}
	
	private PageDao() {}
	
	public int createPageForWebsite(int websiteId, Page page) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql1 = "INSERT into Page (Title, Description, Created, Updated, Views, WebsiteId) VALUES (?,?,?,?,?,?)";
			statement = connection.prepareStatement(sql1);
			statement.setString(1, page.getTitle());
			statement.setString(2, page.getDescription());
			statement.setString(3, page.getCreated());
			statement.setString(4, page.getUpdated());
			statement.setString(5, page.getViews());
			statement.setInt(6, page.getWebsiteId());
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
	
	
	public Collection<Page> findAllPages(){
		List<Page> allPages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "SELECT * FROM Page";
			statement = connection.prepareStatement(sql);
			results = statement.executeQuery(); 
			while(results.next()) {
				int id = results.getInt("id");
				String title = results.getString("Title");
				String description = results.getString("Description");
				String created = results.getString("Created");
				String updated = results.getString("Updated");
				String visits = results.getString("Views");
				int websiteId = results.getInt("WebsiteId");
				
				Page page = new Page(id, title, description, created, updated, visits, websiteId);
				allPages.add(page);
			}
			System.out.println(allPages);
			
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
		return allPages;
	}
	
	public Page findPageById(int pageId) {
		Page w = new Page();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "SELECT * FROM Page WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pageId);
			results = statement.executeQuery(); 
			if(results.next()) {				
				int id = results.getInt("id");
				String title = results.getString("Title");
				String description = results.getString("Description");
				String created = results.getString("Created");
				String updated = results.getString("Updated");
				String views = results.getString("Views");
				int websiteId = results.getInt("WebsiteId");
				
				w = new Page(id, title, description, created, updated, views, websiteId);
			}else {
				System.out.println("Page not found by id: " + pageId);
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
	
	public Page findPageByTitle(String pageTitle, int websiteId) {
		Page w = new Page();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "SELECT * FROM Page WHERE Title=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, pageTitle);
			results = statement.executeQuery(); 
			if(results.next()) {				
				int id = results.getInt("id");
				String title = results.getString("Title");
				String description = results.getString("Description");
				String created = results.getString("Created");
				String updated = results.getString("Updated");
				String views = results.getString("Views");
				
				w = new Page(id, title, description, created, updated, views, websiteId);
			}else {
				System.out.println("Page not found by name: " + pageTitle);
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
	
	public Collection<Page> findPagesForWebsite(int websiteId){
		List<Page> allPages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "SELECT * FROM Page WHERE WebsiteId=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, websiteId);
			results = statement.executeQuery(); 
			while(results.next()) {				
				int id = results.getInt("id");
				String title = results.getString("Title");
				String description = results.getString("Description");
				String created = results.getString("Created");
				String updated = results.getString("Updated");
				String views = results.getString("Views");
				Page page = new Page(id,title,description,created,updated,views,websiteId) ;
				allPages.add(page);
			}
			System.out.println(allPages);
			
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
		return allPages;
	}
	
	public int updatePage(int pageId, Page page) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "UPDATE Page SET Title=?, Description=?, Created=?, Updated=?, Views=? WHERE `id` = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, page.getTitle());
			statement.setString(2, page.getDescription());
			statement.setString(3, page.getCreated());
			statement.setString(4, page.getUpdated());
			statement.setString(5,page.getViews());
			statement.setInt(6,pageId);
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
	
	public int deletePage(int pageId) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "DELETE FROM `Page` where `id` = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,pageId);
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
