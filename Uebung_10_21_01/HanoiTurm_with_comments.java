/* 
Hab die Kommentare die vorgegeben waren dringelassen, just fyi.
Es geht hier darum das "Spiel" Türme von Hanoi umzusetzen. Dabei soll allerdings nicht gespielt werden, sondern nur das Spielfeld und der Lösungsalgorithmus
programmiert werden. Lest euch am besten mal den Wiki-Artikel dazu durch.
Die Klasse HanoiTurm stellt dabei quasi einen Stab dar.
Die einzelnen Scheiben werden als Strings im Format 1 Breiteneinheit = "/\" gespeichert (Breite 1 = "/\", Breite 3 = "/\/\/\" etc.)


Datenstruktur fuer das Spiel Tuerme von Hanoi,
 welche einen einzelnen Stab darstellt..
 */
public class HanoiTurm
{
      // jede Scheibe wird durch einen String dargestellt
      // je laenger ein String, desto groesser die Scheibe
      // in values werden somit die Scheiben abgelegt
      private String[] values;
      private int position; // position gibt die Position der obersten Scheibe an - ist position = -1, dann befindet sich keine Scheibe auf dem Stab

      // Konstruktor (keine Scheibe vorhanden, Stabgroesse ist 1)
      public HanoiTurm()
      {
            position = -1; 
            values = new String[1];
      }

      // Konstruktor (keine Scheibe vorhanden)
      // @param groesse gibt die Groesse des Stabes an (und somit wie viele Scheiben maximal auf diesen gelegt werden koennen)
      // Man beachte: Die Größe wird am Anfang festgelegt und dann nicht mehr verändert - zum Zählen der Scheiben kann nicht die Länge des Feldes betrachtet werden
      // da diese unabhängig davon wieviele Elemente tatsächlich drin stehen immer gleich lang bleibt ("leere" Elemente sind vom Typ null)
      public HanoiTurm(int groesse)
      {
            position = -1; 
            values = new String[groesse];
      }


      // Gibt die maximale Anzahl an Scheiben auf dem Stab zurück, also die Länge des im Konstruktor initialisierten Feldes.
      public int maxSize()
      {
          return values.length;
      }
      
      // Top soll die oberste Scheibe zurückgeben. Deren Index wird in der Variable position gespeichert.
      public String top(){
            if (position == -1){                                        // Wenn Stab leer        
                  System.out.println("Zugriff auf leeren Stab");        // Ausgabe Fehlermeldung
                  return null;                                          
            }
            else {
                  return values[position];                              // Ansonsten Rückgabe der obersten Scheibe (bspw. "/\/\")
            }
      }

      public void pop(){                                                // pop "entfernt" die oberste Scheibe -> Trick: anstatt den Wert zu löschen genügt es,
                                                                        // den Wert von position, also den Index der höchsten Scheibe, um 1 zu verringern
                                                                        // der alte Wert der obersten Scheibe kann später überschrieben werden (siehe push())
            if (position == -1){                                        // Wenn Stab nicht leer
                  System.out.println("Zugriff auf leeren Stab");        
            }
            else{
                  position += -1;                                       // alternativ auch position -= 1, Index wird um 1 nach "links" verschoben
            }
      }

      public void push(String scheibe){                                       // push fügt eine neue Scheibe hinzu, wenn möglich 
            if (position + 1 == maxSize()){                                   // zunächst Test ob position bereits auf das letzte mögliche Element zeigt
                                                                              // maxSize() (siehe Z.39) gibt Länge des Feldes zurück -> position muss Index von letzem Element (Länge - 1) sein
                  System.out.println("maximale Anzahl an Scheiben erreicht");
            }
            else if (position!=-1){                                           // wenn mindestens 1 Scheibe auf dem Stapel ist
                  if (values[position].length() < scheibe.length()){          // wenn kleiner als neue Scheibe dann Fehlermeldung ausgeben
                  System.out.println("kleinere Scheibe vorhanden");
                  }
                  else{                                                       // ansonsten neue Scheibe hinzufügen
                        values[position + 1] = scheibe;                       // Füge die neue Scheibe am Index position + 1 ein
                        position += 1;                                        // Erhöhe position, also den Index der höchsten Scheibe um 1
                  }                                                           // 76 und 77 könnten auch vertauscht werden, dann aber in 76 ohne +1
            }
            else{                                                             // Sonst (wenn Stapel leer) neue Scheibe hinzufügen
                values[position + 1] = scheibe;
                position += 1;
            }
      }

      public int size(){                                                // size soll Anzahl der Scheiben zurückgeben
            return position + 1;                                        // Anzahl = Index der obersten Scheibe (also position) + 1(da Index bei 0 beginnt)
      }
}