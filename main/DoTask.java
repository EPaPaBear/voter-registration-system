package main.java.vr.voter_reg.main;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import main.java.vr.voter_reg.Controller.Controller;
import main.java.vr.voter_reg.View.View;
import main.java.vr.voter_reg.main.ReflectionAPI;

public class DoTask {
	
	private static DoTask maintask = null;
	
	private DoTask() {
	}

	public static DoTask getInstance() {
		
		if(maintask == null)
			maintask = new DoTask();
		return maintask;
	}
	
	//Implementing a reflection API to dynamically instantiate a particular class
	
	public void callClass(String className, String thing_you_want_do) {
		//There's supposed to be a condition here, but we can slack off a bit
		
		System.out.println("Instantiating class: " + className); //Mostly controller classes
		try {
			Controller controller;
			controller = (Controller) ReflectionAPI.instantiateClass("main.java.vr.voter_reg." + className + "Controller");
			Method method = controller.getClass().getMethod(thing_you_want_do);
			method.invoke(controller);
		} 
		catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void callView(String viewName) {
		//There's supposed to be a condition here, but we can slack off a bit
		try {
			System.out.println("Instantiating class: " + viewName); //Mostly view classes
			View view = (View)ReflectionAPI.instantiateClass("main.java.vr.voter_reg.View." + viewName + "View");
			view.displayView();
			view.displayOptions();
			view.showStuff();
		} 
		catch (InstantiationException | IllegalAccessException | ExceptionInInitializerError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
