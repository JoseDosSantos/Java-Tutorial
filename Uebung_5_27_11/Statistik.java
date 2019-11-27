import java.util.Arrays;
import java.util.Scanner;

public class Statistik{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int feld_laenge = Integer.parseInt(args[0]);
		int anzahl = Integer.parseInt(args[1]);

		int [] [] matrix = new int [feld_laenge][2]; // matrix[columns][rows]

		for (int i=0; i < anzahl; i++){
			int next_value = in.nextInt();
			for (int col=0; col<matrix.length; col++){
				if (matrix[col][1] == 0){
					matrix[col][0] = next_value;
					matrix[col][1] = matrix[col][1] + 1;
					break;
				}
				else if (matrix[col][0] == next_value) {
					matrix[col][1] = matrix[col][1] + 1;
					break;
				}
			}	
		}

		// Eingegebene Zahlen ausgeben
		for (int col=0; col < matrix.length; col++){
			if (matrix[col][1] > 0){				// nur wenn Anzahl nicht 0
				if (!(col == 0)){					// für alle außer erster Zahl vorher Komma
					System.out.print(',');
				}
				System.out.print(matrix[col][0]);
			}
		}
		System.out.print("\n");

		// Anzahl ausgeben
		for (int col=0; col < matrix.length; col++){
			if (matrix[col][1] > 0){				// nur wenn Anzahl nicht 0
				if (!(col == 0)){					// für alle außer erster Zahl vorher Komma
					System.out.print(',');
				}
				System.out.print(matrix[col][1]);
			}
		}

	}
}