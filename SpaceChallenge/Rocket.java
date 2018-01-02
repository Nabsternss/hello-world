package SpaceChallenge;

public class Rocket implements SpaceShip{

	int rocketCost=0;
	int rocketWeight=0;
	int RocketMaxWeight=0;
	int cargoCarried=0;
	int CargoLimit=0;
	int currentWeight=rocketWeight;
	double launchExplosionChance=0.0;
	double landCrashChance=0.0;
	int numberOfRockets=0;



	@Override
	public boolean launch(double random) {
		return true;
	}

	@Override
	public boolean land(double random) {
		return true;
	}

	@Override
	public boolean canCarry(Item item) {
		return (this.currentWeight+item.weight)<=this.RocketMaxWeight;
	}

	@Override
	public void carry(Item item) {
		this.currentWeight+=item.weight;
		this.cargoCarried=this.currentWeight-this.rocketWeight;
	}

}
