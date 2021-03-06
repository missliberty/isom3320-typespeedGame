import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.util.Collection;

public class UpdateGame implements Runnable {
	Pane parent;
	Text scoreText;
	GameState gameState;
	
	public int currentScore = 0;
	Shooter shooter;
	SplashScreen splashScreen;
	GameOverScreen gameOverScreen;
	
	public UpdateGame (Pane parent) {
		this.parent = parent;
		this.shooter = new Shooter();
		this.splashScreen = new SplashScreen(this);
		this.gameOverScreen = new GameOverScreen(this);
		this.gameState = GameState.SPLASH;
	}
	
	@Override
	public void run() {
				//clear the gameCenter
				parent.getChildren().clear();
		
				if (gameState == GameState.SPLASH) {
					splashScreen.show(this.parent);
					return;
				}
				
				if (gameState == GameState.GAMEOVER) {
					gameOverScreen.show(this.parent);
					return;
				}

				//update targets
				Collection<Target> targets = Target.getTargets();
				
				if (gameState == GameState.PLAYING) {
					for (Target aTarget: targets) {
						// update positions and animation state
						aTarget.update();
					}
				}
				
				//add back the elements 
				addTargetsToParent(parent);
				
				String currentScoreString = Integer.toString(currentScore);
				this.scoreText.setText(currentScoreString);
				
				if (gameState == GameState.SUCCESS) {
					this.shooter.show(this.parent);
					boolean hit = this.shooter.updateBullet();
					if (hit) {
						gameState = GameState.PLAYING;
						Target.targets.remove(this.shooter.target.word);
					}
					if (Target.targets.size()==0) {
						gameState = GameState.GAMEOVER;
					}
				}
	}
	
	public void setup() {
		setupTargets();
	}

	private void addTargetsToParent(Pane parent) {	
		
		Group g = new Group();
		
		for(Target aTarget : Target.getTargets()) {
			Text t = new Text(aTarget.word);
			t.setId("wordStyle");

			double parentHeight = parent.getHeight();
			double parentWidth = parent.getWidth();

			g.getChildren().add(t);
			t.setTranslateX(aTarget.xCor*parentWidth/100);
			t.setTranslateY(aTarget.yCor*parentHeight/100);
			aTarget.targetWidth = t.getLayoutBounds().getWidth()/parentWidth*100;
			
	  	}
		
		g.setManaged(false);
		parent.getChildren().add(g);
     }
	  
	 private void setupTargets() {
		 Target.setup();
		 Target.setupTargets(10);

	 }
	 
	 public void setScoreText(Text scoreText) {
		 this.scoreText = scoreText;
	 }
	 
	 public void hitTarget(Target target) {		   
		   this.currentScore += 25;
		   this.gameState = GameState.SUCCESS;
		   this.shooter.reset(target);
	 }
	 
	 
}
