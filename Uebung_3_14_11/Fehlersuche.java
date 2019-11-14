import java.io.*;
public class Fehlersuche{
	static final int loesung = 42;
	public static void main(String[] args ) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print ("Die halbe Wahrheit ist: ");
		int hW = Integer.parseInt(in.readLine());
		int antwort;
		antwort = 2*hW;
		if(antwort == 42) System.out.println ("Korrekt!");
		else System.out.println("Falsch");
	}
}

/*
1. Anlauf:
Error: Fehlersuche.java:3: error: <identifier> expected
Codezeile: static final int 42 = loesung;
						   ^
Grund: Name und Wert vertauscht
Richtig: static final int loesung = 42

2. Anlauf:
Error: Fehlersuche.java:7: error: cannot find symbol
Codezeile: hW = in.readLine();
		   ^
Grund: Wertzuweisung vor Variablendeklaration
Richtig: int hW = in.readLine(); oder Zeile 9 (int hW;) vor Zeile 7 einfügen

3. Anlauf:
Error: Fehlersuche.java:7: error: incompatible types: String cannot be converted to int
Codezeile: int hW = in.readLine();
							   ^
Grund: Konsoleninhalt wird als String ausgelesen, soll aber Variable vom Typ Integer zugewiesen werden -> muss konvertiert werden
Richtig: int hW = Integer.parseInt(in.readLine());


4. Anlauf:
Error: Fehlersuche.java:9: error: incompatible types: possible lossy conversion from double to int
Codezeile: antwort = 2.0*hW;
						^
Grund: Zuweisen des Produkts von Double mit Integer zu Variable vom Typ Integer problematisch 
da unterschiedliche Wertebereiche, Nachkommastellen können verloren gehen
Richtig: antwort = 2*hW;


5. Anlauf:
Error: Fehlersuche.java:10: error: incompatible types: int cannot be converted to boolean
Codezeile: if(antwort = 42) System.out.println ("Korrekt!");
					  ^
Grund: = ist Wertzuweisung, Vergleich mit ==
Richtig: if(antwort == 42) System.out.println ("Korrekt!");
*/