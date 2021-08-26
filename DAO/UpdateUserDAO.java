package main.java.vr.voter_reg.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.java.vr.voter_reg.DTO.DTO;
import main.java.vr.voter_reg.main.ConnectDBSingleton;

public class UpdateUserDAO implements DAO{
	
	private final String updateFname = "UPDATE voter_register.voter SET voterfname = ? WHERE voterid = ?;";

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
		
		try(Connection conn = connect(); PreparedStatement prep = conn.prepareStatement(updateFname)){
			
			prep.setString(1, object.getfName());
			prep.setString(2, object.getOption());
			
			prep.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(DTO object) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Connection connect() throws SQLException{
		return ConnectDBSingleton.getInstance().EstablishConnection();
	}

}
