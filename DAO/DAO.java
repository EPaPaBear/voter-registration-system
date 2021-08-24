package main.java.vr.voter_reg.DAO;

import main.java.vr.voter_reg.DTO.DTO;

public interface DAO{
	
	public String create(DTO object);
	public void read();
	public boolean update(DTO object);
	public boolean delete(DTO object);

}
