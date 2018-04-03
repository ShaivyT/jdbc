package com.sat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sat.model.Utility;

public class PrivilegeDao {
	
	public static PrivilegeDao instance = null;
	public static PrivilegeDao getInstance() {
		if(instance == null) {
			instance = new PrivilegeDao();
		}
		return instance;
	}
	private PrivilegeDao() {}
	public int assignWebsitePriviledge(int developerId, int websiteId, int priviledgeId) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "INSERT INTO Website_Privilege (DeveloperId, WebsiteId,PrivilegeId) VALUES (?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,developerId);
			statement.setInt(2,websiteId);
			statement.setInt(3,priviledgeId);
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
	
	public int assignPagePriviledge(int developerId, int pageId, int priviledgeId) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "INSERT INTO Page_Privilege (DeveloperId, PageId, PrivilegeId) VALUES (?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,developerId);
			statement.setInt(2,pageId);
			statement.setInt(3,priviledgeId);
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
	
	public int deleteWebsitePriviledge(int developerId, int websiteId, int priviledgeId) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "DELETE FROM Website_Privilege  WHERE DeveloperId = ? AND WebsiteId = ? and PrivilegeId = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,developerId);
			statement.setInt(2,websiteId);
			statement.setInt(3,priviledgeId);
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
	
	public int deletePagePriviledge(int developerId, int pageId, int priviledgeId) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null; 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "DELETE FROM Page_Privilege WHERE DeveloperId = ? AND PageId = ? and PrivilegeId = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,developerId);
			statement.setInt(2,pageId);
			statement.setInt(3,priviledgeId);
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
