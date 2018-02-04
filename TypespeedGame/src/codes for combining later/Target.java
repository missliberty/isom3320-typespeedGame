import java.lang.*;
import java.util.*;
import java.util.concurrent.*; //for multi-threading use
import java.lang.*; //for random pick use

public class Target {
	
	//Declare variables for the class
	public double xCor;
	public double yCor;
	public static double duration; // duration for the target acrossing the screen (in millisecs)
	public boolean isPause;
	public String content; //String content for a target
	
	/** these variables might need to move to the canvas class*/
	public static Target[] targetsOnScreen = new Target[500];
	public static boolean[] onScreenWordsOccupied = new boolean[500]; /*Since onScreenWords can be repeated, it is needed to record
	all the targets on screen */
	public static String[] wordBank = new String[500];
	

	//define file name for the text file to be scanned
	public static String fileName = "words.txt";
	
	//THIS FOR LOOP SHOULD BE INSIDE A METHOD TO REMOVE ERROR
	//Initialize the variables
	for (int i = 0; i < onScreenWordsOccupied.length; i++) {
		onScreenWordsOccupied[i] = false;
	}
	
	//Constructor for the class
	public Target(String wordContent) {
		this.content = wordContent;
	}

	//Scan word from the text file
	public static void scanFile() {
		
		//Declare scanner to scan the words.txt file
		Scanner scannerForTextFile = new Scanenr(new File(fileName));
		
		//counter for indicating the array index of each item
		public static int wordIndex = 0;
		
		//Scan and put the words inside wordBank array
		while (scannerForTextFile.hasNextLine()) {
			wordBank[wordIndex] = scannerForTextFile.nextLine();
			wordIndex++;
		}
		
		//close the scanner
		scannerForTextFile.close();
		
	}
		
	//Get method for X coordinate
	public double getXCor() {
		return xCor;
	}
	
	//Get method for Y coordinate
	public double getYCor() {
		return yCor;
	}
	
	public String getContent() {
		return content;
	}

}
