import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;

public class Shooter extends Canvas {
	
	//Set up the starting variables
	
	public boolean isVisible;
	public boolean isShooterVisible;
	public boolean isBulletVisible;
	public boolean isExplodeVisible;
	
	private double x, y; //position where the shooter appears
	
	
	//bullet variables

	private ImageView ivShooter; 
    private ImageView ivBullet;
    private ImageView ivExplode;
    
    private AudioClip swoosh;
    private AudioClip explosion;
    
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
		ivBullet.setFitWidth(100);
		ivBullet.setImage(bullet);
		ivBullet.setFitWidth(100);
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
		
		//Add audio files
		 swoosh = new AudioClip(getClass().getResource("audio/shoot.wav").toString());
	     explosion = new AudioClip(getClass().getResource("audio/explosion.wav").toString());
     
		 //Not sure if needed?
	     isVisible = true;
	     isShooterVisible = false;
	     isBulletVisible = false;
	     isExplodeVisible = false;
	

	}
	
	//A method that makes the shooter appear on the screen 
	
	public void showShooter(Pane parent){
	    
	    //Condition: if word is matched -> show shooter
	    //if (Canvas.isSuccess = true)
	    //parent.getChildren().addAll(spShooter);
	    //isShooterVisible = true;
	  
	}
	
	//A method that shoots the bullet
	public void shootBullet(Pane parent){
		
		// if (isShooterVisible = true)
			 parent.getChildren().addAll(spBullet);
		    
    }
	
	public void explode(Pane parent){
		
		parent.getChildren().addAll(spExplode);
		    
    }
	
	
	
	
}