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
		    System.out.println("Enter num 1 to start Exchange or other number to exit: ");
		     
		    int res = sc.nextInt();
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
	}
	private void openStream() {
		ThreadChecker tc = new ThreadChecker();
		tc.start();
	}
	
	private void closeStream() {
		LiveLoader.checker_flag = true;
	}
	
	
}
