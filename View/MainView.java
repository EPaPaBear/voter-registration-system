package main.java.vr.voter_reg.View;

import java.util.*;

import main.java.vr.voter_reg.DTO.DTO;
import main.java.vr.voter_reg.main.DoTask;

public class MainView implements View{

	@Override
	public void displayView(DTO objectdata) {
		
		System.out.println("Welcome to voter's registration app");
	}

	@Override
	public void showStuff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayOptions() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select your user type\n[U] Regular voter\n[A] Administrator*");
		String usertype = scanner.nextLine();
		if(usertype.equals("U")) {
			DoTask.getInstance().callClass("RegisterUser","doSomething", null);
		}
		else DoTask.getInstance().callClass("LoginAdmin", "doSomething", null);
		scanner.close();
	}
}
