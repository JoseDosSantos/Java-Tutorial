/*
Nehmt euch hier kurz Zeit um sicherzugehen dass ihr die Aufgabe verstanden habt. Fakt ist: die Aufgabenstellung ist beschissen und lässt einfach mal einen Teil der geforderten
Funktionalität aus. Schaut euch auch bei Japex die eingelesenen txt-Dateien an um zu verstehen wie genau die aufgebaut sind.

Hier ein kurzes Beispiel wie eine solche Input-Datei aussieht:

3
2
#O
OO
O#

Die # stehen für Wände, die O für "Gänge" im Labyrinth.
Die erste Zeile ist hier die Anzahl der Zeilen, die zweite für die Anzahl der Spalten

*/


import java.nio.file.Files;													// Der Code für das Einlesen der Datei stammt auch aus einer vorherigen Übung, hab ich nur kopiert
import java.nio.file.Paths;													// Diese imports sind dafür nötig
import java.io.IOException;

public class Labyrinth{														
	private int x_dim;														// hier gibt es einige Instanzvariablen, die allesamt private sind (wie in Aufgabenstellung verlangt)
	private int y_dim;														// x_dim und y_dim speichern die Größe des Labyrinths, so dass wir später prüfen ob wir uns außerhalb bewegen würden
	private boolean[][] matrix;												// diese Matrix hält dann das eingelesene Labyrinth. Wertetyp ist boolean, wobei Wand = false und Weg = true
	private int x_pos;														// die x-Position (horizontal) wird nach dem Einlesen bestimmt
	private int y_pos = 0;													// der Eingang ist lauf Aufgabe immer in der ersten Reihe, die y-Position des Spielers ist also am Anfang immer 0


	public Labyrinth(String name) throws IOException{						// throws IOException weil wir Files und Paths verwenden
		String content = new String(Files.readAllBytes(Paths.get(name)));	// hier wird die Datei als ein String eingelesen
		String[] rows = content.split("\n");								// splitten des String bei \n (also dem Enter-Zeichen) - wir erhalten eine Liste mit den einzelnen Zeilen

		y_dim = Integer.parseInt(rows[0]);									// wir wissen: die Anzahl der Zeilen (y_dim) steht in der ersten Zeile (index 0)
		x_dim = Integer.parseInt(rows[1]);									// die Anzahl der Spalten (x_dim) steht in der zweiten Zeile (index 1)

		matrix = new boolean[x_dim][y_dim];									// erstellen einer neuen "leeren" boolean-Matrix mit den Dimensionen von oben

		for (int y=0; y < y_dim; y++){										// die eingelesenen Zeichen müssen in umgewandelt werden (O->true, #->false). Wir iterieren durch die Zeilen...
			for (int x=0; x < x_dim; x++){									// ... und dann innerhalb der Zeilen durch die Spalten (x-Dimension)
				String val = rows[y + 2].trim().split("")[x];				// +2 da wir die ersten beiden Zeilen in der Datei überspringen, mit trim() werden Leerzeichen und nicht sichtbare Sonderzeichen
																			// an Anfang und Ende entfernt (gab sonst irgendwie Fehler, nicht sicher warum) und die Zeilen dann in die einzelnen
																			// Zeichen gesplittet ("#O" -> ["#", "O"]) und dann über den Index x ausgewählt
				if (val.equals("#")){										// wenn #, dann false in matrix an der stelle schreiben
					matrix[x][y] = false;
				}
				else{														// sonst true
					matrix[x][y] = true;
				}
			}
		}
		
		for (int x = 0; x < x_dim; x++){									// hier wird die Startposition bestimmt -> wir iterieren durch die erste Zeile und suchen das erste true
			if(matrix[x][0]){												// hier muss kein matrix[x][0] == true gemacht werden, da matrix[x][0] ja bereits true oder false ist
				x_pos = x;													// die x-Koordinate des ersten true soll der Startpunkt des Spielers sein und wird in x_pos gespeichert
				break;														// sobald der erste Punkt gefunden wurde wird die Suche (also die Schleife) beendet
			}
		}
	}

	public boolean bewegeDich(char z){										// Diese Funktion bekommt einen Buchstaben als Input, soll zurückgeben ob die entsprechende Beweung möglich ist
																			// UND: falls ja auch die Spielerposition entsprechend verändern (dieser Teil fehlt einfach in der Aufgabe)
		boolean move;														// Hilfsvariable, in die der jeweilige Wert des Zielfeldes gespeichert wird
		switch (z){															// switch: für bestimmte Inputs wird ein bestimmer Code ausgeführt. Falls kein case definiert springt es zu default ganz unten
			case 'l':														// Hier das Beispiel für Input 'l', also eine Bewegung nach links
				if (x_pos > 0){												// Zuerst wird geprüft ob wir uns nicht schon ganz links befinden (x=0), denn dann wäre die Bewegung definitiv nicht möglich
					move = matrix[x_pos - 1][y_pos];						// Falls nicht, auslesen des Werts des Felds links neben der aktuellen Spielerposition
					if (move){												// Falls move = true, also ein Gang links ist, die x_pos des Spielers um 1 nach links verschieben (also 1 abziehen)
						x_pos += -1;
					}
					return move;											// Rückgabe move (falls true war Bewegung möglich / erfolgreich, falls false nicht)
				}
				else {return false;}
			case 'r':
				if (x_pos < x_dim-1){										// hier analog zu oben, nur mit check, ob wir noch nicht ganz rechts sind (in dem Fall wäre x_pos = x_dim-1 (-1 weil dim ja bei 1 anfängt, pos aber bei 0))
					move = matrix[x_pos + 1][y_pos];						
					if (move){
						x_pos += 1;
					}
					return move;
				}
				else {return false;}
			case 'o':
				if (y_pos > 0){
					move = matrix[x_pos][y_pos - 1];
					if (move){
						y_pos += -1;
					}
					return move;
				}
				else {return false;}
			case 'u':
				if (y_pos < y_dim-1){
					move = matrix[x_pos][y_pos + 1];
					if (move){
						y_pos += 1;
					}
					return move;
				}
				else {
					return false;
				}
			default:
				return false;
		}
	}	
														
	public String toString(){												// wie auch in der letzten Aufgabe overloaden wir die toString Methode, um das Labyrinth mit print ausgeben zu können
																			// Das heißt: ist Labyrinth x = new Labyrinth("datei.txt") wird bei System.out.print(x) diese Methode aufgerufen,
																			// und der Rückgabewert der Methode ausgegeben
		String output = "";													// Start mit leerem Ausgabestring
		for(int y=0; y < y_dim; y++){										// Iterieren durch Zeilen
			for(int x=0; x < x_dim; x++){									// Innerhalb jeder Zeile iterieren durch die Spalten
				if (x==x_pos && y==y_pos){									// Ist die aktuelle Position der Schleife = x_pos und y_pos, also der Spielerposition, hänge ein x an den output
					output+="x";
				}
				else if (matrix[x][y]){										// sonst: falls an aktuelle Position ein true steht, hänge ein "O" an
					output+="O";
				}
				else {														// sonst: hänge "#" an
					output+="#";
				}
			}
			output +="\n";													// nach jeder Zeile wird ein "\n", also ein Zeilenumbruch angefügt
		}
		return output;														// der fertige Outputstring inklusive Zeilenumbrüchen wird zurückgegeben (und kann dann einfach in der Konsole dargestellt werden)
	}
}