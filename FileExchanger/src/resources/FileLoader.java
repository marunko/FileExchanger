package resources;

import java.util.Scanner;

public class FileLoader {
	private static String from;
	private static String to;
	static {
		from = null; // C:\\JavaFiles\\from_file.txt
		to = null;// C:\\JavaFiles\\to_file.txt
	}
	
	public static final String get_from() {
		return from;
	}
	public static final String get_to() {
		return to;
	}
	public static final void set_from(Scanner sc) {
		System.out.println("Please enter File Path (like this: C:\\JavaFiles\\from_file.txt) Form: ");
		FileLoader.from = sc.nextLine();
		 
	}
	public static final void set_to(Scanner sc) {
		System.out.println("Please enter File Path (like this: C:\\JavaFiles\\from_file.txt) To: ");
		FileLoader.to = sc.nextLine();
	}
}
