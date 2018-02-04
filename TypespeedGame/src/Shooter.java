import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Shooter extends Canvas {
	
	//Set up the starting variables
	
	private boolean isVisible; 
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
		
			isVisible = true;
			//show shooter image 
			
			
			//How to link to actual Canvas? 
			Canvas.root.inputBar.getChildren().addAll(shooter, bullet);
			
			
	}
	
	//A method that shoots the bullet
	
	private int direction, speed;

	public void shoot(int dir) {
		
		ImageView bullet = new ImageView(new Image(getClass().getResourceAsStream("images/bullet.jpg")));

		        direction = dir;
		        speed = 15;
		    }
		    
	public void act() {
        setLocation(getX(), getY());
        setRotation(direction);
        move();
    }
		
	
	private void move() {
		
	}

	private void setRotation(int direction2) {
		
	}

	private void setLocation(int x2, int y2) {
		
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
