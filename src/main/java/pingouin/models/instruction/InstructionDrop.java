package pingouin.models.instruction;

import pingouin.enums.InstructionEnums;
import pingouin.models.Bike;
import pingouin.models.Coordonnees;
import pingouin.models.Truck;

public class InstructionDrop extends Instruction {
	private Bike bike;
	private Truck truck;
	
	public InstructionDrop(Bike bike, Truck truck) {
		super(InstructionEnums.DROP);
		this.bike = bike;
		this.truck = truck;
	}

	@Override
	public String toString() {
		return this.getInstruction() + " " + bike;
	}

	public static boolean isPossible(Bike bike, Truck truck) {
		if(bike == null) {
			return false;
		}
		
		if(truck == null) {
			return false;
		}
		
		if(!truck.isAvailable()) {
			return false;
		}
		
		int indexOfBike = truck.getBikesOnTruck().indexOf(bike);
		if(indexOfBike < 0) {
			return false;
		}
		
		return true;
	}

	@Override
	public void apply() {
		truck.getBikesOnTruck().remove(bike);
		bike.setPosition(new Coordonnees(truck.getPosition().getX(), truck.getPosition().getY()));
		bike.setDestination(null);
		this.estTermine = true;
	}
}
