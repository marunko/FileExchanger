package resources;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUpdater {
	
	private String from, to; 
	public FileUpdater() {
		this.from = FileLoader.get_from();
		this.to = FileLoader.get_to();
	}
	
	public byte[] take_bytes() throws FileNotFoundException, IOException {
		byte[] bytes;
		
		try(FileInputStream fs = new FileInputStream(from)){
			bytes = new byte[fs.available()];
			fs.read(bytes);
		}
		
		return bytes;
		
	}
	
	public String take_text_from_source_file() throws IOException {
			 
			byte[] bytes = take_bytes();
			try(ByteArrayInputStream bs = new ByteArrayInputStream(bytes)){
			    int s;
			    char[] ch = new char[bs.available()]; int t=0;
			    while((s=bs.read())!=-1){
			                 
			        ch[t] = (char)s; ++t;
			    }
			     
				return String.valueOf(ch);
			}
		 
	}
	
	public void update_target_file() throws IOException{
		String string = take_text_from_source_file();
		try(FileOutputStream fs = new FileOutputStream(to)){
			byte[] bytes = string.getBytes();
			fs.write(bytes);
		}
	}
}
