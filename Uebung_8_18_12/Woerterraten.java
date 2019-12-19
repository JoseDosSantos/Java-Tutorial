import java.util.Scanner;

public class Woerterraten {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String zielwort = args[0];
		int maxVersuche = Integer.parseInt(args[1]);

		int versuche = 0;
		boolean geloest = false;
		String gefundeneBuchstaben = "";
		
		for (int i=0; i<zielwort.length(); i++){
			System.out.print("_");
		}
		System.out.print("\n");

		while (versuche < maxVersuche){
			versuche+=1;
			String input = scan.nextLine();
			
			if (input.length() > 1){
				if (input.equals(zielwort)){
					geloest = true;
					break;
				}
			}
			else{
				if (zielwort.contains(input)){
					if (gefundeneBuchstaben.contains(input)){
						System.out.println("Buchstabe kam bereits vor");
						versuche -= 1;
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
				geloest = true;
				break;
			}
			System.out.println(output);

			
		}

		if (geloest){
			System.out.print(versuche);
			System.out.print(" Versuche fuer ");
			System.out.println(zielwort);
		}
		else{
			System.out.println("Maximale Anzahl an Versuchen ueberschritten");
		}


	}
}