
public class PrintAndMoveWord implements Runnable {

	//Pick a word as the target content
	String wordToBePrinted = pickWords(Target.wordBank);
	
	/**This part are used as handling the multithread, need to copy to the class that handles printing and moving the word*/
	
	/** These need to be in the main class for handling these thread*/
	//Create a thread array to manage all the array
	public static Thread[] wordThreadArray = new Thread[500];
	//Create an array to store all the word comntent that each thread are dealing with
	public static String[] wordOnEachThread = new String[500];
	
	//Create task
	Runnable printMove = new PrintAndMoveWord();
	
	/**These 2 parts of the code should run everytime a word is printed*/
	
	@Override
	public void run() {
		
		//Create a new Target object
		Target word = new Target(wordToBePrinted);
		
		//Put words inside the words on screen array
		for (int i = 0; i < Target.wordsOnScreen.length; i++) {
			if (Target.onScreenWordsOccupied[i] == false) {
				Target.onScreenWordsOccupied[i] = true;
				Target.wordsOnScreen[i] = wordToBePrinted;
				break;
			}
		}
		
		//Put the word(a target object) into a Target array for managing all the word on screen
		for (int i = 0; i < Target.targetsOnScreen.length; i++) {
			if (Target.targetsOnScreen[i] == null) {
				Target.targetsOnScreen[i] = word;
			}
		}
		
		//Put the word printing task into an array (for multi thread)
		//Create thread
		Thread wordThread = new Thread(printMove); //printMove is the runnable task
		for (int i = 0; i < wordThreadArray.length; i++) {
			if (wordThreadArray[i] == null) {
				wordThreadArray[i] = wordThread;
				wordOnEachThread[i] = wordToBePrinted;
				break;
			}
		}
		
		//Start thread
		wordThread.start();
		
		//print the word onto the screen (animation, any function that I can call to start the printing?)

	}
	
	//Picking the word to be printed randomly from the word bank
	public static String pickWords(String[] wordBank) {
		//Generate a random number from 0 to 499
		int randomIndex = (int) (Math.random() * 500);
		return wordBank[randomIndex];
		
	}
	


	

}
