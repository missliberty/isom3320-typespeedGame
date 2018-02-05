import java.io.File;
import java.io.IOException;
import java.lang.*;
import java.util.*;
import java.util.concurrent.*; //for multi-threading use

import javafx.event.ActionEvent;

import java.lang.*; //for random pick use


public class Target {
	
	//Declare variables for the class
	public double xCor;
	public double yCor;
	public double dXCor;
	public double dYCor;
	public double targetWidth;
	public String word;
	
	
	//Constructor
	public Target(String word) {
		this.word = word;
		this.xCor = Math.random()*100;//random position on screen
		this.yCor = Math.random()*100;//random position on screen
		this.targetWidth = 1;
		double theta = Math.random()*2*Math.PI;
		this.dXCor = Math.cos(theta);
		this.dYCor = Math.sin(theta);
				
	}
	
	//Setup list for loading the word database
	public static List<String> wordBank= new ArrayList<String>();

	//define file name for the text file to be scanned
	public static String fileName ="./words.txt";
   
	//Create method to update the position on screen
	public void update() {
		this.xCor += this.dXCor;
		this.yCor += this.dYCor;
	
		
		if (xCor < 0) {
			dXCor = -dXCor;
			xCor = 1;
		}
			
		if (xCor + targetWidth > 100) {
			dXCor = -dXCor;
			xCor = 99 - targetWidth;
		}
		
		if (yCor < 0) {
			dYCor = -dYCor;
			yCor = 1;
		}
			
		if (yCor > 100) {
			dYCor = -dYCor;
			yCor = 99;
		}
	}
	
	//Method to load in the word database 
	
    public static void setup() { 	
   		try {
	   		//Declare scanner to scan the words.txt file
	   		Scanner scannerForTextFile = new Scanner(new File(ClassLoader.getSystemResource("words.txt").toURI()));
	   		
	   		//Scan and put the words inside wordBank array
	   		while (scannerForTextFile.hasNextLine()) {
	   			wordBank.add(scannerForTextFile.nextLine());
	   		}
	   		
	   		//close the scanner
	   		scannerForTextFile.close();
	   		//Display if no file found
   		} catch (Exception e) {
   			wordBank.add("no");
   			wordBank.add("file");
   			wordBank.add("found");
   			wordBank.add("#loser");
   		}
   	}
    //Create a hash map to handle word matching with input
    public static Map<String, Target> targets = new HashMap<String, Target>();
    
    //Method to select the words to be displayed 
    public static void setupTargets(int numTargets) {
    		int numTargetsAdded = 0;
    		numTargets = Math.min(numTargets,  wordBank.size());
	    while(numTargetsAdded < numTargets) {
	    		Target newTarget = Target.getRandomTarget();

	    		if (targets.get(newTarget.word) == null) {
	    			targets.put(newTarget.word, newTarget);
	    			numTargetsAdded++;
	    		}
	    }
    }

    //Method to pick a random word from the loaded database
    public static Target getRandomTarget() {
	       int randomIndex = (int) (Math.floor(Math.random() * wordBank.size())); 
	       String randomWord = wordBank.get(randomIndex);
	       return new Target(randomWord);
    }
    
    //Method to return the chosen group of words when game starts 
    public static Collection<Target> getTargets() {
    		return Target.targets.values();
    	
    }
}
   
	