package com.sat.dao;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sat.model.Utility;
import com.sat.model.Website;

public class WebsiteDao {
	
	public static WebsiteDao instance = null;
	public static WebsiteDao getInstance() {
		if(instance == null) {
			instance = new WebsiteDao();
		}
		return instance;
	}
	private WebsiteDao() {}
	
	public int createWebsiteForDeveloper(int developerId, Website website) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "INSERT INTO Website (Name,Description,Created,Updated,Visits,DeveloperId) VALUES (?,?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, website.getName());
			statement.setString(2, website.getDescription());
			statement.setString(3,"2018-03-12");
			statement.setString(4,"2018-03-12");
			statement.setString(5,website.getVisits());
			statement.setInt(6,developerId);
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
	
	public Collection<Website> findAllWebsites(){
		List<Website> allWebsites = new ArrayList<Website>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "SELECT * FROM Website";
			statement = connection.prepareStatement(sql);
			results = statement.executeQuery(); 
			while(results.next()) {
				
				int id = results.getInt("id");
				String name = results.getString("Name");
				String description = results.getString("Description");
				String created = results.getString("Created");
				String updated = results.getString("Updated");
				String visits = results.getString("Visits");
				int developerId = results.getInt("DeveloperId");
				Website website = new Website(id, name, description, created, updated, visits, developerId);
				allWebsites.add(website);
			}
			System.out.println(allWebsites);
			
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
		return allWebsites;
		
	}
	
	public Collection<Website> findWebsitesForDeveloper(int developerId){
		List<Website> allWebsites = new ArrayList<Website>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "SELECT * FROM Website WHERE DeveloperId = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, developerId);
			results = statement.executeQuery(); 
			while(results.next()) {
				
				int id = results.getInt("id");
				String name = results.getString("name");
				String description = results.getString("Description");
				String created = results.getString("Created");
				String updated = results.getString("Updated");
				String visits = results.getString("Visits");
				//int dId = results.getInt("DeveloperId");
				
				Website website = new Website(id, name, description, created, updated, visits, developerId);
				allWebsites.add(website);
			}
			System.out.println(allWebsites);
			
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
		return allWebsites;
	}
	
	public Website findWebsiteById(int websiteId) {
		Website w = new Website();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "SELECT * FROM Website WHERE id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, websiteId);
			results = statement.executeQuery(); 
			if(results.next()) {				
				int id = results.getInt("id");
				String name = results.getString("name");
				String description = results.getString("Description");
				String created = results.getString("Created");
				String updated = results.getString("Updated");
				String visits = results.getString("Visits");
				int developerId = results.getInt("DeveloperId");
				
				w = new Website(id, name, description, created, updated, visits, developerId);
			}else {
				System.out.println("Website not found by id: " + websiteId);
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
	
	public int updateWebsite(int websiteId, Website website) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "UPDATE Website SET name=?, description=?,created=?,updated=?,visits=? WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, website.getName());
			statement.setString(2, website.getDescription());
			statement.setString(3, website.getCreated());
			statement.setString(4, website.getUpdated());
			statement.setString(5,website.getVisits());
			statement.setInt(6,websiteId);
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
	
	public int deleteWebsite(int websiteId) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "DELETE from Website WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,websiteId);
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
	
	public Website findWebsiteByName(String websiteName){
		
		Website w = new Website();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "SELECT * FROM Website WHERE Name = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, websiteName);
			results = statement.executeQuery(); 
			if(results.next()) {				
				int id = results.getInt("id");
				String name = results.getString("Name");
				String description = results.getString("Description");
				String created = results.getString("Created");
				String updated = results.getString("Updated");
				String visits = results.getString("Visits");
				int developerId = results.getInt("DeveloperId");
				
				w = new Website(id, name, description, created, updated, visits, developerId);
			}else {
				System.out.println("Website not found by name: " + websiteName);
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
}
