package main.java.vr.voter_reg.service;

import main.java.vr.voter_reg.DAO.LoginAdminDAO;
import main.java.vr.voter_reg.DTO.DTO;

public class LoginAdminService {
	
	private LoginAdminDAO loginto;
	
	public LoginAdminService() {
		loginto = new LoginAdminDAO();
	}
	
	public String login(DTO adminobj) {
		return loginto.verify(adminobj);
	}
}
