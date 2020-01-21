/*
In dieser Klasse soll nun das Spiel unter Verwendung der Klasse Hanoiturm tatsächlich ablaufen.
Das Grundprinzip wird bei Wikipedia ganz gut dargestellt (mit GIFs), also schaut es euch da an.
Wie genau der Algorithmus im Einzelnen funktioniert hab ich auch noch nicht ganz nachvollzogen - glücklicherweise gibt es im Wiki-Artikel
Pseudocode genau dafür, der nur implementiert werden muss.
*/

public class TuermeVonHanoi{
      static int verschiebungen = 0;                        // verschiebungen wird später zum Zählen der Anzahl der Verschiebungen genutzt
      public static void main(String[] args) {  
            int anzahl = Integer.parseInt(args[0]);         // anzahl der Scheiben wird als Kommandozeilenparameter übergeben

            HanoiTurm turm1 = new HanoiTurm(anzahl);        // Initialisieren der 3 benötigten Türme/Stäbe
            HanoiTurm turm2 = new HanoiTurm(anzahl);
            HanoiTurm turm3 = new HanoiTurm(anzahl);


            for (int i=anzahl; i>0; i--){                   // Bevor das Spiel starten kann, müssen auf dem erstem Stab die Scheiben sortiert hinzugefügt werden
                                                            // Weil wir die Scheiben von breitester zu dünnster hinzufügen müssen fangen wir bei anzahl an und zählen runter
                  String scheibe = "";                      // Start mit leerer Scheibe (erinnere: jede "Breiteneinheit" entspricht 1x "/\")
                  for (int j=0; j<i; j++){                  // Der Breite entsprechend die "/\" hinzufügen
                        scheibe += "/\\";                   // Anmerkung: "/\\" statt "/\", da das \ ein escape-character ist (Java versteht beispielsweise "\n" als Zeilenumbruch)
                  }                                         // Um einen normalen Backslash zu schreiben muss \\ verwendet werden
                  turm1.push(scheibe);                      // mit der in HanoiTurm geschriebenen Methode wird die neue Scheibe zu turm1 hinzugefügt
            }
            
            umstapeln(anzahl, turm1, turm2, turm3);         // Aufrufen der umstapeln-Methode (siehe unten)
            System.out.print(anzahl);                       // Ausgabe anzahl und verschiebungen wie in Tests gefordert
            System.out.print(" Scheiben, ");
            System.out.print(verschiebungen);
            System.out.println(" Verschiebungen");

            String output = "";                             // Am Ende muss noch der Turm3 als String ausgegeben werden
            for (int i=anzahl; i>0; i--){                   // Wir zählen wieder rückwärts von anzahl runter und lesen in jedem Durchlauf die oberste Scheibe aus
                  String scheibe = turm3.top();             // Auslesen der obersten Scheibe
                  int anzLeer = i-1;                        // Die Anzahl der Leerzeichen ist so praktischerweise = i-1. Zeichnet euch ruhig mal auf warum.
                  for (int j=0; j<anzLeer;j++){             // Leerzeichen an output anhängen
                        output+=" ";
                  }
                  output += scheibe;                        // nach den Leerzeichen folgt erst die Scheibe (ist ja bereits String)
                  output += "\n";                           // und dann ein Zeilenumbruch
                  turm3.pop();                              // Am Ende jedes Schleifendurchlaufs wird die oberste Scheibe entfernt
            }
            System.out.print(output);                       // Ausgabe des fertigen Ausgabestrings
      }

      public static void umstapeln(int i, HanoiTurm a, HanoiTurm b, HanoiTurm c){
                                                            // Implementiert einfach 1:1 den Pseudocode von Wikipedia
            if (i > 0) {
                  umstapeln(i-1, a, c, b);
                  String scheibe = a.top();
                  a.pop();                                  // hier ist der einzige Punkt an dem wirklich was verschoben wird
                  c.push(scheibe);
                  verschiebungen+=1;                        // dementsprechend wird hier der Zähler erhöht
                  umstapeln(i-1, b, a, c);
            }
      }
}

