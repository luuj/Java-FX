
public class Candy implements Comparable<Candy>{
	protected String name;
	private int gramsOfSugar;
	
	/**
	 * @param name
	 * @param gramsOfSugar
	 */
	public Candy(String name, int gramsOfSugar) {
		this.name = name;
		this.gramsOfSugar = gramsOfSugar;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Candy [name=" + name + ", gramsOfSugar=" + gramsOfSugar + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gramsOfSugar;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Candy)) {
			return false;
		}
		Candy other = (Candy) obj;
		if (gramsOfSugar != other.gramsOfSugar) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gramsOfSugar
	 */
	public int getGramsOfSugar() {
		return gramsOfSugar;
	}
	/**
	 * @param gramsOfSugar the gramsOfSugar to set
	 */
	public void setGramsOfSugar(int gramsOfSugar) {
		this.gramsOfSugar = gramsOfSugar;
	}

	@Override
	public int compareTo(Candy o) {	
		return (this.name).compareTo(o.getName());
	}
	
	
}
