package main.java.vr.voter_reg.View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import main.java.vr.voter_reg.DTO.DTO;
import main.java.vr.voter_reg.main.DoTask;

public class HomePageView implements View {
	
	private String adminopt;
	private DTO adminuser = new DTO();

	@Override
	public void displayView(DTO objectData) {
		try {
			Properties session = readprops("AdminSession.properties");
			objectData.setUsername(session.getProperty("Username"));
			objectData.setUserID(session.getProperty("Userid"));
			
			System.out.println("Hey there Admin " + objectData.getUsername() + ", ID: " + objectData.getUserID());
			adminuser.setUsername(objectData.getUsername());
			adminuser.setUserID(objectData.getUserID());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showStuff() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("resource")
	@Override
	public void displayOptions() {
		
		try {
			Scanner scanner  = new Scanner(System.in);
			System.out.println("Would you like to \n[C]reate new user\n[R]ead user info\n[U]pdate user info\n[D]elete a user\n[E]xit");
			adminopt = scanner.nextLine();
			
			switch(adminopt) {
				case "C":
					adminuser.setOption("C");
					DoTask.getInstance().callClass("HomeOption", "doSomething", adminuser);
					scanner.close();
					break;
				case "R":
					System.out.println("Display [A]ll users\nFind [S]pecific user");
					adminopt = scanner.nextLine();
					adminuser.setOption("R" + adminopt);
					DoTask.getInstance().callClass("HomeOption", "doSomething", adminuser);
					scanner.close();
					break;
				case "U":
					adminuser.setOption("U");
					DoTask.getInstance().callClass("HomeOption", "doSomething", adminuser);
					scanner.close();
					break;
				case "D":
					adminuser.setOption("D");
					DoTask.getInstance().callClass("HomeOption", "doSomething", adminuser);
					scanner.close();
					break;
				case "E":
					System.out.println("Exiting...");
					return;
				default:
					System.out.println("Invalid option! Try again");
					this.displayOptions();
					scanner.close();
					break;
			}
		}catch(Exception e) {
				System.out.println(e.getClass() + " " + e.getCause() + ": " + e.getMessage());
				e.printStackTrace();
		}
	}
	
	public static Properties readprops(String filename) throws IOException{
		
		 FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(filename);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	      return prop;
	}

}
