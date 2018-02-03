import java.awt.TextField;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;


public class GameInit {
	
	private Canvas canvas;
    private Label currentScore;
    private Rectangle inputField;
    

	public GameInit() {
		
		currentScore = new Label();
		currentScore.setMinWidth(Dimensions.SCREEN_WIDTH);
		currentScore.setFont(Font.font("Tahoma",FontWeight.NORMAL, 20));
		currentScore.setTextFill(Color.BLACK);
		currentScore.setAlignment(Pos.TOP_RIGHT);
		currentScore.setTextAlignment(TextAlignment.RIGHT);
		
		Label inputLabel = new Label("Type here:");
		grid.add(inputLabel, 0, 1);

		TextField userInput = new TextField();
		grid.add(userInput, 1, 1);
	        
        
        this.getChildren().addAll(currentScore, inputField);
    }
	
	public GameInit getInit() {
        return canvas;
    }
	
	public void setInit(GameInit canvas) {
        this.canvas = canvas;
    }

}
