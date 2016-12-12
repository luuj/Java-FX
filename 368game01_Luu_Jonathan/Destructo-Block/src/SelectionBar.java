import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/********************************************
 * Selection Bar
 * Contains drop-down menu to select sprite
 * Contains TextField for scale
 ********************************************/

public class SelectionBar {
	private BorderPane passedBP;
	private HBox mainContainer;
	private ComboBox<String> blockMenu;
	private TextField scaleTextField;
	
	SelectionBar(BorderPane bp){
		passedBP = bp;
		mainContainer = new HBox();
		mainContainer.setPadding(new Insets(15,15,15,15));
		mainContainer.setSpacing(30);
		
		EntityDropDown();
		ScaleField();
		passedBP.setTop(mainContainer);
	}
	
	//Drop-down menu for entities
	private void EntityDropDown(){
		ObservableList<String> blockOptions = FXCollections.observableArrayList("Blue Block", "Green Block", "Yellow Block", "Red Block", 
				"Bomb Block", "Star Block", "Timer Block", "Indestructable Block", "Background", "Pause Button");
		blockMenu = new ComboBox<String>(blockOptions);
		blockMenu.setMinWidth(215);

		Label blockLabel = new Label("Select an entity:");
		blockLabel.setPadding(new Insets(5,10,0,0));
		
		HBox blockHBox = new HBox();
		blockHBox.getChildren().addAll(blockLabel, blockMenu);
		
		mainContainer.getChildren().add(blockHBox);
	}
	
	//TextField to enter in scale
	private void ScaleField(){
		Label scaleLabel = new Label("Scale Percentage:");
		scaleLabel.setPadding(new Insets(5,10,0,0));

		scaleTextField = new TextField();
		scaleTextField.setMinWidth(215);
		scaleTextField.setText("100");

		HBox scaleHBox = new HBox();
		scaleHBox.getChildren().addAll(scaleLabel, scaleTextField);
		
		mainContainer.getChildren().add(scaleHBox);
	}
	
	//Getters
	String GetCurrentOption(){
		return blockMenu.getSelectionModel().getSelectedItem();
	}
	
	int GetCurrentScale(){
		try{
			return Integer.parseInt(scaleTextField.getText());
		}catch(Exception e){
			System.out.println("Error. Please enter in a valid integer for the scale text field");
			return -1;
		}
	}
}
