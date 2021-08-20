package main.java.vr.voter_reg.main;

public class Admin {
	
	private String username, userID, password;
	
	public Admin(String username, String userID, String password) {
		this.username = username;
		this.userID = userID;
		this.password = password;
	}
	
	public Admin() {
	}
	
	public String getUserName() {
		return username;
	}
	
	public String getID() {
		return userID;
	}
	
	public String getPassword() {
		return password;
	}

}
