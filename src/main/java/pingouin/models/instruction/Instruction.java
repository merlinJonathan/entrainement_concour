package pingouin.models.instruction;

import pingouin.enums.InstructionEnums;

public abstract class Instruction {
	private InstructionEnums instruction;

	public Instruction(InstructionEnums instruction) {
		super();
		this.instruction = instruction;
	}

	public InstructionEnums getInstruction() {
		return instruction;
	}

	public void setInstruction(InstructionEnums instruction) {
		this.instruction = instruction;
	}
	
	public abstract String toString();
}
