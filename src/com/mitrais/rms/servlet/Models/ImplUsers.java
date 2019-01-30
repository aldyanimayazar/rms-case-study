package com.mitrais.rms.servlet.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mitrais.rms.config.DataConnection;

public class ImplUsers implements UsersDao {

	@Override
	public List<Users> findAll() {
		List<Users> result = new ArrayList();
		try(Connection connection = DataConnection.getConnection()) 
		{
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery("SELECT * FROM users");
			while (results.next()) {
				Users users = new Users(results.getInt("id"), results.getString("firstname"), results.getString("lastname"), results.getString("email"), results.getString("email"), results.getString("password"), results.getDate("created_at"), results.getDate("updated_at"));
				result.add(users);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean save(Users users) {
		try(Connection conn = DataConnection.getConnection())  
		{
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (firstname,lastname,email,password,phone) VALUES (?,?,?,?,?)");
            stmt.setString(1, users.getFirstname());
            stmt.setString(2, users.getLastname());
            stmt.setString(3, users.getEmail());
            stmt.setString(4, users.getPhone());
            stmt.setString(5, users.getPassword());
            int i = stmt.executeUpdate();
            if(i == 1) {
                return true;
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Users users) {
		try(Connection conn = DataConnection.getConnection())  
		{
			if(users.getPassword() != null) {
				PreparedStatement stmt = conn.prepareStatement("UPDATE users SET firstname=?, lastname=?, email=?, password=?, phone=? WHERE id=?");
	            stmt.setString(1, users.getFirstname());
	            stmt.setString(2, users.getLastname());
	            stmt.setString(3, users.getEmail());
	            stmt.setString(4, users.getPhone());
	            stmt.setString(5, users.getPassword());
	            stmt.setInt(6, users.getId());
	            int i = stmt.executeUpdate();
	            if(i == 1) {
	                return true;
	            }
			} else {
				PreparedStatement stmt = conn.prepareStatement("UPDATE users SET firstname=?, lastname=?, email=? , phone=? WHERE id=?");
	            stmt.setString(1, users.getFirstname());
	            stmt.setString(2, users.getLastname());
	            stmt.setString(3, users.getEmail());
	            stmt.setString(4, users.getPhone());
	            stmt.setInt(5, users.getId());
	            int i = stmt.executeUpdate();
	            if(i == 1) {
	                return true;
	            }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Users users) {
		try(Connection conn = DataConnection.getConnection())  
		{
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE id=?");
            stmt.setInt(1, users.getId());
            int i = stmt.executeUpdate();
            if(i == 1) {
                return true;
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Optional<Users> findByUserEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users find(int id) {
		try(Connection conn = DataConnection.getConnection())  
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
			{
            	Users users = new Users(id, rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("phone"));
            	System.out.println(users);
            	return users;
            	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Users> authentication(String email, String password) {
		List data = new ArrayList();
		try(Connection connection = DataConnection.getConnection()) 
		{
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users where email=? AND password=?");
			//stmt.setInt(1, email);
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet results = stmt.executeQuery();
			if(results.next())
			{
				Users users = new Users(results.getInt("id"), results.getString("firstname"), results.getString("lastname"), results.getString("email"), results.getString("email"), results.getString("password"), results.getDate("created_at"), results.getDate("updated_at"));
				data.add(users);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	private static class SingletonHelper
    {
        private static final ImplUsers INSTANCE = new ImplUsers();
    }

	public static UsersDao getInstance() {
		return SingletonHelper.INSTANCE;
	}

}
