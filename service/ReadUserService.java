package main.java.vr.voter_reg.service;

import java.util.ArrayList;

import main.java.vr.voter_reg.DAO.ReadUserDAO;

public class ReadUserService {
	
	private ReadUserDAO read;
	
	public ReadUserService() {
		read = new ReadUserDAO();
	}
	
	public ArrayList<String> readAll(){
		return read.getVoters();
	}

}
