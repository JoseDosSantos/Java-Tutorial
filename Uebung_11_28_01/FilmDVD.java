public class FilmDVD extends Medium{
	private String genre;

	public FilmDVD(String titel, String genre){
		super(titel);
		this.titel = titel;
		this.genre = genre;
	}

	@Override
	public boolean equals(Object obj) {
        if(obj instanceof Medium) {
            Medium m = (Medium) obj;
            if(this.toString().euqals(m.toString())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
    	return super.toString() + " ( " + genre + ")";
    }

}