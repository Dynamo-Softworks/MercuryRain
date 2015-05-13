package status;

//These apply status effects to parts. not sure how to proceed here.
public class status{
	private int statusType;
	private String typeName;
	//0=decreasing 1=sustain 2=increasing
	private int developmentStatus=0;
	private int turnsRemaining;
	
	public status(int type, int turns){
		statusType=type;
		turnsRemaining=turns;
	}

	public status(int type){
		statusType=type;
		turnsRemaining=0;
	}
	
	public int getStatusType(){
		return statusType;
	}
	
	public int getTurnsRemaining(){
		return turnsRemaining;
	}
	
	public String getStatusName(){
		return typeName;
	}
	
	//cancels the status effect.
	public void nullify(){
		turnsRemaining=-1;
	}
	
	//lowers the turn count on the status effect by 1.	
	public void lowerTurnCount(){
		if(!(turnsRemaining<0)){
			turnsRemaining--;
		}
		else{
			System.out.println("DEBUG::Status "+ typeName +" has no turns left.");
		}
	}
	
	public void increaseTurnCount(){
		turnsRemaining++;
	}
	
	public void sustainTurnCount(){
		//empty method. Exists to help avoid confusion when handling status effects.
	}
	
	public void setDevelopmentStatus(int temp){
		developmentStatus=temp;
	}
	public int getDevelopmentStatus(){
		
		return developmentStatus;
	}
	
	
}