package main.java.vr.voter_reg.View;

import java.util.*;

import main.java.vr.voter_reg.DTO.DTO;

//import main.java.vr.voter_reg.main.Admin;
import main.java.vr.voter_reg.main.DoTask;

public class RegisterUserView implements View{

	@Override
	public void displayView(DTO Objectdata) {
		
		try {
			Scanner register = new Scanner(System.in);
			System.out.println("Register | VOTER" + "-".repeat(15));
			
			System.out.println("Enter first name:");
			String firstname = register.nextLine();
			System.out.println("Enter last name:");
			String lastname = register.nextLine();
			System.out.println("What is your nationality:");
			String nationality = register.nextLine();
			System.out.println("Enter your date of birth [yyyy-mm-dd]:");
			String year = register.nextLine();
			System.out.println("Enter any valid national ID:");
			String ghanaId = register.nextLine();
			System.out.println("Where do you currently reside:");
			String location = register.nextLine();
			System.out.println("[M]ale or [F]emale:");
			String sex = register.nextLine();
			System.out.println("Enter your polling station number:");
			String pollno = register.nextLine();
			System.out.println("Current physical address <optional | press 's' to skip>:");
			String physadd = register.nextLine();
			System.out.println("Current digital address [XX-DDDD]:");
			String digiadd = register.nextLine();
			
			DTO user = new DTO(firstname, lastname, nationality, year, ghanaId, location, sex, pollno, physadd, digiadd);
			
			DoTask.getInstance().callClass("RegistrationPage", "doSomething", user);
			
			register.close();
		}
		catch(Throwable e) {
			System.out.println(e.getCause() + "\nMsg: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void showStuff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayOptions() {
		//System.out.println("Your registration was successful. Contact your local admin to check your details.\n EXITING...");
		//return;
	}

}
