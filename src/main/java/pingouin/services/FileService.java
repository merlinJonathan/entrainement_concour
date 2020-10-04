package pingouin.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pingouin.models.Bike;
import pingouin.models.City;
import pingouin.models.Rental;
import pingouin.models.Truck;

public class FileService {
	public static List<String> readFile(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .collect(Collectors.toList());
    }

    public static void writeFile(List<String> lines, String filePath) throws IOException {
        Files.write(Paths.get(filePath), lines);
    }

    public static void appendFile(List<String> lines, String filePath) throws IOException {
        Files.write(Paths.get(filePath), lines, StandardOpenOption.APPEND);
    }

    public static City initData(String inputfile) throws IOException {
        City city = new City();
        resetCounts();
        
        List<String> lines = FileService.readFile(inputfile);

        final List<String> firstLine = Arrays.asList(lines.get(0).split(" "));
        final List<String> rentalRequestLines = lines.subList(1, lines.size());

        final int nbBicycles = Integer.parseInt(firstLine.get(1));
        final int nbTrucks = Integer.parseInt(firstLine.get(2));
        final int capacityTruck = Integer.parseInt(firstLine.get(3));
        final int basePrice = Integer.parseInt(firstLine.get(4));

        for(String rentalRequestLine: rentalRequestLines) {
        	Rental rental = new Rental(rentalRequestLine);
        	city.addRental(rental);
        }

        city.initiateVehicles(nbBicycles, nbTrucks, capacityTruck);
        Rental.setPrixBase(basePrice);

        return city;
    }
    
    private static void resetCounts() {
        Bike.setCompteurID(0);
        Truck.setCompteurID(0);
        Rental.setCompteurId(0);
    }
}
