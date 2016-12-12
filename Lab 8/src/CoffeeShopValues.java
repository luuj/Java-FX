import javafx.scene.control.ComboBox;

//Struct to store all values
public class CoffeeShopValues {
	protected String drinkType, size;
	protected boolean hasIce, hasSoy, hasExtraShot;
	protected int sweetLevel;
	protected String name, offerCode, commentEntry;
	
	public CoffeeShopValues(){
		drinkType = "Espresso";
		size = "Medium";
		hasIce = false;
		hasSoy = false;
		hasExtraShot = false;
		sweetLevel = 50;
		name = "";
		offerCode = "";
		commentEntry = "";
	}
	
}
