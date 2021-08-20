package main.java.vr.voter_reg.Controller;

import main.java.vr.voter_reg.main.DoTask;

public class LoginAdminController implements Controller {

	@Override
	public void doSomething() {
		DoTask.getInstance().callView("LoginAdmin");
		
	}

}
