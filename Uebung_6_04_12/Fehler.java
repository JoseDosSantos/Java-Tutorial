public class Fehler{
	public static void main(String[] args) {
	int a[] = {1 ,2 ,3 ,4 ,5};
	int b[] = {2 ,3 ,5 ,7 , -1};

	System.out.println(a[(a.length*b[a[b[0]]])%a.length]);

	}
}