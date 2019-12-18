public class TestWunsch{
	public static void main(String[] args) {
		/*
		Wunschliste liste = erzeugeLeereWunschliste(5);
		neuerWunsch(liste, "a", 10);
		neuerWunsch(liste, "b", 15);
		neuerWunsch(liste, "c", 4);
		neuerWunsch(liste, "d", 12);
		neuerWunsch(liste, "g", 13);
		gibWuenscheAus(liste);		

		neuerWunsch(liste, "h", 17);
		gibWuenscheAus(liste);
		neuerWunsch(liste, "i", 7);
		gibWuenscheAus(liste);
		*/		
	}

	public static Wunschliste erzeugeLeereWunschliste(int anzahl){
		Wunschliste liste = new Wunschliste(anzahl);
		return liste;
	}

	public static void neuerWunsch(Wunschliste liste, String beschreibung, int prioritaet){
		Wunsch neu;
		if (prioritaet < 0){
			neu = new Wunsch(beschreibung, 0);
		}
		else {
			neu = new Wunsch(beschreibung, prioritaet);
		}
		
		if (liste.wuensche[liste.length-1] == null){
			for (int i=0; i<liste.length; i++){
				if (liste.wuensche[i] == null){
					liste.wuensche[i] = neu;
					break;
				}
				else if(liste.wuensche[i].prioritaet>=neu.prioritaet){
					for (int j=liste.length-1; j>i; j--){
						liste.wuensche[j] = liste.wuensche[j-1];
					}
					liste.wuensche[i] = neu;
					break;
				}
			}
		}

		else {
			if (neu.prioritaet > liste.wuensche[0].prioritaet){
				for (int i=0; i<liste.length; i++){
					if (liste.wuensche[i].prioritaet>=neu.prioritaet){
						for (int j=0; j<i-1;j++){
							liste.wuensche[j] = liste.wuensche[j+1];
						}
						liste.wuensche[i-1] = neu;
						break;
					}
					if (i == liste.length-1){
						for (int j=0; j<i;j++){
							liste.wuensche[j] = liste.wuensche[j+1];
						}
						liste.wuensche[i] = neu;
					}
				}
			}
		}
	}

	public static void gibWuenscheAus(Wunschliste liste){
		for (int i = 0; i<liste.length; i++){
			System.out.print(liste.wuensche[i].beschreibung);
			System.out.print(" (");
			System.out.print(liste.wuensche[i].prioritaet);
			System.out.println(")");
		}
	}
}