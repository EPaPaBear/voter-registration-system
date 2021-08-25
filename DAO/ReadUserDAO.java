package main.java.vr.voter_reg.DAO;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.vr.voter_reg.DTO.DTO;
import main.java.vr.voter_reg.main.ConnectDBSingleton;

public class ReadUserDAO implements DAO {
	
	private final String readall = "SELECT * FROM voter_register.voter";
	private ArrayList<String> allvoters = new ArrayList<String>();
	
	
	@Override
	public String create(DTO object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void read() {
		
		try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(readall)) {
           
				while(rs.next()) {
					allvoters.add(rs.getString("voterid") + "\t" + rs.getString("idno")+ "\t" + rs.getString("voterfname")+ "\t" + rs.getString("voterlname")
					+ "\t" + rs.getDate("dob").toString()+ "\t" + rs.getString("nationality")+ "\t" + rs.getString("locations")+ "\t" + rs.getString("sex")
					+ "\t" + rs.getDate("dor").toString() + "\t" + rs.getString("pon")+ "\t" + rs.getString("physicaladd")+ "\t" + rs.getString("digitaladd"));
				}
        } 
		catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		
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
	
	public Connection connect() throws SQLException {
        return ConnectDBSingleton.getInstance().EstablishConnection();
    }
	
	public ArrayList<String> getVoters(){
		this.read();
		return allvoters;
	}

}
