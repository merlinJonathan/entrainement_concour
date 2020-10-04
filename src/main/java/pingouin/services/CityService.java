package pingouin.services;

import java.util.List;

import pingouin.models.Bike;
import pingouin.models.City;
import pingouin.models.Coordonnees;
import pingouin.models.Output;
import pingouin.models.Truck;
import pingouin.models.instruction.InstructionDrive;
import pingouin.models.instruction.InstructionDrop;
import pingouin.models.instruction.InstructionPickUp;
import pingouin.models.instruction.InstructionRent;
import pingouin.models.instruction.InstructionStep;

public class CityService {
	public static Output start(City city) {
		Output output = new Output();

		//placementInitialBike(output, city.getBikes());
		//placementInitialTruck(output, city.getTrucks());


		output.addCoordonneesBike(0, 3);
		city.getBikes().get(0).setPosition(new Coordonnees(0, 3));
		output.addCoordonneesBike(4, 2);
		city.getBikes().get(1).setPosition(new Coordonnees(4, 2));
		output.addCoordonneesTruck(3, 4);
		city.getTrucks().get(0).setPosition(new Coordonnees(3, 4));
		
		output.addInstruction(new InstructionRent(city.getBikes().get(0), city.getRentals().get(1)));
		output.addInstruction(new InstructionRent(city.getBikes().get(1), city.getRentals().get(0)));
		output.addInstruction(new InstructionStep());
		output.addInstruction(new InstructionStep());
		output.addInstruction(new InstructionPickUp(city.getBikes().get(0), city.getTrucks().get(0)));
		output.addInstruction(new InstructionPickUp(city.getBikes().get(1), city.getTrucks().get(0)));
		output.addInstruction(new InstructionDrive(city.getTrucks().get(0), new Coordonnees(3,  6)));
		output.addInstruction(new InstructionStep());
		output.addInstruction(new InstructionDrop(city.getBikes().get(0)));
		output.addInstruction(new InstructionRent(city.getBikes().get(0), city.getRentals().get(3)));
		
		return output;
	}
	
	private static void placementInitialBike(Output output, List<Bike> listeBike) {
		for(Bike bike: listeBike) {
			output.addCoordonneesBike(0, 0);
		}
	}
	
	private static void placementInitialTruck(Output output, List<Truck> listeTruck) {
		for(Truck truck: listeTruck) {
			output.addCoordonneesTruck(0, 0);
		}
	}
}
