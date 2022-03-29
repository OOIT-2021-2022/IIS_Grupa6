package geometry;

public class Rectangle {

	private Point upperLeft;
	private int width;
	private int height;
	private boolean selected;
	
	// Konstruktori 
	
	public Rectangle () {
		
	}
	public Rectangle (Point upperLeft, int width, int height) {
		this.upperLeft = upperLeft;
		this.height = height;
		this.width = width;
	}
	public Rectangle (Point upperLeft, int width, int height, boolean selected) {
		this (upperLeft, width, height);
		this.selected = selected;
	}
	
	// Povrsina pravougaonika
	public int area() {
		return width * height;
	}
	// Obim pravougaonika 
	
	public int circumference() {
		return 2*width + 2*height;
	}
	
	// Metode pristupa
	public Point getUpperLeft() {
		return upperLeft;
	}
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle pomocni = (Rectangle) obj;
			if (this.upperLeft.equals(pomocni.getUpperLeft()) && this.width == pomocni.width && this.height == pomocni.height) {
				return true;
			} else {
				return false;
			}
		}else {
			return false;
		}
	}
	public String toString() {
		return "Upper left point: " + upperLeft + " ,width= " + width + " ,height= " + height;
	}
}
