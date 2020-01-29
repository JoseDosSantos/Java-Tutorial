/*
Die Zaehler-Klasse soll nun eine Arraylist mit mehreren Paaren (genauer gesagt mit Elementen
vom Typ T, aber in der Aufgabe wird Paar als Typ verwendet) zu verwalten.
Bei der Deklaration einer Arraylist wird der jeweilige Typ in eckigen Klammern angegeben:
ArrayList<int> test = new ArrayList<int>();
ArrayList haben wir schon öfter verwendet, ist ähnlich zu Feld (a[]), hat aber eigene
Methoden, die das Arbeiten mit der Liste vereinfachen. Diese beinhalten (siehe auch Japex):
test.size() gibt die Anzahl der aktuellen Elemente zurück
test.add(T element) fügt das Element am Ende hinzu und gibt true zurück
test.get(int index) gibt das Element an der entsprechenden Position zurück
test.set(int index, T element) ersetzt das bereits vorhandene Element an der entsprechenden Position durch element und gibt das ersetzte Element zurück
test.indexOf(Object o) gibt, falls das Objekt vorhanden ist, die Position zurück, andernfalls -1
*/

import java.util.ArrayList;			// um ArrayLists zu verwenden müssen diese zuerst importiert werden

public class Zaehler<T>{											// T als generischer Parameter wie bei Paar
	private ArrayList <T> elemente = new ArrayList<T>();			// elemente enthält Objekte vom Typ T
	private ArrayList <Integer> count = new ArrayList<Integer>();	// die Liste mit den Häufigkeiten ist immer vom Typ Integer
																	// Note: int und Integer sind quasi dasselbe, Integer hat aber noch eigene Methoden

	public void neuesElement(T o){				// neues Element o hinzufügen
		int idx = elemente.indexOf(o);			// zuerst schauen wir ob objekt bereits in elemente
		if (idx == -1){							// wenn nicht gibt indexOf -1 zurück
			elemente.add(o);					// mit add kann an eine Arraylist ein neues Element hinzugefügt werden
			count.add(1);						// für das neue Objekt wird ein Zähler an die Zählerliste angefügt
		}
		else {
			count.set(idx, count.get(idx) + 1);	// wenn Element vorhanden dann Zähler an Stelle idx um 1 erhöhen
		}
	}

	public String toString(){
		String output = "";						// Output nach Aufgabenstellung zusammenbasteln
		for (int i=0; i<elemente.size(); i++){	
			output += elemente.get(i).toString() + " (" + count.get(i).toString() + " mal)\n";
		}										// count variablen sind Integer, haben also toString-Methode mit der sie
												// zu String umgewandelt werden können
		return output;
	}


}