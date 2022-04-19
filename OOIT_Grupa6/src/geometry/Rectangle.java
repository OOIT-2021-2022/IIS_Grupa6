package geometry;

import java.awt.Graphics;

public class Rectangle extends Shape{

	private Point upperLeft;
	private int width;
	private int height;
	
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
		setSelected(selected);
	}
	public boolean contains(int x, int y) {
		return (upperLeft.getX() < x && upperLeft.getX() + width > x && upperLeft.getY() < y
				&& upperLeft.getY() + height > y);
	}
	public boolean contains(Point p) {
		return upperLeft.getX() < p.getX() && upperLeft.getX() + width > p.getX()
				&& upperLeft.getY() < p.getY() && upperLeft.getY() + height > p.getY();
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
	@Override
	public void draw(Graphics g) {
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		
	}
}
