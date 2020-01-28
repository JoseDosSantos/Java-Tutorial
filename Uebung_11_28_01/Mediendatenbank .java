public class Mediendatenbank {
    private Medium[] db;
    private int anzahlMedien;
    public Mediendatenbank(int groesse) {
        db = new Medium[groesse];
        anzahlMedien = 0;
    }
    public Medium gibMedium(int pos) {
        if(pos < 0) return null;
        if(pos >= anzahlMedien)
            return null;
        return db[pos];
    }

    public int fuegeNeuesMediumHinzu(Medium m){
        if (anzahlMedien < db.length){
            db[anzahlMedien] = m;
            anzahlMedien += 1;
            return anzahlMedien - 1;
        }
        else{
            return -1;
        }
    }

    public int findeMedium(Medium m){
        for(int i=0; i<anzahlMedien; i++){
            if (db[i].equals(m)){
                return i;
            }
        }
        else {
            return -1;
        }
    }
}