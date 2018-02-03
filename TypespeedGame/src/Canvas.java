import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.image.*;
import javafx.animation.*;
import javafx.event.*;
import javafx.util.Duration;
import javafx.scene.media.AudioClip;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import java.awt.TextField;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
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
    private ImageView shooter; 
    private ImageView bullet;
    private ImageView explode;
    private AudioClip swoosh;
    private AudioClip explosion;
    private boolean visible;
    
    public void handle(ActionEvent event){
      
     //Make the shooter appear if one word is paused/matched 
     //Make the bullet move + play sound
     //Show explosion + play sound
     
    /**  SAMPLE CODE
     if (plane.getX() > 250)
        plane.setX(-50);
      else
        plane.setX(plane.getX() + 10);
      if(plane.getX() == -50)
        swoosh.play();
    }
    **/
      
    }
    
    @Override
    public void start(Stage stage) throws Exception {
    	 
       shooter = new ImageView(new Image("images/shooter.png"));
       bullet = new ImageView(new Image("images/bullet.jpg"));
       explode = new ImageView(new Image("images/explosion.png"));
       bg = new Image("images/bg.jpg");
       
       //Call Splash Screen (need to override launch)
       
       //Pane startPane = new Pane();
       //startPane.getChildren().addAll(SplashScreen.addButton()); 
       
       
       //Set up the border pane layout
       BorderPane root = new BorderPane();
      
       
       //Setup the toolbar spacing
       final Pane leftSpace = new Pane();
       HBox.setHgrow(
               leftSpace,
               Priority.SOMETIMES);

       final Pane rightSpace = new Pane();
       
       HBox.setHgrow(
               rightSpace,
               Priority.SOMETIMES);

       final ToolBar toolBar = new ToolBar(
               new Text("Score: "),
               leftSpace,
               rightSpace,
               new Text("Time: "));
       
       toolBar.getStyleClass().add("toolBar");
       toolBar.setPrefWidth(700);
       toolBar.setPrefHeight(40);
       
       //Create and style input bar
       HBox inputBar = new HBox();
       inputBar.getStyleClass().add("inputBar");

       //Create text label
       final Text name = new Text();
       name.setText("Type any of the words: ");
       name.getText();
       
       //Add label to the input bar
       inputBar.getChildren().add(name);
      
       //Create and style mid-section
       HBox gameCenter = new HBox();
       gameCenter.getStyleClass().add("gameCenter");
       
       //Add boxes to the border pane
       root.setTop(toolBar);
       root.setCenter(gameCenter);
       root.setBottom(inputBar);
  
       stage.setScene(new Scene(root, 700, 500));
       root.getStylesheets().add (Canvas.class.getResource("TypespeedGame.css").toExternalForm());
       
       Text scenetitle = new Text("Typespeed Challenge");
       scenetitle.setFont(Font.font("Monotype Corsiva", FontWeight.NORMAL, 20));
       
       Timeline timeline = new Timeline();
       timeline.getKeyFrames().add(new KeyFrame(new Duration(100), this));
       timeline.setCycleCount(Timeline.INDEFINITE);
       timeline.play();
       
       swoosh = new AudioClip(getClass().getResource("audio/shoot.wav").toString());
       explosion = new AudioClip(getClass().getResource("audio/explosion.wav").toString());

       stage.show();
    }
    
  
	public static void main (String[] args){
      launch(args);
      
    }
    
 }
