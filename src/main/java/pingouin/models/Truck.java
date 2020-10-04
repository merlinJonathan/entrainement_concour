package pingouin.models;

import java.util.ArrayList;
import java.util.List;

public class Truck extends Vehicule{
	private static int compteurID = 0;
	private static int maxCapacity;
	private Coordonnees destination;
	private List<Bike> bikesOnTruck = new ArrayList<>();
	
	public Truck(Coordonnees position) {
		super(compteurID, 2, position);
		compteurID++;
		this.destination = null;
	}

	public static int getMaxCapacity() {
		return maxCapacity;
	}

	public static void setMaxCapacity(int maxCapacity) {
		Truck.maxCapacity = maxCapacity;
	}

	public boolean isAvailable() {
		return destination != null;
	}

	public Coordonnees getDestination() {
		return destination;
	}

	public void setDestination(Coordonnees destination) {
		this.destination = destination;
	}

	public List<Bike> getBikesOnTruck() {
		return bikesOnTruck;
	}

	public void setBikesOnTruck(List<Bike> bikesOnTruck) {
		this.bikesOnTruck = bikesOnTruck;
	}

	public static int getCompteurID() {
		return compteurID;
	}

	public static void setCompteurID(int compteurID) {
		Truck.compteurID = compteurID;
	}

	@Override
	public String toString() {
		return "T" + this.id;
	}
}
