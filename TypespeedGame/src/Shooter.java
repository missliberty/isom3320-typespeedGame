import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Shooter extends Canvas {
	
	//Set up the starting variables

	private double bulletX, bulletY, bulletDX, bulletDY, bulletTheta, targetDistance; 
	
	Target target;
	
	//Image variables
	private ImageView ivShooter; 
    private ImageView ivBullet;
    
    //Load bullet shooting sound
    String musicFile = "src/audio/explode.mp3";
    Media sound = new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);
  
    //Setup stack pane for dynamic elements 
    StackPane spShooter;
    StackPane spBullet;
    

	public Shooter() {
	 
		//Add shooter image
		spShooter = new StackPane();
		Image shooter = new Image("images/shooter.png");
		ivShooter = new ImageView();
		ivShooter.setFitWidth(50);
		ivShooter.setImage(shooter);
		ivShooter.setPreserveRatio(true);
		spShooter.getChildren().addAll(ivShooter);
	
		//Add bullet image
		spBullet = new StackPane();
		Image bullet = new Image("images/bullet.png");
		ivBullet = new ImageView();
		ivBullet.setImage(bullet);
		ivBullet.setFitWidth(25);
		ivBullet.setPreserveRatio(true);
		spBullet.getChildren().addAll(ivBullet);
	}
	
	//Make shooter and bullet appear on the screen
	public void show(Pane parent){  
		Group gShooter = new Group();
		gShooter.getChildren().add(spShooter);
	    parent.getChildren().add(gShooter);
	    
		double parentHeight = parent.getHeight();
		double parentWidth = parent.getWidth();
	    
	    gShooter.setTranslateX(parentWidth/2);
	    gShooter.setTranslateY(parentHeight - spShooter.getHeight());
	    parent.getChildren().add(spBullet);
	   	    
	    Group gBullet = new Group();
	    gBullet.getChildren().add(spBullet);
	    parent.getChildren().add(gBullet);

		gBullet.setTranslateX(bulletX*parentWidth/100 - ivBullet.getLayoutBounds().getWidth());
		gBullet.setTranslateY(bulletY*parentHeight/100 - ivBullet.getLayoutBounds().getWidth()/2);
		//ivBullet.setRotate(bulletTheta/Math.PI * 180);
	}
	
	//Make the bullet move towards the matched word
	public boolean updateBullet() {
		bulletX += bulletDX;
		bulletY += bulletDY;
		targetDistance -= 2;
		return targetDistance < -1;
	}
	
	//Animate words on screen
	public void reset(Target target) {
		this.target = target;
		bulletX = 50;
		bulletY = 100;
		bulletDX = (target.xCor - 50);
		bulletDY = (target.yCor - 100);
		targetDistance = Math.sqrt(bulletDX*bulletDX + bulletDY*bulletDY);
		bulletDX /= targetDistance;
		bulletDY /= targetDistance;
		bulletTheta = Math.atan2(-bulletDY, bulletDX);
		bulletDX *= 2;
		bulletDY *= 2;

		//Refresh the audio file 
		mediaPlayer.stop();
		mediaPlayer.play();
	}
	
	
}