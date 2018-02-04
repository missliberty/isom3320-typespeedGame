import java.lang.*;
import java.util.*;
import java.util.concurrent.*; //for multi-threading use
import java.lang.*; //for random pick use

public class Target implements Runnable {
	
	//Declare variables for the class
	public static double xCor;
	public static double yCor;
	public double duration; // duration for the target a crossing the screen (in millisecs)
	
	//Constructor 
	public Target() {
	}
	
	//Override the run() method in Runnable interface
	@Override
	public void run() {
	
	}

	//moved word bank to canvas 
	
	/** Multi threading for picking few words as target*/
	
	//Create executor for handling thread pool
	ExecutorService executor = Executors.newFixedThreadPool(3);
	
	//Submit runnable task to the executor
	//executor.execute(void printWord1());
	
	//Close the executor
	//executor.shutdown();
}
