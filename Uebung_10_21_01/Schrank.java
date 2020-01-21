public class Schrank{
	private Gegenstand[] gegenstaende;
	private double gMax;
	private int anzMax;
	private double gewichtCurrent = 0.0;
	private int anzahlCurrent = 0;

	public Schrank(double g, int anz){
		gMax = g;
		anzMax = anz;
		gegenstaende = new Gegenstand[anz];
	}

	public char packeEtwasRein(Gegenstand objekt){
		if (anzahlCurrent == anzMax){
			return 'v';
		}
		if (gewichtCurrent + obkjekt.getGewicht() > gMax){
			return 'm';
		}
		gegenstaende[anzahlCurrent] = objekt;
		anzahlCurrent += 1;
		gewichtCurrent += objekt.getGewicht();
	}

	public void print(){
		for (int i=0; i<anzahlCurrent; i++){
			System.out.println(gegenstaende[i]);
		}
	}

	public void print(double g){
		for (int i=0; i<anzahlCurrent; i++){
			if (gegenstaende[i].getGewicht() <= g){
				System.out.println(gegenstaende[i]);
			}
		}
	}

	public boolean istGegenstandVorhanden(String n){
		for (int i=0; i<anzahlCurrent; i++){
			if (n.equals(gegenstaende[i].getName())){
				return true;
			}
		}
	}




}