package SpaceChallenge;

public class U1 extends Rocket{
	U1(){
		rocketCost=100;
		rocketWeight=10000;
		RocketMaxWeight=18000;
		cargoCarried=0;
		CargoLimit=8000;
		currentWeight=rocketWeight;
		launchExplosionChance=0.05;
		landCrashChance=0.01;
		numberOfRockets=0;
	}
	@Override
	public boolean launch(double random) {
		random =Math.random();
		launchExplosionChance=0.05*((double)cargoCarried/(double)CargoLimit)*10;
		return (this.launchExplosionChance<random);
	}

	@Override
	public boolean land(double random) {
		random =Math.random();
		launchExplosionChance=0.01*((double)cargoCarried/(double)CargoLimit)*10;
		return (this.launchExplosionChance<random);
	}
}
