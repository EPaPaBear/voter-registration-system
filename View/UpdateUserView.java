package main.java.vr.voter_reg.View;

import java.util.Scanner;

import main.java.vr.voter_reg.DTO.DTO;
import main.java.vr.voter_reg.main.DoTask;
import main.java.vr.voter_reg.service.UpdateUserService;

public class UpdateUserView implements View{
	
	private UpdateUserService up = new UpdateUserService();
	
	@Override
	public void displayView(DTO objectData) {
		System.out.println("Hello there! We can only update first names for now.");
		System.out.println("Enter the voter id:");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		System.out.println("Enter the new first name:");
		String newname = scanner.nextLine();
		
		if(!id.equals(null)) {
			objectData.setOption(id);
			objectData.setfName(newname);
			//this.updateFnameServ(objectData);
			if(this.updateFnameServ(objectData)) {
				System.out.println("First updated successfully!");
				System.out.println("Update [a]nother?");
				String another = scanner.nextLine();
				if(another.equals("a")) DoTask.getInstance().callView("UpdateUser", objectData);
				else {
					System.out.println("You pressed another button. Redirecting to homepage");
					DoTask.getInstance().callView("HomePage", objectData);
				}
			}
			else {
				System.out.println("Couldn't update first name. Something went wrong. Try again");
				 DoTask.getInstance().callView("UpdateUser", objectData);
			}
		}
		else this.displayView(objectData);
		
		scanner.close();	
	}

	@Override
	public void showStuff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayOptions() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean updateFnameServ(DTO object) {
		return up.updateFname(object);
	}

}
