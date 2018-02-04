import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Shooter extends Canvas {
	
	//Set up the starting variables
	
	private boolean visible; 
	private int x, y; //position where the shooter appears
	private int wordX, wordY; // get the position of the target
	
	//bullet variables

	private ImageView shooter; 
    private ImageView bullet;
    

	public Shooter(int startX, int startY) {
		
		shooter = new ImageView(new Image("images/shooter.png"));
		x = startX;
		y = startY;
	
	}
	
	//A method that makes the shooter appear on the screen 
	
	public void showShooter(){
		
		boolean isVisible = false; //by default the shooter is invisible 
		
		if () /** word is correctly inputted by user**/ {
			
			isVisible = true;
			
			//How to link to actual Canvas? 
			
			Canvas.root.inputBar.getChildren().addAll(shooter, bullet);
			
			
			startX = getWordX(); //get the X position of the currently paused word 
			startY = 0; // show the Shooter on the bottom of the Canvas
		}
	}
	
	//A method that shoots the bullet
	
	public void shoot() {
		 
		 ImageView bullet = new ImageView(new Image(getClass().getResourceAsStream("images/bullet.jpg")));
		 getX();
		 getY();
		 
		
		 
		 //make canvas show the image 
		
		}
		//show bullet image
		//set target 
		//automatically shoot when target identified 
		//hide bullet
		//show explosion with sound
		
	}
	
	/** Getters and Setters **/
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}


	public boolean isVisible() {
		return visible;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}


	public void setVisible(boolean visible) {
		this.visible = false;
	}
	
}
