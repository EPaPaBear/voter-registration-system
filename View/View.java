package main.java.vr.voter_reg.View;

import main.java.vr.voter_reg.DTO.DTO;

//View contains a list of methods to be implemented by all classes that implement it

public interface View {

	public void displayView(DTO objectData);
	public void showStuff();
	public void displayOptions();
}
