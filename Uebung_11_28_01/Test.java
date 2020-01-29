/* 
nur die Test-Datei für Aufgabe 1 von Japex, könnt ihr ignorieren
*/
import java.io.*;
public class Test {
    public static void main(String[] args) throws IOException {
        Zaehler<Paar<String>> zeichenketten = new Zaehler<Paar<String>>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String eing1, eing2;
        System.out.println("Wie viele Werten sollen eingegeben werden?");
        int max = Integer.parseInt(in.readLine());
        Paar<String> p;
        for(int i=0; i<max; i++) {
            System.out.println("Erster Wert:");
            eing1 = in.readLine();
            System.out.println("Zweiter Wert:");
            eing2 = in.readLine();
            p = new Paar<String>(eing1, eing2);
            if(p.getWert1().equals(eing1)) System.out.println("Wert 1 wurde korrekt gespeichert!");
            else System.out.println(eing1 + " stimmt nicht mit " + p.getWert1() + " ueberein!");
            if(p.getWert2().equals(eing2)) System.out.println("Wert 2 wurde korrekt gespeichert!");
            else System.out.println(eing2 + " stimmt nicht mit " + p.getWert2() + " ueberein!");
            System.out.println("Erzeugtes Paar: " + p);
            zeichenketten.neuesElement(p);
        }
        System.out.print(zeichenketten);
    }
}