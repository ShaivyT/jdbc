package com.sat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sat.model.Developer;
import com.sat.model.Utility;

public class DeveloperDao {
	
	public static DeveloperDao instance = null;
	public static DeveloperDao getInstance() {
		if(instance == null) {
			instance = new DeveloperDao();
		}
		return instance;
	}
	private DeveloperDao() {}
	
	public int createDeveloper(Developer developer) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql1 = "INSERT INTO Person (Firstname,Lastname,Username,Password,Email,Dob) VALUES (?,?,?,?,?,?)";
			statement = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, developer.getFirstName());
			statement.setString(2, developer.getLastName());
			statement.setString(3, developer.getUsername());
			statement.setString(4, developer.getPassword());
			statement.setString(5, developer.getEmail());
			statement.setString(6, developer.getDob());
//			statement.setInt(7, 444);
			key = statement.executeUpdate();
			results = statement.getGeneratedKeys();
			
			int devId;
			if(results.next()) {
				devId = results.getInt(1);
				statement.close();
				statement = null;
				String sql2 = "INSERT INTO Developer (id,DeveloperKey) VALUES (?,?)";
				statement2 = connection.prepareStatement(sql2);
				statement2.setInt(1, devId);
				statement2.setString(2, developer.getDeveloperKey());
				key = statement2.executeUpdate(); 
				statement2.close();
			}
			else {
				System.out.println("Developer Key not returned");
			}
			
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
	
	
	public Collection<Developer> findAllDevelopers()	{
		List<Developer> allDevelopers = new ArrayList<Developer>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "SELECT * FROM Person, Developer WHERE Person.Id = Developer.Id";
			statement = connection.prepareStatement(sql);
			results = statement.executeQuery(); 
			while(results.next()) {
				int id=results.getInt("id");
				String firstname = results.getString("Firstname");
				String lastname = results.getString("Lastname");
				String username = results.getString("Username");
				String password = results.getString("Password");
				String email = results.getString("Email");
				String dob = results.getString("Dob");
				String developerKey = results.getString("DeveloperKey");
				Developer developer = new Developer(id, firstname,lastname,username,password,email,dob,developerKey);
				allDevelopers.add(developer);
			}
			System.out.println(allDevelopers);
			
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
		return allDevelopers;
	}
	
	public Developer findDeveloperById(int developerId) {
		Developer d = new Developer();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "SELECT * FROM Person JOIN Developer ON PERSON.Id = Developer.Id WHERE Developer.Id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, developerId);
			results = statement.executeQuery();
			
			if(results.next()) {
				int id=results.getInt("id");
				String firstname = results.getString("Firstname");
				String lastname = results.getString("Lastname");
				String username = results.getString("Username");
				String password = results.getString("Password");
				String email = results.getString("Email");
				String dob = results.getString("Dob");
				String developerKey = results.getString("DeveloperKey");
				d = new Developer(id, firstname,lastname,username,password,email,dob,developerKey);
			} else {
				System.out.println("Developer not found by Id!!!");
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
		return d;
	}
	
	
	public Developer findDeveloperByUsername(String username) {
		
		Developer d = new Developer();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "SELECT * FROM Person, Developer Where Person.Id = Developer.Id AND Person.Username=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			results = statement.executeQuery();
			
			if(results.next()) {
				int id=results.getInt("id");
				String firstname = results.getString("Firstname");
				String lastname = results.getString("Lastname");
//				String u = results.getString("Username");
				String password = results.getString("Password");
				String email = results.getString("Email");
				String dob = results.getString("Dob");
				String developerKey = results.getString("DeveloperKey");
				d = new Developer(id, firstname,lastname,username,password,email,dob,developerKey);
			} else {
				System.out.println("Developer not found by username!!!");
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
		return d;
		
	}
	
	public Developer findDeveloperByCredentials(String username, String password)	{
		
		Developer d = new Developer();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "SELECT * FROM Person JOIN Developer ON PERSON.Id = Developer.Id WHERE Person.Username=?  AND Person.Password=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(1, password);
			results = statement.executeQuery();
			
			if(results.next()) {
				int id=results.getInt("id");
				String firstname = results.getString("Firstname");
				String lastname = results.getString("Lastname");
//				String u = results.getString("Username");
//				String p = results.getString("Password");
				String email = results.getString("Email");
				String dob = results.getString("Dob");
				String developerKey = results.getString("DeveloperKey");
				d = new Developer(id, firstname,lastname,username,password,email,dob,developerKey);
			}
			else {
				System.out.println("Developer not found by credentials!!!");
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
		return d;
		
	}
	
	public int updateDeveloper(int developerId, Developer developer) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "UPDATE person join Developer ON Person.id = Developer.id SET firstname=?,lastname=?,username=?,"
					+ "password=?,email=?,dob=?,DeveloperKey=? WHERE Developer.id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, developer.getFirstName());
			statement.setString(2, developer.getLastName());
			statement.setString(3, developer.getUsername());
			statement.setString(4, developer.getPassword());
			statement.setString(5, developer.getEmail());
			statement.setString(6, developer.getDob());
			statement.setString(7, developer.getDeveloperKey());
			statement.setInt(8, developerId);
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
	
	public int deleteDeveloper(int developerId) {
		int key = -999;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = Utility.getDMConnection();
			String sql = "DELETE from Person WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,developerId);
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
