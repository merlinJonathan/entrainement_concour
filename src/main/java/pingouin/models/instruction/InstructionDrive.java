package pingouin.models.instruction;

import pingouin.enums.InstructionEnums;
import pingouin.models.Coordonnees;
import pingouin.models.Truck;

public class InstructionDrive extends Instruction {
	private Truck truck;
	private Coordonnees destination;
	
	public InstructionDrive(Truck truck, Coordonnees destination) {
		super(InstructionEnums.DRIVE);
		this.truck = truck;
		this.destination = destination;
	}

	@Override
	public String toString() {
		return this.getInstruction() + " " + truck + " " + destination.getX() + " " + destination.getY();
	}
}
