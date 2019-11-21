import java.util.Scanner;

public class Progressbar{
	public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		int prozent;
		while(true){
			prozent = in.nextInt();
			if (prozent < 0 || prozent > 100){
				System.out.println("ungueltiger Wert");
			}
			else{
				break;								// break springt aus Schleife
			}
		}

		int number_lines = prozent / 10;    		// rundet automatisch ab (int/int ergibt immer int)

		for (int i=0; i<number_lines; i++){
			System.out.print("|");					// print druckt in selbe Zeile, println endet mit "Enter"
		}
		for (int i=0; i< 10 - number_lines; i++){
			System.out.print("-");
		}
	}
}