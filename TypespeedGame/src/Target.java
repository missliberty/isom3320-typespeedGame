import java.lang.*;
import java.util.*;
import java.util.concurrent.*; //for multi-threading use
import java.lang.*; //for random pick use

public class Target implements Runnable {
	
	//Declare variables for the class
	public double xCor;
	public double yCor;
	public double speed; // Or duration?
	
	/** these variables might need to move to the canvas class*/
	public String[] wordsOnScreen = new String[500];
	public boolean[] onScreenWordsOccupied = new boolean[500]; /*Since onScreenWords can be repeated, it is needed to record
	all the targets on screen */
	public String[] wordBank = new String[500];
	

	//define file name for the text file to be scanned
	public static String fileName = "words.txt"; 
	
	//THIS FOR LOOP SHOULD BE INSIDE A METHOD TO REMOVE ERROR
	//Initialize the variables
	for (int i = 0; i < onScreenWordsOccupied.length; i++) {
		onScreenWordsOccupied[i] = false;
	}
	
	
	public Target() {
		// TODO Auto-generated constructor stub
	}
	
	//Override the run() method in Runnable interface
	@override
	public void run() {
	
	}
	
	//WHY MAIN HERE?
	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	//}
	
	//Scan word from the text file
	public static void scanFile() throws IOException {
		
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
	
	/** Multi threading for picking few words as target*/
	
	//Create executor for handling thread pool
	ExecutorService executor = Executors.newFixedThreadPool(3);
	
	//Submit runnable task to the executor
	executor.execute(printWord());
	executor.execute(printWord());
	executor.execute(printWord());
	
	//Close the executor
	executor.shutdown();
	
	
	//Method for printing the words
	public static void printWord() {
		String wordToBePrinted = pickWords(wordBank);
		
		//Put words inside the words on screen array
		int counter = 0;
		for (int i = 0; i < wordsOnScreen.length; i++) {
			if (onScreenWordsOccupied[i] == false) {
				onScreenWordsOccupied[i] = true;
				wordsOnScreen[i] = wordToBePrinted;
				break;
			}
		}
		
		//Print the word on the screen with a speed / duration
		
		
	}
	
	//Picking the word to be printed randomly from the word bank
	
	public static String pickWords(String[] wordBank) {
		//Generate a random number from 0 to 499
		int randomIndex = (int) (Math.random() * 500);
		reutrn wordBank[randomIndex];
		
	}
	
	//Get method for X coordinate
	public static double getXCor() {
		return xCor;
	}
	
	//Get method for Y coordinate
	public static double getYCor() {
		return yCor;
	}

}
