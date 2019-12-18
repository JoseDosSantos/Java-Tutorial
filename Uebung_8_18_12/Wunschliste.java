public class Wunschliste{
	public Wunsch[] wuensche;
	public int length = 0;
	public Wunschliste(int anzahl){
		wuensche = new Wunsch[anzahl];
		length = anzahl;
	}
}