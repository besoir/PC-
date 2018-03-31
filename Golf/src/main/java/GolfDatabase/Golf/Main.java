
package GolfDatabase.Golf;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class Main extends Application
{ public static Section sec2;
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		sec2 = new Section();
		sec2.createTeamsFromPdf();
	Parent root = FXMLLoader.load(getClass().getResource("/abcd.fxml"));
    Scene scene = new Scene(root);
    
    
    stage.setScene(scene);
    stage.show();
	}
	
	
	
	
	
	
	public static void main( String[] args )
    { 
       // System.out.println( "Hello World!" );
        launch(args);
    }


	

	
}
