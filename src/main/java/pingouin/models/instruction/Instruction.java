package pingouin.models.instruction;

import pingouin.enums.InstructionEnums;

public abstract class Instruction {
	private InstructionEnums instruction;
	protected boolean estTermine = false;
	
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
	
	public boolean isEstTermine() {
		return estTermine;
	}

	public void setEstTermine(boolean estTermine) {
		this.estTermine = estTermine;
	}

	public abstract String toString();

	public abstract void apply();
}
