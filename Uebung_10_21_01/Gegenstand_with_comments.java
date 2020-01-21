/* 
Das ist eine einfachere Aufgabe, hier müssen nur die geforderten Methoden und Variablen umgesetzt werden.
*/


public class Gegenstand{
	private String name;						// beide sind private (Aufgabenstellung fordert: nicht von außen zugreifbar)
	private double gewicht;

	public Gegenstand(String n, double g){		// Konstruktor erhält Name n und Gewicht g und speichert diese in den Instanzvariablen
		name = n;								
		if (g<0){
			gewicht = 0;						// wenn Gewicht < 0 dann gewicht = 0
		}
		else gewicht = g;
	}

	public double getGewicht(){					// Methoden, die gewicht zurückgibt (kann von außerhalb der Klasse aufgerufen werden, ermöglich also
		return gewicht;							// indirekten Zugriff auf die Variablen gewicht bzw. Name)
	}

	public String getName(){
		return name;
	}

	public String toString(){					// Wird versucht mit print bzw. println ein Objekt vom Typ Gegenstand auszugeben, wird immer die toString Methode
												// der Klasse aufgerufen.
		return name + " (" + Double.toString(gewicht) + ")";		// Rückgabe des fertigen Strings (hier in 1 Zeile, in Datei ohne comments mit 2)
	}
}