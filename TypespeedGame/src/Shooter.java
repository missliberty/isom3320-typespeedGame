
public class Shooter {
	
	//Set up the starting variables
	
	private boolean visible; 
	private int x, y; //position where the shooter appears
	private int wordX, wordY // get the position of the target
	//bullet variables

	public Shooter(int startX, int startY) {
		
		x = startX;
		y = startY;
		visible = false; //by default the shooter is invisible 
	
	}
	
	//A method that makes the shooter appear on the screen 
	
	public void showShooter(){
		
		if () /** word is correctly inputted by user**/ {
			startX = /**use the X of the word that was correctly identified**/;
			startY = 0; // show the Shooter on the bottom of the Canvas
			visible = true;
		}
	}
	
	//A method that shoots the bullet
	
	public void shootBullet() {
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
