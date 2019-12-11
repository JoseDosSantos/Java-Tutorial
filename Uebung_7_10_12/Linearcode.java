/*
Die Schwierigkeit dieser Aufgabe liegt zu 80% darin zu verstehen wie das Linearcode-System funktioniert.
Schaut euch die Yapex-Erklärung und den Wikipedia-Artikel dazu an.
Grundidee: der Code besteht aus | und Leerzeichen. Jede Zahl wird durch 5 | und Leerzeichen kodiert, nach jeder Zahl folgt ein | als Trennsymbol
Die Reihenfolge der Symbole spielt hier eine Rolle - das erste steht für 0, das zweite für 1, das dritte für 2, das vierte für 4 und das fünfte für 7
Die Leerzeichen zeigen dabei an, welche Zeichen man addieren soll. Jede Zahl von 0-9 lässt sich aus einer Kombination von 2 Leerzeichen und 3 | darstellen.
Die 11 entspricht dabei der 0.
Beispiel (ich nutze _ um die Leerzeichen besser sichtbar zu machen, in der Aufgabe sind es aber richtige Leerzeichen):


01247
|_|_| = 5
_|||_ = 8 
__||| = 1
|||__ = 0

Die letzte Zahl eines Strings ist dabei die Prüfziffer. Diese entsprich der Summe aller vorhergehenden Zahlen % 10, das heißt: addiert man alle Zahlen + die Prüfziffer, so ist die Summe durch 10 teilbar

Wir sollen einen String der einen solchen Code enthält auslesen und in die enstprechenden Zahlen umwandeln. Passt die Summe nicht, geben wir eine Fehlermeldung aus, 
ansonsten alle Zahlen außer der Prüfziffer in umgekehrter Reihenfolge
*/



public class Linearcode{											// Achtung: in Yapex heißt diese Klasse scheinbar nicht Linearcode sondern nur Test (entscheidend ist dass die so heißt wie die .java Datei)
	public static void main(String[] args) {
		// String code = args[0];		
		String code = "|| ||||| ||||| ||||| ||||| ||||||  |";		// Nur zum Testen
		int[] zahlen = new int[code.length()/6];					// Nur zum Test

		for (int i=0; i<code.length()/6; i++){						// Idee hier: wir iterieren durch Länge / 6 (jede Zahl besteht aus 5 Zeichen + Trenn-|)
			int value = 0;											// Das ist unser dekodierter Wert, wir beginnen bei 0
			for (int j=0; j<5; j++){								// Jetzt iterieren wir von 0-4 (die 5 steht für das sechste Zeichen, das ja aber nur das Trennzeichen ist, welches wir ignorieren wollen)
				if (code.charAt(i*6 + j) == ' ') {					// Der Index des aktuellen Zeichens ist i*6 (als quasi die aktuelle Zahl) + j (das aktuelle Zeichen). 
																	// Mit charAt bekommen wir das Zeichen am Index eine Strings. Wenn das Zeichen ein Leerzeichen ist:
					if (j==0) {value += 0;}							// (+0 ist eigentlich egal, aber der Vollständigkeit halber)
					if (j==1) {value += 1;}							// Ansonsten: wenn wir am jeweiligen Index sind (also hier j=1 = zweites Element), dann addiere den entsprechenden Wert siehe oben
					if (j==2) {value += 2;}
					if (j==3) {value += 4;}
					if (j==4) {value += 7;}
					}
				
			}
			if (value > 10){										// Wenn der Wert > 10 (kann eigentlich nur 11 sein) dann sollen wir nicht 11 sondern 0 addieren
				zahlen[i] += 0;
			}
			else{
				zahlen[i] = value;									// Ansonsten einfach drauf
			}
		}

		int quersumme = 0;											// ich nenne es quersumme weil es in der Aufgabe so heißt, bei Zahlen < 10 ist das ja einfach normal die Summe
		for (int i = 0; i<zahlen.length; i++){						// Addieren der Zahlen
			quersumme += zahlen[i];
		}

		if (quersumme%10 != 0){										// Wenn die Quersumme nicht durch 10 teilbar ist (also der Rest > 0) dann Fehlermeldung ausgeben
			System.out.println("Falscher Code");
		}
		else {														// Ansonsten rückwärts die Zahlen ohne Prüfziffer in einer Zeile (print statt println) ausgeben
			for (int i=zahlen.length-2; i>=0; i--){					// Die Schleife beginnt bei länge-2, da länge-1 der Index des letzten Elements (der Prüfziffer) ist und wir das ja nicht mit ausgeben wollen
				System.out.print(zahlen[i]);						// Vom Vorletzen angefangen gehen wir rückwärts (i--) und geben die Zahlen aus
		}
	}

}









