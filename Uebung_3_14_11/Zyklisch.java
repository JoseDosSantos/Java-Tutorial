import java.io.*;
public class Zyklisch{
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String original = in.readLine();
        String ziel = in.readLine();
        int laenge = original.length();
        boolean solved = false;

        for(int i=0; i<laenge; i++){
        	if(original.equals(ziel)){  //Vergleich von Strings mit str1.equals(str2)!
        		solved = true;
        		System.out.println(i);
        	}
        	// System.out.println(original);
        	original = original.substring(laenge-1, laenge) + original.substring(0, laenge-1);      	
        }
        if (!solved) System.out.println(-1); //! = nicht 

    }
}
        //"abcde".substring(0, 4)) = "abcd"
        //"abcde".substring(4, 5)) = "e"




/*
"abcde" -> "eabcd"

"abcde".substring(0, 2) = "ab"

liste = [a, b, c, d, e]

0 1 2 3 4 5 6 7
a b c d e f g h 

n = length(liste) = 5
liste[0] = a
liste[2] = c
liste[0:2] = [a, b, c]
liste[-1] = e
neu = liste[-1] + liste[0:n-1]
neu_string = "e" + "abcd" = "eabcd"

String text = "abcde"
*/