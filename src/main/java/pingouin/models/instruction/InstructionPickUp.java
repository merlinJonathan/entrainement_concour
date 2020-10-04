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

	@Override
	public String toString() {
		return this.getInstruction() + " " + bike + " " + truck;
	}
}
