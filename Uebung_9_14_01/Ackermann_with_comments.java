/* Die Aufgabe is denke ich eigentlich relativ einfach, die Ackermann-Funktion wird einfach als Methode implementiert
Besonderheit, oder besser gesagt Thema, ist Rekursion, also dass sich die Funktion selbst aufruft.
Die Ackermann-Funktion ist in sofern besonders, als dass sie sehr schnell wächst. Schon bei sehr niedrigen Werten kann die sehr schnell extrem große Ergenisse liefern, die der PC gar nicht mehr
verarbeiten kann.
Interessant ist hier auch das Thema Stack (siehe https://de.wikipedia.org/wiki/Stapelspeicher). Wenn die Funktion sich selbst aufruft, "stapelt" Java die Funktionsaufrufe und arbeitet sie dann
nacheinander wieder ab. Da die größe dieses Stapels (Stacks) begrenzt ist, kann es relativ schnell zu einem Stackoverflow Error kommen, weil Java nicht genügend Operationen stacken kann um
die Berechnung zuende zu bringen (daher kommt dann auch der Name der Seite Stackoverflow ;))
*/

public class Ackermann{
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);			// die beiden Parameter werden beim Funktionsaufruf mitgegeben und mit parseInt von String zu Integer umgewandelt
		int m = Integer.parseInt(args[1]);
		System.out.println(ack(n, m));				// das Ergebnis der Funktion ausgeben
	}

	public static int ack(int n, int m){			// Hier die Funkion die 1:1 die mathematische Funktion abbildet und sich teilweise selbst aufruft
		if (n == 0){
			return m + 1;
		}
		else if (n > 0 && m == 0){	
			return ack(n-1, 1);						// beispielsweise hier
		}
		else{
			return ack(n-1, ack(n, m-1));			// und hier
		}
	}
}