
public class FilledChocolate extends Chocolate {
	private String filling;
	
	public FilledChocolate(String name, int gramsOfSugar, double percentCocoa, String fillingType) {
		super(name, gramsOfSugar, percentCocoa);
		this.filling = fillingType;
	
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Filled" + super.toString() +  " [filling=" + filling + "]";
	}

	/**
	 * @return the filling
	 */
	public String getFilling() {
		return filling;
	}

	/**
	 * @param filling the filling to set
	 */
	public void setFilling(String filling) {
		this.filling = filling;
	}

}
