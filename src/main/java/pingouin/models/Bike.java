package pingouin.models;

public class Bike extends Vehicule {
	private static int compteurID = 0;
	
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

	@Override
	public String toString() {
		return "B" + this.id;
	}
}
