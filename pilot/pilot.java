package pilot;

public class pilot{
	
	private String name;
	
	private int kills;
	
	private int gender;
	
	private int level;
	
	private int experience;
	
	//0=Will, 1=Marksmanship, 2=CQC, 3=Piloting, 4=Engineering, 5=Initiative, 6=Luck, 7=Skill
	private int[] stats= new int[8];
	
	public pilot(String tempName, int tempGender, int will, int marksmanship, int cqc, int piloting, int engineering, 
			int initiative, int luck, int skill){
		name=tempName;
		
		kills=0;
		
		gender=tempGender;
		
		level=0;
		
		
		stats[0]=will;
		stats[1]=marksmanship;
		stats[2]=cqc;
		stats[3]=piloting;
		stats[4]=engineering;
		stats[5]=initiative;
		stats[6]=luck;
		stats[7]=skill;
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
	
}