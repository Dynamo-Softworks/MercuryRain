package tech;

import part.*;

import java.math.*;

//generates parts
public class tech{
	
	long partID_Counter;
	
	//biases must add to 10. bias can be negative
	public part generatePart(String name, int size, int techLevel, int speedBias, int powerBias, int materialsBias){
		part genPart= new part();
		
		genPart.setPartName(name);
		genPart.setTechLevel(techLevel);
		genPart.setSizeLevel(size);
		
		int techPoints=(int)(25*(Math.log(10*techLevel))-49);
		
		//divie up the points
		int materialsTechPoints=techPoints*(materialsBias/10);
		int speedTechPoints=techPoints*(speedBias/10);
		int powerTechPoints=techPoints*(powerBias/10);
		
		//generate thermal properties
		genPart.setHeatThreshold(this.generateHeatThreshold(materialsTechPoints));
		genPart.setHeatTolerance(this.generateHeatTolerance(materialsTechPoints));
		genPart.setHeat(0);
		
		//generate hull points and mass
		genPart.setNominalMass(this.generateMass(genPart, speedTechPoints));
		genPart.setMass(genPart.getNominalMass());
		genPart.setMaxHullPoints(this.generateHullPoints(genPart, materialsTechPoints));
		
		//generate basic power parameters
		
		
		partID_Counter++;
		
		return genPart;
		
		
		
	}
	
	public double generateHeatTolerance(int allocatedPoints){
		
		double heatStats;
		double points=allocatedPoints;
		
		heatStats=(1.0-(.01*points));
		
		//if the part is impervious to heat, -1 is used as a tag so that special heat weapons can still be used.
		if(heatStats<=0){
			heatStats=-1;
		}
		return heatStats;
	}
	
	public int generateHeatThreshold(int allocatedPoints){
		int heatStats;
		
		//idea being threshold is based off allocated points and material
		heatStats=(100+(20*(allocatedPoints/2)));
		
		return heatStats;
	}
	
	public double generateMass(part temp, int speedTechPoints){
		
		double nominalMass=0;
		
		//idea being mass is based off material, size, a random element, and speed points 
		double volume=(double)temp.getSizeLevel()*(Math.random()*(1.25-.75)+.75);
		
		double density=temp.getMaterialCode()-(((double)speedTechPoints)*20);
		
		nominalMass=(density*volume)/1000;
		
		return nominalMass;
	}
	
	public int generateHullPoints(part temp, int materialTechPoints){
		int hullPoints;
		
		//idea being hullPoints are based off size, material, mass, and the number of materials points
		hullPoints=(int)((temp.getMass()*(temp.getMaterialCode()/(1/temp.getSizeLevel())*100))*materialTechPoints);
		
		
		return hullPoints;
	}
	
	public int generateMaxPower(part temp)
	
}