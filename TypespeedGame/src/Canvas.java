import javafx.scene.shape.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.application.Application;
import javafx.application.Platform;
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
import javafx.geometry.*;
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
    public static boolean isSuccess = false;
   
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
       
       //Check the word matching ENTER pressed 
       userInput.setOnKeyPressed(new EventHandler<KeyEvent>()
       {
           @Override
           public void handle(KeyEvent ke) {
               if (ke.getCode().equals(KeyCode.ENTER)) {
            	   //checkCorrect(); //should be from the method in Player class
            	   
            	   System.out.println(userInput.getText());
            	   Target target = Target.targets.get(userInput.getText());
            	   userInput.setText("");
	            	   if(target != null) {
	            		   updateGame.hitTarget(target);
	            	   }
               }
           }
       });
       
     
       //Create and style mid-section
       
       HBox gameCenter = new HBox();
       //gameCenter.setPadding(new Insets(40, 0, 0, 20));
       gameCenter.getStyleClass().add("gameCenter");
       gameCenter.setMaxWidth(700);
       gameCenter.setMinWidth(700);
       gameCenter.setPrefWidth(700);
 
       //Add boxes to the border pane
       root.setTop(toolBar);
       root.setCenter(gameCenter);
       root.setBottom(inputBar);
           
       stage.setScene(new Scene(root, 700, 500));
       //stage.setResizable(false);
       root.getStylesheets().add(Canvas.class.getResource("TypespeedGame.css").toExternalForm());
       
      
       stage.show();
       
       updateGame = new UpdateGame(gameCenter);
       updateGame.setScoreText(scoreText);
       updateGame.setup();
       
       Platform.runLater(updateGame);
      
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

		       //How to make these words show in the gameCenter		
		public static void main (String[] args) {		
			launch(args);	      
		}
    
 }
