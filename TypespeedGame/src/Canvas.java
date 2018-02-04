import javafx.scene.shape.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.image.*;
import javafx.animation.*;
import javafx.event.*;
import javafx.util.Duration;
import javafx.scene.media.AudioClip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import javafx.scene.control.Label;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class Canvas extends Application implements EventHandler<ActionEvent> {
 
    private Image bg;
    private ImageView explode;
    private AudioClip swoosh;
    private AudioClip explosion;
    
    private boolean isVisible;
    public int currentScore;
    
   
    public static String[] wordBank = new String[500];
    public static String[] wordsOnScreen = new String[500];

	//define file name for the text file to be scanned
	public static String fileName ="words.txt";
    
	
	public void handle(ActionEvent event){
      
     //Make the shooter appear if one word is paused/matched 
     //Make the bullet move + play sound
     //Show explosion + play sound
		
	
}
    public static void scanFile() throws IOException {
    	
   		
   		//Declare scanner to scan the words.txt file
   		Scanner scannerForTextFile = new Scanner(new File(fileName));
   		
   		//counter for indicating the array index of each item
   		int wordIndex = 0;
   		
   		//Scan and put the words inside wordBank array
   		
   		while (scannerForTextFile.hasNextLine()) {
   			wordBank[wordIndex] = scannerForTextFile.nextLine();
   			wordIndex++;
   		}
   		
   		//close the scanner
   		scannerForTextFile.close();
   		
   	}
   	
    @Override
    public void start(Stage stage) throws Exception {
    	 
       
       explode = new ImageView(new Image("images/explosion.png"));
       bg = new Image("images/bg.jpg");
       
       
       //Call Splash Screen (need to override launch)
       
       
       //Setup layout of the canvas
       BorderPane root = new BorderPane();
      
       //Setup the toolbar spacing
       final Pane leftSpace = new Pane();
       HBox.setHgrow(
               leftSpace,
               Priority.SOMETIMES);

       final Pane rightSpace = new Pane();
       String currentScoreText = Integer.toString(currentScore);

       HBox.setHgrow(
               rightSpace,
               Priority.SOMETIMES);

       final ToolBar toolBar = new ToolBar(
               new Text("Score: "),
               new Text(currentScoreText),
               
               leftSpace,
               rightSpace
               );
       
       //Create and style toolbar
       toolBar.getStyleClass().add("toolBar");
       toolBar.setPrefWidth(700);
       toolBar.setPrefHeight(40);
       
       //Create and style input bar
       HBox inputBar = new HBox();
       inputBar.getStyleClass().add("inputBar");
    
     
       //Add label to the input bar
       final Text name = new Text();
       name.setText("Type words here: ");
       name.getText();
       inputBar.getChildren().add(name);
       
       //Add text field for user input 
       final TextField userInput = new TextField();
       inputBar.getChildren().add(userInput);
       
       //Check the word matching ENTER pressed 
       userInput.setOnKeyPressed(new EventHandler<KeyEvent>()
       {
           @Override
           public void handle(KeyEvent ke) {
               if (ke.getCode().equals(KeyCode.ENTER)) {
            	   //checkCorrect(); //should be from the method in Player class
            	   
            	   System.out.println(userInput);
               }
           }
       });
       
     
       //Create and style mid-section
       
       HBox gameCenter = new HBox();
       gameCenter.getStyleClass().add("gameCenter");
       //need to add moving words to gameCenter  
       
       
       //Add boxes to the border pane
       root.setTop(toolBar);
       root.setCenter(gameCenter);
       root.setBottom(inputBar);
           
       stage.setScene(new Scene(root, 700, 500));
       root.getStylesheets().add(Canvas.class.getResource("TypespeedGame.css").toExternalForm());
       
    
      //Load the audio files
       swoosh = new AudioClip(getClass().getResource("audio/shoot.wav").toString());
       explosion = new AudioClip(getClass().getResource("audio/explosion.wav").toString());
      
       stage.show();
      
       
}
    
    //Method for animating the words 
   
    public void makeWordsMove() {
    	
    	//This should be String/ array not rectangle
    	final Rectangle rectBasicTimeline = new Rectangle(100, 50, 100, 50);
        rectBasicTimeline.setFill(Color.RED);
    
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        
        final KeyValue kv = new KeyValue(rectBasicTimeline.xProperty(), 300);
        final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
       
        
        timeline.getKeyFrames().add(kf);
        timeline.play();

    }
    
	
		public static void pickWords(String[] wordBank) {
			
			 //Pick 10 words to be displayed

		       String[] wordsArr = new String [10];
		       int arraySize = wordsArr.length;
		       int randomIndex = 0;
			
		       //Pick the words randomly from the words.txt file
		       for (int i = 0; i < arraySize; i++) {
		    	   
		    	   randomIndex = (int) (Math.random() * 500);
		    	   String newWord = wordBank[randomIndex];
		    	   wordsArr[i] = newWord;
		    	  
		       }
		       
		       //How to make these words show in the gameCenter?
		       
		     
		      
		}
			
		public static void main (String[] args) {
			
			launch(args);
			//moveWords();
			
		      
		}
    
 }
