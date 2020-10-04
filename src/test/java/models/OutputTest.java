package models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pingouin.models.Bike;
import pingouin.models.Coordonnees;
import pingouin.models.Output;
import pingouin.models.Rental;
import pingouin.models.Truck;
import pingouin.models.instruction.InstructionDrive;
import pingouin.models.instruction.InstructionDrop;
import pingouin.models.instruction.InstructionPickUp;
import pingouin.models.instruction.InstructionRent;
import pingouin.models.instruction.InstructionStep;

public class OutputTest {

	@Test
	public void testGetScore() {
		Output output = new Output();

		Bike bike0 = new Bike(new Coordonnees(0, 3));
		Bike bike1 = new Bike(new Coordonnees(4, 2));
		Bike bike0_1 = new Bike(new Coordonnees(3, 6));

		Rental rental0 = new Rental(0, new Coordonnees(4, 2), new Coordonnees(3, 4), 1);
		Rental rental1 = new Rental(0, new Coordonnees(0, 3), new Coordonnees(3, 4), 2);
		Rental rental2 = new Rental(1, new Coordonnees(9, 4), new Coordonnees(6, 6), 1);
		Rental rental3 = new Rental(3, new Coordonnees(4, 6), new Coordonnees(7, 6), 2);
		Rental.setPrixBase(5);
		
		Truck truck0 = new Truck(new Coordonnees(3, 4));

		output.addInstruction(new InstructionRent(bike0, rental1));
		output.addInstruction(new InstructionRent(bike1, rental0));
		output.addInstruction(new InstructionStep());
		output.addInstruction(new InstructionStep());
		output.addInstruction(new InstructionPickUp(bike0, truck0));
		output.addInstruction(new InstructionPickUp(bike1, truck0));
		output.addInstruction(new InstructionDrive(truck0, new Coordonnees(3, 6)));
		output.addInstruction(new InstructionStep());
		output.addInstruction(new InstructionDrop(bike0));
		output.addInstruction(new InstructionRent(bike0_1, rental3));
		
		assertEquals(26, output.getScore());
	}
}
