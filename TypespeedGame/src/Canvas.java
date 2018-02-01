import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.image.*;
import javafx.animation.*;
import javafx.event.*;
import javafx.util.Duration;
import javafx.scene.media.AudioClip;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

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
     
    public void start(Stage stage) throws Exception {
    	
    	BorderPane root = new BorderPane();
    	root.setPadding(new Insets(10, 0, 10, 0));
    	
    	Button btnBottom = new Button("Bottom");
    	root.setBottom(btnBottom);
    	BorderPane.setAlignment(btnBotton, Pos.BOTTOM_LEFT);
        

       shooter = new ImageView(new Image("shooter.png"));
       bg = new ImageView(new Image("bg.jpg"));
       bullet = new ImageView(new Image("bullet.jpg"));
       explode = new ImageView(new Image("explosion.png"));

       root.getChildren().addAll();
       root.setAlignment(Pos.CENTER);
       root.setHgap(10);
       root.setVgap(10);
       root.setPadding(new Insets(25, 0, 25, 0));
       
       stage.setScene(new Scene(root, 700, 500));
       scene.getStylesheets().add (Login.class.getResource("TypespeedGame.css").toExternalForm());
       
       Text scenetitle = new Text("Typespeed Challenge");
       scenetitle.setFont(Font.font("Monotype Corsiva", FontWeight.NORMAL, 20));
       root.add(scenetitle, 0, 0, 2, 1);

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
