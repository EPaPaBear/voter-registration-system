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
			String voterid = register.register(object);
			System.out.println("Registration successful! Your voter's ID is " + voterid + ".\nKindly contact your administrator for further details or changes.");
			return;
		}
	}

}
