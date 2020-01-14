public class Bruch{
	private int zaehler;
	private int nenner;

	public Bruch(int z, int n){
		zaehler = z;
		nenner = n;
		kuerze();
	}

	public Bruch(String bruch){
		String parts[] = bruch.split("/");
		zaehler = Integer.parseInt(parts[0]);
		nenner = Integer.parseInt(parts[1]);
		kuerze();
	}

	public String toString(){
		String neu = "";
		neu += Integer.toString(zaehler);
		neu += "/";
		neu += Integer.toString(nenner);
		return neu;
	}

	public Bruch addiere(Bruch b){
		int nenner_neu = zaehler * b.zaehler;
		int zaehler_neu = zaehler * b.nenner + b.zahler * nenner;
		Bruch neu = new Bruch(zaehler_neu, nenner_neu);
		return neu;
	}

	private void kuerze(){
		int teiler = ggT(zaehler, nenner);
		while (teiler > 1){
			zaehler = zaehler / teiler;
			nenner = nenner / teiler;
			teiler = ggT(zaehler, nenner);
		}
	}

	private int ggT(int a, int b) {
		if (b==0)
			return a;
		else
			return ggT(b, Math.abs(a%b));
	}


}

