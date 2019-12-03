/*
1. Schritt: Aufgabe verstehen
Es soll eine Methode geschrieben werden (wenn unklar ist was eine Methode ist, bitte einfach mal
das Internet, oder eure Vorlesungsfolien konsultieren. main ist ein Beispiel für eine Methode.)

Diese Methode soll ein Feld (sprich ein eindimensionales Array, oder auch einfach eine Liste) von
doubles einlesen. Für alle Elemente der Liste außer dem Letzen und dem Ersten soll der Durschnitt jedes
Elements und seines Vorgängers / Nachfolgers errechnet werden. Das so geglättete Feld soll zurückgegeben werden
Beispiel: Feld = [3, 2, 4, 3, 5]
Länge(Feld) = 5 -> erstes Element hat den Index 0, letztes Element den Index Länge - 1
Wir überspringen Feld[0] und Feld[4], da diese entweder keinen Vorgänger oder keinen Nachfolger haben -> Indizes i 1-3 sind relevant
Für alle Felder dazwischen berechnen wir den Durschnitt aus Feld[i], dem Vorgänger Feld[i-1] und dem Nachfolger Feld[i+1]
Für i=1: (Feld[i-1] + Feld[i] + Feld[i+1]) / 3 = (Feld[0] + Feld[1] + Feld[2]) / 3 = (3 + 2 + 4) / 3 = 3
-> der geglättete Wert ist also 3
Wiederholt man diesen Algorithmus für alle Felder erhält man als Ergebnis: [3, 3, 3, 4, 5]
*/


import java.util.Arrays;												// Nur für Ausgabe von Arrays mit println zu Testzwecken, für den Code nicht relevant 


public class Glaettung{
	public static void main(String[] args) {
		double [] feld = {2,1,2,1,2,1};									// Siehe oben, nur für Test
		System.out.println(Arrays.toString(glaetten(feld)));			// Siehe oben, nur für Test
	}

	/*
	Wir definieren im Folgenden eine neue Methode. Wichtig ist die Reihenfolge: 1 Zugriffsrecht (public/private/package) 2 static (siehe unten) 3 Rückgabetyp 4 Methodenname(5 Parameter){...}
	Beispiel: public static int summe(int num1, int num2){...}
	Im Folgenden eine kurze Erläuterung der einzelnen Bestandteile:
	1 Zugriffsrecht: entweder public, package oder private 
		- public: heißt, die Methode kann von außerhalb der Klasse aufgerufen werden (eine andere Klasse kann diese Methode aufrufen)
		- package (default): ähnlich zu public, aber nur Klassen im selben "package" (vereinfach gesagt: im selben Ordner) können diese Methode aufrufen -> ist für yapex tests der Fall 
		- private: diese Methode kann nur von anderen Methoden der Klasse aufgerufen werden, zu der sie gehört
		- wird kein Zugriffsrecht spezifiziert wird automatisch von package ausgegangen
	2 static: optionales Schlüsselwort. mit static definierte Methoden und Variablen exisiteren einmalig für alle Instanzen dieser Klasse und auch dann aufgerufen werden,
	 	wenn es kein aktives Objekt der Klasse gibt
	Beispiel: 
	public class Beispiel(){
		public static void main(String[] args) {
			static int x = 5;
			int y = 3;		
		}
	}
	
	public class Andere Klasse(){
		public static void main(String[] args) {
			System.out.println(Beispiel.x); <- das funktioniert auch vor Zeile 48
			System.out.println(Beispiel.y); <- das funktioniert nicht y ist nicht static, erst nach Erzeugung eines Objektes kann die Variable abgerufen werden
			test1 = new Beispiel;
			test2 = new Beispiel;

			test1.x = 8; <- das ändert automatisch auch test2.x zu 8, denn static variablen sind über alle Instanzen der zugehörigen Klasse (Beispiel) nur einmal verfügbar
			test1.y = 0; <- das ändert nur test1.y, test2.y bleibt 3, denn y ist nicht static
		}
	}
	Achtung: eine static Methode kann nur andere static Methoden aufrufen

	3 Jede Methode hat einen Rückgabetyp, also einen Datentyp den sie am Ende zurückgibt. Das kann ein normaler Variablentyp (int, double, char, bool,...), eine Feld (int[], double[],...),
		ein Objekttyp (Beispiel, hierzu zählt aber technisch gesehen auch String) oder auch nichts (void) sein. Außer bei void muss am Ende der Funktion ein return-statement stehen,
		welches ein Variable oder ein Objekt mit dem angegebenen Datentyp zurückgibt

	4 Der Methodenname kann relativ frei gewählt werden: er darf allerdings nicht nur aus Zahlen bestehen, keine Leerzeichen enthalten ( a_b ist aber okay) und die meisten Sonderzeichen 
		sind auch nicht zugelassen. Wird üblicherweise kleingeschrieben (im Gegensatz zu Klassennamen) und sollte möglichst aussagekräftig sein (bspw. wurzel statt w).

	5 In Klammern folgt auf den Name eine mit Komma getrennte Liste von Parametern die bei Funktionsaufruf übergeben werden. Dabei wird zuerst der Typ und dann ein Name festgelegt
	
	Beispiel:
	static int quadrat(int num1){
		return num1 * num1
	}

	public static void main(String[] args){
		x = 5;
		System.out.println(quadrat(x));
	}
	>>> Output ist 5
	Beachte: der Name der Variable ist nur in der Methode selbst relevant (in main wird eine Variable mit Bezeichner x übergeben, aber innerhalb der Methode quadrat heißt diese Variable immer num1)
	*/




	static double[] glaette(double[] numbers){					// Nun praktisch: static ist nötig, da Methode in Test (siehe Yapex) auch static. Siehe Aufgabe: double Feld (double[], das [] steht für Feld)
																// soll zurückgegeben werden. Double Feld (hier numbers genannt) wird als Parameter übergeben		
		int len = numbers.length;								// Für bessere Lesbarkeit wird die Länge des Feldes (bei arrays mit array.length - beachte: keine Klammer!) als Variable gespeichert
		double [] new_field = new double[len];					// Problem: wenn wir die Werte in das Eingabearray speichern überschreiben wir die zur Berechnung benötigten Werte mit den geglätteten Werten
																// Lösung: neues Array mit gleicher Länge (names new_field, Name ist natürlich beliebig) erstellen -> new weist Speicher für darauffolgendes Objekt zu
																// In diesem Fall wird ein neues Feld vom Datentyp double erstellt. Dieses ist leer (mit 0 gefüllt)
																// Achtung: würde man new_field = numbers schreiben, würde new_field keine Kopie von number sein, sondern quasi auf dieselben Bits im Speicher zeigen
																// Somit würden die Veränderung von new_field auch numbers verändern (da sie dasselbe Objekt bezeichnen) -> daher hier new
																// Dies ist bei den elementaren Datentypen nicht nötig (int, double, float, char, boolean)

		for (int i=1; i<len-1; i++){										// Wir iterieren durch das Feld, beginnend beim zweiten Element (i=1) bis zum vorletzten Element (i<len-1)
			new_field[i] = (numbers[i-1] + numbers[i] + numbers[i+1])/3;	// Der geglättete Wert wird in das neue feld gespeichert
		}

		new_field[0] = numbers[0];								// Da das neue Array leer ist, wir in der Schleife aber das erste und das letzte Element überspringen übertragen wir manuell das erste (i=0)
		new_field[len-1] = numbers[len-1];						// und das letzte (i=len-1) Element in das neue Feld new_field
		return new_field;										// mit return wird das neue, geglättete Feld zurückgegeben. Beachte: new_field hat den Typ double[], wie oben vor dem Methodennamen angegeben
	}
}

