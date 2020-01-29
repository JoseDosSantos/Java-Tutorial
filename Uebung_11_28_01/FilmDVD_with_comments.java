// siehe Medium.java

public class FilmDVD extends Medium{				// subclass extends superclass, erbt damit alle Methoden von superclass
	private String genre;							// genre ist ein String, titel wird von Medium übernommen

	public FilmDVD(String titel, String genre){		// Konstruktor erhält titel und genre
		super(titel);								// wichtig: mit super(titel) wird der Konstruktor der superclass aufgerufen 
													// -> dies ist nötig, damit der titel gespeichert wird
		this.genre = genre;							
	}

	// Override stellt sicher, dass der Compiler weiß dass hier eine Funktion der parentclass überschrieben wird
	@Override
	public boolean equals(Object obj) {					
        if(obj instanceof Medium) {
            Medium m = (Medium) obj;
            if(this.toString().equals(m.toString())){		// Unterschied hier: die toString Methoden werden aufgerufen, die
            												// einen String aus titel und genre erstellen (siehe unten)
                return true;
            }
        }
        return false;
    }

    // auch hier wird die toString-Methode der parentclass überschrieben
    @Override
    public String toString(){
    	return super.toString() + " ( " + genre + ")";		// Problem: titel ist Teil der superclass Medium, aber: titel ist private
    														// Zugriff nur über toString-Methode möglich
    														// da toString aber hier überschrieben wird, kann auf die toString-Methode
    														// von Medium mit super.toString() aufgerufen, um den Titel zu erhalten
    }

}