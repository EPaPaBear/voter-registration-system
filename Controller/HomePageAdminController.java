package main.java.vr.voter_reg.Controller;

import main.java.vr.voter_reg.DTO.DTO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

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
			
			if(userobjID.equals(null)) {
				System.out.println("Ooops! Looks like something went wrong, try again.");
				DoTask.getInstance().callView("LoginAdmin", object);
			}
			else {
				object.setUserID(userobjID);
				try {
					Properties sess = new Properties();
					sess.setProperty("Username",object.getUsername());
					sess.setProperty("Userid", object.getUserID());
					FileOutputStream output = new FileOutputStream("AdminSession.properties");
					sess.store(output, "Current admin session details");
					System.out.println("Login Success!");
					object.setUserID(userobjID);
					DoTask.getInstance().callView("HomePage", object);
					
				}catch(IOException e) {
					System.out.println("An error occured.");
					e.printStackTrace();
				}
			}
		}
		else {
			DoTask.getInstance().callView("LoginAdmin", object);
		}
		
	}

}
