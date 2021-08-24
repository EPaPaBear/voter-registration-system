package main.java.vr.voter_reg.main;

import java.lang.reflect.InvocationTargetException;

public class ReflectionAPI {
	
	public static Object instantiateClass(String className) throws InstantiationException,IllegalAccessException,ExceptionInInitializerError {
		
			//Attempting to instantiate the class in the given string param
			try {
				return Class.forName(className).getDeclaredConstructor().newInstance();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				e.printStackTrace();
				return null;
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
}
