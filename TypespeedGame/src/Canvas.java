import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
 
public class Canvas extends Application {

@Override
   public void start(Stage stage) throws Exception {
       Group root = new Group();
       
       Scene scene = new Scene(root, 700, 500, Color.YELLOW);
 
       Rectangle r = new Rectangle(5,5,690,490);
       r.setFill(Color.WHITE);
       root.getChildren().add(r);
 
       stage.setTitle("JavaFX Scene Graph Demo");
       stage.setScene(scene);
       stage.show();
   }
 
   public static void main(String[] args) {
       launch(args);
   }
}

