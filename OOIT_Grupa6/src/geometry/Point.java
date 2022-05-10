package geometry;

import java.awt.Graphics;

public class Point extends Shape {

	private int x;
	private int y;

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
		setSelected(selected);
	}

	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;

		/*
		 * if (this.distance(x, y) <= 2) return true; else return false;
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

	@Override
	public void draw(Graphics g) {
		g.drawLine(x - 2, y, x + 2, y); // horizontalna linija
		g.drawLine(x, y - 2, x, y - 2); //vertiklna linija
	}

	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void moveBy(int byX, int byY) {
		this.x = this.x + byX;
		this.y += byY;
	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Point) {
			return (int) (this.distance(0, 0) - ((Point) obj).distance(0, 0));
		}
		return 0;
	}

}
