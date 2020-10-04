package pingouin.models;

import java.util.ArrayList;
import java.util.List;

public class City {
	private List<Truck> trucks = new ArrayList<>();
	private List<Bike> bikes = new ArrayList<>();
	private List<Rental> rentals = new ArrayList<>();
	
	private int clock = 0;
	private int score = 0;
	
	public City() {}

	public List<Truck> getTrucks() {
		return trucks;
	}

	public List<Bike> getBikes() {
		return bikes;
	}

	public List<Rental> getRentals() {
		return rentals;
	}
	
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
}
