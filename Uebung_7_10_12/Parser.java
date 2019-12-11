/* auch hier ist das Wichtigste: was soll gemacht werden?
Ein String soll eingelesen, die dort angegebenen Brüche als Zähler und Nenner ausgelesen, in eine Dezimalzahl (also Zähler/Nenner) umgewandelt werden und die Liste der Dez-Zahlen zurückgegeben werden
"-1/2;3/4;5/-2" -> ["-1/2", "3/4", "5/-2"]
				-> [["-1", "2"], ["3", "4"], ["5", "-2"]]
				-> [-1/2, 3/4, 5/-2]
				-> [-0.5, 0.75, -2.5]

*/


public class Parser {
	public static void main(String[] args) {
		//String test = "-1/2;3/4;5/-2";					// Die Werte in Main sind nur zum Testen während des Entwickelns
		//parseToDouble(test);
		//double [] test_vals = {-0.5, 1.3231, 1.0};
		//System.out.println(parseToString(test_vals));
	}

	public static double[] parseToDouble(String brueche){	// parseToDouble erhält als Parameter einen String und gibt ein double-Feld (also eine List mit doubles) zurück
		String[] geteilt = brueche.split(";");				// mit String.split teilen wir den String an einem bestimmten Zeichen (hier ;) und erhalten wir ein Feld von Teil-strings (ohne das Zeichen)
		double[] feld = new double[geteilt.length];			// Initialisieren eines double-Felds, in das wir die berechneten Dezimalwerte speichern (die Anzahl der Teile von geteilt ist die Anzahl der Brüche also die Länge des Felds)

		for (int i=0; i < geteilt.length; i++){				// jetzt iterieren wir durch das Feld welches die Brüche als String enthält
			String bruch = geteilt[i];						// für einfachere Lesbarkeit wird hier der jeweilige String ausgelesen und in der Variable bruch gespeichert
			String[] zahlen = bruch.split("/");				// den String teiler wir erneut, diesmal am Schrägstrich. Die List zahlen enthält nun als erstes Element den Zähler und als zweites Element den Nenner
			feld[i] = Double.parseDouble(zahlen[0]) / Double.parseDouble(zahlen[1]); // wir wandeln die beiden Elemente mit Double.parseDouble von Strings zu doubles um, Teilen diese und speichern das Ergebnis
		}

		/*For testing
		for (int i=0; i < feld.length; i++){
			System.out.println(feld[i]);
		}
		*/
		return feld;			// Am Ende wird das Feld zurückgegeben

	}


	/* für den zweiten Teil müssen wir uns überlegen, wie wir eine Dezimalzahl in einen Bruch umwandeln.
	Eine kurze Google-Recherche zeigt, dass wir die Anzahl der Dezimalstellen zählen und dann:
	Zähler = Zahl * 10^AnzahlDez
	Nenner = 10^AnzahlDez

	Bsp.: 0.85
	-> AnzDez = 2
	-> Zähler = 0.85 * 10^2 = 85
	-> Nenner = 10^2 = 100
	-> Bruch = 85/100

	Problem: Der Bruch ist noch ungekürzt -> wie kürzt man Brüche?
	-> Solange teilen durch den größten gemeinsamen Teiler (oder durch irgendeinen Teiler), solanger dieser > 1
	-> Wie bestimme ich den GGT?
	-> Google ist dein Freund-> ich habe nach kurzer Suche die unten genutzte Methode gefunden
	-> Wichtig ist-> die Methode ist rekursiv, d.h. sie ruft sich immer wieder selber aus
	-> Versucht ruhig mal zu verstehen wie sie funktioniert, an sich ist es nicht superkompliziert
	Wichtig: % ist der Modulo-Operator, gibt den Rest der Division wieder
	*/

	public static int groessterGemeinsamerTeiler(int a, int b) {
		if (b==0)
			return a;
		else
			return groessterGemeinsamerTeiler(b, Math.abs(a%b));
	}




	public static String parseToString(double[] werte){						// Umgekehrt zur Methode oben ist hier der Parameter ein Feld von double-Werten und der Rückgabetyp String
		String output = "";													// Wir starten mit einem leeren Outputstring, an den wir die Brüche anfügen

		for (int i=0; i<werte.length; i++){									// Iterieren durch die Liste der doubles
			Double val = werte[i];											// Wichtig hier: wir lesen den Wert als Double (großgeschrieben) aus, weil Double, anders als double, über eigene Funktionen verfügt
																			// Hier zum Beispiel .toString Falls ihr das nicht wisst: Google: "java double to string", da werdet ihr das auch finden
			String[] splitter = val.toString().split("\\.");				// Zum Bestimmen der Dezimalstellen teilen wir den String am .
																			// Hier komisch: das Punktsymbol heißt bei split etwas anderes (siehe Regular Expresions). Wenn wir am Punkt splitten wollen
																			// muss split "\." erhalten. Da \ aber in Java der sogenannte Escape-Character ist, denkt Java, dass es den Punkt escapen soll
																			// Das ist nicht der Fall, also müssen wir den Escape-Character nochmals "escapen" (durch einen zweiten Backslash)
																			// damit am Ende \. in die split-Funktion übergeben wird. Bei Unklarheiten google Escape-Character
			int dezimalStellen = splitter[1].length();						// Die Anzahl der Dezimalstellen ist die Länge des zweiten Teilstrings (aller Zeichen nach dem Komma)
			int zaehler = (int) (val * Math.pow(10, dezimalStellen));		// Potenzieren mit Math.pow(Basis, Exponent). Math muss nicht gesondert importiert werden
			int nenner = (int) (Math.pow(10, dezimalStellen));				// Berechnung wie oben besprochen
			

			int ggt = groessterGemeinsamerTeiler(zaehler, nenner);			// Jetzt nutzen wir die Methode von oben um den GGT zu berechnen
			while(ggt > 1){													// Solange ggt > 1 (wenn er sofort nur 1 ist dann können wir nicht kürzen und überspringen die Schleife)
				zaehler = zaehler / ggt;									// Teile Zähler durch GGT
				nenner = nenner / ggt;										// Teile Nenner durch GGT
				ggt = groessterGemeinsamerTeiler(zaehler, nenner);			// Berechne den neuen GGT
			}

			output += Integer.toString(zaehler);							// Jetzt müssen wir den fertigen Bruch an den Outputstring anhängen - mit Integer.toString werden Integers zu Strings umgewandelt
			output += "/";													// Verknüfung erfolgt einfach mit +
			output += Integer.toString(nenner);								// Remember: a += b ist dasselbe wie a = a + b
			if (i != werte.length - 1){										// Wenn wir nicht im letzten Durchlauf sind dann hänge auch noch ein ; an
				output += ";";
			}
		}
		return output;														// Rückgabe des fertigen Strings
	}

}

