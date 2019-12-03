import java.util.Arrays;
public class Glaettung{
	public static void main(String[] args) {
		double [] feld = {2,1,2,1,2,1};
		System.out.println(Arrays.toString(glaetten(feld)));
	}

	static double[] glaette(double[] numbers){
		int len = numbers.length;
		double [] new_field = new double[len];
		
		new_field[0] = numbers[0];
		new_field[-1] = numbers[-1];


		for (int i=1; i<len-1; i++){
			new_field[i] = (numbers[i-1] + numbers[i] + numbers[i+1])/3;
		}
		return new_field;
	}


}

