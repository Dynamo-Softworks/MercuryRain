package tech;

import part.*;

import java.math.*;

//generates parts
public class tech{
	
	//biases must add to 10. bias can be negative
	public part generatePart(String name, int techLevel, int speedBias, int powerBias, int materialsBias){
		part genPart= new part();
		
		genPart.setPartName(name);
		genPart.setTechLevel(techLevel);
		
		int techPoints=(int)(25*(Math.log(10*techLevel))-49);
		
		int materialsTechPoints=techPoints*(materialsBias/10);
		int speedTechPoints=techPoints*(speedBias/10);
		int powerTechPoints=techPoints*(powerBias/10);
		
		//generate thermal properties
		genPart.setHeatThreshold(this.generateHeatThreshold(materialsTechPoints));
		genPart.setHeatTolerance(this.generateHeatTolerance(materialsTechPoints));
		
		//generate hull points
		
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
		heatStats=(100+(20*(allocatedPoints/2)));
		
		return heatStats;
	}
	
	
}