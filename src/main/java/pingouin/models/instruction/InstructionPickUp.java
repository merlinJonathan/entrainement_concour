package pingouin.models.instruction;

import pingouin.enums.InstructionEnums;
import pingouin.models.Bike;
import pingouin.models.Truck;

public class InstructionPickUp extends Instruction {
	private Bike bike;
	private Truck truck;
	
	public InstructionPickUp(Bike bike, Truck truck) {
		super(InstructionEnums.PICKUP);
		this.bike = bike;
		this.truck = truck;
	}

	public static boolean isPossible(Bike bike, Truck truck) {
		if(bike == null || truck == null) {
			return false;
		}
		
		if(!bike.isAvailable()) {
			return false;
		}
		
		if(!truck.isAvailable()) {
			return false;
		}
		
		if(bike.getPosition().distanceTo(truck.getPosition()) != 0) {
			return false;
		}
		
		if(Truck.getMaxCapacity() >= truck.getBikesOnTruck().size()) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return this.getInstruction() + " " + bike + " " + truck;
	}

	@Override
	public void apply() {
		truck.getBikesOnTruck().add(bike);
		this.estTermine = true;
	}
}
