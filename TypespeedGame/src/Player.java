
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
	Player[] players = new Player[10000];
	
	//method for sorting the top 3 players in the game
	public static sortTopThree (Player[] players) {
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
