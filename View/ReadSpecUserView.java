package main.java.vr.voter_reg.View;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.vr.voter_reg.DTO.DTO;
import main.java.vr.voter_reg.main.DoTask;
import main.java.vr.voter_reg.service.ReadUserService;

public class ReadSpecUserView implements View{
	
	ArrayList<String> data = new ArrayList<String>();

	@Override
	public void displayView(DTO objectData) {
		
		try {
			this.setAllVoters();
			System.out.println("Search for specific voter:" + "\n" + "=".repeat(15));
			System.out.println("Enter voter ID:");
			Scanner scanner = new Scanner(System.in);
			String voterid = scanner.nextLine();
			
			int searchres = getIndexOfSearch(data,voterid);
			
			if(searchres == -1) {
				System.out.println("Search terminated. The id you entered could not be located. Please try a different id");
				DoTask.getInstance().callView("ReadSpecUser", objectData);
				scanner.close();
			}
			else {
				System.out.println("ID entry found!");
				System.out.println(data.get(searchres));
			}
		}
		catch(Exception e) {
			System.out.println("Hollup...An error occured\n" + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void showStuff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayOptions() {
		
		try {
			System.out.println("Done! Would you like to [F]ind another user\nDisplay [A]ll users\n[E]xit to homepage");
			Scanner sear = new Scanner(System.in);
			String opt = sear.nextLine();
			
			switch(opt) {
				case "F":
					DoTask.getInstance().callView("ReadSpecUser", new DTO());
					sear.close();
				case "A":
					DoTask.getInstance().callView("ReadAllUser", new DTO());
					sear.close();
				case "E":
				default:
					DoTask.getInstance().callView("HomePage", new DTO());
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void setAllVoters() {
		ReadUserService readall = new ReadUserService();
		data = readall.readAll();
	}
	
	public int getIndexOfSearch(ArrayList<String> list, String searchitem) {
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).contains(searchitem)) {
				return i;
			}
		}
		
		return -1;
	}
	
}
