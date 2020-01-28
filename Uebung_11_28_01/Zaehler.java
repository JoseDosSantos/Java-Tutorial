import java.util.ArrayList;

public class Zaehler<T>{
	private ArrayList <T> elemente = new ArrayList<T>();
	private ArrayList <Integer> count = new ArrayList<Integer>();

	public void neuesElement(T o){
		int idx = elemente.indexOf(o);
		if (idx == -1){
			elemente.add(o);
			count.add(1);
		}
		else {
			count.set(idx, count.get(idx) + 1);
		}
	}

	public String toString(){
		String output = "";
		for (int i=0; i<elemente.size(); i++){
			output += elemente.get(i).toString() + " (" + Integer.toString(count.get(i)) + " mal)\n";
		}
		return output;
	}


}