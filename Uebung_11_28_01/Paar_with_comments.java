/*
In dieser Aufgabe geht es vor allem um das Konzept generischer Klassen. Sinn ist hier
dass man noch nicht genau weiß, mit was für einem Typ die Variablen genutzt werden, weshalb
man hinter dem Klassennamen in eckigen Klammern einen Platzhalter einfügt, der dann beim
Erstellen eines Objektes der Klasse durch den Typ in eckigen Klammern bestimmt wird.
Der Platzhalter (hier T) wird dann überall im Code durch den übergebenen Typ ersetzt.
Beispiel siehe unten:
Paar p = new Paar<int>(1, 2) -> hier haben die Variablen wert1 und wert2 den Typ int
Paar p = new Paar<String>("abc", "xyz") -> hier haben die Variablen den Typ String

Das Ergebnis ist hier ähnlich zur Methodenüberladung (dieselbe Methode wird mehrmals mit
unterschiedlichen Parametern deklariert und dann jeweils die passende verwendet), aber halt
auf Klassenebene und besser verallgemeinerbar.

*/

public class Paar<T> {				// T als Platzhalter für den zu verwendenden Typen
    private T wert1, wert2;			// Variablen haben the Typ T (wird dann zur Laufzeit ersetzt)

    public Paar(T wert1, T wert2){	// Im Konstruktor werden zwei Werte übergeben
    	this.wert1 = wert1;			// mit this.wert1 können die Parameter von den 
    	this.wert2 = wert2;			// Klassenvariablen unterschieden werden
    }

    public T getWert1(){			// funktion deren Rückgabetyp abhängig von T ist
    	return wert1;				// gibt wert1 zurück -> wert1 ist private, kann also
    }								// nur mit dieser Funktion von außerhalb der Klasse
    								// abgefragt werden
    public T getWert2(){			// Beispiel: Paar p = new Paar<int>(1, 2)
    	return wert2;				// int wert = p.getWert1() -> so funktioniert es
    }								// int wert = p.wert1 -> so nicht, auf wert1 kann nicht
    								// direkt zugegriffen werden, weil private

    public String toString(){		// toString gibt einen String wie in der Aufgabe gefordert zurück
    	return "(" + wert1.toString() + ", " + wert2.toString() + ")";
    								// Wichtig hier: wert1.toString() funktioniert für fast alle
    								// Variablentypen und wandelt den wert in einen String um
    }								// Wenn wert1 bereits String ist wird nichts umgewandelt


    public boolean equals(Object o) {	// mit dieser Funktion vergleichen wir das Paar mit einem übergebenen Paar
        if(o instanceof Paar<?>) {		// instanceof überprüft, ob o vom Typ Paar ist
        								// mit ? wird der Typ von T ignoriert
            Paar<?> p = (Paar<?>) o;	// dieser Teil ist ein bisschen tricky zu verstehen
			// mit einem Typ in runden Klammern vor der Variable wird diese
			// in den Typ umgewandelt (bsp: double a = (double) 5 -> a = 5.0)
			// hier wird o in ein Paar umgewandelt -> das scheint erstmal unnötig, schließlich haben wir ja
			// bereits geprüft ob o vom Typ Paar ist
			// Problem: der Compiler (also der Teil von Java der den Code in Binärcode übersetzt) muss
			// wissen, welchen Typ o hat, wenn wir beispielsweise o.toString() aufrufen wollen
			// auch wenn der folgende Code nie ausgeführt wird, wenn o kein Paar ist, würde der Compiler
			// sich beschweren, weil er nicht sicherstellen kann dass die Methode toString für o aufgerufen werden kann
			// daher wird o nochmal in ein Paar umgewandelt (obwohl es ja schon eins ist)
            // theoretisch könnte man auch o = (Paar<?>) o; schreiben, hier wird p verwendet, weil es sauberer ist

            if (this.toString().equals(p.toString())){		// das this. ist hier nicht nötig, verdeutlicht aber, dass die
            												// dass das Paar-Objekt seine eigene toString -Methode aufrufen soll
            	return true;								// die beiden String werden verglichen (Stringvergleich mit a.equals(b))
            }
            else{
            	return false;
            }
        }
        return false;
    }
}