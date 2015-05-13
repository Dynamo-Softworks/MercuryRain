import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import pilot.pilot;

//saves stuff to text files, right now just does Pilots.
public class save{
	
	private PrintWriter writer;
	
	public save(String fileHandler) throws IOException{
		writer= new PrintWriter(new File(fileHandler+".txt"));
	}
	
	public void savePilot(pilot saved) throws IOException{
		writer.println(saved.getPass());
		writer.println(saved.getName());
		writer.println(saved.getKills());
		writer.println(saved.getGender());
		writer.println(saved.getLevel());
		writer.println(saved.getExperience());
		
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		int count=0;
		while(count<8){
			writer.println(saved.getStat(count));
			count++;
		}
		
	}
	
}

