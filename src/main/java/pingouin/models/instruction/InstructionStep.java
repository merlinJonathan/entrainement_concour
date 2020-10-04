package pingouin.models.instruction;

import pingouin.enums.InstructionEnums;

public class InstructionStep extends Instruction {
	
	public InstructionStep() {
		super(InstructionEnums.STEP);
	}

	@Override
	public String toString() {
		return this.getInstruction().toString();
	}
}
