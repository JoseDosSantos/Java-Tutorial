public class Caesar{
	public static void main(String[] args) {
		String encrypted = args[0].toLowerCase().replaceAll("[^a-zA-Z]", "");
		String common_letters = args[1].toLowerCase().replaceAll("[^a-zA-Z]", "");

		int encrypted_length = encrypted.length();
		int max_counter = 0;
		char most_common = ' ';

		for (int i=0; i<26; i++){
			int current_count = 0;
			char current_char = (char)(i+97);

			for (int j=0; j<encrypted_length; j++){
				if (current_char == encrypted.charAt(j)){
					current_count += 1;
				}

			}
			if (current_count > max_counter){
				max_counter = current_count;
				most_common = current_char;
			}
		}

		for (int i=0; i<common_letters.length(); i++){
			 System.out.println(most_common - common_letters.charAt(i));
		}


		System.out.println(encrypted);
		System.out.println("Most common letter: " + most_common + " Count: " + Integer.toString(max_counter));

		System.out.println(common_letters);





	}
}