public class BytesVerstehen
{
	public static void main (String[] args)
	{
		byte test = 127;
		System.out.println(test);
		test++; // test wird um 1 erhoeht
		//test = test + 1
		System.out.println(test);
	}
}

/*
a) Das Progamm gibt -128 aus. Dies geschieht, da 127 die größte mit den 8 Bit des Byte-datentyps (mit Vorzeichen) darstellbare Zahl ist.
Versucht man diese zu erhöhen, "overflowt" die Variable und springt vom höchsten zum niedrigsten möglichen Wert. (1111 1111 -> 0000 0000)

b) Anstatt die Variable bitweise zur erhöhen wird versucht, einen Integer zu addieren. Da der Java-Compiler automatisch erkennt, dass eine solche Addition aufgrund des größeren Wertebereichs
von Integern möglicherweise fehlerhaft abläuft (durch over - oder underflow) wirft er hier, auch bei theoretisch problemlosen Operationen (wenn test = 0), eine Fehlermeldung aus.


0 = 0000
1 = 0001
2 = 0010
3 = 0011
4 = 0100
5 = 0101
6 = 0110
7 = 0111
8 = 1000
9 = 1001
10 = 1010
11 = 1011
12 = 1100
13 = 1101
14 = 1110
15 = 1111
16 = 0000 ??

+1
= 0000
16 = 10000

test++
test = test + 1


0000 0000 = -128
1111 1111 = 127
*/
