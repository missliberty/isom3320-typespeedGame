import javafx.application.Application;
import javafx.scene.layout.StackPane;
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
	
	//* Stage initial settings  *//
	
	@Override 
	public void start(Stage theStage) {
		
		theStage.setTitle("This is the Typespeed Game");
		
		Group root = new Group();
		Scene the Scene = new Scene(root);
		theStage.setScene(theScene);
		
		Canvas canvas = new Canvas(512,512);
		root.getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
        
	    gc.setFill( Color.YELLOW );
	    gc.setStroke( Color.BLACK );
	    gc.setLineWidth(2);
	    Font theFont = Font.font( "Arial", FontWeight.BOLD, 48 );
	    gc.setFont( theFont );
	    gc.fillText( "Typespeed Challenge!", 60, 50 );
	    gc.strokeText( "Typespeed Challenge!", 60, 50 );
	     
	    Image earth = new Image( "bg.jpg" );
	    gc.drawImage( bg, 180, 100 );
	    
	    //Start the game loop 
	    
	    final long startNanoTime = System.nanoTime();
	    
	    new AnimationTimer() {
	        public void handle(long currentTime) {
	            double t = (currentTime - startTime) / 1000000000.0; 
	 
	            double x = 232 + 128 * Math.cos(t);
	            double y = 232 + 128 * Math.sin(t);
	 
	            // background image clears canvas
	            gc.drawImage( bg, 0, 0 );
	        }
	        }
	    .start();
	
	    theStage.show();
	}
	
	//* Main method *//
	
	public static void main(String[] args) {
        launch(args);
    }
        
}


