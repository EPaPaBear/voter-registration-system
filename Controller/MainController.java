package main.java.vr.voter_reg.Controller;

import main.java.vr.voter_reg.DTO.DTO;
import main.java.vr.voter_reg.main.DoTask;

public class MainController implements Controller{

	@Override
	public void doSomething(DTO object) {
		DoTask.getInstance().callView("Main", object);
		
	}

}
