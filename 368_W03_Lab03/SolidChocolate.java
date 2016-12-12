
public class SolidChocolate extends Chocolate {

	private int numberSections;
	
	public SolidChocolate(String name, int gramsOfSugar, double percentCocoa, int numSections) {
		super(name, gramsOfSugar, percentCocoa);
		this.numberSections = numSections;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Solid" + super.toString() + " [numberSections=" + numberSections + "]";
	}

	/**
	 * @return the numberSections
	 */
	public int getNumberSections() {
		return numberSections;
	}

	/**
	 * @param numberSections the numberSections to set
	 */
	public void setNumberSections(int numberSections) {
		this.numberSections = numberSections;
	}



}
