public class FilmDVD extends Medium{
	String genre;

	public FilmDVD(String t, String g){
		titel = t;
		genre = g;
	}

	public boolean equals(Object obj) {
        if(obj instanceof Medium) {
            Medium m = (Medium) obj;
            if(titel.equals(m.titel) && genre.equals(m.genre)){
                return true;
            }
        }
        return false;
    }

    public String toString(){
    	return titel + "( " + genre + ")"
    }

}