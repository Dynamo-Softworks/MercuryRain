package game;

import java.io.IOException;
import java.util.Scanner;


//main menu
public class mainMenu{
	
	private Scanner commandReader= new Scanner(System.in);
	
	private boolean quit=false;
	
	private String command;
	
	public mainMenu() throws InterruptedException, IOException{
		System.out.println("SYSTEM: BOOT...");
		Thread.sleep(1000);
		System.out.println("...");
		Thread.sleep(1000);
		System.out.println("...");
		Thread.sleep(1000);
		System.out.println("SYSTEM: LIFE_SUPPORT::GO!");
		Thread.sleep(500);
		System.out.println("SYSTEM: NEURO_CONTROL::GO!");
		Thread.sleep(225);
		System.out.println("SYSTEM: COCKPIT_DISPLAYS::GO!");
		Thread.sleep(1000);
		System.out.println("SYSTEM: PRIMARY SYSTEMS ONLINE");
		Thread.sleep(250);
		System.out.println("SYSTEM: LOCOMOTION::GO!");
		Thread.sleep(250);
		System.out.println("SYSTEM: COMBAT::GO!");
		Thread.sleep(250);
		System.out.println("SYSTEM: TARGETING::GO!");
		Thread.sleep(250);
		System.out.println("SYSTEM: WEAPONS::GO!");
		Thread.sleep(1000);
		System.out.println("SYSTEM: SECONDARY SYSTEMS ONLINE");
		Thread.sleep(250);
		System.out.println("SYSTEM: SENSORS::GO!");
		Thread.sleep(250);
		System.out.println("SYSTEM: ECM::GO!");
		Thread.sleep(500);
		System.out.println("SYSTEM: AI::GO!");
		Thread.sleep(1000);
		System.out.println("SYSTEM: TERTIARY SYSTEMS ONLINE");
		Thread.sleep(200);
		System.out.println("SYSTEM: DAMAGE_CONTROL::GO!");
		Thread.sleep(200);
		System.out.println("SYSTEM: HUD::GO!");
		Thread.sleep(200);
		System.out.println("SYSTEM: lIGHTING::GO!");
		Thread.sleep(200);
		System.out.println("SYSTEM: STATUS_READOUTS::GO!");
		Thread.sleep(1000);
		System.out.println("SYSTEM: ANCILLARY SYSTEMS ONLINE");
		Thread.sleep(1000);
		System.out.println("...");
		Thread.sleep(1000);
		System.out.println("SYSTEM: BOOT COMPLETE");
		System.out.println("SYSTEM: ALL SYSTEMS ONLINE");
		Thread.sleep(500);
		System.out.println("AI: Welcome, Pilot.");
		Thread.sleep(250);
		System.out.println("AI: Please make a selection. "
				+ "Type 'help' for SYSTEM to return a list of commands. Commands are case insensitive.");
		
		while(quit==false){
			command=(commandReader.nextLine()).toLowerCase();
			
			if(command.equals("quit")){
				quit=true;
			}
			else if(command.equals("help")){
				System.out.println("");
				System.out.println("");
				System.out.println("SYSTEM: HELP ENGAGED");
				System.out.println("SYSTEM: 'QUIT' TO QUIT");
				System.out.println("SYSTEM: 'BUILD' TO BUILD PARTS");
			}
			
			else if(command.equals("build")){
				System.out.println("SYSTEM: RUNNING PART BUILDER...");
				Thread.sleep(250);
				System.out.println("SYSTEM: DO YOU WISH TO USE THE PROTOTYPE EDITOR? (Y/N)");
				
				command=(commandReader.nextLine()).toLowerCase();
				boolean stupidity;
				String handle;
				
				if(command.equals("y")){
					stupidity=false;
					System.out.println("ERROR: UNABLE TO COMPLY. PROTOTYPE BUILD SOFTWARE UNAVAILABLE. DEFAULTING TO NORMAL.");
					
				}
				else{
					stupidity=false;
				}
				
				Thread.sleep(250);
				System.out.println("SYSTEM: DO YOU WISH TO SAVE PARTS TO THE LIBRARY? (Y/N)");
				
				command=(commandReader.nextLine()).toLowerCase();
				
				if(command.equals("y")){
					
					System.out.println("ERROR: READ/WRITE TEST FAILED. DEFAULTING TO NO SAVE.");
					
					
					
				}
				else{
					buildLoop build= new buildLoop(stupidity);
				}
				
				
				
				
			}
		}
		
		
	}
	
	
	
}