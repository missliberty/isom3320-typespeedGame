
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
	
	GameInit.userInput.setOnAction( e -> {
		
		if ( e.getCode() == KeyCode.ENTER) {
			
			//Check whether the input is correct
			boolean isCorrect = checkCorrect(Canvas.userInput.getText(), Target.targetsOnScreen);
			
			//Create temp target to find the target that contains the userInput.text
			Target tempTarget;
			
			for (int i = 0; i < Target.targetsOnScreen.length; i++) {
				if (Target.targetsOnScreen[i].getContent().equals(GameInit.userInput.getText())) {
					tempTarget = Target.targetsOnScreen[i];
				}
			}
			
			
			
			if (isCorrect) mainCorrect(tempTarget); //Need to add an argument for calling this method, how to pass that particular target into it?
			
			//Empty the text field for next entry
			Canvas.userInput.setText("");
		}
		
	})
	

	
	//Method for checking whether the input text matches the word on the screen
	public static boolean checkCorrect(String inputText, Target[] targetsOnScreen) {
		for (int i = 0; i < targetsOnScreen.length; i++) {
			if (targetsOnScreen[i].getContent().equals(inputText)) {
				//Return true if the input text matches an element in the array
				targetsOnScreen[i].score += inputText.length();
				//correctCounter++;
				return true;
			}
		}
		
		//Return false if there nothing matched in the array
		return false;
	}
	
	
	public static void mainCorrect (Target targetWord) {
		
		//1. Pause the animation for the word
		targetWord.isPause = true;
		
		for (int i = 0; i < PrintAndMoveWord.wordThreadArray,length; i++) {
			if (PrintAndMoveWord.wordOnEachThread[i].equals(targetWord.getContent())) {
				PrintAndMoveWord.wordThreadArray[i].sleep(10000);//Pause the thread for 10 seconds
			}
		}
		
		//2. Get the coordinates
		double xCor = targetWord.getXCor();
		double yCor = targetWord.getYCor();
		
		//3. remove it from the wordsOnScreen array
		for (int i = 0; i < Target.targetsOnScreen.length; i++) {
			if (Target.targetsOnScreen[i].getContent().equals(targetWord)) {
				Target.targetsOnScreen[i].content = "";
				Target.onScreenWordsOccupied[i] = false;
			}
		}
		
		//4. Call shooter function
		Shooter shooter = new Shooter(xCor, yCor);
		shooter.showShooter();

	}

	
	/**Leaderboard Stuff, which should be also placed in the the class that initiate the computation */
	
	//crearte player array for storing the name and score for all player
	//Push player data into this array when gameover
	Player[] players = new Player[10000];
	Player[] topThree = new Player[3]; //The leaderboard that we will be showing
	
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
