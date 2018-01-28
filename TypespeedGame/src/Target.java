import java.lang.*;
import java.util.*;

public class Target implements Runnable{
	
	//Declare variables for the class
	public double xCor;
	public double yCor;
	public String[] wordsOnScreen = new String[500];
	public String[] wordBank = new String[500];
	public double speed;
	
	//define file name for the text file to be scanned
	public static String fileName = "words.txt";
	
	
	public Target() {
		// TODO Auto-generated constructor stub
	}
	
	//Override the run() method in Runnable interface
	@override
	public void run() {
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
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
	
	//Get method for X coordinate
	public static double getXCor() {
		return xCor;
	}
	
	//Get method for Y coordinate
	public static double getYCor() {
		return yCor;
	}

}
