package pingouin.models.instruction;

import pingouin.enums.InstructionEnums;
import pingouin.models.Bike;
import pingouin.models.Rental;

public class InstructionStep extends Instruction {
	
	public InstructionStep() {
		super(InstructionEnums.STEP);
	}


	public static boolean isPossible(Bike bike, Rental rental) {
		return true;
	}

	@Override
	public String toString() {
		return this.getInstruction().toString();
	}

	@Override
	public void apply() {	
		this.estTermine = true;
	}
}
