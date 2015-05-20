package part;

import java.util.ArrayList;

import tech.material;

//a generic part class. These objects make up mechs. Not sure how to proceed yet though.
public class part{
	
	//Generic Variables
	
	//name of part. Arm 9000, leg 003, blaster MK3, etc.
	private String partName;
	
	private String partType;
	
	private int matBias;
	private int powBias;
	private int speedBias;
	private double seedValue;
	private int materialCode;
	
	//unique identifier
	private long ID;
	
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
	private ArrayList<ArrayList<part>> hardpoints=new ArrayList<ArrayList<part>>();
	
	private ArrayList<part> hard0=new ArrayList<part>();
	private ArrayList<part> hard1=new ArrayList<part>();
	private ArrayList<part> hard2=new ArrayList<part>();
	private ArrayList<part> hard3=new ArrayList<part>();
	private ArrayList<part> hard4=new ArrayList<part>();
	
	
	
	//contains max hardpoint numbers
	private int hardPointLimit0;
	private int hardPointLimit1;
	private int hardPointLimit2;
	private int hardPointLimit3;
	private int hardPointLimit4;
	
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
	private material material;
	
	private boolean active=true;
		
	
	
	//Methods
	public part(){
		existence=true;
		active=true;
		efficency=1;
		heatTolerance=1;
		hardpoints.add(0, hard0);
		hardpoints.add(1, hard1);
		hardpoints.add(2, hard2);
		hardpoints.add(3, hard3);
		hardpoints.add(4, hard4);
		
	}
	
	public part(String tempName, long tempID, int tempHullPoints, int tempMaxHullPoints, double tempMass, int tempTechLevel, 
			int tempSizeLevel, int tempHeat, 
			int tempPowerNormal, int tempPowerRequirment, int tempMaxPower, material tempMaterial, int tempCode){
		
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
		
		material=tempMaterial;
		materialCode=tempCode;
		
		hardpoints.add(0, hard0);
		hardpoints.add(1, hard1);
		hardpoints.add(2, hard2);
		hardpoints.add(3, hard3);
		hardpoints.add(4, hard4);
		
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
	
	public long getID(){
		return ID;
	}
	
	public void setID(long partID_Counter){
		ID=partID_Counter;
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

	public material getMaterial() {
		return material;
	}

	public void setMaterial(material material) {
		this.material = material;
	}

	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}

	public int getMatBias() {
		return matBias;
	}

	public void setMatBias(int matBias) {
		this.matBias = matBias;
	}

	public int getPowBias() {
		return powBias;
	}

	public void setPowBias(int powBias) {
		this.powBias = powBias;
	}

	public int getSpeedBias() {
		return speedBias;
	}

	public void setSpeedBias(int speedBias) {
		this.speedBias = speedBias;
	}

	public double getSeedValue() {
		return seedValue;
	}

	public void setSeedValue(double d) {
		this.seedValue = d;
	}

	public int getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(int materialCode) {
		this.materialCode = materialCode;
	}

	public ArrayList<ArrayList<part>> getHardpoints() {
		return hardpoints;
	}

	public void setHardpoints(ArrayList<ArrayList<part>> hardpoints) {
		this.hardpoints = hardpoints;
	}

	public int getHardPointLimit0() {
		return hardPointLimit0;
	}

	public void setHardPointLimit0(int hardPointLimit0) {
		this.hardPointLimit0 = hardPointLimit0;
	}

	public int getHardPointLimit1() {
		return hardPointLimit1;
	}

	public void setHardPointLimit1(int hardPointLimit1) {
		this.hardPointLimit1 = hardPointLimit1;
	}

	public int getHardPointLimit2() {
		return hardPointLimit2;
	}

	public void setHardPointLimit2(int hardPointLimit2) {
		this.hardPointLimit2 = hardPointLimit2;
	}

	public int getHardPointLimit3() {
		return hardPointLimit3;
	}

	public void setHardPointLimit3(int hardPointLimit3) {
		this.hardPointLimit3 = hardPointLimit3;
	}

	public int getHardPointLimit4() {
		return hardPointLimit4;
	}

	public void setHardPointLimit4(int hardPointLimit4) {
		this.hardPointLimit4 = hardPointLimit4;
	}
	
	public void printAll(){
		System.out.println("Name: "+getPartName());
		System.out.println("Type: "+getPartType());
		System.out.println("Size Level: "+getSizeLevel());
		System.out.println("Tech Level: "+getTechLevel());
		System.out.println("Hull Points: "+getHullPoints());
		System.out.println("Max Hull Points: "+getMaxHullPoints());
		System.out.println("Mass: "+getMass());
		System.out.println("Nominal Mass: "+getNominalMass());
		System.out.println("Heat Threshold: "+getHeatThreshold());
		System.out.println("Heat Tolerance: "+getHeatTolerance());
		System.out.println("Max Power: "+getMaxPower());
		System.out.println("Normal Power: "+getPowerNormal());
		System.out.println("Minimum Power: "+getPowerRequirment());
		System.out.println("");
		System.out.println("Material Values");
		getMaterial().printAll();
	}
	
	public void printAllDEBUG(){
		System.out.println("Name: "+getPartName());
		System.out.println("Type: "+getPartType());
		System.out.println("Size Level: "+getSizeLevel());
		System.out.println("Tech Level: "+getTechLevel());
		System.out.println("Hull Points: "+getHullPoints());
		System.out.println("Max Hull Points: "+getMaxHullPoints());
		System.out.println("Mass: "+getMass());
		System.out.println("Nominal Mass: "+getNominalMass());
		System.out.println("Heat Threshold: "+getHeatThreshold());
		System.out.println("Heat Tolerance: "+getHeatTolerance());
		System.out.println("Max Power: "+getMaxPower());
		System.out.println("Normal Power: "+getPowerNormal());
		System.out.println("Minimum Power: "+getPowerRequirment());
		System.out.println("");
		System.out.println("Material Values");
		getMaterial().printAll();
		System.out.println("");
		System.out.println("Debug Values");
		System.out.println("Seed Value: "+getSeedValue());
		System.out.println("Material Bias: "+getMatBias());
		System.out.println("Power Bias: "+getPowBias());
		System.out.println("Speed Bias: "+getSpeedBias());
		System.out.println("Material Code: "+getMaterialCode());
		
		
	}
	
	public void printDEBUG(){
		System.out.println("Seed Value: "+getSeedValue());
		System.out.println("Material Bias: "+getMatBias());
		System.out.println("Power Bias: "+getPowBias());
		System.out.println("Speed Bias: "+getSpeedBias());
		System.out.println("Material Code: "+getMaterialCode());
	}
	
	public part searchHardPoints(String name){
		part temp= new part();
		
		int size= this.hardpoints.size();
		int sizea;
		int count=0;
		int counta=0;
		
		boolean check=false;
		
		while(count<size && check==false){
			
			sizea=hardpoints.get(count).size();
			while(counta<sizea && check==false){
				if(hardpoints.get(count).get(counta).getPartName().equals(name)){
					
				}
				
				counta++;
			}
			
			count++;
		}
		
		return temp;
	}

	public ArrayList<part> getHard0() {
		return hardpoints.get(0);
	}

	public void setHard0(ArrayList<part> hard0) {
		this.hard0 = hard0;
	}
	
	public part getHard0Part(int temp) {
		return hardpoints.get(0).get(temp);
	}

	public ArrayList<part> getHard1() {
		return hardpoints.get(1);
	}
	
	public part getHard1Part(int temp) {
		return hardpoints.get(1).get(temp);
	}

	public void setHard1(ArrayList<part> hard1) {
		hardpoints.remove(1);
		 hardpoints.add(1, hard1);
	}

	public ArrayList<part> getHard2() {
		return hardpoints.get(2);
	}
	
	public part getHard2Part(int temp) {
		return hardpoints.get(2).get(temp);
	}

	public void setHard2(ArrayList<part> hard2) {
		hardpoints.remove(2);
		 hardpoints.add(2, hard2);
	}

	public ArrayList<part> getHard3() {
		return hardpoints.get(3);
	}
	
	public part getHard3Part(int temp) {
		return hardpoints.get(3).get(temp);
	}

	public void setHard3(ArrayList<part> hard3) {
		hardpoints.remove(3);
		 hardpoints.add(3, hard3);
	}

	public ArrayList<part> getHard4() {
		return hardpoints.get(4);
	}
	
	public part getHard4Part(int temp) {
		return hardpoints.get(4).get(temp);
	}

	public void setHard4(ArrayList<part> hard4) {
		 hardpoints.remove(4);
		 hardpoints.add(4, hard4);
	}
	
	
	
	
}