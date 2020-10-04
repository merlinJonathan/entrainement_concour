package pingouin.models;

public abstract class Vehicule {
	protected int speed;
	protected int id;
	protected Coordonnees position;
	protected Coordonnees destination;
	
	public Vehicule(int id, int speed, Coordonnees position) {
		this.id = id;
		this.speed = speed;
		this.position = position;
	}
	
	public void deplacer() {
		for(int i = 0 ; i < speed ; i++) {
			boolean aDejaBouge = false;
			if(this.position.getX() < destination.getX()) {
				this.position.setX(this.position.getX() + 1);
				aDejaBouge = true;
			}
			
			if(!aDejaBouge && this.position.getX() > destination.getX()) {
				this.position.setX(this.position.getX() - 1);
				aDejaBouge = true;
			}
			
			if(!aDejaBouge && this.position.getY() < destination.getY()) {
				this.position.setY(this.position.getY() + 1);
				aDejaBouge = true;
			}
			
			if(!aDejaBouge && this.position.getY() > destination.getY()) {
				this.position.setY(this.position.getY() - 1);
				aDejaBouge = true;
			}
		}
	}
	
	public int getDistanceToDestination() {
		return position.distanceTo(destination);
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

	public Coordonnees getDestination() {
		return destination;
	}

	public void setDestination(Coordonnees destination) {
		this.destination = destination;
	}

	public abstract String toString();
}
