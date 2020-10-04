package pingouin.enums;

public enum InstructionEnums {
	RENT("RENT"),
	DRIVE("DRIVE"),
	DROP("DROP"),
	PICKUP("PICKUP"),
	STEP("STEP");
	
	private String instruction;
	
	private InstructionEnums(String instruction) {
		this.instruction = instruction;
	}
	
	public String toString() {
		return this.instruction;
	}
}
