// hier geht es einfach darum ein paar spezielle Konzepte umzusetzen

public class Bruch{
	private int zaehler;											// private: die Werte können nur von Funktionen innerhalb der Klasse verändert werden
	private int nenner;												// da die Variablen außerhalb der Funktionen definiert werden, können diese von überall (innerhalb und außerhalb der Klasse gelesen werden)

	public Bruch(int z, int n){										// Konstruktor: Funktion die beim Initialisiern eines neuen Objekts der Klasse Bruch ausgeführt wird (hat denselben Namen
																	// wie die Klasse und keinen Rückgabewert)
		zaehler = z;												// die Parameter sind int-Werte für Zähler und Nenner, diese werden in Instanzvariablen gespeichert
		nenner = n;
		kuerze();													// die Werte werden automatisch gekürzt falls möglich, siehe unten
	}

	public Bruch(String bruch){										// Es gibt hier zwei Konstruktoren, man spricht vonMethodenüberladung. Je nach Typ des übergebenen Parameters wird der passende ausgeführt
		String parts[] = bruch.split("/");							// da der Bruch hier als String übergeben wird, wird der String geteilt und die einzelnen Bestandteile in int umgewandelt
		zaehler = Integer.parseInt(parts[0]);						// und dann in den Instanzvariablen gespeichert
		nenner = Integer.parseInt(parts[1]);
		kuerze();													// auch hier wird anschließend immer gekürzt (falls möglich)
	}


	public String toString(){										// Die Methode toString wird ausgeführt, wenn man versuchen mit System.out.print ein Objekt des Typs print auszugeben
		String neu = "";											// In diesem Fall soll der Bruch als String ausgeben werden
		neu += Integer.toString(zaehler);							// An einen leeren Outputstring werden nacheinander der Zähler, der "/" und der Nenner angehängt
		neu += "/";													// Remember: neu += "/" ist dasselbe wie neu = neu + "/"
		neu += Integer.toString(nenner);
		return neu;
	}

	public Bruch addiere(Bruch b){									// die Methode erhält ein zweites Objekt vom Typ Bruch als Parameter,soll diesen mit dem "eigenen" addieren und das Ergebnis als
																	// als neues Objekt vom Typ Bruch zurückgeben
		int nenner_neu = nenner * b.nenner;							// Addition von Brüchen heißt gemeinsamen Nenner finden -> einfachster Weg: beide Nenner multiplizieren
		int zaehler_neu = zaehler * b.nenner + b.zaehler * nenner;	// Analog werden dann die Zähler jeweils mit dem Nenner des anderen Bruchs multipliziert und dann addiert
		Bruch neu = new Bruch(zaehler_neu, nenner_neu);				// Hier wird ein neuer Bruch instanziiert: Da wir im Konstruktor immer kürzen müssen wir uns darüber keine Gedanken machen
		return neu;
	}

	private void kuerze(){											// Brüche kürzen hatten wir neulich schonmal. Habe da auch nur den Code wiederverwendet: wir teilen solange durch den 
		int teiler = ggT(zaehler, nenner);							// größten gemeinsamen Teiler von Zähler und Nenner bis dieser nicht mehr größer als 1 (also = 1) ist.
		while (teiler > 1){											// dazu nutzen wir die unten Hilfsfunktion unten
			zaehler = zaehler / teiler;
			nenner = nenner / teiler;
			teiler = ggT(zaehler, nenner);							// Wichtig: diese Funktion gibt keinen Bruch zurück, sondern kürzt die Instanzvariablen zaehler und nenner von ganz oben
		}
	}

	private int ggT(int a, int b) {									// Hatten wir auch schonmal, Tom kannte dafür sogar den Fachbegriff. Einfache rekursive Methode zum Finden des ggT.
		if (b==0)
			return a;
		else
			return ggT(b, Math.abs(a%b));
	}


}

