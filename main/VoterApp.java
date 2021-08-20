package main.java.vr.voter_reg.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VoterApp {

	public static void main(String[] args) {
		VoterApp administrate = new VoterApp();
		Admin admin = new Admin("Ebo", "1234567899876543", "Ebopassword");
		
		long id = administrate.insertAdmin(admin);
		
		System.out.println(String.format("%s | %s has been added as admin with id %s", admin.getUserName(),admin.getID(),id));
		
	}
	
	public long insertAdmin(Admin admin) {
        String SQL = "SET search_path TO voter_register,public; INSERT INTO administrator(userid,username,userpassword) VALUES(?,?,?);";

        long id = 0;

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, admin.getID());
            pstmt.setString(2, admin.getUserName());
            pstmt.setString(3, admin.getPassword());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
	
	public Connection connect() throws SQLException {
        return ConnectDBSingleton.getInstance().EstablishConnection();
    }
}
