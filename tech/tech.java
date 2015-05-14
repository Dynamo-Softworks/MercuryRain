package tech;

import part.*;



//generates parts
public class tech{
	
	long partID_Counter;
	materialsLibrary lib = new materialsLibrary();
	
	public tech(){
		
	}
	
	//biases must add to 10. bias can be negative
	public part generatePart(String name, int size, int techLevel, int speedBias, int powerBias, int materialsBias, int materialCode){
		part genPart= new part();
		//part type. change based on the type of part being generated.
		genPart.setPartType("part");
		
		//base seed value
		genPart.setSeedValue(Math.random());
		
		genPart.setPartName(name);
		genPart.setTechLevel(techLevel);
		genPart.setSizeLevel(size);
		genPart.setMaterial(lib.getMaterial(materialCode));
		genPart.setMaterialCode(materialCode);
		
		int techPoints=(int)(25*(Math.log(10*techLevel))-49);
		
		//divie up the points
		double materialsTechPoints=techPoints*materialsBias/100;
		double speedTechPoints=techPoints*speedBias/100;
		double powerTechPoints=techPoints*powerBias/100;
		
		//save biases for regeneration
		genPart.setPowBias(powerBias);
		genPart.setMatBias(materialsBias);
		genPart.setSpeedBias(speedBias);
		
		//generate thermal properties
		genPart.setHeatThreshold(this.generateHeatThreshold(genPart,(int) materialsTechPoints));
		genPart.setHeatTolerance(this.generateHeatTolerance((int) materialsTechPoints));
		genPart.setHeat(0);
		
		//generate hull points and mass
		genPart.setNominalMass(this.generateMass(genPart, (int) speedTechPoints));
		genPart.setMass(genPart.getNominalMass());
		genPart.setMaxHullPoints(this.generateHullPoints(genPart, (int) materialsTechPoints));
		genPart.setHullPoints(genPart.getMaxHullPoints());
		
		//generate basic power parameters
		genPart.setMaxPower(this.generateMaxPower(genPart, (int) powerTechPoints));
		genPart.setPowerNormal(this.generatePowerNormal(genPart));
		genPart.setPowerRequirment(this.generatePowerRequirment(genPart));
		genPart.setID(partID_Counter);
		partID_Counter++;
		
		//System.out.println("OK");
		
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
	
	public int generateHeatThreshold(part temp,int allocatedPoints){
		int heatStats;
		
		//idea being threshold is based off allocated points and material
		heatStats=(int) (temp.getMaterial().getMeltingPoint()+(20*(allocatedPoints/2)));
		
		return heatStats;
	}
	
	public double generateMass(part temp, int speedTechPoints){
		
		double nominalMass=0;
		
		//idea being mass is based off material, size, a random element, and speed points 
		double volume=(double)temp.getSizeLevel()*(temp.getSeedValue()*(1.25-.75)+.75);
		
		double density=temp.getMaterial().getDensity()-(((double)speedTechPoints)*5);
		
		nominalMass=(density*volume)/1000;
		
		return nominalMass;
	}
	
	public int generateHullPoints(part temp, int materialTechPoints){
		int hullPoints;
		
		//idea being hullPoints are based off size, material, mass, and the number of materials points
		hullPoints=(int)(materialTechPoints*temp.getSizeLevel()*temp.getMaterial().getDensity()*temp.getMass()/100);
		
		
		return hullPoints;
	}
	
	public int generateMaxPower(part temp, int powerTechPoints){
		int maxPower=0;
		
		double maxPower2=(powerTechPoints/(temp.getMaterial().getConductivity()*100000));
		//System.out.println(maxPower2);
		maxPower=(int) Math.round(maxPower2);
		//System.out.println(maxPower);
		return maxPower;
	}
	
	public int generatePowerNormal(part temp){
		int powerNormal=(int)(.5*(temp.getMaxPower()));
		return powerNormal;
	}
	
	public int generatePowerRequirment(part temp){
		int powerRequirment=(int)(.5*(temp.getPowerNormal()));
		return powerRequirment;
	}
	
	public int[] generateRandomBias(){
		int[] bias=new int[3];
		
		int bias0=100;
		int bias1=100;
		int bias2=100;
		
		while(bias0>95){
			bias0=(int)(Math.random()*100+1);
			
		}
		
		while(bias1>95-bias0){
			bias1=(int)(Math.random()*100+1);
			
		}
		
		bias2=100-bias0-bias1;
		
		double die=Math.random()*5+1;
		die=Math.round(die);
		//System.out.println(die);
		
		if(die<=2){
			bias[0]=bias0;
			bias0=bias1;
			bias1=bias2;
			//System.out.println("a");
		}
		
		else if(die<=4){
			bias[0]=bias1;
			bias1=bias2;
			//System.out.println("b");
		}
		else{
			bias[0]=bias2;
			//System.out.println("c");
		}
		
		die=Math.random()*6+1;
		die=Math.round(die);
		
		if(die<=3){
			bias[1]=bias1;
			bias[2]=bias0;
			//System.out.println("1");
		}
		else{
			bias[1]=bias0;
			bias[2]=bias1;
			//System.out.println("2");
		}
		
		
		
		
		return bias;
		
	}

}
	
