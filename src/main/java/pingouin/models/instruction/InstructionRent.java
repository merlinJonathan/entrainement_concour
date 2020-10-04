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
	
	public static boolean isPossible(Bike bike, Rental rental) {
		if(rental == null || bike == null) {
			return false;
		}
		
		if(!bike.isAvailable()) {
			return false;
		}
		
		if(!rental.isAvailable()) {
			return false;
		}
		
		if(bike.getPosition().distanceTo(rental.getPositionClient()) > rental.getRangeMaxMarcheClient()) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return this.getInstruction() + " " + bike + " " + rental;
	}

	@Override
	public void apply() {
		rental.setAvailable(false);
		bike.setDestination(rental.getDestination());
		
		if(bike.getPosition().distanceTo(rental.getPositionClient()) != 0) {
			this.deplacementClient();
		} else {
			bike.deplacer();
			this.rental.setPositionClient(bike.getDestination());
		}
		
		if(bike.getPosition().distanceTo(rental.getDestination()) == 0) {
			bike.setDestination(null);
			this.estTermine = true;
		}
	}
	
	/** ========================================== PRIVATE ======================================== **/
	private void deplacementClient() {
		boolean aDejaBouge = false;
		if(bike.getPosition().getX() < rental.getPositionClient().getX()) {
			rental.getPositionClient().setX(rental.getPositionClient().getX() - 1);
			aDejaBouge = true;
		}
		
		if(!aDejaBouge && bike.getPosition().getX() > rental.getPositionClient().getX()) {
			rental.getPositionClient().setX(rental.getPositionClient().getX() + 1);
			aDejaBouge = true;
		}
		
		if(!aDejaBouge && bike.getPosition().getY() < rental.getPositionClient().getY()) {
			rental.getPositionClient().setY(rental.getPositionClient().getY() - 1);
			aDejaBouge = true;
		}
		
		if(!aDejaBouge && bike.getPosition().getY() > rental.getPositionClient().getY()) {
			rental.getPositionClient().setY(rental.getPositionClient().getY() + 1);
			aDejaBouge = true;
		}
	}
}
