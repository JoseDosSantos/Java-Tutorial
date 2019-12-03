public class Glaettung{
	public static void main(String[] args) {
	}

	static double[] glaette(double[] numbers){					
		int len = numbers.length;								
		double [] new_field = new double[len];					

		for (int i=1; i<len-1; i++){										
			new_field[i] = (numbers[i-1] + numbers[i] + numbers[i+1])/3;
		}

		new_field[0] = numbers[0];								
		new_field[len-1] = numbers[len-1];						
		return new_field;										
	}
}

