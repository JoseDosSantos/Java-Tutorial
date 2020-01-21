/*
Relativ intuitiv, wie bei Gegenstand sollen hier nur die Methoden umgesetzt werden
*/
public class Schrank{
	private Gegenstand[] gegenstaende;						// Feld von Gegenständen
	private double gMax;									// Maximales Gewicht (wird an Konstruktor übergeben)
	private int anzMax;										// Maximale Anzahl von Gegenständen (wird an Konstruktor übergeben)
	private double gewichtCurrent = 0.0;					// Aktuelles Gewicht (muss bei Hinzufügen aktualisiert werden)
	private int anzahlCurrent = 0;							// Aktuelle Anzahl (muss bei Hinzufügen aktualisiert werden)

	public Schrank(double g, int anz){						// Konstruktor (Parameter sind maximales Gewicht und maximale Anzahl)
		gMax = g;
		anzMax = anz;
		gegenstaende = new Gegenstand[anz];					// Feld wird mit Länge der maximalen Anzahl initialisiert
	}

	public char packeEtwasRein(Gegenstand objekt){			// Erhält ein objekt vom Typ Gegenstand
		if (anzahlCurrent == anzMax){						// Wenn schon voll 
			return 'v';										// erinnere: 'v' ist char, "v" ist String
		}
		if (gewichtCurrent + objekt.getGewicht() > gMax){	// Wenn Gewicht mit neuem Gegenstand überschritten wäre
			return 'm';
		}
		gegenstaende[anzahlCurrent] = objekt;				// Ansonsten: neuen Gegenstand hinzufügen (anzahlCurrent ist Index von letzem Element in Feld + 1)
		anzahlCurrent += 1;									// Anzahl erhöhen
		gewichtCurrent += objekt.getGewicht();				// Gewicht erhöhen
		return 'e';											// return nicht vergessen
	}

	public void print(){									// print ohne Parameter: Ausgabe aller Gegenstände Zeile für Zeile
		for (int i=0; i<anzahlCurrent; i++){
			System.out.println(gegenstaende[i]);
		}
	}

	public void print(double g){							// print mit Parameter g (Methode wird doppelt mit unterschiedlichen Parametern deklariert -> Überladung)
		for (int i=0; i<anzahlCurrent; i++){				
			if (gegenstaende[i].getGewicht() <= g){			// Wenn Gegenstand leichter als g ist dann ausgeben
				System.out.println(gegenstaende[i]);
			}
		}
	}

	public boolean istGegenstandVorhanden(String n){		// Wenn Gegenstand mit name n in Liste dann true, sonst false zurückgeben
		for (int i=0; i<anzahlCurrent; i++){
			if (n.equals(gegenstaende[i].getName())){		// Erinnere: Vergleich von Strings mit string1.equals(string2)
				return true;
			}
		}
		return false;
	}
}