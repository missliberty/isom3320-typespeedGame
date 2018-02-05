// Title:       ISOM 3320: Group Project
// Semester:    Winter 2017/18
// Author1:     SOBANSKA, Sandra Anna (sasobanska@connect.ust.hk)
// Author2:	    WONG, Tin Long (tlwongai@connect.ust.hk)
//Project Name: Typespeed Challenge

/*
 * This game commands the user to properly type in the words
 * which are animated on the screen in order to score points. 
 * Player should input the word and press Enter in order to score. 
 * The word will be destroyed automatically if correct and each word 
 * adds 25 points to score. The game ends when the player shoots down 
 * all the words on screen. 
 * Good luck! 
 *  
 */

import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Priority;
import javafx.scene.image.*;
import javafx.event.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class Canvas extends Application implements EventHandler<ActionEvent> {
 
    //Initialize variables
	private Image bg; 
    UpdateGame updateGame;
    
    public void handle(ActionEvent event){

   }
   	
    @Override
    public void start(Stage stage) throws Exception {
    	 
       bg = new Image("images/bg.jpg");
   
       //Setup layout of the canvas
       BorderPane root = new BorderPane();
       root.setMaxHeight(500);
       root.setMinHeight(500);
       root.setPrefHeight(500);
  
       //Setup the toolbar spacing
       final Pane leftSpace = new Pane();
       HBox.setHgrow(
               leftSpace,
               Priority.SOMETIMES);

       final Pane rightSpace = new Pane();
       
       HBox.setHgrow(
               rightSpace,
               Priority.SOMETIMES);
       Text scoreText = new Text("0");
       
       final ToolBar toolBar = new ToolBar(
               new Text("Score: "),
               scoreText,
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
       
       //Check the word when ENTER pressed 
       userInput.setOnKeyPressed(new EventHandler<KeyEvent>()
       {
           @Override
           public void handle(KeyEvent ke) {
               if (ke.getCode().equals(KeyCode.ENTER)) {
            	   
            	   //System.out.println(userInput.getText());
            	   Target target = Target.targets.get(userInput.getText());
            	   userInput.setText("");
	            	   if(target != null) {
	            		   updateGame.hitTarget(target);
	            	   }
               }
           }
       });

       //Create and style mid-section of the borderpane
       HBox gameCenter = new HBox();
       gameCenter.getStyleClass().add("gameCenter");
       gameCenter.setMaxWidth(700);
       gameCenter.setMinWidth(700);
       gameCenter.setPrefWidth(700);
 
       //Add parts to the border pane
       root.setTop(toolBar);
       root.setCenter(gameCenter);
       root.setBottom(inputBar);
           
       //Setup the stage and make size fixed 
       stage.setScene(new Scene(root, 700, 500));
       stage.setResizable(false);
       root.getStylesheets().add(Canvas.class.getResource("TypespeedGame.css").toExternalForm());
       
       //Call show method
       stage.show();
       
       //Update canvas 
       updateGame = new UpdateGame(gameCenter);
       updateGame.setScoreText(scoreText);
       updateGame.setup();
       Platform.runLater(updateGame);
       
       //Implement multi-threading
       new Thread(new Runnable() {
    	   	@Override public void run() {
    	   		try {
	    	   		while(stage.isShowing()) {
	    	   			Platform.runLater(updateGame);
	    	   		
	    	   			Thread.sleep(50);
	    	   		}
    	   		} catch (InterruptedException e) {}
    	   	}
       }).start();  
}

	/**Main Method**/
    
	public static void main (String[] args) {		
		launch(args);	      
	}
    
 }
