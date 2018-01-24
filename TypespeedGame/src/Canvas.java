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


//Starting code copied from: https://github.com/tutsplus/Introduction-to-JavaFX-for-Game-Development/blob/master/Example3T.java 

public class Canvas extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override 
	public void start(Stage theStage) {
		theStage.setTitle("This is title");
		
		Group root = new Group();
		Scene the Scene = new Scene(root);
		theStage.setScene(theScene);
		
		Canvas canvas = new Canvas(512,512);
		root.getChildren().add(canvas);
		
		//link to GameElements
		
		
	}

}
