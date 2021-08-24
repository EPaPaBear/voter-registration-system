package main.java.vr.voter_reg.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.vr.voter_reg.DTO.DTO;

import main.java.vr.voter_reg.main.ConnectDBSingleton;

public class LoginAdminDAO implements DAO{
	
	//private final String pick = "SET search_path TO voter_register,public;";
	private final String verify_Query =  "SELECT userid, username, userpassword FROM voter_register.administrator WHERE username = ? and userpassword = ? ;";
	private String userID;
	
	@Override
	public String create(DTO object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(DTO object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(DTO object) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String verify(DTO object) {
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(verify_Query)){
			
			pstmt.setString(1, object.getUsername());
			pstmt.setString(2, object.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) 
				userID = rs.getString("userid");
			
			return userID;
		}
		catch(Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}	
	}

	public Connection connect() throws SQLException {
        return ConnectDBSingleton.getInstance().EstablishConnection();
    }
}
