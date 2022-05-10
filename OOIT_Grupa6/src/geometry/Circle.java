package geometry;

import java.awt.Graphics;

public class Circle extends Shape {

	private Point center;
	private int radius;
	
	public Circle() {
		
	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		setSelected(selected);
	}
	
	public boolean contains(int x, int y) {
		return center.distance(x, y) <= radius;
	}
	public boolean contains(Point p)
	{
		return center.distance(p.getX(), p.getY()) <= radius;
	}
	
	public double area() {
		return radius * radius * Math.PI;
	}
	public double circumference() {
		return 2 * radius * Math.PI;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle pomocni = (Circle) obj;
			if(pomocni.getCenter().equals(center) && pomocni.getRadius() == radius) 
				return true;
			return false;
		}
		return false;
		
	}
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public String toString() {
		return "Center point =" + center + " radius =" + radius;
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(center.getX() - radius, center.getY() - radius, radius*2,  radius*2);
		
	}

	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
	}

	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);
	}

	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Circle) {
			return  (int) (this.area() - ((Circle) obj).area());
		}
		return 0;
	}

}
