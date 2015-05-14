package mech;

import java.util.*;

import part.part;

//the player's avatar. This class handles the mech's construction, handles firing, targeting, etc. No where near done.
public class mech{
	
	 //contains mechparts
	 private ArrayList<part> mechFrame= new ArrayList<part>();
	 
	 //contains player's inventory
	 private ArrayList<part> mechInventory=new ArrayList<part>();
	 
	 private int power;
	 
	 private int powerGen;
	 
	 public mech(){
		 
	 }
	 

	 
	 public void use(){
		 //uses a device or part
	 }



	public ArrayList<part> getMechFrame() {
		return mechFrame;
	}



	public void setMechFrame(ArrayList<part> mechFrame) {
		this.mechFrame = mechFrame;
	}



	public ArrayList<part> getMechInventory() {
		return mechInventory;
	}



	public void setMechInventory(ArrayList<part> mechInventory) {
		this.mechInventory = mechInventory;
	}
	 
	 //need save load
	 
	 
	
}