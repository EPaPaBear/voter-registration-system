package main.java.vr.voter_reg.service;

import main.java.vr.voter_reg.DAO.DeleteUserDAO;
import main.java.vr.voter_reg.DTO.DTO;

public class DeleteUserService {
	
	private DeleteUserDAO delete;
	
	public DeleteUserService() {
		delete = new DeleteUserDAO();
	}
	
	public boolean deleteUser(DTO object) {
		return delete.delete(object);
	}

}
