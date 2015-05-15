package game;

import java.io.IOException;
import java.util.Scanner;

import game.save;
import mech.*;
import part.*;
import tech.*;


//pre-game, mechs are built. Also for playing with the part generator.
public class buildLoop{
	
	//determines where the parts here will be saved
	String save;
	
	//Determines if the build loop will allow negative biases. Probably results in dumb stuff like negative mass.
	//Nathan, here you go. A variable, all for you.
	boolean stupidity;
	boolean quit=false;
	
	Scanner reader= new Scanner(System.in);
	String command;
	
	public buildLoop(boolean stup, String hand) throws IOException{
		
		save partSave=new save(hand);
		tech partGen=new tech();
		part temp=new part();
		
		while(quit==false){
			System.out.println("SYSTEM: ENTER NEW COMMAND");
			
			command=(reader.nextLine()).toLowerCase();
			
			if(command.equals("quit")){
				quit=true;
			}
			
			else if(command.equals("help")){
				System.out.println("");
				System.out.println("");
				System.out.println("SYSTEM: HELP ENGAGED");
				System.out.println("SYSTEM: 'QUIT' TO QUIT");
				System.out.println("SYSTEM: 'BUILD' TO CREATE A PART");
			}
			
			else if(command.equals("build")){
				System.out.println("SYSTEM: ENTER PART NAME");
				String name=(reader.nextLine()).toLowerCase();
				
				System.out.println("SYSTEM: ENTER PART SIZE [0-4]");
				int size=(reader.nextInt());
				
				System.out.println("SYSTEM: ENTER PART TECH LEVEL (ANY INTEGER)");
				int tech=(reader.nextInt());
				
				int biast=0;
				
				while(biast!=100){
				
					System.out.println("SYSTEM: ENTER PART MATERIAL BIAS (BIASES MUST ADD TO 100 [THERE ARE THREE BIASES])");
					int mat=(reader.nextInt());
					
					System.out.println("SYSTEM: ENTER PART POWER BIAS (BIASES MUST ADD TO 100)");
					int pow=(reader.nextInt());
					
					System.out.println("SYSTEM: ENTER PART SPEED BIAS (BIASES MUST ADD TO 100)");
					int speed=(reader.nextInt());
					
					biast=mat+pow+speed;
					if(biast!=100){
						System.out.println("ERROR: BIASES MUST ADD TO 100");
					}
					else{
						System.out.println("SYSTEM: GENERATING PART");
						temp=partGen.generatePart(name, size, tech, speed, pow, mat, 0);
					}
				}
					
				System.out.println("SYSTEM: GENERATING PART");
					
					
				System.out.println("SYSTEM: SAVING PART");
					
				partSave.saveMechPart(temp);
					
				System.out.println("SYSTEM: OUTPUTTING PART");
					
				temp.printAll();
					
					
				}
			}
		}
		
	
	public buildLoop(boolean stup){
		
		
			
		
		tech partGen=new tech();
		part temp=new part();
		
		while(quit==false){
			System.out.println("BUILD: ENTER NEW COMMAND");
			
			command=(reader.nextLine()).toLowerCase();
			
			if(command.equals("quit")){
				quit=true;
			}
			
			else if(command.equals("help")){
				System.out.println("");
				System.out.println("");
				System.out.println("BUILD: HELP ENGAGED");
				System.out.println("BUILD: 'QUIT' TO QUIT");
				System.out.println("BUILD: 'BUILD' TO CREATE A PART");
			}
			
			else if(command.equals("build")){
				System.out.println("BUILD: ENTER PART NAME");
				String name=(reader.nextLine()).toLowerCase();
				
				System.out.println("BUILD: ENTER PART SIZE [0-4]");
				int size=(reader.nextInt());
				
				System.out.println("BUILD: ENTER PART TECH LEVEL (ANY INTEGER)");
				int tech=(reader.nextInt());
				
				int biast=0;
				
				while(biast!=100){
				
					System.out.println("BUILD: ENTER PART MATERIAL BIAS (BIASES MUST ADD TO 100 [THERE ARE THREE BIASES])");
					int mat=(reader.nextInt());
					
					System.out.println("BUILD: ENTER PART POWER BIAS (BIASES MUST ADD TO 100)");
					int pow=(reader.nextInt());
					
					System.out.println("BUILD: ENTER PART SPEED BIAS (BIASES MUST ADD TO 100)");
					int speed=(reader.nextInt());
					
					biast=mat+pow+speed;
					if(biast!=100){
						System.out.println("ERROR: BIASES MUST ADD TO 100");
					}
					else{
						System.out.println("BUILD: GENERATING PART");
						temp=partGen.generatePart(name, size, tech, speed, pow, mat, 0);
						temp.printAll();
					}
				}
			
			}
			
		
		}
	}
}