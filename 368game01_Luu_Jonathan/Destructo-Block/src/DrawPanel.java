import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/********************************************
 * Main Game Panel
 * Temporarily being used for sprite testing
 ********************************************/

public class DrawPanel extends Application{
	public void start(Stage stage){
		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(borderPane, 1000, 800, Color.WHITE);
		stage.setTitle("Destructo-Block");
		stage.setResizable(false);
		
		//Create menu-bar for testing
		SelectionBar sb = new SelectionBar(borderPane);
		DrawPanelListener.setDrawPanelListener(borderPane, sb);

		stage.setScene(scene);
		stage.show();
	}

	public static void main (String [] args){
		launch(args);
	}
}
