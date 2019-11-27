import java.util.Scanner;
import java.util.Arrays;

public class IntArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int field_size = Integer.parseInt(args[0]);
		int n_numbers = Integer.parseInt(args[1]);

		int [] zahlenfeld = new int[field_size];

		for (int i=0; i<n_numbers; i++){
			System.out.println(Arrays.toString(zahlenfeld));
			int value = in.nextInt();
			zahlenfeld[value] += 1;

		}
		System.out.println(field_size);
		System.out.println(n_numbers);
		System.out.println(zahlenfeld);


	}
}