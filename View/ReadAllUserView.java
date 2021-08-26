package main.java.vr.voter_reg.View;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.vr.voter_reg.DTO.DTO;
import main.java.vr.voter_reg.main.DoTask;
import main.java.vr.voter_reg.service.ReadUserService;

public class ReadAllUserView implements View{
	
	ArrayList<String> data = new ArrayList<String>();

	@Override
	public void displayView(DTO objectData) {
		this.setAllVoters();
		System.out.println("Displaying all registered voters" + "\n" + "=".repeat(15));
		for(String voters: data) {
			System.out.println(voters);
		}
		
	}

	@Override
	public void showStuff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayOptions() {
		System.out.println("Done! Would you like to [F]ind a user\n[E]xit to homepage");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.nextLine();
		
		switch(choice) {
			case "F":
				DoTask.getInstance().callView("ReadSpecUser", new DTO());
				break;
			case "E":
				System.out.println("Redirecting to homepage...");
				DoTask.getInstance().callView("HomePage", new DTO());
				break;
		}
		
		scanner.close();
		
	}
	
	public void setAllVoters() {
		ReadUserService readall = new ReadUserService();
		this.data = readall.readAll();
	}
	
}
