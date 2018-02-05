import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;


public class SplashScreen {
 
  private Button startButton;

  Image splashImage = new Image("http://i65.tinypic.com/6p7zm0.png");
  ImageView iv1 = new ImageView();

  public SplashScreen(UpdateGame updateGame) {
	  iv1.setImage(splashImage);
	  iv1.setPreserveRatio(true);
	  startButton = new Button("START GAME");
	  
	  startButton.setOnMousePressed(new EventHandler<MouseEvent>()
      {
          @Override
          public void handle(MouseEvent me) {
              updateGame.gameState = GameState.PLAYING;
          }
      });
  }

  public void show(Pane parent) { 
    StackPane stackPane = new StackPane();
    Group gButton = new Group();
    gButton.getChildren().add(startButton);
    stackPane.getChildren().addAll(iv1, gButton);
    parent.getChildren().add(stackPane);

    gButton.setTranslateY(parent.getHeight()/2 - startButton.getLayoutBounds().getHeight());
  }
}