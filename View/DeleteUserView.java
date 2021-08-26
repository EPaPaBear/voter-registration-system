package main.java.vr.voter_reg.View;

import java.util.Scanner;

import main.java.vr.voter_reg.DTO.DTO;
import main.java.vr.voter_reg.main.DoTask;
import main.java.vr.voter_reg.service.DeleteUserService;

public class DeleteUserView implements View{
	
	private DeleteUserService del = new DeleteUserService();
	private boolean toknow = false;
	
	@Override
	public void displayView(DTO objectData) {
		System.out.println("Hello there! Want to delete a registered voter?");
		System.out.println("Enter the voter id:");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		
		if(!id.equals(null)) {
			objectData.setOption(id);
			toknow = this.deleteUserServ(objectData);
			if(toknow) {
				System.out.println("User deleted successfully!" + toknow);
				System.out.println("Delete [a]nother?");
				String another = scanner.nextLine();
				if(another.equals("a")) DoTask.getInstance().callView("DeleteUser", objectData);
				else {
					System.out.println("You pressed another button. Redirecting to homepage");
					DoTask.getInstance().callView("HomePage", objectData);
				}
			}
			else {
				System.out.println("Couldn't delete voter. Something went wrong. Try again");
				 DoTask.getInstance().callView("DeleteUser", objectData);
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
	
	public boolean deleteUserServ(DTO object) {
		return del.deleteUser(object);
	}

}
