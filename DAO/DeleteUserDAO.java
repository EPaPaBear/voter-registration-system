package main.java.vr.voter_reg.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.java.vr.voter_reg.DTO.DTO;
import main.java.vr.voter_reg.main.ConnectDBSingleton;

public class DeleteUserDAO implements DAO {
	
	private String del = "DELETE FROM voter_register.voter WHERE voterid = ?";

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
		
		try(Connection conn = connect(); PreparedStatement ptmt = conn.prepareStatement(del)){
			
			ptmt.setString(1, object.getOption());
			
			int no = ptmt.executeUpdate();
			if(no == 0) {
				return false;
			}
			else {
				return true;
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public Connection connect() throws SQLException{
		return ConnectDBSingleton.getInstance().EstablishConnection();
	}

}
