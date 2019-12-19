/*
Ich versuche hier die Kommentare ein wenig kürzer zu halten. Was soll gemacht werden? Das Spiel Galgenraten soll programmiert werden.
Anfangs wird ein Zielwort und die maximale Anzahl der Versuche (äquivalent zur Anzahl der Striche des Galgens) als Kommandozeilenparameter (also in args)
übergeben werden.
Daraufhin kann der Nutzer solange 
a) versuchen das Wort zu erraten
b) einen Buchstaben raten
bis die maximale Anzahl an Versuchen erreicht ist.
Bereits vorher genannte Buchstaben können ignoriert werden und Zählen nicht als Versuch.
*/

import java.util.Scanner;									// Zum Einlesen des Nutzer-Inputs nutzen wir wie schon zuvor den Scanner

public class Woerterraten {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);				// Initialisieren des Scanners
		String zielwort = args[0];							// Der erste Parameter ist das zu erratende Wort
		int maxVersuche = Integer.parseInt(args[1]);		// Der zweite Parameter ist die Anzahl der Versuche (wird als String eingelesen, also mit Integer.parseInt in einen Integer umgewandelt)

		int versuche = 0;									// Hilfsvariable zum Zählen der Versuche
		String gefundeneBuchstaben = "";					// Hilfsstring in dem wir alle versuchten Buchstaben speichern
		
		for (int i=0; i<zielwort.length(); i++){			// Bevor die eigentlich Eingabe beginnt wird einmal "_" für jeden Buchstaben im Zielwort ausgegeben
			System.out.print("_");							// Achtung: print (statt println), da wir alle in dieselbe Zeile ausgeben wollen
		}
		System.out.print("\n");								// Damit die Nutzereingabe in eine neue Zeile erfolgt geben wir hier ein "\n" (also ein Enter) aus
															// Alternativ kann hier auch System.out.println(""); stehen

		do {												// Idee: do while Schleife die durchläuft bis maximale Anzahl an Versuchen erreicht oder mit break beendet
			versuche+=1;									// Erhöhen des Versuchszählers
			String input = scan.nextLine();					// Einlesen des nächsten Nutzerinputs
			
			if (input.length() > 1){						// Wenn mehr als ein Zeichen eingegeben wurde prüfen, ob Input = Zielwort
				if (input.equals(zielwort)){				// Wenn ja gewünschte Ausgabe
					System.out.print(versuche);
					System.out.print(" Versuche fuer ");
					System.out.println(zielwort);
					break;									// wenn das Wort vor maxVersuchen erraten wurde, ist das Spiel zuende, also mit break Schleife beenden
				}
				else{
					System.out.println("Falsches Wort");	// Ausgabe bei falschem Wort (das steht nicht in der Aufgabenstellung, ist nur aus Tests bzw. Beispieloutput bei Yapex erkenntlich)
				}

			}
			else{											// Wenn nur ein Zeichen eingegeben wurde:
				if (gefundeneBuchstaben.contains(input)){	// mit string1.contains(string2) kann überprüft werden ob string2 in string 1 enthalten ist
															// hier: wenn Input in String mit allen bekannten Buchstaben
					System.out.println("Buchstabe kam bereits vor");
					versuche -=1;							// wenn Buchstabe schon probiert dann zählt der Versuch nicht, der Zähler für die Versuche wird wieder um 1 verringert
				}
				else {								
					gefundeneBuchstaben += input;			// Wenn Buchstabe noch nicht probiert: Hinzufügen zu String mit bekannten Buchstaben
				}
			}

			String output = "";								// Leerer output string
															// Man könnte hier auch einfach die Zeichen so ausgeben, allerdings lässt sich so einfach der output-String
															// mit dem Zielwort vergleichen um zu sehen ob wir alle Buchstaben erraten haben

			for (int i=0; i<zielwort.length();i++){			// Iterieren durch das Zielwort
				String aktuellerBuchstabe = Character.toString(zielwort.charAt(i));	// für Lesbarkeit Speichern in variable
															// mit charAt kann der Char an Index vom String ausgelesen werden - für str1.contains(str2) muss allerdings
															// auch str2 ein String (und kein Char) sein, daher Umwandlung von char zu String mit Character.toString
				if (gefundeneBuchstaben.contains(aktuellerBuchstabe)){		// Wenn der aktuelle Buchstabe schon erraten wurde (also in String mit bekannten Buchstaben ist)
					output += aktuellerBuchstabe;			// Häng den aktuellen Buchstaben an den output-string an
				}
				else{
					output += "_";							// Sonst(wenn unbekannt) hänge einfach ein "_" an
				}
			}
			
			
			if (output.equals(zielwort)){					// ist der output gleich dem gesuchten Wort (wurden also alle Buchstaben erraten) dann Ausgabe Gewinnnachricht
				System.out.print(versuche);
				System.out.print(" Versuche fuer ");
				System.out.println(zielwort);
				break;										// auch hier: wenn erraten ist Spiel vorbei, also loop beenden
			}
			if (versuche == maxVersuche){					// Wenn wir die maximale Anzahl an Versuchen erreicht haben und die Schleife nicht vorher beendet (also
															// das Spiel gewonnen) wurde dann Output Verliermessage
				System.out.println("Maximale Anzahl an Versuchen ueberschritten");
			}
			else {											// Sonst Ausgabe des Outputstrings
				System.out.println(output);
			}
		} while (versuche < maxVersuche);					// Diese Schleife wird so oft ausgeführt wie maximale Versuche gestattet sind
	}
}