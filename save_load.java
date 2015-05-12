import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class save_load{
	private String saveFileHandler;
	
	private Scanner reader;
	
	private PrintWriter writer;
	
	public save_load(String handle) throws IOException{
		saveFileHandler=handle;
		
		reader= new Scanner(new File(saveFileHandler+".text"));
		
		writer= new PrintWriter(new File(saveFileHandler+".text"));
	}
	
	public void loadPilot() throws IOException{
		
		while(reader.hasNext()){
			
		}
		
	}
}