/*
Mediendatenbank hält eine Liste mit DVD's / CD's - interessant hier: db ist Feld vom Typ Medium, kann deswegen aber alle Klassen
halten, die von Medium erben.
*/

public class Mediendatenbank {
    private Medium[] db;
    private int anzahlMedien;
    public Mediendatenbank(int groesse) {           // Konstruktor, initialisieren der leeren db (Größe der Liste wird festgelegt)
        db = new Medium[groesse];
        anzahlMedien = 0;
    }
    public Medium gibMedium(int pos) {              // Gibt Medium an IDX zurück oder null falls nicht möglich
        if(pos < 0) return null;                    // Wenn pos < 0 dann null (index <0 ist nicht möglich)
        if(pos >= anzahlMedien)                     // wenn pos > als Anzahl der Medien: return null (nicht möglich)
            return null;
        return db[pos];                             // ansonsten return Medium
    }

    public boolean fuegeNeuesMediumHinzu(Medium m){ // neues Medium hinzufügen
        if (anzahlMedien < db.length){              // wenn db nicht voll 
            db[anzahlMedien] = m;                   // neues Element bei Index Anzahl hinzugefügt (Anzahl ist immer höchster Index + 1)
            anzahlMedien += 1;                      // erhöhe Anzahl
            return true;
        }
        else{                                       // wenn Anzahl > db.length (db ist bereits voll) dann return false
            return false;
        }
    }

    public int findeMedium(Medium m){               // suchen nach Medium
        for(int i=0; i<anzahlMedien; i++){          // Iterieren durch db
            if (db[i].equals(m)){                   // hier nutzen wir die equals-Funktion aus MusikCD/FilmDVD um zu checken ob gleich
                return i;                           // wenn gleich (also Medium in db enthalten) return index
            }
        }
        return -1;                                  // sonst return -1
    }
}