package pingouin.models.instruction;

import pingouin.enums.InstructionEnums;
import pingouin.models.Bike;
import pingouin.models.Rental;

public class InstructionRent extends Instruction {
	private Bike bike;
	private Rental rental;
	
	public InstructionRent(Bike bike, Rental rental) {
		super(InstructionEnums.RENT);
		this.bike = bike;
		this.rental = rental;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}
	
	public int getDistanceAParcourir() {
		return this.bike.getPosition().distanceTo(this.rental.getDestination());
	}

	@Override
	public String toString() {
		return this.getInstruction() + " " + bike + " " + rental;
	}
}
