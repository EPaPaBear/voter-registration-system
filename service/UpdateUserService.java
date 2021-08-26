package main.java.vr.voter_reg.service;

import main.java.vr.voter_reg.DAO.UpdateUserDAO;
import main.java.vr.voter_reg.DTO.DTO;

public class UpdateUserService {
	
	private UpdateUserDAO update;
	
	public UpdateUserService() {
		update = new UpdateUserDAO();
	}
	
	public boolean updateFname(DTO object) {
		return update.update(object);
	}
}
