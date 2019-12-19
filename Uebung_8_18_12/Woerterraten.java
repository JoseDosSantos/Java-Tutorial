import java.util.Scanner;

public class Woerterraten {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String zielwort = args[0];
		int maxVersuche = Integer.parseInt(args[1]);

		int versuche = 0;
		String gefundeneBuchstaben = "";
		
		for (int i=0; i<zielwort.length(); i++){
			System.out.print("_");
		}
		System.out.print("\n");

		do {
			String input = scan.nextLine();
			versuche+=1;

			if (input.length() > 1){
				if (input.equals(zielwort)){
					System.out.print(versuche);
					System.out.print(" Versuche fuer ");
					System.out.println(zielwort);
					break;
				}
			}
			else{
				if (zielwort.contains(input)){
					if (gefundeneBuchstaben.contains(input)){
						System.out.println("Buchstabe kam bereits vor");
						continue;
					}
					else {
						gefundeneBuchstaben += input;
					}
				}
			}

			String output = "";

			for (int i=0; i<zielwort.length();i++){
				String aktuellerBuchstabe = Character.toString(zielwort.charAt(i));
				if (gefundeneBuchstaben.contains(aktuellerBuchstabe)){
					output += aktuellerBuchstabe;
				}
				else{
					output += "_";
				}
			}
			
			
			if (output.equals(zielwort)){
				System.out.print(versuche);
				System.out.print(" Versuche fuer ");
				System.out.println(zielwort);
				break;
			}
			if (versuche == maxVersuche){
				System.out.println("Maximale Anzahl an Versuchen ueberschritten");
			}
			else {
				System.out.println(output);
			}
			

		} while (versuche < maxVersuche);
	}
}