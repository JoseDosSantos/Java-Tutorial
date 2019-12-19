public class Wunschliste{
	public Wunsch[] wuensche;				// Klassenvariable wuensche ist ein Feld (eine Liste) von Wunsch-Objekten
	public int length = 0;					// Hilfsvariable, die angibt wie viele Wunsch-Objekte wuensche enthält
	public Wunschliste(int anzahl){			// Konstruktor, erhält größe des Feldes und speichert (leeres) Feld vom Typ Wunsch mit Länge Anzahl in wuensche
		wuensche = new Wunsch[anzahl];		
		length = anzahl;					// Außerdem wird die Länge in length gespeichert
	}
}