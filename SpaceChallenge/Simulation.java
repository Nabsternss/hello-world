package SpaceChallenge;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation{
	double random=0.0;
	public ArrayList<Item> loadItems(String phase)throws Exception {
		System.out.println("\n============   Prepairing items of '"+phase+"' that will send to MARS...   ============");
		File file = new File(phase);
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(file);
		ArrayList<Item> rocketItems=new ArrayList<Item>();

		while (scanner.hasNextLine()) {
			String line=scanner.nextLine();
			String [] details=line.split("=");
			Item rocketItem = new Item();
			rocketItem.name=details[0];
			rocketItem.weight=Integer.parseInt(details[1]);
			rocketItems.add(rocketItem);
		}
		//System.out.println(rocketItems.get(0).name);
		System.out.println("============   Items prepaired successfully   ============");
		return rocketItems;
	}
	public ArrayList<U1> loadU1()throws Exception{
		ArrayList<Item> items=loadItems("phase-1.txt");
		System.out.println("\n============   Start loading U1 rocket with items...   ============");
		ArrayList <U1> fleetU1=new ArrayList<>();
		int i=0;
		while (i<items.size()) {
			U1 u1=new U1();
			if (items.get(i).weight> u1.CargoLimit) {
				System.out.println("WARNING: cargo No. "+(i+1)+" :'"+items.get(i).name + "', has " 
						+ items.get(i).weight+" Tones, and it is over than the rocket cargo limit ("+u1.CargoLimit+")");
				i++;
			}
			else {
				while ((i<items.size())&&(u1.canCarry(items.get(i)))) {
					u1.carry(items.get(i));
					i++;
				}
				fleetU1.add(u1);
				System.out.println("Rocket U1 number "+fleetU1.size()+" has loaded with "+ u1.cargoCarried +" Tones successfully!");
			}
		}
		System.out.println(fleetU1.size()+" U1 rockets needed to send all items to Mars");
		System.out.println("============   End of loading U1 rocket with items...   ============");
		return fleetU1;
	}
	public ArrayList<U2> loadU2()throws Exception{
		ArrayList<Item> items=loadItems("phase-2.txt");
		System.out.println("\n============   Start loading U2 rocket with items...   ============");
		ArrayList <U2> fleetU2=new ArrayList<>();
		int i=0;
		while (i<items.size()) {
			U2 u2=new U2();
			if (items.get(i).weight> u2.CargoLimit) {
				System.out.println("WARNING: cargo No. "+(i+1)+" :'"+items.get(i).name + "', has " 
						+ items.get(i).weight+" Tones, and it is over than the rocket cargo limit ("+u2.CargoLimit+")");
				i++;
			}
			else {
				while ((i<items.size())&&(u2.canCarry(items.get(i)))) {
					u2.carry(items.get(i));
					i++;
				}
				fleetU2.add(u2);
				System.out.println("Rocket U2 number "+fleetU2.size()+" has loaded with "+ u2.cargoCarried +" Tones successfully!");
			}
		}
		System.out.println(fleetU2.size()+" U2 rockets needed to send all items to Mars");
		System.out.println("============   End of loading U2 rocket with items...   ============");
		return fleetU2;
	}

	public void runSimulation()throws Exception {
		ArrayList<U1>U1Fleet=new ArrayList<U1>();
		U1Fleet=loadU1();
		ArrayList<U2>U2Fleet=new ArrayList<U2>();
		U2Fleet=loadU2();
		System.out.println("\n============ start sending rockets to Mars: ============");
		int U1TotalPudget=0;
		int rocketCounter=0;
		random=Math.random();
		System.out.println("\nStart sending U1 rockets...");
		for(U1 u1 : U1Fleet) {
			while (u1.launch(random)==false || u1.land(random)==false) {
				random=Math.random();
				System.out.println("Rocket U1 number "+(U1Fleet.indexOf((u1))+1)+" has faild to launch or land, trying relaunch it again...");
				u1.numberOfRockets++;
				rocketCounter++;
			}
			u1.numberOfRockets++;
			System.out.println("Rocket U1 number "+(U1Fleet.indexOf((u1))+1)+" has launched after "+u1.numberOfRockets+" try/tries.");
			rocketCounter++;
		}
		System.out.println("=========== Number of U1 rockets needed to send all items to Mars is "+rocketCounter);
		U1TotalPudget=100*rocketCounter;
		System.out.println("=========== The cost of all U1 rockets that send to Mars is: $"+U1TotalPudget+" Milions");

		System.out.println("\nStart sending U2 rockets...");
		int U2TotalPudget=0;
		rocketCounter=0;
		for(U2 u2 : U2Fleet) {
			while (u2.launch(random)==false || u2.land(random)==false) {
				random=Math.random();
				System.out.println("Rocket U2 number "+(U2Fleet.indexOf((u2))+1)+" has faild to launch or land, trying relaunch it again...");
				u2.numberOfRockets++;
				rocketCounter++;
			}
			u2.numberOfRockets++;
			System.out.println("Rocket U2 number "+(U2Fleet.indexOf((u2))+1)+" has launched after "+u2.numberOfRockets+" try/tries.");
			rocketCounter++;
		}
		System.out.println("=========== Number of U2 rockets needed to send all items to Mars is "+rocketCounter);
		U2TotalPudget=120*rocketCounter;
		System.out.println("=========== The cost of all U2 rockets that send to Mars is: $"+U2TotalPudget+" Milions");
	}
}

