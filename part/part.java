package part;

import java.util.ArrayList;

public class part{
	
	//Generic Variables
	
	//name of part. Arm, leg, blaster MK3, etc.
	private String partName;
	
	//unique identifier
	private int ID;
	
	//max hp
	private int maxHullPoints;
	
	//current HP
	private int hullPoints;
	
	//metric ton
	private double mass;
	
	//normal part mass
	private double nominalMass;
	
	//number of statpoints available in generation
	private int techLevel;
	
	//determines hardpoints number modifier, and also likelyhood of being hit. 
	//1=component(heat sink, vane, servo <5% chance of hit)
	//size examples below based off of a medium sized mech
	//2=small(smaller weapon, comms, small plate, low cal weapon, cockpit 10%-20%) 
	//3=medium(larger weapon, medium armour plate, 20%-35%)
	//4=large(arm, leg, primary weapon 35%-55%)
	//5=massive(torso, shield)
	private int sizeLevel;
	
	//contains hardpoints
	private ArrayList[] hardpoints=new ArrayList[5];
	
	//contains max hardpoint numbers
	private int s0;
	private int s1;
	private int s2;
	private int s3;
	private int s4;
	
	//current amount of heat
	private int heat;
	
	private double heatTolerance;
	
	private int heatThreshold;
	
	//minimum power requirment to operate at all
	private int powerRequirement;
	
	//power required normally;
	private int powerNormal;
	
	//max before part becomes overcharged
	private int maxPower;
	
	//how much power the part is being provided
	private int currentPower;
	
	private double efficency;
	
	//current list of status. Stores both debuffs and buffs.
	//private ArrayList<status> statusList= new ArrayList<status>();
	
	//used to check if the part has been completely destroyed
	private boolean existence;
/*	
	//used to display generic summary. 
	//0=nominal 1=hot 2=overheat 3=powerShortage 4=noPower/unPowered 
	//5=onFire 6=electricalsparking/arcing 7=emp/stunned 
	//8=fried/severeElectricalDamage 9=corroded 10=milddamage
	//11=mediumdamage 12=heavydamage 13=nonfunctional 14=destroyed(still repairable, just outside of battle)
	//Use to also check if something needs to be returned from statusList.
	private int statusSummary;
	
*/
	
	private boolean active=true;
		
	
	
	//Methods
	public part(){
		existence=true;
		active=true;
		efficency=1;
		heatTolerance=1;
		
	}
	
	public part(String tempName, int tempID, int tempHullPoints, int tempMaxHullPoints, double tempMass, int tempTechLevel, 
			int tempSizeLevel, int tempHeat, 
			int tempPowerNormal, int tempPowerRequirment, int tempMaxPower){
		
		partName=tempName; 
		
		ID=tempID;
		
		hullPoints=tempHullPoints;
		
		maxHullPoints=tempMaxHullPoints;
		
		mass=tempMass;
		
		techLevel=tempTechLevel;
		
		sizeLevel=tempSizeLevel;
		
		heat=tempHeat;
		
		powerNormal=tempPowerNormal;
		
		powerRequirement=tempPowerRequirment;
		
		maxPower=tempMaxPower;
		
		existence=true;
		active=true;
		efficency=1;
		heatTolerance=1;
		
		
		
	}
	
	//handles damage from weapons unshielded (no armour/shield). takeShieldedDamage handles damage from weapons when armour/shields are active.  takeHeatDamage deals with heat damage. statusEffect deals with other types of debuffs/buffs.
	public void takeDamage(int damageAmount){
		
		//does damage to hullpoints
		hullPoints=hullPoints-damageAmount;
		
		//if the amount of damage is greater than 150% the max health of the part, 
		//it is assumed the part is just blown out of existence.
		if(damageAmount>(1.5*maxHullPoints)){
			existence=false;
			System.out.println("DEBUG::CRITICAL EXISTENCE FAILURE!!!! Part " + partName + " has ceased existing due to obscene damage!");
		}
		
		//blows mass out of part (shrapnel/general destruction)
		mass=mass-generateMassRemoval(damageAmount);
		
		//no mass left, nothing remains of the part.
		if(mass<=0){
			existence=false;
			System.out.println("DEBUG::CRITICAL EXISTENCE FAILURE!!!! Part " + partName + " has ceased existing due to total anhilation of constituent matter!");
		}
	}
	
	//handles adding heat
	public void takeHeatDamage(int addHeat){
		heat=heat+addHeat;
	}
	
	//handles basic status effects NEEDS DOING
	public void handleStatusEffects(){
		
		
	}
	
	//returns an amount of mass to eject from the part;
	public double generateMassRemoval(int damageAmount){
		double remove;
		int tempSize;
		if(sizeLevel==0){
			tempSize=1;
		}
		else{
			tempSize=sizeLevel*10;
		}
		
		remove=((((damageAmount/2)/(hullPoints*mass))*100*tempSize));
		
		
		
		return remove;
	}
	
	
	
	//getter setters for int
	
	public int getID(){
		return ID;
	}
	
	public void setID(int temp){
		ID=temp;
	}
	
	public int getMaxHullPoints(){
		return maxHullPoints;
	}
	
	public void setMaxHullPoints(int temp){
		maxHullPoints=temp;
	}
	
	public int getTechLevel(){
		return techLevel;
	}
	
	public void setTechLevel(int temp){
		techLevel=temp;
	}
	
	public int getSizeLevel(){
		return sizeLevel;
	}
	
	public void setSizeLevel(int temp){
		sizeLevel=temp;
	}
	
	public int getPowerNormal(){
		return powerNormal;
	}
	
	public void setPowerNormal(int temp){
		powerNormal=temp;
	}
	
	public int getCurrentPower(){
		return currentPower;
	}
	
	public void setCurrentPower(int temp){
		currentPower=temp;
	}
	
	public int getPowerRequirment(){
		return powerRequirement;
	}
	
	public void setPowerRequirment(int temp){
		powerRequirement=temp;
	}
	
	public int getMaxPower(){
		return maxPower;
	}
	
	public void setMaxPower(int temp){
		maxPower=temp;
	}
	
	public int getHullPoints(){
		return hullPoints;
	}
	
	public void setHullPoints(int temp){
		hullPoints=temp;
	}
	
	public int getHeat(){
		return heat;
	}
	
	public void setHeat(int temp){
		heat=temp;
	}
	
	public int getHeatThreshold(){
		return heatThreshold;
	}
	
	public void setHeatThreshold(int temp){
		heatThreshold=temp;
	}
		
	//getter setter for double
	
	public double getMass(){
		return mass;
	}
	
	public void setMass(double temp){
		mass=temp;
	}
	
	public double getNominalMass(){
		return nominalMass;
	}
	
	public void setNominalMass(double temp){
		nominalMass=temp;
	}
	
	public double getEfficency(){
		return efficency;
	}
	
	public void setEfficency(double temp){
		efficency=temp;
	}
	
	public double getHeatTolerance(){
		return heatTolerance;
	}
	
	public void setHeatTolerance(double temp){
		heatTolerance=temp;
	}
	
	//setter and getters for bools
	
	public boolean getActive(){
		return active;
	}
	
	public void setActive(boolean temp){
		active=temp;
	}
	
	public boolean getExistence(){
		return existence;
	}
	
	public void setExistence(boolean temp){
		existence=temp;
	}
	
	//setter getters for strings
	
	public String getPartName(){
		return partName;
	}
	
	public void setPartName(String temp){
		partName=temp;
	}
	
	
}