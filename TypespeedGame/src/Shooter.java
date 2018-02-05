import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Shooter extends Canvas {
	
	//Set up the starting variables
	
	public boolean isVisible;
	public boolean isShooterVisible;
	public boolean isBulletVisible;
	public boolean isExplodeVisible;
	
	private double bulletX, bulletY, bulletDX, bulletDY, bulletTheta, targetDistance; 
	
	Target target;
	
	//bullet variables

	private ImageView ivShooter; 
    private ImageView ivBullet;
    private ImageView ivExplode;
    
    private AudioClip swoosh;
    private AudioClip explosion;
    
    String musicFile = "src/audio/explode.mp3";

    Media sound = new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);
  
    
    StackPane spShooter;
    StackPane spBullet;
    StackPane spExplode;
    

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
		Image bullet = new Image("images/bullet.jpg");
		ivBullet = new ImageView();
		ivBullet.setImage(bullet);
		ivBullet.setFitWidth(25);
		ivBullet.setPreserveRatio(true);
		spBullet.getChildren().addAll(ivBullet);
		
		//Add explosion image
		spExplode = new StackPane();
		Image explode = new Image("images/explosion.png");
		ivExplode = new ImageView();
		ivExplode.setFitWidth(30);
		ivExplode.setImage(explode);
		ivExplode.setFitWidth(30);
		ivExplode.setPreserveRatio(true);
		spExplode.getChildren().addAll(ivExplode);
		 
	}
	
	//A method that makes the shooter appear on the screen 
	
	public void show(Pane parent){  
		Group gShooter = new Group();
		gShooter.getChildren().add(spShooter);
	    parent.getChildren().add(gShooter);
	    
		double parentHeight = parent.getHeight();
		double parentWidth = parent.getWidth();
	    
	    gShooter.setTranslateX(parentWidth/2);
	    gShooter.setTranslateY(parentHeight - spShooter.getHeight());
	    
	    Group gBullet = new Group();
	    gBullet.getChildren().add(spBullet);
	    parent.getChildren().add(gBullet);

		gBullet.setTranslateX(bulletX*parentWidth/100 - ivBullet.getLayoutBounds().getWidth()/2);
		gBullet.setTranslateY(bulletY*parentHeight/100 - ivBullet.getLayoutBounds().getWidth()/2);
		//ivBullet.setRotate(bulletTheta/Math.PI * 180);
	}
	
	public boolean updateBullet() {
		bulletX += bulletDX;
		bulletY += bulletDY;
		return targetDistance-- < -1;
	}
	
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
		mediaPlayer.stop();
		mediaPlayer.play();
	}
	
		
	public void explode(Pane parent){
		
		parent.getChildren().addAll(spExplode);
		    
    }
	
	
	
	
}