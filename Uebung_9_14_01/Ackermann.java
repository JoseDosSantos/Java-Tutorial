public class Ackermann{
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		System.out.println(ack(n, m));
	}

	public static int ack(int n, int m){
		if (n == 0){
			return m + 1;
		}
		else if (n > 0 && m == 0){
			return ack(n-1, 1);
		}
		else{
			return ack(n-1, ack(n, m-1));
		}
	}
}