package pingouin.models;

public class Bike extends Vehicule {
	private static int compteurID = 0;
	private Coordonnees destination;
	
	public Bike(Coordonnees position) {
		super(compteurID, 2, position);
		compteurID++;
		destination = null;
	}
	
	public boolean isAvailable() {
		return destination != null;
	}
	
	public static int getCompteurID() {
		return compteurID;
	}

	public static void setCompteurID(int compteurID) {
		Bike.compteurID = compteurID;
	}

	public Coordonnees getDestination() {
		return destination;
	}

	public void setDestination(Coordonnees destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "B" + this.id;
	}
}
