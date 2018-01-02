package SpaceChallenge;

public class Item {
	String name;
	int weight;
	public Item() {}
	public Item(String name,int weight) {
		this.name=name;
		this.weight=weight;
	}
	  @Override
	  public String toString() {
	    return name;
	  }
}
