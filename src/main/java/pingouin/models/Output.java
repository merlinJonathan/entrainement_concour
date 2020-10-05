package pingouin.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pingouin.models.instruction.Instruction;
import pingouin.models.instruction.InstructionRent;
import pingouin.services.FileService;

public class Output {
	List<Coordonnees> coordonneesDepartBike = new ArrayList<>();  
	List<Instruction> instructions = new ArrayList<>();
	List<Coordonnees> coordonneesDepartTruck = new ArrayList<>();
	
	public Output() {}

	public void addCoordonneesBike(int x, int y) {
		this.coordonneesDepartBike.add(new Coordonnees(x, y));
	}

	public void addCoordonneesTruck(int x, int y) {
		this.coordonneesDepartTruck.add(new Coordonnees(x, y));
	}

	public void addInstruction(Instruction instruction) {
		this.instructions.add(instruction);
	}

	public List<Coordonnees> getCoordonneesDepartBike() {
		return coordonneesDepartBike;
	}

	public void setCoordonneesDepartBike(List<Coordonnees> coordonneesDepartBike) {
		this.coordonneesDepartBike = coordonneesDepartBike;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	public List<Coordonnees> getCoordonneesDepartTruck() {
		return coordonneesDepartTruck;
	}

	public void setCoordonneesDepartTruck(List<Coordonnees> coordonneesDepartTruck) {
		this.coordonneesDepartTruck = coordonneesDepartTruck;
	}

	@Override
	public String toString() {
		String result = "";
		
		for(Coordonnees bike: this.coordonneesDepartBike) {
			result += bike.getX() + " " + bike.getY() + "\n";
		}
		
		result += "\n";
		
		for(Coordonnees truck: this.coordonneesDepartTruck) {
			result += truck.getX() + " " + truck.getY() + "\n";
		}
		
		result += "\n";
		
		for(Instruction instruction : this.instructions) {
			result += instruction + "\n";
		}
		
		return result;
	}
	
	public List<String> getListLines() {
		List<String> result = new ArrayList<>();
		
		for(Coordonnees bike: this.coordonneesDepartBike) {
			result.add(bike.getX() + " " + bike.getY());
		}

		result.add("");
		
		for(Coordonnees truck: this.coordonneesDepartTruck) {
			result.add(truck.getX() + " " + truck.getY());
		}

		result.add("");
		
		for(Instruction instruction : this.instructions) {
			result.add(instruction.toString());
		}
		
		return result;
	}
	
	public void generateFile(String filePath) throws IOException {
        FileService.writeFile(this.getListLines(), filePath);
    }
	
	public int getScore() {
		int score = 0;
		
		for(Instruction instruction : this.instructions) {
			if(instruction instanceof InstructionRent) {
				InstructionRent rent = (InstructionRent) instruction;
				
				score += rent.getDistanceAParcourir();
				score += Rental.getPrixBase();
			}
		}
		
		return score;
	}
	
	public List<Instruction> getAllInstructionsEnCours() {
		return instructions.stream().filter(instruction -> instruction.isEstTermine() == false).collect(Collectors.toList());
	}
}
