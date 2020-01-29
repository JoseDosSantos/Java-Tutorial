/*
siehe FilmDVD, die Klasse ist quasi gleich, einziger unterschied ist künstler statt genre
*/

public class MusikCD extends Medium{
	private String kuenstler;

	public MusikCD(String titel, String kuenstler){
        super(titel);
		this.kuenstler = kuenstler;
	}

    @Override
	public boolean equals(Object obj) {
        if(obj instanceof Medium) {
            Medium m = (Medium) obj;
            if(this.toString().equals(m.toString())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
    	return super.toString() + " von " + kuenstler;
    }

}