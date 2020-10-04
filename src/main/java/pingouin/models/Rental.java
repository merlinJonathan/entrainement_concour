package pingouin.models;

import java.util.Arrays;
import java.util.List;

public class Rental {
	private static int compteurId = 0;
	private static int prixBase;
	private int id;
	private int tourDepart;
	private Coordonnees positionClient;
	private int speedClient = 1;
	private boolean isAvailable = true;
	private Coordonnees destination;
	private int rangeMaxMarcheClient;
	
	public Rental() {
		this.id = compteurId;
		compteurId++;
	}
	
	public Rental(int tourDepart, Coordonnees positionClient, Coordonnees destination, int rangeMaxMarcheClient) {
		this();
		this.tourDepart = tourDepart;
		this.positionClient = positionClient;
		this.destination = destination;
		this.rangeMaxMarcheClient = rangeMaxMarcheClient;
	}
	
	public Rental(String fileLine) {
		this();
		List<String> line = Arrays.asList(fileLine.split(" "));
		
		this.tourDepart = Integer.parseInt(line.get(0));
		this.positionClient = new Coordonnees(Integer.parseInt(line.get(1)), Integer.parseInt(line.get(2)));
		this.destination = new Coordonnees(Integer.parseInt(line.get(3)), Integer.parseInt(line.get(4)));
		this.rangeMaxMarcheClient = Integer.parseInt(line.get(5));
	}

	public int getRangeMaxMarcheClient() {
		return rangeMaxMarcheClient;
	}

	public void setRangeMaxMarcheClient(int rangeMaxMarcheClient) {
		this.rangeMaxMarcheClient = rangeMaxMarcheClient;
	}

	public Coordonnees getDestination() {
		return destination;
	}

	public void setDestination(Coordonnees destination) {
		this.destination = destination;
	}

	public static int getPrixBase() {
		return prixBase;
	}

	public static void setPrixBase(int prixBase) {
		Rental.prixBase = prixBase;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getSpeedClient() {
		return speedClient;
	}

	public Coordonnees getPositionClient() {
		return positionClient;
	}

	public void setPositionClient(Coordonnees positionClient) {
		this.positionClient = positionClient;
	}

	public int getId() {
		return id;
	}
	
	public int getTourDepart() {
		return tourDepart;
	}

	public static int getCompteurId() {
		return compteurId;
	}

	public static void setCompteurId(int compteurId) {
		Rental.compteurId = compteurId;
	}

	public String toString() {
		return "R" + this.id;
	}
}
