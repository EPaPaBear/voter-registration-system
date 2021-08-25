package main.java.vr.voter_reg.Controller;

import main.java.vr.voter_reg.DTO.DTO;
import main.java.vr.voter_reg.main.DoTask;

public class HomeOptionController implements Controller{

	@Override
	public void doSomething(DTO object) {
		
		try {
			String option = object.getOption();
			
			switch(option) {
				case "C":
					System.out.println("Creating new user...");
					DoTask.getInstance().callView("CreateUser", null);
					break;
				case "RA":
					DoTask.getInstance().callView("ReadAllUser", null);
					break;
				case "RS":
					DoTask.getInstance().callView("ReadSpecUser", null);
					break;
				case "U":
					System.out.println("To do tomorrow");
					break;
				case "D":
					System.out.println("To do tomorrow");
					break;
					default:
						System.out.println("An error occured!");
			}
		}catch(Throwable e) {
			System.out.println("You prolly fucked up somewhere.\n" + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
