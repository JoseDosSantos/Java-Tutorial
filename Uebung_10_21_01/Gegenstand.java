public class Gegenstand{
	private String name;						
	private double gewicht;

	public Gegenstand(String n, double g){
		name = n;								
		if (g<0){
			gewicht = 0;
		}
		else gewicht = g;
	}

	public double getGewicht(){
		return gewicht;
	}

	public String getName(){
		return name;
	}

	public String toString(){
		output = name + " (" + Double.toString(gewicht) + ")";
		return output;
	}
}