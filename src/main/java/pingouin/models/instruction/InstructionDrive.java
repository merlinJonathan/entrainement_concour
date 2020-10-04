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

	public static boolean isPossible(Truck truck) {
		if(truck == null) {
			return false;
		}
		
		if(!truck.isAvailable()) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return this.getInstruction() + " " + truck + " " + destination.getX() + " " + destination.getY();
	}
	
	@Override
	public void apply() {
		truck.setDestination(this.destination);
		truck.deplacer();
		
		if(truck.getDistanceToDestination() == 0) {
			this.estTermine = true;
			truck.setDestination(null);
		}
	}
}
