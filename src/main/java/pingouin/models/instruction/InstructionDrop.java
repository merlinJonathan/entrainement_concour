package pingouin.models.instruction;

import pingouin.enums.InstructionEnums;
import pingouin.models.Bike;

public class InstructionDrop extends Instruction {
	private Bike bike;
	
	public InstructionDrop(Bike bike) {
		super(InstructionEnums.DROP);
		this.bike = bike;
	}

	@Override
	public String toString() {
		return this.getInstruction() + " " + bike;
	}
}
