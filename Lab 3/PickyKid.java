
public class PickyKid extends Kid{
	String candyTypeDislike;
	
	public PickyKid(String name, String costume, String candyType){
		super(name, costume);
		candyTypeDislike = candyType;
	}
	
	@Override
	public void collectCandy(Candy piece){
		if (piece.getName().equals(candyTypeDislike)){
			System.out.println(super.getName() + " dislikes " + candyTypeDislike + " and throws it on the ground. It is ruined forever");
			return;
		}
		else
			super.collectCandy(piece);
	}
}
