import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DrawShop {
	BorderPane borderPane;
	VBox vbox;
	VBox allTextEntries;
	
	public DrawShop(BorderPane bp){
		borderPane = bp;
		
		//Box for central options
		vbox = new VBox();
		vbox.setPadding(new Insets(7,50,50,30));
		vbox.setSpacing(28);
		
		//Box for bottom options
		allTextEntries = new VBox();
		allTextEntries.setPadding(new Insets(0,0,150,15));
		allTextEntries.setSpacing(15);
	}
	
	public void drawAll(){
		drawTitle();
		drawDescriptions();
		drawDrinkOptions();
		drawSizeOptions();
		drawExtraOptions();
		drawSweetnessOptions();
		drawTextEntryOptions();
		drawSubmitButton();
	}
	
	public void drawTitle(){
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15,15,15,0));
		hbox.setSpacing(10);
		hbox.setAlignment(Pos.CENTER);
		
		//Set font and size for top label
		Label text = new Label("Welcome to the Coffee Shop!");
		text.setFont(new Font("Cambria", 20));
		
		hbox.getChildren().add(text);
		borderPane.setTop(hbox);
	}
	
	public void drawDescriptions(){
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(15,15,15,15));
		vbox.setSpacing(30);
		
		//Text labels placed on left side of border pane
		Label drinkText = new Label("Select a drink:");
		Label sizeText = new Label("Size:");
		Label extraText = new Label("Extras:");
		Label sweetText = new Label("Sweetness:");
		
		vbox.getChildren().addAll(drinkText, sizeText, extraText, sweetText);
		borderPane.setLeft(vbox);
	}
	
	public void drawDrinkOptions(){
		//Create ComboBox and set the default value
		ObservableList<String> options = FXCollections.observableArrayList("Espresso", "Caffe Latte", "Flat White", "Cappuccino", "Caffe Mocha", "Americano", "Espresso Macchiato");
		ComboBox<String> drinkOptions = new ComboBox<String>(options);
		drinkOptions.setMinWidth(215);
		drinkOptions.setValue("Espresso");
		
		//Add to the border pane
		vbox.getChildren().addAll(drinkOptions);
		borderPane.setRight(vbox);
	}
	
	public void drawSizeOptions(){
		HBox radioButtonBox = new HBox();
		radioButtonBox.setSpacing(5);
		ToggleGroup group = new ToggleGroup();
		
		//Creating the three radio size buttons
		RadioButton smallButton = new RadioButton("Small");
		smallButton.setToggleGroup(group);
		
		RadioButton mediumButton = new RadioButton("Medium ");
		mediumButton.setToggleGroup(group);
		mediumButton.setSelected(true);
		
		RadioButton largeButton = new RadioButton("Large");
		largeButton.setToggleGroup(group);
		
		radioButtonBox.getChildren().addAll(smallButton, mediumButton, largeButton);
		vbox.getChildren().add(radioButtonBox);		
	}
	
	public void drawExtraOptions(){
		HBox checkButtonBox = new HBox();
		checkButtonBox.setSpacing(5);
		
		//Three check-boxes for extras
		CheckBox soyBox = new CheckBox("Soy Milk");
		CheckBox icedBox = new CheckBox("Iced  ");
		CheckBox shotBox = new CheckBox("Extra Shot");
		
		checkButtonBox.getChildren().addAll(icedBox, soyBox, shotBox);
		vbox.getChildren().add(checkButtonBox);
	}
	
	public void drawSweetnessOptions(){
		HBox sliderBox = new HBox();
		sliderBox.setSpacing(5);
		
		//Setting slider options for sweetness
		Slider sweetnessSlider = new Slider();
		sweetnessSlider.setMin(0);
		sweetnessSlider.setMax(100);
		sweetnessSlider.setValue(50);
		
		sweetnessSlider.setShowTickLabels(true);
		sweetnessSlider.setShowTickMarks(true);
		sweetnessSlider.setMajorTickUnit(50);
		sweetnessSlider.setMinorTickCount(5);
		sweetnessSlider.setBlockIncrement(10);
		sweetnessSlider.setMinWidth(215);
		
		sliderBox.getChildren().add(sweetnessSlider);
		vbox.getChildren().add(sliderBox);
	}
	
	public void drawTextEntryOptions(){
		//Name field
		HBox nameEntry = new HBox();
		nameEntry.setSpacing(34);
		
		Label name = new Label("Name for order:");
		name.setPadding(new Insets(5,0,0,0));
		
		TextField nameField = new TextField();
		nameField.setMinWidth(215);
		
		nameEntry.getChildren().addAll(name, nameField);
		
		//Offer-code field
		HBox offerCodeEntry = new HBox();
		offerCodeEntry.setSpacing(62);
		
		Label offerCode = new Label("Offer code:");
		offerCode.setPadding(new Insets(5,0,0,0));

		TextField offerField = new TextField();
		offerField.setMinWidth(215);
		
		offerCodeEntry.getChildren().addAll(offerCode, offerField);
		
		//Comment field
		HBox commentEntry = new HBox();
		commentEntry.setSpacing(62);
		
		Label commentLabel = new Label("Comments:");
		commentLabel.setPadding(new Insets(5,0,0,0));

		TextArea commentArea = new TextArea();
		commentArea.setMaxWidth(215);
		commentArea.setMaxHeight(50);
		
		commentEntry.getChildren().addAll(commentLabel, commentArea);
		
		//Add all three text fields
		allTextEntries.getChildren().addAll(nameEntry, offerCodeEntry, commentEntry);
		borderPane.setBottom(allTextEntries);
	}
	
	public void drawSubmitButton(){
		//Submit order button at bottom of screen
		Button submitButton = new Button("Submit Order");
		HBox buttonBox = new HBox();
		buttonBox.setPadding(new Insets(10,0,0,125));
		buttonBox.getChildren().add(submitButton);
		
		allTextEntries.getChildren().add(buttonBox);
	}
}
