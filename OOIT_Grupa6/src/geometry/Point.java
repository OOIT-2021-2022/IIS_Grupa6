package geometry;

public class Point {

	private int x;
	private int y;
	private boolean selected;
	
	public double distance(int x2, int y2) {
		double dx = x - x2;
		double dy = y - y2;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;
	}
	
	//metode pristupa
	//GET i SET metode
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
		
	}
	public int getY() {
		return this.y; //moze i return y (bez this)
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
}
