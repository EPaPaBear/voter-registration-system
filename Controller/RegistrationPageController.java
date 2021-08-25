package main.java.vr.voter_reg.Controller;

import main.java.vr.voter_reg.DTO.DTO;
import main.java.vr.voter_reg.main.DoTask;
import main.java.vr.voter_reg.service.RegisterUserService;

public class RegistrationPageController implements Controller {
	
	private RegisterUserService register;
	
	public RegistrationPageController() {
		register = new RegisterUserService();
	}

	@Override
	public void doSomething(DTO object) {
		if(object == null) {
			DoTask.getInstance().callView("RegisterUser", object);
		}
		else {
			if(object.getOption().equals("Admin")) {
				String id = register.register(object);
				if(id.equals(null)) {
					System.out.println("An error occured! Redirecting to homepage");
					DoTask.getInstance().callView("HomePage", object);
				}
				else {
					System.out.println("Registration successful! User " + object.getfName() + " voter id is " + id);
					System.out.println("Returning to homepage...");
					DoTask.getInstance().callView("HomePage", object);
				}
			}
			else {
				String voterid = register.register(object);
				System.out.println("Registration successful! Your voter's ID is " + voterid + ".\nKindly contact your administrator for further details or changes.");
				return;
			}
		}
	}

}
