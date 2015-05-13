import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import pilot.pilot;

public class load{
	private String saveFileHandler;
	
	private Scanner reader;
	
	
	public load(String handle) throws IOException{
		saveFileHandler=handle;
		
		reader= new Scanner(new File(saveFileHandler+".text"));
	}
	
	public pilot loadPilot() throws IOException{
		
		
		
		String pass = null;
		
		String name=null;
		
		int kills = 0;
		
		int gender = 0;
		
		int level = 0;
		
		int experience = 0;
		
		int[]stats=new int[8];
		
		while(reader.hasNext()){
			
			pass=reader.next();
			name=reader.next();
			kills=reader.nextInt();
			gender=reader.nextInt();
			level=reader.nextInt();
			experience=reader.nextInt();
			stats[0]=reader.nextInt();
			stats[1]=reader.nextInt();
			stats[2]=reader.nextInt();
			stats[3]=reader.nextInt();
			stats[4]=reader.nextInt();
			stats[5]=reader.nextInt();
			stats[6]=reader.nextInt();
			stats[7]=reader.nextInt();
		}
		
		pilot loaded=new pilot(pass, name, kills, gender, level, experience, stats[0], stats[1], stats[2], stats[3],
				stats[4], stats[5], stats[6], stats[7]);
		
		return loaded;
	}
}