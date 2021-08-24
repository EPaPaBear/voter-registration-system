package main.java.vr.voter_reg.View;

import main.java.vr.voter_reg.DTO.DTO;

public class HomePageView implements View {
	
	//private DTO holder;

	@Override
	public void displayView(DTO objectData) {
		// TODO Auto-generated method stub
		System.out.println("Hey there!");
		System.out.println("Username: " + objectData.getUsername());
		System.out.println("UserID: " + objectData.getUserID());
		System.out.println("This is all I could do for today. Will continue tomorrow");
	}

	@Override
	public void showStuff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayOptions() {
		// TODO Auto-generated method stub
		System.out.println("Exiting...");
		return;
		
	}

}
