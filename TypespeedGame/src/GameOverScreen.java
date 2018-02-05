import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class GameOverScreen {
	
	//Initialize the elements 
	  private Button restartButton;
	  Image endImage = new Image("https://ak5.picdn.net/shutterstock/videos/31256245/thumb/1.jpg");
	  ImageView iv1 = new ImageView();

	  //Build the game over screen
	  public GameOverScreen(UpdateGame updateGame) {
		  iv1.setImage(endImage);
		  iv1.setPreserveRatio(true);
		  restartButton = new Button("PLAY AGAIN");
		  restartButton.setOnMousePressed(new EventHandler<MouseEvent>() //restart the game when pressed
		  
	      {
	          @Override
	          public void handle(MouseEvent me) {
	        	      updateGame.setup(); //create the main canvas 
	              updateGame.gameState = GameState.PLAYING; //change state of the game 
	              
	          }
	      });
	  }

	  //Make the image and button show on the ending screen
	  public void show(Pane parent) { 
	    StackPane stackPane = new StackPane();
	    Group gButton = new Group();
	    gButton.getChildren().add(restartButton);
	    stackPane.getChildren().addAll(iv1, gButton);
	    parent.getChildren().add(stackPane);
	    gButton.setTranslateY(parent.getHeight()/2 - restartButton.getLayoutBounds().getHeight()-50);
	  }
	
	
}
