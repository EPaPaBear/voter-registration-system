package main.java.vr.voter_reg.View;

import java.util.*;

import main.java.vr.voter_reg.DTO.DTO;
import main.java.vr.voter_reg.main.DoTask;

public class LoginAdminView implements View{
	
	private String username, password;
	
	@Override
	public void displayView(DTO objectdata) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Login | ADMINISTRATOR" + "\n" + "-".repeat(15));
			System.out.println("Enter username");
			username = scanner.nextLine();
			System.out.println("Enter password");
			password = scanner.nextLine();
			DTO admin = new DTO(username, null, password);
			DoTask.getInstance().callClass("HomePageAdmin", "doSomething", admin);
			scanner.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void showStuff() {
		// There's nothing to show
		
	}

	@Override
	public void displayOptions() {
		// We just gotta sign in is all, we've got nothing to show for now.
		
	}
	
}
