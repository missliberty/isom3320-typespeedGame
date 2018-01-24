import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


// code copied from: https://github.com/tutsplus/Introduction-to-JavaFX-for-Game-Development/blob/master/Example3T.java 

public class Canvas extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	//The main method//
	
	@Override 
	public void start(Stage theStage) {
		
		theStage.setTitle("This is the Typespeed Game");
		
		Group root = new Group();
		Scene the Scene = new Scene(root);
		theStage.setScene(theScene);
		
		Canvas canvas = new Canvas(512,512);
		root.getChildren().add(canvas);
		
		//link to GameElements class
		
		Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount( Timeline.INDEFINITE );
        
        final long timeStart = System.currentTimeMillis();
        
        KeyFrame kf = new KeyFrame(
        		Duration.seconds(0.017);
            
        		new EventHandler<ActionEvent>() {
        			public void handle(ActionEvent ae) {
        				double t = (System.currentTimeMillis() - timeStart) / 1000.0; 
                                
                    double x = 232 + 128 * Math.cos(t);
                    double y = 232 + 128 * Math.sin(t);
                    
                    // Clear the canvas
                    gc.clearRect(0, 0, 512,512);
                    
                    // background image clears canvas
                    gc.drawImage( space, 0, 0 );
                    gc.drawImage( earth, x, y );
                    gc.drawImage( sun, 196, 196 );
                }
            });
        
        gameLoop.getKeyFrames().add( kf );
        gameLoop.play();
        
        theStage.show();
        }	
	}