/*
Die Aufgabe ist verhältnismäßig recht umfangreich und hat auch mich eine Weile zu verstehen gekostet (wie ihr gemerkt habt). Versucht Stück für Stück
zu verstehen was gemacht werden soll und was die einzelnen Teile tun.
Grundidee: wir nutzen die beiden anderen erstellten Klassen Wunsch und Wunschliste. Es wird eine neue Wunschliste erstellt und mit Wünschen gefüllt.
Solange noch freie Plätze in der Liste sind (also mindestens das letzte Element null ist) fügen wir einfach  den nächsten Wunsch ein. 
Dabei sollen die Wünsche immer der Priorität aufsteigend nach geordnet sein.
Ist die Liste voll (das letze Element nicht null) dann wird geschaut, ob der neue Wunsche eine höhere Priorität als mindestens der erste Wunsch in der Liste
hat (da aufsteigend sortiert hat der erste Wunsch die niedrigste Priorität). Ist das der Fall suchen wir die passende Stelle für den Wunsch, "verschieben" alles 
davor nach links (so dass das erste Element praktisch vorne aus der Liste rausfällt) und fügen den neuen Wunsch ein.
Mit gibWuenscheAus sollen die Wünsche dann ausgegeben werden.
*/

public class TestWunsch{
	public static void main(String[] args) {
		/*
		Wunschliste liste = erzeugeLeereWunschliste(5);					// Das hier diente nur Testzwecken, verdeutlicht aber wie die einzelnen Funktionen
		neuerWunsch(liste, "a", 10);									// aufgerufen werden können
		neuerWunsch(liste, "b", 15);
		neuerWunsch(liste, "c", 4);
		neuerWunsch(liste, "d", 12);
		neuerWunsch(liste, "g", 13);
		gibWuenscheAus(liste);		

		neuerWunsch(liste, "h", 17);
		gibWuenscheAus(liste);
		neuerWunsch(liste, "i", 7);
		gibWuenscheAus(liste);
		*/		
	}

	public static Wunschliste erzeugeLeereWunschliste(int anzahl){		// Simple Methode die ein Objekt vom Typ Wunschliste zurückgibt
		Wunschliste liste = new Wunschliste(anzahl);					// Neues Objekt wird initialisiert (anzahl wird dabei an den Konstruktor von Wunschliste übergeben)
		return liste;													// Die leere Wunschliste wird zurückgegeben
	}

	public static void neuerWunsch(Wunschliste liste, String beschreibung, int prioritaet){ // Diese Klasse soll einen neuen Wunsch einfügen (wenn möglich)
		Wunsch neu;														// Variable neu vom Typ Wunsch wird deklariert
		if (prioritaet < 0){											// Siehe Aufgabe: wenn Prio < 0 dann Prio = 0
			neu = new Wunsch(beschreibung, 0);							// neu wird ein Objekt der Klasse Wunsch zugewiesen. Beschreibung und Prio werden an den Konstruktor von Wunsch übergeben
		}																// Das heißt: ab hier können wir mit neu.priorität bzw. neu.beschreibung auf die Klassenvariablen zugreifen
		else {
			neu = new Wunsch(beschreibung, prioritaet);					// Same as above, nur hier nicht mit prio=0 sondern mit unveränderter übergebener prioritaet
		}
		
		if (liste.wuensche[liste.length-1] == null){					// Der erste Fall: die Liste ist noch nicht voll (das letzte Element ist null)
			for (int i=0; i<liste.length; i++){							// Mit dieser Schleife suchen wir nach der Stelle zum Einfügen indem wir durch die Liste iterieren
				if (liste.wuensche[i] == null){							// Die Logik hier muss verstanden werden: wir schauen zuerst ob der Wunsch am jeweiligen
					liste.wuensche[i] = neu;							// Index null ist -> wenn ja: neuen Wünsch an Stelle i einfügen
					break;												// Mit break die "Suchschleife" beenden, da der Wunsch ja nur einmal eingefügt werden soll
				}
				else if(liste.wuensche[i].prioritaet>=neu.prioritaet){	// Wenn die Liste am Index nicht leer ist, muss geprüft werden, ob der bereits vorhandene Wunsch eine höhere 
																		// Prio hat -> wenn ja, dann sollen alle Wünsche "nach hinten verschoben werden" und der neue Wunsch
																		// an der aktuellen Stelle eingefügt
					for (int j=liste.length-1; j>i; j--){				// Der schwierigste Teil: wir gehen rückwärts durch die Liste bis zum Index nach dem aktuellen Suchindex
						liste.wuensche[j] = liste.wuensche[j-1];		// Hier geschieht das Verschieben: dem jeweiligen Index wird der Wunsch der im index davor steht zugewiesen
					}													// Das heißt alle auf i folgenden Wunsch-Objekte sind einen Index nach hinten geruckt
					liste.wuensche[i] = neu;							// Der aktuell im Index i stehende Wunsch ist kurzzeitig doppelt vorhanden (da er nicht vom Wunsch im Vor-Index)
					break;												// überschrieben wurde. Hier speichern wir jetzt den neuen Wunsch und überschreiben den alten. break wie oben
				}														// Achtung: break beendet immer die nächsthöhere Schleife, also das for in Zeile 46 (if ist keine Schleife)
			}
		}

		else {															// der zweite Fall: die Liste ist schon voll
			if (neu.prioritaet > liste.wuensche[0].prioritaet){			// wenn der neue Wunsch wenigstens eine höhere Priorität halt als der Erste (also der niedrigste)
				for (int i=0; i<liste.length; i++){						// Wir laufen wie oben durch die Liste und suchen die richtige Stelle zum Einfügen (also die erste Stelle, wo 
																		// an der es einen Wunsch mit höherer Prio gibt)--> vor dieser müssen wir einfügen
					if (liste.wuensche[i].prioritaet>=neu.prioritaet){	// Hier ist die Logik umgekehrt: es soll immer der Wunsch mit niedrigster Prio rausgworfen werden
						for (int j=0; j<i-1;j++){						// Dementsprechend verschieben wir alle Wert bis zum Index nach links, so dass der erste Wunsch rausfällt
							liste.wuensche[j] = liste.wuensche[j+1];	// Wir beginnen bei i=0 und überschreiben alle Wünsche mit dem Index am nachfolgenden Index
						}												// Dies geschieht für alle Wünsche vor i (weil der Wunsch bei i ja eine höhere Prio hat, also nicht verschoben wird)
						liste.wuensche[i-1] = neu;						// Am Index vor dem aktuellen i wird nach verschieben (auch hier ist zeitweise i-1 und i-2 gleich) der neue Wunsch gespeichert
						break;											// Die Suchschleife (Z.65) wird beendet, der Wunsch soll ja nur einmal eingefügt werden
					}
					if (i == liste.length-1){							// Ausnahmefall: es gibt keinen Wunsch mit höherer Prio als neu-> wenn es beim letzten Durchlauf bisher kein break gab
						for (int j=0; j<i;j++){							// In dem Fall werden, wie oben, alle Wünsche vom Folgenden überschrieben, die Liste "rutscht nach links"
							liste.wuensche[j] = liste.wuensche[j+1];	// auch hier gibt es kurz zwei Indizes an denen derselbe Wunsch gespeichert ist (i und i-1, also letzter und vorletzter)
						}
						liste.wuensche[i] = neu;						// Jetzt wird in i (if in Z.74 --> also ist i der Index des letzten Felds)) der neue Wunsch gespeichert
					}
				}
			}
		}
	}

	public static void gibWuenscheAus(Wunschliste liste){				// Der einfach Teil -> Die Wuensche sollen ausgegeben werden
		for (int i = 0; i<liste.length; i++){							// Iterieren durch alle Elemente der Wunschliste
			if (liste.wuensche[i] != null){								// Der Wunsch kann nur dann ausgegeben werden, wenn er existiert(nicht null ist)
				System.out.print(liste.wuensche[i].beschreibung);		// liste.wuensche greifen wir auf die Variable wuensche des Wunschliste-Objekts zu
				System.out.print(" (");									// liste.wuensche[i] gibt dementsprechend den Wunsch am Index i zurück
				System.out.print(liste.wuensche[i].prioritaet);			// Auf die Variablen der Wunsch-Objekte kann man wiederum mit Wunsch.prioritaet / Wunsch.beschreibung zugreifen
				System.out.println(")");								// mit print werden die einzelnen Bestandteile in eine Zeile ausgegeben, am Ende println, da damit automatisch der 
			}															// der nächste Wunsch in der nächsten Zeile ausgegeben wird
		}
	}
}