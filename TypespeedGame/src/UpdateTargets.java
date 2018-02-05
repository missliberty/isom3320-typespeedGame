import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.util.Collection;

public class UpdateTargets implements Runnable {
	Pane parent;
	Text scoreText;
	
	public int currentScore = 0;
	Shooter shooter;
	
	public UpdateTargets (Pane parent) {
		this.parent = parent;
		this.shooter = new Shooter();
	}
	
	@Override
	public void run() {
				//update targets
				
				Collection<Target> targets = Target.getTargets();
				
				for (Target aTarget: targets) {
					// update positions and animation state
					aTarget.update();
				}
				
				//clear the gameCenter
				parent.getChildren().clear();
				
				//add back the elements 
				addTargetsToParent(parent);
				
				String currentScoreString = Integer.toString(currentScore);
				this.scoreText.setText(currentScoreString);
				this.shooter.showShooter(this.parent);
				
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
	 
	 
}
