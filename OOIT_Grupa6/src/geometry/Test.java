package geometry;

public class Test {

	public static void main(String[] args) {
		
		Point p = new Point (); 
		p.setX(6);
		p.setY(5);
		p.setSelected(true);
		
		System.out.println("X coordinate: " + p.getX() + " Y coordinate: " + p.getY() + " Selected: " + p.isSelected());
		
		double result = p.distance(2, 2);
		System.out.println("Distance between points is: " + result);
		
		Line l1 = new Line();
		Rectangle r1 = new Rectangle();
		Point p1 = new Point();
		Circle c1 = new Circle();
		p1.setX(1);
		p1.setY(1);
		
		// 1. Inicijalizovati x koordinatu tacke p na vrednost y koordinate tacke p1
		p.setX(p1.getY());
		System.out.println("Point p, x coordinate: " + p.getX());
		
		//2. Postaviti za pocetnu tacku linije l1 tacku p, a za krajnju tacku linije l1 tacku p1
		
		l1.setStartPoint(p);
		l1.setEndPoint(p1);
		System.out.println("Line l1 start point " + l1.getStartPoint().getX() + "," +  l1.getStartPoint().getY());
		
		//3. Postaviti y koordinatu krajnje tacke l1 na 23
		
		l1.getEndPoint().setY(23);
		
		// 4. Inicijalizovati x koordinatu pocetne tacke linije l1
				// na vrednost y koordinate krajnje tacke linije l1

				l1.getStartPoint().setX(l1.getEndPoint().getY());
				System.out.println("X of start point of line l1 = " + l1.getStartPoint().getX());

				// 5. Postaviti x koordinatu krajnje tacke l1 na vrednost
				// duzine linije l1 umanjene za vrednost zbira x i y
				// koordinate pocetne tacke linije l1

				l1.getEndPoint().setX((int) (l1.length() - (l1.getStartPoint().getX() + l1.getEndPoint().getY())));										

				// 6. Postaviti x koordinatu tacke gore levo pravougaonika
				// r1 na vrednost 10 i y koordinatu na vrednost 15

				r1.setUpperLeft(p1);
				r1.getUpperLeft().setX(10);
				r1.getUpperLeft().setY(15);
				System.out.println("X of U.L.P of r1 = " + r1.getUpperLeft().getX());
				System.out.println("Y of U.L.P of r1 = " + r1.getUpperLeft().getY());

				// 7. Postaviti centar kruga c1 na koordinate tacke
				// gore levo od r1

				c1.setCenter(r1.getUpperLeft());
				System.out.println("X of center of c1 = " + c1.getCenter().getX());
				System.out.println("Y of center of c1 = " + c1.getCenter().getY());

				// 8. Postaviti x koordinatu centra kruga c1 na vrednost razlike
				// povrsine pravougaonika r1 i y koordinate pocetne tacke linije l1

				r1.setHeight(20);
				r1.setWidth(30);
				c1.getCenter().setX(r1.area() - l1.getStartPoint().getY());
				System.out.println("X of center of c1 = " + c1.getCenter().getX());
		
				Point p2 = new Point(50, 100);
				Line l2 = new Line(p2, new Point(400,500));
				Rectangle r2 = new Rectangle(p1, 50, 80);
				
				System.out.println(p2);
				System.out.println(p1);
				System.out.println(l2);
				System.out.println(r2);
				
				System.out.println(p2.equals(p1));
				System.out.println(p2.equals(l2));
				
				p1.setX(50);
				p1.setY(100);
				System.out.println(p2.equals(p1));
				
				System.out.println(p2 instanceof Point);
				System.out.println(p2 instanceof Object);
				
				
				
				
				
				
				
				
				
	}

}
