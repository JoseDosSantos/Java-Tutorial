public class Wunsch{							// Einfache Klasse Wunsch
	public int prioritaet;						// Klassenvariablen. Dank public kann auch außerhalb der Klasse auf diese zugegriffen werden.
	public String beschreibung;

	public Wunsch(String desc, int prio){		// Methode mit selbem Namen wie Klasse ist Konstruktor -> wird ausgeführt wenn neues Objekt der Klasse instanziiert wird
		prioritaet = prio;						// Dies geschieht beispielsweise mit Wunsch beispiel = new Wunsch("beschreibung", 1)
		beschreibung = desc;					// Die in Klammer stehenden Werte werden automatisch den Klassenvariablen zugewiesen
	}
}