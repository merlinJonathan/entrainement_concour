package pingouin.models;

public class Coordonnees {
	private int x;
	private int y;
	
	public Coordonnees(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int distanceTo(Coordonnees b) {
		return Math.abs(this.x - b.x) + Math.abs(this.y - b.y);
	}

	@Override
	public String toString() {
		return "[" + x + ";" + y + "]";
	}
}
