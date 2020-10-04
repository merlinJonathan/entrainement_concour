package pingouin.models;

public abstract class Vehicule {
	protected int speed;
	protected int id;
	protected Coordonnees position;
	
	public Vehicule(int id, int speed, Coordonnees position) {
		this.id = id;
		this.speed = speed;
		this.position = position;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Coordonnees getPosition() {
		return position;
	}

	public void setPosition(Coordonnees position) {
		this.position = position;
	}

	public abstract String toString();
}
