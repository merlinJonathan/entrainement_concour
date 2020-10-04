package pingouin.models;

import java.util.ArrayList;
import java.util.List;

import pingouin.models.instruction.InstructionDrive;
import pingouin.models.instruction.InstructionDrop;
import pingouin.models.instruction.InstructionPickUp;
import pingouin.models.instruction.InstructionRent;
import pingouin.models.instruction.InstructionStep;

public class City {
	private List<Truck> trucks = new ArrayList<>();
	private List<Bike> bikes = new ArrayList<>();
	private List<Rental> rentals = new ArrayList<>();
	
	private int clock = 0;
	
	public City() {}
	
	public void addBike(Bike bike) {
		this.bikes.add(bike);
	}
	
	public void addTruck(Truck truck) {
		this.trucks.add(truck);
	}
	
	public void addRental(Rental rental) {
		this.rentals.add(rental);
	}

    public void initiateVehicles(int nbBikes, int nbTrucks, int maxCapacityEachTruck){    	
    	for(int i = 0; i < nbBikes; i++) {
    		this.bikes.add(new Bike(null));
    	}
    	
    	Truck.setMaxCapacity(maxCapacityEachTruck);
    	for(int i = 0; i < nbTrucks; i++) {
    		this.trucks.add(new Truck(new Coordonnees(0, 0)));
    	}
    }
    
    public Output start() {
		Output output = new Output();

		//placementInitialBike(output, city.getBikes());
		//placementInitialTruck(output, city.getTrucks());


		output.addCoordonneesBike(0, 3);
		this.bikes.get(0).setPosition(new Coordonnees(0, 3));
		output.addCoordonneesBike(4, 2);
		this.bikes.get(1).setPosition(new Coordonnees(4, 2));
		output.addCoordonneesTruck(3, 4);
		this.trucks.get(0).setPosition(new Coordonnees(3, 4));
		
		output.addInstruction(new InstructionRent(this.bikes.get(0), this.rentals.get(1)));
		output.addInstruction(new InstructionRent(this.bikes.get(1), this.rentals.get(0)));
		output.addInstruction(new InstructionStep());
		output.addInstruction(new InstructionStep());
		output.addInstruction(new InstructionPickUp(this.bikes.get(0), this.trucks.get(0)));
		output.addInstruction(new InstructionPickUp(this.bikes.get(1), this.trucks.get(0)));
		output.addInstruction(new InstructionDrive(this.trucks.get(0), new Coordonnees(3,  6)));
		output.addInstruction(new InstructionStep());
		output.addInstruction(new InstructionDrop(this.bikes.get(0), this.trucks.get(0)));
		output.addInstruction(new InstructionRent(this.bikes.get(0), this.rentals.get(3)));
		
		return output;
	}
    
    
    /** ============================================ PRIVATE ============================================== **/
	
	private void placementInitialBike(Output output) {
		for(Bike bike: this.bikes) {
			output.addCoordonneesBike(0, 0);
		}
	}
	
	private void placementInitialTruck(Output output) {
		for(Truck truck: this.trucks) {
			output.addCoordonneesTruck(0, 0);
		}
	}
	
	/** ============================================= Getter & Setter ======================================= **/
	
	public List<Truck> getTrucks() {
		return trucks;
	}

	public List<Bike> getBikes() {
		return bikes;
	}

	public List<Rental> getRentals() {
		return rentals;
	}
}
