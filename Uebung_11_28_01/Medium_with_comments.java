/*
Thema dieser Aufgabe ist Vererbung. Eine Klasse kann von einer anderen Klasse mit extends erben (siehe FilmDVD und MusikCD).
Dabei erhält sie alle Variablen und Methoden von dieser Klasse. Diese können aber überschrieben werden wenn nötig.
In dieser Aufgabe ist Medium die super-Klasse (auch parent-class), von der geerbt wird. FilmDVD und MusikCD sind sub-classes (oder child-classes),
welche von Medium erben. Details dazu in den Kommentaren der Klassen .
*/

public class Medium {
    private String titel;

    public Medium(String titel) {           // im Konstruktor wird ein Titel übergeben
        this.titel = titel;                 // Mit this.titel wird der Klassenvariable titel der Wert des Parameters titel zugewiesen
    }
    public String toString() {
        return titel;
    }
    public boolean equals(Object obj) {
        if(obj instanceof Medium) {         // Für Erklärung siehe Paar.
            Medium m = (Medium) obj;
            if(titel.equals(m.titel))       // Wenn Titel gleich dann gib true zurück
                return true;
        }
        return false;
    }
}