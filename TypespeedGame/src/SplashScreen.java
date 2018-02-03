/**

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class SplashScreen extends Application {
	
  private Pane splashLayout;
  private Button startButton;
  private Stage mainStage;
  private static final int SPLASH_WIDTH = 700;
  private static final int SPLASH_HEIGHT = 500;

  public static void main(String[] args) throws Exception { launch(args); }

  @Override public void init() {
	  
    ImageView splash = new ImageView(new Image("http://i65.tinypic.com/6p7zm0.png"));
    
    splashLayout = new HBox();
    splashLayout.getChildren().addAll(splash);
    
    //Need to put the button on top of the image 
    
    //Apply CSS styles
    splashLayout.setStyle("-fx-padding: 5; -fx-background-color: cornsilk; -fx-border-width:5; -fx-border-color: linear-gradient(to bottom, chocolate, derive(chocolate, 50%));");
    splashLayout.setEffect(new DropShadow());
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

**/

import javafx.scene.*;
import javafx.scene.image.*;


public class SplashScreen {  
  private static Image gameRules;
  private static Node rulesNode; 
  
  
  //background image
  public static Node setBackground() throws Exception {
    gameRules = new Image("images/bg.jpg", 1000, 600, false, false);
    rulesNode = new ImageView(gameRules);
    
    return rulesNode; 
  }
  
  
  //instructions 
  public static Node addButton() throws Exception {
    Button startButton = new Button("START GAME");
    
    return startButton; 
  }
}