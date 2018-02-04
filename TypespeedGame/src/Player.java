
public class Player {
	
	//Declare variables for the Player class
	public String name;
	public int score;
	
	//Constructor for the class
	public Player(String playerName) {
		this.name = playerName;
	}
	
	
	/** These should be put as an event handler under the enter button */
	
	int correctCounter = 0;
	
	//Method for checking whether the input text matches the word on the screen
	public static boolean checkCorrect(String inputText, String[] wordsOnScreen) {
		for (int i = 0; i < wordsOnScreen.length; i++) {
			if (wordsOnScreen[i].equals(inputText)) {
				//Return true if the input text matches an element in the array
				score = score + inputText.length(); //Or add the score later when the shooter already finish the shooting animation?
				correctCounter++;
				return true;
			}
		}
		
		//Return false if there nothing matched in the array
		return false;
	}
	
	public static void mainCorrect (Target targetWord) {
		
		//Check whether the input is correct
		boolean isCorrect = checkCorrect(textfieldname.getText(), Target.wordsOnScreen);
	
		if (isCorrect) {
			
			//Need to write the code here!!
			//for (int i = 0; i < wordsOnScreen.length; i++)
			
			//1. Pause the animation for the word
			//2. Get the coordinates

			double xCor = targetWord.getXCor();
			double yCor = targetWord.getYcor();
			//3. remove it from the wordsOnScreen array
			
			for (int i = 0; i < wordsOnScreen.length; i++) {
				if (wordsOnScreen[i].equals(targetWord))
			}
			
			//4. Call shooter function
			Shooter shooter = new Shooter(xCor, yCor);
			shooter.showShooter();
			
			//5. check speed and increase if needed
			checkScore(targetWord);
		}
		
		//Empty the text field for next entry
		textfieldname.setText("");
	}
	
	public static void checkScore(Target target) {
		if (correctCounter = 5) {
			target.duration -= 100; //decrease the duration by 100 millisec
			correctCounter = 0;
		}
	}
	

	
	/**Leaderboard Stuff, which should be also placed in the canvas class */
	
	//Create player array for storing the name and score for all player
	//Push player data into this array when gameover
	
	Player[] players = new Player[10000];
	Player[] topThree = new Player[3];
	
	//method for sorting the top 3 players in the game
	
	public static void sortTopThree (Player[] players) {
		
		//Declare variable for storing the largest score that scanned
		int prevLargestScore = -9999;
		String prevLargestName = "";
		int maxIndex = -1;
		
		//Declare a temp array for storing the players
		Player[] tempPlayers = new Player[players.length];
		
		//Copy the data to the temp
		for (int i = 0; i < players.length; i++) {
			tempPlayers[i] = players[i];
		}
		
		//Loop through all the players data in the array
		for (int i = 0; i < topThree.length; i++) {
			for (int j = 0; j < players.length; j++) {
				if (tempPlayers[j].score > prevLargestScore) {
					prevLargestScore = tempPlayers[j].score;
					prevLargestName = tempPlayers[j].name;
					maxIndex = j
					topThree[i] = players[j];
				//Handle the case where there are multiple players having the same score
				} else if (tempPlayers[j].score == prevLargestScore) {
					//Sort the name in alphabetical order
					if (tempPlayers[j].name.compareTo(prevLargestName) < 0) {
						topThree[i] = tempPlayers[j];
						prevLargestName = tempPlayers[j].name;
						maxIndex = j;
					}
				}
			}
			
			//Take away the top score from the temp array
			tempPlayers[maxIndex].score = -10000;
			
			//Reset the maxIndex and prevLargestScore for the next loop cycle
			maxIndex = -1;
			prevLargestScore = -9999;
		}
	}

}
