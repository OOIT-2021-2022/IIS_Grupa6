package geometry;

import java.awt.Graphics;

public class Donut extends Circle{

	private int innerRadius;
	
	public Donut () {
		
	}
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		//setCenter(center);
		//setRadius(radius);
		this.innerRadius = innerRadius;
	}
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center,radius,innerRadius);
		setSelected(selected);
	}
	
	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}
	
	public boolean contains(int x, int y) {
		return (super.contains(x, y) && getCenter().distance(x,y) >= innerRadius);
	}
	
	@Override
	public boolean contains(Point p) {
		return super.contains(p) && getCenter().distance(p.getX(), p.getY()) >= innerRadius;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut pomocni = (Donut) obj;
			if(pomocni.getCenter().equals(getCenter()) &&
					pomocni.getRadius() == getRadius() &&
					pomocni.innerRadius == innerRadius) 
				return true;
			return false;
		}
		return false;
	}
	
	
	
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	public int getInnerRadius() {
		return innerRadius;
	}
	
	
	public String toString() {
		return super.toString() + " , innerRadius: " + innerRadius;
				
	}
	public void draw(Graphics g) {
		super.draw(g); //spoljasnji krug
		g.drawOval(getCenter().getX() - innerRadius, getCenter().getY() - innerRadius, innerRadius*2, innerRadius*2);
		//unutrasnji krug
	}

}
