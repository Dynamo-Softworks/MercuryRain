package pilot;

//the Players' pilots. Stats determine dice roll modifiers.
public class pilot{
	
	private String name;
	
	private int kills;
	
	private int gender;
	
	private int level;
	
	private int experience;
	
	private String pass;
	
	//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
	private int[] stats= new int[8];
	
	//new pilot
	public pilot(String newPass, String tempName, int tempGender, int will, int marksmanship, int cqc, int piloting, int engineering, 
			int initiative, int luck, int skill){
		name=tempName;
		
		kills=0;
		
		gender=tempGender;
		
		level=0;
		
		experience=0;
		
		
		stats[0]=will;
		stats[1]=marksmanship;
		stats[2]=cqc;
		stats[3]=piloting;
		stats[4]=engineering;
		stats[5]=initiative;
		stats[6]=luck;
		stats[7]=skill;
		
		setPass(newPass);
	}
	
	//load constructor
	public pilot(String newPass, String tempName, int tempKills, int tempGender, int tempLevel, int tempExperience, 
			int will, int marksmanship, int cqc, int piloting, int engineering, 
			int initiative, int luck, int skill){
		setPass(newPass);
		
		name=tempName;
		
		kills=tempKills;
		
		gender=tempGender;
		
		level=tempLevel;
		
		experience=tempExperience;
		
		
		stats[0]=will;
		stats[1]=marksmanship;
		stats[2]=cqc;
		stats[3]=piloting;
		stats[4]=engineering;
		stats[5]=initiative;
		stats[6]=luck;
		stats[7]=skill;
		
		
	}
	//just an empty one for load
	public pilot() {
		
	}

	//need save load mechanics
	public String getName(){
		return name;
	}
	
	public void setName(String temp){
		name=temp;
	}
	
	public int getKills(){
		return kills;
	}
	
	public void setKills(int temp){
		kills=temp;
	}
	
	public int getGender(){
		return gender;
	}
	
	public void setGender(int temp){
		gender=temp;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setLevel(int temp){
		level=temp;
	}
	
	public int getExperience(){
		return experience;
	}
	
	public void setExperience(int temp){
		experience=temp;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String tempPass) {
		pass = tempPass;
	}
	
	public int[] getStats(){
		return stats;
	}
	public int getStat(int temp){
		return stats[temp];
	}
	
	public void setStats(int temp0, int temp1, int temp2, int temp3, int temp4, int temp5, int temp6, int temp7)
	{
		stats[0]=temp0;
		stats[1]=temp1;
		stats[2]=temp2;
		stats[3]=temp3;
		stats[4]=temp4;
		stats[5]=temp5;
		stats[6]=temp6;
		stats[7]=temp7;
	}
	public int getWill(){
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		return stats[0];
	}
	
	public void setWill(int temp){
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		stats[0]=temp;
	}
	
	public int getMarksmanship(){
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		return stats[1];
	}
	
	public void setMarksmanship(int temp){
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		stats[1]=temp;
	}
	
	public int getCQC(){
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		return stats[2];
	}
	
	public void setCQC(int temp){
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		stats[2]=temp;
	}
	
	public int getPiloting(){
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		return stats[3];
	}
	
	public void setPiloting(int temp){
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		stats[3]=temp;
	}
	
	public int getEngineering(){
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		return stats[4];
	}
	
	public void setEngineering(int temp){
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		stats[4]=temp;
	}
	
	public int getInitiative(){
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		return stats[5];
	}
	
	public void setInitiative(int temp){
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		stats[5]=temp;
	}
	
	public int getLuck(){
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		return stats[6];
	}
	
	public void setLuck(int temp){
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		stats[6]=temp;
	}
	
	public int getSkill(){
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		return stats[7];
	}
	
	public void setSkill(int temp){
		//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
		stats[7]=temp;
	}
	
	
	
}