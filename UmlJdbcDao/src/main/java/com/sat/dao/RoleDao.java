package com.sat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sat.model.Utility;


public class RoleDao {
	
	public static RoleDao instance = null;
	public static RoleDao getInstance() {
		if(instance == null) {
			instance = new RoleDao();
		}
		return instance;
	}
	private RoleDao() {}
	public int assignWebsiteRole(int developerId, int websiteId, int roleId) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "INSERT INTO Website_Role (DeveloperId, WebsiteId, RoleId) VALUES (?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,developerId);
			statement.setInt(2,websiteId);
			statement.setInt(3,roleId);
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
	
	public int assignPageRole(int developerId, int pageId, int roleId) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "INSERT INTO Page_Role (DeveloperId, PageId, RoleId) VALUES (?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,developerId);
			statement.setInt(2,pageId);
			statement.setInt(3,roleId);
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
	
	public int deleteWebsiteRole(int developerId, int websiteId, int roleId) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "DELETE FROM Website_Role  WHERE DeveloperId = ? AND WebsiteId = ? and RoleId = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,developerId);
			statement.setInt(2,websiteId);
			statement.setInt(3,roleId);
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
	
	public int deletePageRole(int developerId, int pageId, int roleId) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "DELETE FROM Page_Role WHERE DeveloperId = ? AND PageId = ? and RoleId = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,developerId);
			statement.setInt(2,pageId);
			statement.setInt(3,roleId);
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
