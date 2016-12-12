
/**
 * @author kendra
 *
 */
public abstract class Chocolate extends Candy {
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Chocolate" + super.toString() + "  [percentCocoa=" + percentCocoa + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(percentCocoa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Chocolate)) {
			return false;
		}
		Chocolate other = (Chocolate) obj;
		if (Double.doubleToLongBits(percentCocoa) != Double.doubleToLongBits(other.percentCocoa)) {
			return false;
		}
		return true;
	}

	private double percentCocoa;
	
	/**
	 * @return the percentCocoa
	 */
	public double getPercentCocoa() {
		return percentCocoa;
	}

	/**
	 * @param percentCocoa the percentCocoa to set
	 */
	public void setPercentCocoa(double percentCocoa) {
		this.percentCocoa = percentCocoa;
	}

	/**
	 * @param name
	 * @param gramsOfSugar
	 */
	public Chocolate(String name, int gramsOfSugar, double percentCocoa) {
		super(name, gramsOfSugar);
		this.percentCocoa = percentCocoa;
	}

}
