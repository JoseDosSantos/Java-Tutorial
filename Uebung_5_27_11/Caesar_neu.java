public class Caesar_neu{
	public static void main(String[] args) {
		String z1 = args[0].toLowerCase();
		String z2 = args[1].toLowerCase();
		z1 = z1.replaceAll("[^a-z]", "");
		z2 = z2.replaceAll("[^a-z]", "");

		int max_count = 0;
		char max_char = ' ';


		for (int i=0; i<26; i++){
			char current_char = (char)(i + 97);
			int current_count = 0;

			for(int j=0; j<z1.length(); j++){
				if(z1.charAt(j) == current_char){
					current_count += 1;
				}				
			}
			if(current_count>max_count){
				max_count = current_count;
				max_char = current_char;
			}
		}	
		System.out.println(max_char);

		for (int i=0; i<z2.length(); i++){
			if (max_char > z2.charAt(i)){
				System.out.println(max_char - z2.charAt(i));
			}
			else {
				System.out.println(z2.charAt(i) - max_char);
			}
			
		}
		
	}
}