// Ignore


public class Palindromtest {
	public static void main(String[] args) {
		String text = args[0]; 							// Zu testdender Text wird als Argument bei Start des Skripts angegeben
		//String text_clean = text.replaceAll("\\s", ""); // Alle Whitespaces (\s) werden entfernt (\ muss escaped werden, daher \\)
		text  = text.toLowerCase();						// Da Groß/Kleinschreibung egal ist werden alle Buchstaben kleingeschrieben

		int laenge = text.length();				// Laenge des Strings auslesen
		
		// Loesung 1: String gleichzeitig rückwärts und vorwärts durchlaufen


		for (int i=0; i<laenge/2; i++){
		/*
		Durch alle Buchstaben im String iterieren
		Idee: x-tes Element muss gleich laenge-1-xtes Element sein
		-1 da Länge = größter Index + 1 (da der kleinste Index 0, aber kleinste Länge 1)
		Beispiel: 
		[0][1][2][3][4][5][6][7]   --> Länge = 8
		 t  e  s  t  w  o  r  t    --> erster Buchstabe hat Index 0, letzter Buchstabe hat Index Länge - 1 = 7
					   			   --> zweiter Buchstabe hat Index 1, zweitletzter Buchstabe hat Index Länge - 1 - 1 = 6
								   --> dritter Buchstabe hat Index 2, drittletzter Buchstabe hat Index Länge - 1 - 2 = 5
								   --> vierter Buchstabe hat Index 3, viertletzter Buchstabe hat Index Länge - 1 - 3 = 4
		*/

			if (!(text_clean.charAt(i) == text_clean.charAt(laenge-1-i))){
				System.out.println(false)
				System.out.println(i);					// Wenn ungleich: Index ausgeben
				break;									// Schleife beenden
			}
			else if (i==(laenge/2-1)){					// Wenn die Buchstaben gleich sind:
				System.out.println(true);				// Wenn maximaler Index erreicht: true ausgeben
			}
		}


		// Loesung 2: String umdrehen und vergleichen - wenn nicht gleich, dann Zeichenweise vergleichen
		/*
		
		// Methode aus dem Internet, mit Stringbuilder kann ein String umgedreht werden
		String text_reverse = new StringBuilder(text_clean).reverse().toString();

		if (text_clean.equals(text_reverse)){			// Wenn die Strings gleich sind, dann print true
			System.out.println(true);
		}
		else {											// Wenn nicht gleich, zeichenweise durch die Strings gehen bis unterschiedliches Zeichen auftritt
			for (int i=0; i<laenge; i++){
														// Achtung: Vergleich von char(und ints, double, bools, etc.) erfolgt mit ==, Vergleich von Strings mit .equals()
														// ! heißt not, also wenn sie nicht gleich sind - Ausdruck dahinter muss in Klammern stehen 
														// (sonst würde es (!"a") == "b" oder so heißen, und das geht ja nicht)
				if (!(text_clean.charAt(i)==text_reverse.charAt(i)){
					System.out.println(i);				// Den Index des ungleichen Zeichens ausgeben
					break;								// Mit break die Schleife beenden (wir suchen nur den ersten unterschiedlichen Buchstaben)
				}
			}
		}
		*/
	}
}

