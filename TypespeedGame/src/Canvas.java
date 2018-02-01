import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.image.*;
import javafx.animation.*;
import javafx.event.*;
import javafx.util.Duration;
import javafx.scene.media.AudioClip;

public class Canvas extends Application implements EventHandler<ActionEvent> {
 
    private ImageView bg;
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
    
        
    public void start(Stage stage) {
       Pane pane = new Pane();
       shooter = new ImageView(new Image("shooter.png"));
       bg = new ImageView(new Image("bg.jpg"));
       bullet = new ImageView(new Image("bullet.jpg"));
       explode = new ImageView(new Image("explosion.png"));

       pane.getChildren().addAll();
       stage.setScene(new Scene(pane, 700, 500));
       stage.setTitle("Typespeed Game");
       
       Timeline timeline = new Timeline();
       timeline.getKeyFrames().add(new KeyFrame(new Duration(100), this));
       timeline.setCycleCount(Timeline.INDEFINITE);
       timeline.play();
       
       swoosh = new AudioClip(getClass().getResource("/shoot.wav").toString());
       explosion = new AudioClip(getClass().getResource("/explosion.wav").toString());

       stage.show();
    }
    
    public static void main (String[] args){
      launch(args);
    }
    
 }
