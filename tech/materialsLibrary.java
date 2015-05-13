package tech;

import java.util.ArrayList;
import tech.material;


//I was thinking I could use this to store materials for reference, and then write a save load function
//for the library instead of creating the materials at run time. Not sure.
class materialsLibrary{
	private ArrayList<material> lib= new ArrayList<material>();
	
	//steel is the default. Thought it would always be good to have around.
	private material steel;
	
	public materialsLibrary(){
		steel=new material(8050, 1510, .466, (1.43*Math.pow(10, 7)), "steel");
		
		lib.add(steel);
		
	}
	
	public ArrayList<material> getMaterialLibrary(){
		return lib;
	}
	
	public material getMaterial(int temp){
		
		return lib.get(temp);
	}
	
	
}