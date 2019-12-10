public class Parser {
	public static void main(String[] args) {
		//String test = "-1/2;3/4;5/-2";
		//parseToDouble(test);
		double [] test_vals = {0.5, 1.3231, 1.0};
		System.out.println(parseToString(test_vals));
	}

	public static double[] parseToDouble(String brueche){
		String[] geteilt = brueche.split(";");
		double[] feld = new double[geteilt.length];

		for (int i=0; i < geteilt.length; i++){
			String bruch = geteilt[i];
			String[] zahlen = bruch.split("/");
			feld[i] = Double.parseDouble(zahlen[0]) / Double.parseDouble(zahlen[1]);
		}

		// For testing
		for (int i=0; i < feld.length; i++){
			System.out.println(feld[i]);
		}

		return feld;
	}


	public static int groessterGemeinsamerTeiler(int a, int b) {
		if (b==0)
			return a;
		else
			return groessterGemeinsamerTeiler(b, a%b);
	}


	public static String parseToString(double[] werte){
		String output = "";

		for (int i=0; i<werte.length; i++){
			Double val = werte[i];
			String[] splitter = val.toString().split("\\.");
			int dezimalStellen = splitter[1].length();
			int zaehler = (int) (val * Math.pow(10, dezimalStellen));
			int nenner = (int) (Math.pow(10, dezimalStellen));
			

			int ggt = groessterGemeinsamerTeiler(zaehler, nenner);
			while(ggt > 1){
				zaehler = zaehler / ggt;
				nenner = nenner / ggt;
				ggt = groessterGemeinsamerTeiler(zaehler, nenner);
			}

			output += Integer.toString(zaehler);
			output += "/";
			output += Integer.toString(nenner);
			if (i != werte.length - 1){
				output += ";";
			}
		}
		return output;
	}

}

/*
"-1/2;3/4;5/-2" -> [-0.5, 0.75, -2.5]
				-> ["-1/2", "3/4", "5/-2"]
				-> [["-1", "2"], ["3", "4"], ["5", "-2"]]
*/