package geometry;

public class Point {

	private int x;
	private int y;
	private boolean selected;

	public double distance(int x2, int y2) {
		double dx = x - x2;
		double dy = y - y2;
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}
	// konstruktori

	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, boolean selected) {
		this(x, y);
		this.selected = selected;
	}

	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;

		/*
		 * if (this.distance(x, y) <= 2) 
		 * 	return true; 
		 * else 
		 * 	return false;
		 */
	}

	// metode pristupa
	// GET i SET metode
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;

	}

	public int getY() {
		return this.y; // moze i return y (bez this)
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point pomocna = (Point) obj;

			if (this.x == pomocna.getX() && this.y == pomocna.getY()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public String toString() {

		return "(" + x + "," + y + ")";

	}

}
