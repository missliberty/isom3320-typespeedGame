
public class Player {
	
	//Declare variables for the Player class
	public String name;
	public int score;
	
	//Constructor for the class
	public Player(String playerName) {
		this.name = playerName;
	}
	
	
	
	
	
	/** These should be put as an event handler under the enter button 
	
	//Method for checking whether the input text matches the word on the screen
	public static boolean checkCorrect(String inputText, String[] wordsOnScreen) {
		for (i = 0; i < wordsOnScreen.length; i++) {
			if (wordsOnScreen[i] == inputText) {
				//Return true if the input text matches an element in the array
				score = score + inputText.length(); //Or add the score later when the shooter already finish the shooting animation?
				return true;
			}
		}
		
		//Return false if there nothing matched in the array
		return false;
	}
	
	boolean isCorrect = checkCorrect(textfieldname.getText(), Target.wordsOnScreen);
	
	if (isCorrect) {
		//Pause the animation for the word
		//Get the coordinates
		//Calll shooter function
	}
	
	*/
	
	
	/**Leaderboard Stuff, which should be also placed in the canvas class */
	
	//crearte player array for storing the name and score for all player
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
		for (i = 0; i < players.length; i++) {
			tempPlayers[i] = players[i];
		}
		
		//Loop through all the players data in the array
		for (i = 0; i < topThree.length; i++) {
			for (j = 0; j < players.length; j++) {
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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
