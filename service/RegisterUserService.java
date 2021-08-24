package main.java.vr.voter_reg.service;

import main.java.vr.voter_reg.DAO.RegisterUserDAO;
import main.java.vr.voter_reg.DTO.DTO;

public class RegisterUserService {
	
	private RegisterUserDAO reg;
	
	public RegisterUserService() {
		reg = new RegisterUserDAO();
	}
	
	public String register(DTO user) {
		return reg.create(user);	
	}

}
