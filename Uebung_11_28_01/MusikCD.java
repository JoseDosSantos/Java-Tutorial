public class MusikCD extends Medium{
	String künstler;

	public FilmDVD(String t, String k){
		titel = t;
		künstler = k;
	}

    @Override
	public boolean equals(Object obj) {
        if(obj instanceof Medium) {
            Medium m = (Medium) obj;
            if(titel.equals(m.titel) && künstler.equals(m.künstler)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
    	return titel + " von  " + künstler;
    }

}