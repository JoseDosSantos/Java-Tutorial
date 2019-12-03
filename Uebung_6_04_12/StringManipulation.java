import java.util.Arrays;

public class StringManipulation{
	public static void main(String[] args) {
		String test = "abCDEa";
		char z = 'a';
		String ins = "xyz";
		System.out.println(reverse(test));
		System.out.println(delete(test, z));
		System.out.println(delete(test, 2, 4));
		System.out.println(insert(test, 2, 'x'));
		System.out.println(insert(test, 2, "xyz"));
		System.out.println(swapUpperLowerCase(test));
		System.out.println(Arrays.toString(toCharacterArray(test)));


	}

	public static String reverse(String str){
		int len = str.length();
		String new_string = "";
		for (int i = len - 1; i>=0; i--){
			new_string += str.charAt(i);
		}
		return new_string;
	}

	public static String delete(String str, char zeichen){
		int len = str.length();
		String new_string = "";
		for (int i=0; i<len; i++){
			if (str.charAt(i) != zeichen){
				new_string = new_string + str.charAt(i);
			}
		}
		return new_string;
	}

	public static String delete(String str, int pos1, int pos2){
		int len = str.length();
		String new_string = "";

		for (int i=0; i<pos1; i++){
			new_string += str.charAt(i);
		}

		for (int i=pos2+1; i<len; i++){
			new_string += str.charAt(i);
		}

		return new_string;
	}

	public static String insert(String str, int pos, char zeichen){
		int len = str.length();
		String new_string = "";
		for (int i=0; i<pos; i++){
			new_string += str.charAt(i);
		}
		new_string += zeichen;
		for (int i=pos; i<len; i++){
			new_string += str.charAt(i);
		}
		return new_string;
	}



	public static String insert(String str1, int pos, String str2){
		int len = str1.length();
		String new_string = "";
		for (int i=0; i<pos; i++){
			new_string += str1.charAt(i);
		}

		new_string += str2;

		for (int i=pos; i<len; i++){
			new_string += str1.charAt(i);
		}

		return new_string;
	}


	public static String swapUpperLowerCase(String str){
		int len = str.length();
		String new_string = "";

		for (int i = 0; i<len; i++){
			if (Character.isUpperCase(str.charAt(i))){
				new_string += (char) (str.charAt(i) + 32);
			}
			if (Character.isLowerCase(str.charAt(i))){
				new_string += (char) (str.charAt(i) - 32);
			}
		}
		
		return new_string;
	}



	public static char[] toCharacterArray(String str){
		int len = str.length();
		char[] new_arr = new char[len];

		for (int i=0; i<len; i++){
			new_arr[i] = str.charAt(i);
		}

		
		return new_arr;
	}



}