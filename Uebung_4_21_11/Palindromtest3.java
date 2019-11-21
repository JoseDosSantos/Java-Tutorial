public class Palindromtest3{
	public static void main(String[] args){
		String text = args[0];
		text = text.toLowerCase();
		int length = text.length();
		int lastPos = length-1;

		for (int i=0; i < length; i++){
			while(text.charAt(lastPos) == ' '){		// " " bedeutet string; ' ' bedeutet char
				lastPos = lastPos - 1;
			}			
			
			if (text.charAt(i) != ' '){
				if (text.charAt(i) != text.charAt(lastPos)){
					System.out.println(false);
					System.out.println(i);
					break;
				}
				else {
					lastPos = lastPos - 1;
				}
			}
			if (i == length-1){
				System.out.println(true);
			}
		}
	}
}

/*
[0][1][2][3][4][5][6][7][8][9][10][11]
 a  _  b  _  _  b  a  _	 _  a  _   _

 i = 0 : a(text[i]) == a (text[länge-1-i])
 i = 1 : _(text[i]) == b (text[länge-1-i])
 i = 2 : _(text[i]) == c (text[länge-1-i])
*/