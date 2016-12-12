import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;

public class CoffeeListeners {
	
	//Go to summary screen
	public static void setSubmitButtonListener(Button b, DrawShop currShop){
		b.setOnAction(new EventHandler<ActionEvent>(){
			@Override	
			public void handle(ActionEvent event){	
				currShop.setTextOptionsFinalize();
				currShop.clearAll();
				currShop.drawSummary();
				
				currShop.borderPane.setOnMouseClicked(e -> {
					Platform.exit();
				});
			}
		});
	}
	
	//ComboBox listener
	public static void setComboBoxListener(ComboBox<String> b, CoffeeShopValues allValues){
		b.setOnAction(new EventHandler<ActionEvent>(){
			@Override	
			public void handle(ActionEvent event){	
				allValues.drinkType = b.getSelectionModel().getSelectedItem();
			}
		});
	}
	
	//RadioButton listener
	public static void setRadioButtonListener(RadioButton b, CoffeeShopValues allValues){
		b.setOnAction(new EventHandler<ActionEvent>(){
			@Override	
			public void handle(ActionEvent event){	
				allValues.size = b.getText();
			}
		});
	}
	
	//CheckBox listener
	public static void setCheckBoxListener(CheckBox b, CoffeeShopValues allValues){
		b.setOnAction(new EventHandler<ActionEvent>(){
			@Override	
			public void handle(ActionEvent event){	
				switch(b.getText()){
				case "Iced  ":
					allValues.hasIce = b.isSelected();
					break;
				case "Soy Milk":
					allValues.hasSoy = b.isSelected();
					break;
				case "Extra Shot":
					allValues.hasExtraShot = b.isSelected();
					break;
				}
			}
		});
	}
	
	//Slider listener
	public static void setSliderListener(Slider s, CoffeeShopValues allValues){
		s.valueProperty().addListener(new ChangeListener<Number>(){
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				allValues.sweetLevel = newValue.intValue();
			}
		});
	}
	

}
