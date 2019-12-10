public class Linearcode{
	public static void main(String[] args) {
		// String code = args[0];		
		String code = "|| ||||| ||||| ||||| ||||| ||||||  |";
		int[] zahlen = new int[code.length()/6];

		for (int i=0; i<code.length()/6; i++){
			int value = 0;
			for (int j=0; j<5; j++){
				if (code.charAt(i*6 + j) == ' ') {
					if (j==0) {value += 0;}
					if (j==1) {value += 1;}
					if (j==2) {value += 2;}
					if (j==3) {value += 4;}
					if (j==4) {value += 7;}
					}
				
			}
			if (value > 10){
				zahlen[i] += 0;
			}
			else{
				zahlen[i] = value;
			}
		}

		int quersumme = 0;
		for (int i = 0; i<zahlen.length; i++){
			quersumme += zahlen[i];
		}

		if (quersumme%10 != 0){
			System.out.println("Falscher Code");
		}
		else {
			for (int i=zahlen.length-2; i>=0; i--){
				System.out.print(zahlen[i]);
			}
		}
	}

}









