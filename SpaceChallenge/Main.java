package SpaceChallenge;

public class Main {

	public static void main(String[] args) {
		Simulation simulation = new Simulation();
		try {
			simulation.runSimulation();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
