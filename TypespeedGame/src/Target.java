import java.lang.*;
import java.util.*;

public class Target implements Runnable{
	
	//Declare variables for the class
	public double xCor;
	public double yCor;
	public String[] wordsOnScreen = new String[10000];
	public String[] wordBank = new String[10000];
	public double speed;
	
	
	public Target() {
		// TODO Auto-generated constructor stub
	}
	
	//Override the run() method in Runnable interface
	public void run() {
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Scan word from the text file
	public static void scanFile() throws IOException {
		//Declare scanner to scan the words.txt file
		Scanner scannerForTextFile = new Scanenr(new File(words.txt));
		
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
