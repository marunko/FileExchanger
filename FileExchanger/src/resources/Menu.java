package resources;

import java.util.Scanner;

import threads.ThreadChecker;

public class Menu {
	
	private Scanner sc;
	
	
	public void Running() {
		System.out.println("Start Programm");
		sc = new Scanner(System.in);
		boolean already_alive = false;
		while(LiveLoader.checker_flag == false) {
			if(FileLoader.get_from() == null && FileLoader.get_to() == null) {
				FileLoader.set_from(sc); FileLoader.set_to(sc);
				System.out.println(FileLoader.get_from() + "\n" + FileLoader.get_to());
			}
			System.out.println("Enter num 1 to start Exchange or other number to exit: ");
		     
		    int res = sc.nextInt(); if(res !=1) break;
		     
		    if(already_alive == false) {
			    if(res == 1) {
			    	openStream();
			    	 
			    }
		    }
		    else {
		    	if(res == 1) {
			    	continue;
			    }
		    }
		    if (res!=1){
		    	closeStream();
		    	break;
		    }
		    already_alive = true;
		}
		System.out.println("Exit");
	}
	private void openStream() {
		ThreadChecker tc = new ThreadChecker();
		tc.start();
	}
	
	private void closeStream() {
		LiveLoader.checker_flag = true;
	}
 
	
	
}
