package main.java.vr.voter_reg.Controller;

import main.java.vr.voter_reg.DTO.DTO;
import main.java.vr.voter_reg.main.DoTask;
import main.java.vr.voter_reg.service.LoginAdminService;

public class HomePageAdminController implements Controller {
	
	private LoginAdminService loginadmin;
	
	public HomePageAdminController() {
		loginadmin = new LoginAdminService();
	}

	@Override
	public void doSomething(DTO object) {
		if(object != null) {
			
			String userobjID = loginadmin.login(object);
			object.setUserID(userobjID);
			
			DoTask.getInstance().callView("HomePage", object);
		}
		else {
			DoTask.getInstance().callView("LoginAdmin", object);
		}
		
	}

}
