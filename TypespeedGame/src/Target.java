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
	public String word;
	public boolean isRendered;
	
	
	//Constructor
	public Target(String word) {
		this.word = word;
		this.xCor = Math.random()*480;
		this.yCor = Math.random()*480;
		double theta = Math.random()*2*Math.PI;
		this.dXCor = Math.cos(theta);
		this.dYCor = Math.sin(theta);
		this.isRendered = false;
				
	}
	
	public double duration; // duration for the target a crossing the screen (in millisecs)
	public boolean isPaused;

    
	public static List<String> wordBank= new ArrayList<String>();
    public static String[] wordsOnScreen = new String[10];

	//define file name for the text file to be scanned
	public static String fileName ="/tmp/words.txt";
    
	public void handle(ActionEvent event){
      
     //Make the shooter appear if one word is paused/matched 
     //Make the bullet move + play sound
     //Show explosion + play sound
		
}
	public void update() {
		
		this.xCor += this.dXCor;
		this.yCor += this.dYCor;
	}
	
    public static void setup() { 	
   		try {
	   		//Declare scanner to scan the words.txt file
	   		Scanner scannerForTextFile = new Scanner(new File(fileName));
	   		
	   		//Scan and put the words inside wordBank array
	   		
	   		while (scannerForTextFile.hasNextLine()) {
	   			wordBank.add(scannerForTextFile.nextLine());
	   	
	   		}
	   		
	   		//close the scanner
	   		scannerForTextFile.close();
   		} catch (IOException e) {
   			wordBank.add("no");
   			wordBank.add("file");
   			wordBank.add("found");
   			wordBank.add("#loser");
   		}
   	}
    
    
    public static Map<String, Target> targets = new HashMap<String, Target>();
    
    public static void setupTargets(int numTargets) {
	    for(int i = 0; i < numTargets; i++) {
	    		Target newTarget = Target.getRandomTarget();
	    		targets.put(newTarget.word, newTarget);
	    		
	    }
    }

    public static Target getRandomTarget() {
	       int randomIndex = (int) (Math.floor(Math.random() * wordBank.size())); 
	       String randomWord = wordBank.get(randomIndex);
	       return new Target(randomWord);
    }
    
    public static Collection<Target> getTargets() {
    		return Target.targets.values();
    	
    }
}
   
	