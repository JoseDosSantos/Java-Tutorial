/* 
1. Schritt: Aufgabe verstehen
Es sollen verschiedene Methoden erstellt werden, die auf die eingegebenen Parameter Operationen anwenden und einen Wert zurückgeben
Auffällig: es sollen zweimal mehrere Methoden mit demselben Namen definiert werden
-> dies nennt man Überladung: solange die Methoden unterschiedlich viele Parameter oder Parameter mit unterschiedlichen Datentypen haben ist dies möglich
Bei Funktionsaufruf wird automatisch die zu den übergebenen Parametern passende Methode ausgewählt
Das Verwenden von Methoden der String-Klasse, also beispielsweise string.toUpperCase, ist nicht erlaubt -> workaround muss gefunden werden
*/

import java.util.Arrays;											// Nur für Ausgabe von Arrays mit println zu Testzwecken, für den Code nicht relevant 

public class StringManipulation{
	public static void main(String[] args) {						// Siehe oben, nur für Test
		String test = "abCDEa";										// Siehe oben, nur für Test
		char z = 'a';												// Siehe oben, nur für Test
		String ins = "xyz";											// Siehe oben, nur für Test
		System.out.println(reverse(test));							// Siehe oben, nur für Test
		System.out.println(delete(test, z));						// Siehe oben, nur für Test
		System.out.println(delete(test, 2, 4));						// Siehe oben, nur für Test
		System.out.println(insert(test, 2, 'x'));					// Siehe oben, nur für Test
		System.out.println(insert(test, 2, "xyz"));					// Siehe oben, nur für Test
		System.out.println(swapUpperLowerCase(test));				// Siehe oben, nur für Test
		System.out.println(Arrays.toString(toCharacterArray(test)));// Siehe oben, nur für Test


	}


	// Für fast alle Methoden muss ein String zurückgegeben werden -> Ansatz: neuen String newString erstellen, zu diesem die benötigten Zeichen hinzufügen und diesen zurückgeben

	public static String reverse(String str){						// reverse gibt String zurück und bekommt einen String (genannt str) als Parameter -> String soll rückwärts zurückgegeben werden
		int len = str.length();										// Speichern der Länge als Variable für leichtere Lesbarkeit
		String new_string = "";										// Erstellen Variable new_string. Zuweisung von "" erzeugt leeren String (ist notwendig, um später hinzuzufügen)
		for (int i = len - 1; i>=0; i--){							// Wir laufen rückwärts durch den Ausgangsstring (beginnend bei len -1, endend bei 0, jedes Mal i--)
			new_string += str.charAt(i);							// Mit str.charAt(i) kann der char am jeweiligen Index eines Strings ausgelesen werden. Dieser wird and new_string angefügt
																	// Erinnerung; "a" + "b" = "ab" Erinnerung:  "a" += "b" ist dasselbe wie "a" = "a" + "b"
		}
		return new_string;											// Fertiger String wird zurückgegeben
	}

	public static String delete(String str, char zeichen){			// delete erhält String str und char zeichen. str soll ohne char zurückgegeben werden (Bsp: str="abcbe", zeichen='b'-> delete(str, zeichen) = "ace")
		int len = str.length();										// Speichern der Länge als Variable für leichtere Lesbarkeit
		String new_string = "";										// Erstellen Variable new_string. Zuweisung von "" erzeugt leeren String (ist notwendig, um später hinzuzufügen)
		for (int i=0; i<len; i++){									// Wir laufen normal durch alle Zeichen des Strings (von 0 bis Länge - 1)
			if (str.charAt(i) != zeichen){							// Ist das Zeichen am aktuellen Index i nicht gleich dem zu entfernenden char Zeichen...
				new_string += str.charAt(i);						// ... wird es an den neuen String new_string angefügt
			}
		}
		return new_string;											// Fertiger String wird zurückgegeben
	}

	public static String delete(String str, int pos1, int pos2){	// delete erhält String str und Anfangs-und Endposition (pos1, pos2). Alle Zeichen zwischen einschließlich pos1 und pos2 sollen entfernt werden
																	// Beachte: andere Parameter als bei letzter Methode
																	// Beispiel: str = "abcdef", pos1 = 2, pos2 = 4 -> delete (str, pos1, pos2) = "abf"
		int len = str.length();										// Speichern der Länge als Variable für leichtere Lesbarkeit
		String new_string = "";										// Erstellen Variable new_string. Zuweisung von "" erzeugt leeren String (ist notwendig, um später hinzuzufügen)
																	// Idee: Wir fügen erst alle Zeichen vor pos1 und dann alle Zeichen nach pos2 zum Ausgabestring hinzu
		for (int i=0; i<pos1; i++){									// Durchlaufen aller Zeichen vor pos1 (von i=0 bis pos1)
			new_string += str.charAt(i);							// Hinzufügen des Zeichens am aktuellen Index an den neuen String new_string 
		}

		for (int i=pos2+1; i<len; i++){								// Durchlaufen aller Zeichen von pos2+1 (damit pos2 nicht mit angehängt wird) bis Ende (len) -> da for solange i<len läuft endet die Schleife bei len-1
			new_string += str.charAt(i);							// Hinzufügen des Zeichens am aktuellen Index an den neuen String new_string 
		}

		return new_string;											// Fertiger String wird zurückgegeben
	}

	public static String insert(String str, int pos, char zeichen){	// insert erhält String str, int pos und char zeichen. Zeichen soll and Position pos eingefügt werden.
		int len = str.length();										// Speichern der Länge als Variable für leichtere Lesbarkeit
		String new_string = "";										// Erstellen Variable new_string. Zuweisung von "" erzeugt leeren String (ist notwendig, um später hinzuzufügen)
																	// Idee: Analog zu letzter Methode: alle Zeichen bis pos zu new_string anfügen, zeichen anfügen, alle Zeichen ab pos anfügen
		for (int i=0; i<pos; i++){									// Durchlaufen aller Zeichen vor pos (von i=0 bis pos)
			new_string += str.charAt(i);							// Hinzufügen des Zeichens am aktuellen Index an den neuen String new_string 
		}
		new_string += zeichen;										// Hinzufügen des neuen zeichens an neuen String
		for (int i=pos; i<len; i++){								// Durchlaufen aller Zeichen ab pos bis Ende
			new_string += str.charAt(i);							// Hinzufügen des Zeichens am aktuellen Index an den neuen String new_string 
		}
		return new_string;											// Fertiger String wird zurückgegeben
	}



	public static String insert(String str1, int pos, String str2){ // insert erhält String str1, int pos und String str2. str2 soll and Position pos eingefügt werden
		int len = str1.length();									// Speichern der Länge als Variable für leichtere Lesbarkeit
		String new_string = "";										// Erstellen Variable new_string. Zuweisung von "" erzeugt leeren String (ist notwendig, um später hinzuzufügen)
																	// Vorgehen identisch zu letzer Methode. Statt einzelnem Zeichen wird String eingefügt
		for (int i=0; i<pos; i++){									// Durchlaufen aller Zeichen vor pos (von i=0 bis pos)
			new_string += str1.charAt(i);							// Hinzufügen des neuen zeichens an neuen String	
		}
		new_string += str2;											// Hinzufügen von str2 zum neuen String new_string 
		for (int i=pos; i<len; i++){								// Hinzufügen des neuen zeichens an neuen String
			new_string += str1.charAt(i);							// Hinzufügen des Zeichens am aktuellen Index an den neuen String new_string 
		}

		return new_string;											// Fertiger String wird zurückgegeben
	}



	/*
	Die Folgende Methode ist mit Stringmethoden (toLowerCase, isLowerCase, etc.) wesentlich leichter umzusetzen. Da diese nicht erlaubt sind müssen wir einen anderen Weg finden um herauszufinden
	ob ein Zeichen grpß-oder kleingeschrieben ist und um dieses dann umzuwandeln.
	Hilfreich ist hier die ASCII-Tabelle: https://de.wikipedia.org/wiki/American_Standard_Code_for_Information_Interchange#ASCII-Tabelle
	Wichtige Erkenntnis: chars können in ints umgewandelt werden und umgekehrt: 
	65 entspricht "A" 
	90 entspricht "Z" 
	97 entspricht "a"
	122 entspricht "z"
	Differenz zwischen "A" und "a" beträgt 32 (da Sonderzeichen dazwischen)
	-> Wenn char zwischen 65 und 90 liegt ist er uppercase-> +32 wandelt zu lowercase um
	-> Wenn char zwischen 97 und 122 liegt ist er lowercase -> -32 wandelt zu uppercase um
	-> Alle anderen chars bleiben unverändert
	*/


	public static String swapUpperLowerCase(String str){						// swapUpperLowerCase erhält String str, soll upper-/lowercase vertauschen und String zurückgeben
		int len = str.length();													// Speichern der Länge als Variable für leichtere Lesbarkeit
		String new_string = "";													// Erstellen Variable new_string. Zuweisung von "" erzeugt leeren String (ist notwendig, um später hinzuzufügen)

		for (int i = 0; i<len; i++){											// Durchlaufen aller Zeichen von str (von i=0 bis i=len-1)
			if ((int) str.charAt(i) >=65 && (int) str.charAt(i) <=90){			// Merke: Umwandlung von char zu int durch (int) vor char -> wenn char zwischen 65 und 90
				new_string += (char) (str.charAt(i) + 32);						// Umwandlung in Großbuchstaben durch +32 und Rückwandlung von int zu char durch (char) vor int, Anfügen an new_string
			}
			else if ((int) str.charAt(i) >=97 && (int) str.charAt(i) <=122){	// Analog zu oben: wenn (int) char zwischen 97 und 122
				new_string += (char) (str.charAt(i) - 32);						// Umwandlung in Kleinbuchstaben durch +32 und Rückwandlung von int zu char durch (char) vor int, Anfügen an new_string
			}
			else {																
				new_string += str.charAt(i);									// Alle anderen Zeichen werden unverändert angefügt (bspw. Punkte, Kommas, Leerzeichen, etc.)
			}
		}
		
		return new_string;														// Fertiger String wird zurückgegeben
	}



	public static char[] toCharacterArray(String str){				// toCharacterArray erhält String str. Achtung! Rückgabetyp ist nicht wie bisher String, sondern Feld vom Typ char (char[])
		int len = str.length();										// Speichern der Länge als Variable für leichtere Lesbarkeit
		char[] new_arr = new char[len];								// Initialisierung eines neuen Feldes new_arr vom Typ char mit Anzahl der Elemente = Länge von str

		for (int i=0; i<len; i++){									// Durchlaufen des gesamten Strings von i=0 bis i=len-1	
			new_arr[i] = str.charAt(i);								// new_arr am Index i wird char von str am Index i zugewiesen
		}

		
		return new_arr;												// Fertiges Array wird zurückgegeben
																	// Beachte: Die Bezeichnungen Feld, Array und Liste bezeichenen dieselbe Sache. Ein Feld/Liste ist ein eindimensionales Array
	}
}