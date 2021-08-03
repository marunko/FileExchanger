package threads;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.*;

import resources.FileUpdater;
import resources.LiveLoader;

public class ThreadChecker extends Thread{
	
	 
	private FileUpdater up = new FileUpdater();
	private byte[] buffer;
	{
		try {
			buffer = up.take_bytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	
	private int check_file() throws FileNotFoundException, IOException {
		// File check info
		if(up.take_bytes().length != buffer.length) {
			buffer = up.take_bytes();
			return -1;
		}
		else return 0;
	}
	
	@Override
	public void run() {
		
		while(!LiveLoader.checker_flag) {
			
			try {
				if(check_file() == -1) {
					up.update_target_file();
				}
				else {
					continue;
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				break;
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
			
		}
	}
}
