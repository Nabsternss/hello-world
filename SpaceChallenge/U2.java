package SpaceChallenge;

public class U2 extends Rocket {
	U2(){
		rocketCost=120;
		rocketWeight=18000;
		RocketMaxWeight=29000;
		cargoCarried=0;
		CargoLimit=11000;
		currentWeight=rocketWeight;
		launchExplosionChance=0.04*(cargoCarried/CargoLimit);
		landCrashChance=0.08*(cargoCarried/CargoLimit);
	}
	@Override
	public boolean launch(double random) {
		random =Math.random();
		launchExplosionChance=0.04*((double)cargoCarried/(double)CargoLimit);
		return (this.launchExplosionChance<random);
	}

	@Override
	public boolean land(double random) {
		random =Math.random();
		launchExplosionChance=0.08*((double)cargoCarried/(double)CargoLimit);
		return (this.launchExplosionChance<random);
	}
}
