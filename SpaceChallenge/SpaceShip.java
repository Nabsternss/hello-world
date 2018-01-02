package SpaceChallenge;

public interface SpaceShip {
	public boolean launch(double random) ;
	public boolean land(double random);
	public boolean canCarry(Item item);
	public void carry(Item item);
}
