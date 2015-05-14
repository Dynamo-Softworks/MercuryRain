import mech.*;
import part.*;
import pilot.*;
import status.*;

import java.io.IOException;

import tech.*;
import game.*;
import map.*;


//Runs game loop, any GUI, puts it all together.
public class mainLoop{
	
	
	public static void main(String [] args) throws IOException{
		int count=0;
		
		tech partGenerator=new tech();
		
		save mechSaver=new save("test");
		
		int[] bias= new int[3];
		
		mech testMech= new mech();
		
		
		
		while(count<10){
			bias=partGenerator.generateRandomBias();
			testMech.getMechFrame().add(partGenerator.generatePart("testComponent"+count, 0, 4, bias[0], bias[1], bias[2], 0));
			count++;
			System.out.println(count);
			
		}
		
		count=0;
		
		int countb=0;
		
		
		while(count<10)
		{
			
			while(countb<count+1){
				mechSaver.getWriterMech().print("/");
				countb++;
			}
			countb=0;
					
			mechSaver.getWriterMech().println("");
			
			mechSaver.saveMechPart(testMech.getMechFrame().get(count));
			mechSaver.saveMechPartDEBUG(testMech.getMechFrame().get(count));
			
		
			while(countb<count+1){
				mechSaver.getWriterMech().print("/");
				countb++;
			}
			
			countb=0;
			mechSaver.getWriterMech().println("");
			
			count++;
			System.out.println(count);
		
		}
		
		
		
	}

}
