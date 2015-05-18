package mech;

import java.util.*;

import part.*;
import part.core.*;
import part.utility.*;

//the player's avatar. This class handles the mech's construction, handles firing, targeting, etc. No where near done.
public class mech{
	
	 //contains mechparts
	 private frame mechFrame= new frame();
	 
	 //contains player's inventory
	 private ArrayList<part> mechInventory=new ArrayList<part>();
	 
	 private int power;
	 
	 private int powerGen;
	 
	 public mech(){
		 
	 }
	 

	 
	 public void use(){
		 //uses a device or part
	 }



	public part getMechFrame() {
		return mechFrame;
	}



	public void setMechFrame(frame mechFrame) {
		this.mechFrame = mechFrame;
	}



	public ArrayList<part> getMechInventory() {
		return mechInventory;
	}



	public void setMechInventory(ArrayList<part> mechInventory) {
		this.mechInventory = mechInventory;
	}
	
	public void addToFrame(part temp){
		this.mechInventory.add(temp);
	}
	
	public void removeFromFrame(part temp){
		
	}
	
	public void searchFrame(part temp){
		
		int size=this.mechFrame.getHardpoints().size();
		int count=0;
		boolean check=false;
		
		while(count<size && check==false){
			
			
		}
		
		
	}
	
	public void searchFrame(String temp){
		
	}
	 
	 //need save load
	 
	 
	
}