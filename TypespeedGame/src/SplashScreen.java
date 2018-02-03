import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;

public class SplashScreen extends Application {
	
  private Pane splashLayout;
  private Button startButton;
  private Stage mainStage;
  private static final int SPLASH_WIDTH = 700;
  private static final int SPLASH_HEIGHT = 500;

  public static void main(String[] args) throws Exception { launch(args); }

  @Override public void init() {

    int x = 700;
    int y = 500;
    
    Image image = new Image("http://i65.tinypic.com/6p7zm0.png",x,y, true, false);
    ImageView iv1 = new ImageView();
    iv1.setImage(image);
    iv1.setPreserveRatio(true);
   // iv1.setFitHeight(x);
   // iv1.setFitWidth(y);

    Button button = new Button("START GAME");
    button.setTranslateX(10);
    button.setTranslateY(10);
    button.setContentDisplay(ContentDisplay.TOP);


    StackPane stackPane = new StackPane();
    stackPane.getChildren().addAll(iv1, button); 

    splashLayout = new HBox();
    splashLayout.getChildren().add(stackPane);

  }
  
  @Override public void start(final Stage initStage) throws Exception {
    showSplash(initStage);
    showMainStage();

  }

  private void showMainStage() {
    mainStage = new Stage();
    mainStage.setIconified(true);
   
    // layout the scene.

    Scene scene = null;
	mainStage.setScene(scene);
    mainStage.show();
    
  }

  private void showSplash(Stage initStage) {
    Scene splashScene = new Scene(splashLayout);
    final Rectangle2D bounds = Screen.getPrimary().getBounds();
    initStage.setScene(splashScene);
    
    initStage.setX(bounds.getMinX() + bounds.getWidth() / 2 - SPLASH_WIDTH / 2);
    initStage.setY(bounds.getMinY() + bounds.getHeight() / 2 - SPLASH_HEIGHT / 2);
    initStage.show();
  }
  
  
public Button getStartButton() {
	return startButton;
}

public void setStartButton(Button startButton) {
	this.startButton = startButton;
}
}