package resources;

import java.io.FileNotFoundException;
import java.io.IOException;

import threads.ThreadChecker;

public class LiveLoader {
	
	public static boolean checker_flag = false; // change to true to drop related threads
	public static void main(String[] args) {
		 Menu menu =new Menu();
		 menu.Running();
	}
	 
}
