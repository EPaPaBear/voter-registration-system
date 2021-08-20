package main.java.vr.voter_reg.View;

import java.util.*;

public class LoginUserView implements View{

	@Override
	public void displayView() {
		Scanner register = new Scanner(System.in);
		System.out.println("Register | VOTER" + "-".repeat(15));
		System.out.println("Enter first name:");
		System.out.println("Enter last name:");
		register.close();
		
	}

	@Override
	public void showStuff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayOptions() {
		// TODO Auto-generated method stub
		
	}

}
