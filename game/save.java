package game;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import pilot.pilot;
import part.*;


//saves stuff to text files, right now just does Pilots.
public class save{
	
	//private PrintWriter writerPilot;
	private PrintWriter writerMech;
	//private PrintWriter writerInventory;
	
	public save(String fileHandler) throws IOException{
		//writerPilot= new PrintWriter(new File(fileHandler+"Pilot.txt"));
		writerMech= new PrintWriter(new File(fileHandler+"Mech.txt"));
		//setWriterInventory(new PrintWriter(new File(fileHandler+"Inventory.txt")));
	}
	
	public void savePilot(pilot saved) throws IOException{
		//writerPilot.println(saved.getPass());
		//writerPilot.println(saved.getName());
		//writerPilot.println(saved.getKills());
		//writerPilot.println(saved.getGender());
		//writerPilot.println(saved.getLevel());
		//writerPilot.println(saved.getExperience());
		
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		int count=0;
		while(count<8){
			//writerPilot.println(saved.getStat(count));
			count++;
		}
		
	}
	
	public void saveMechPart(part saved) throws IOException{
		 writerMech.println(saved.getPartName());
		 writerMech.println(saved.getPartType());
		 writerMech.println(saved.getTechLevel());
		 writerMech.println(saved.getSizeLevel());
		 writerMech.println(saved.getMatBias());
		 writerMech.println(saved.getPowBias());
		 writerMech.println(saved.getSpeedBias());
		 System.out.println(saved.getSeedValue());
		 writerMech.println(saved.getSeedValue());
		 System.out.println("OK2222");
	}
	public void saveMechPartDEBUG(part saved) throws IOException{
		 System.out.println(saved.getPartName());
		 System.out.println(saved.getPartType());
		 System.out.println(saved.getMatBias());
		 System.out.println(saved.getPowBias());
		 System.out.println(saved.getSpeedBias());
		 System.out.println(saved.getSeedValue());
	
	}
	public void saveMechPartTree(part saved, int iteration) throws IOException{
		ArrayList<ArrayList<part>> tree= saved.getHardpoints();
		int size=tree.size();
		int count=0, countb=0;
		saveMechPart(saved);
		while(count<size){
			System.out.println("part"+iteration);
			while(countb<tree.get(count).size()){
				saveMechPartTree(tree.get(count).get(countb), count+1);
				countb++;
			}
			count++;
		}
	}

	//public PrintWriter getWriterInventory() {
		//return writerInventory;
	//}

	//public void setWriterInventory(PrintWriter writerInventory) {
		//this.writerInventory = writerInventory;
	//}
	
	public PrintWriter getWriterMech() {
		return writerMech;
	}

	public void setWriterMech(PrintWriter writerMech) {
		this.writerMech = writerMech;
	}
	
	//public PrintWriter getWriterPilot() {
		//return writerPilot;
	//}

	//public void setWriterPilot(PrintWriter writerPilot) {
		//this.writerPilot = writerPilot;
	//}
}

