package introduction;

public class Variables {

	public static void main(String[] args) {

		//deklaracija i inicijalizacija promenljive - double
		double firstNumber;
		firstNumber = 1;
		double secondNumber = 5;

		//vraca kao double jer su oba operanda tipa double
		double doubleResult = firstNumber / secondNumber;
		System.out.println(doubleResult);

		//da bi vracao kao int mora se izvrsiti EKSPLICITNA konverzija
		int result = (int) (firstNumber / secondNumber);
		System.out.println(result);

		// konjunkcija, disjunkcija i negacija - u knjizi detalji
		boolean alwaysTrue = true;
		boolean secondBoolean = false;
		System.out.println(alwaysTrue && secondBoolean);
		System.out.println(alwaysTrue || secondBoolean);
		System.out.println(!alwaysTrue);
		System.out.println(!secondBoolean);

		// konkatenacija (spajanje) stringova
		String name = "Petar";
		String lastName = "Petrović";
		System.out.println(name + " " + lastName + " Njegoš");

		// IF - ELSE blok
		if (firstNumber > 0)
			System.out.println("Number is positive.");
		else if (firstNumber < 0)
			System.out.println("Number is negative.");
		else
			System.out.println("Number is equal to zero.");

		// WHILE
		// Ispisati brojeve uz WHILE od 1 do 10
		int i = 1;
		while (i <= 10) {
			System.out.println(i);
			i++;
		}

		// 1. Zadatak
		System.out.println("Prvi zadatak");
		int a=24;
		int b=12;
		String operation = "-";
		if (operation ==  "+") 
			System.out.println(a + b);
		else if (operation ==  "-") 
			System.out.println(a - b);
		else if (operation ==  "/") 
			System.out.println(a / b);
		else
			System.out.println(a * b);

		// 2. Zadatak - prvi nacin
		// Ispisati faktorijel broja 5 (5!) uz pomocu WHILE petlje
		i = 5;
		int factorial = 1;
		while (i > 0) {
			factorial = factorial * i;
			// factorial *= i; - drugi nacin zapisa onog iznad
			i--;
		}
		System.out.println("while 5! = " + factorial);

		// 2. Zadatak - drugi nacin
		// Ispisati faktorijel broja 5 (5!) uz pomocu DO WHILE petlje
		i = 5;
		factorial = 1;
		do {
			factorial *= i;
			i--;
		} while (i > 0);
		System.out.println("do while 5! = " + factorial);

		// 3. Zadatak
		// Ispisati uz pomocu FOR petlje neparne brojeve od 1 do 10
		for (i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				continue; //nastavlja for petlju
				// break; - zavrsava for petlju kad udje u if
			}
			System.out.println("Number " + i + " is odd.");
		}
	}

}
