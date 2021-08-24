package main.java.vr.voter_reg.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import main.java.vr.voter_reg.DTO.DTO;
import main.java.vr.voter_reg.main.ConnectDBSingleton;

public class RegisterUserDAO implements DAO{
	
	private final String pick = "SET search_path TO voter_register,public;";
	private final String insertion = pick + "INSERT INTO voter (voterID,idNo,voterFName,voterLName,doB,nationality,locations,sex,doR,poN,physicalAdd,digitalAdd) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
	
	public Connection connect() throws SQLException {
        return ConnectDBSingleton.getInstance().EstablishConnection();
    }

	@Override
	public String create(DTO object) {
		try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(insertion,
                Statement.RETURN_GENERATED_KEYS)) {

           pstmt.setString(1, object.getVoterID());
           pstmt.setString(2, object.getGhID());
           pstmt.setString(3, object.getfName());
           pstmt.setString(4, object.getlName());
           pstmt.setDate(5, object.getDateBirth());
           pstmt.setString(6, object.getNational());
           pstmt.setString(7, object.getLocation());
           pstmt.setString(8, object.getSex());
           pstmt.setDate(9, object.getDateReg());
           pstmt.setString(10, object.getPollno());
           pstmt.setString(11, object.getPhysaddress());
           pstmt.setString(12, object.getDigiaddress());

           pstmt.executeUpdate();
            System.out.println("User added successfully.");
            
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "ERROR!!";
        }
		return object.getVoterID();
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

	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}
	
}
