public class Palindromtest2{
	public static void main(String[] args){
		String text = args[0];
		text = text.toLowerCase();
		int length = text.length();
		int lastPos = length - 1;

		for (int i=0; i<length; i++){
			while(text.charAt(lastPos) == ' '){
				lastPos = lastPos - 1;
			}

			if (text.charAt(i) !=  ' '){
				if (text.charAt(i) != text.charAt(lastPos)){
					System.out.println(false);
					System.out.println(i);
					break;
				}
				else {
					lastPos = lastPos - 1;
				}
			}
			
			if (i == length - 1){
				System.out.println(true);
			}
		}
	}
}

