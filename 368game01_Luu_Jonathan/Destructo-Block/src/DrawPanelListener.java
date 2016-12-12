import Entities.*;
import javafx.scene.layout.BorderPane;

/****
 * Listener for main panel
 * Draws object based on scale and ComboBox selection
 ****/

public class DrawPanelListener {
	public static void setDrawPanelListener(BorderPane bp, SelectionBar sb){
		bp.setOnMouseClicked(e -> {
			DrawEntity(bp, sb.GetCurrentOption(), e.getX(), e.getY());
		});
	}
	
	//Create object to draw
	private static void DrawEntity(BorderPane bp, String entityString, double X, double Y){
		Block drawBlock = new Block();

		if (entityString == null)
			return;
		
		switch (entityString){
		case "Blue Block":
			drawBlock = new BlueBlock();
			break;
		case "Green Block":
			drawBlock = new GreenBlock();
			break;
		case "Yellow Block":
			drawBlock = new YellowBlock();
			break;
		case "Red Block":
			drawBlock = new RedBlock();
			break;
		case "Bomb Block":
			drawBlock = new BombBlock();
			break;
		case "Star Block":
			drawBlock = new StarBlock("Red");
			break;
		case "Timer Block":
			drawBlock = new TimerBlock();
			break;
		case "Indestructable Block":
			drawBlock = new IndestructableBlock();
			break;
		case "Background":
		{
			BackgroundImage backgroundImage = new BackgroundImage();
			backgroundImage.setImageLocation(X-175, Y-200);
			bp.getChildren().add(backgroundImage.getImage());
			return;
		}
		case "Pause Button":
			PauseButton pb = new PauseButton(X,Y, bp);
			return;
		}
		
		drawBlock.setImageLocation(X-45, Y-28);
		bp.getChildren().add(drawBlock.getImage());
	}

}
