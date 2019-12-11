/*
Die Aufgabe fordert explizit zum Suchen nach Lösungen im Internet auf. Zu empfehlen ist wie immer Stackoverflow. Ich hab auch bloß gegoogelt.
Wichtig ist: es gibt für diese Probleme unfassbar viele Lösungen die von einer bis 50 Zeilen alles beinhalten. Ruhig ein bisschen Suchen oder rumprobieren.
Grundsätzlich ist es besser die einfachere Lösung zu nehmen. Allerdings kann das manchmal aus unterschiedlichen Gründen nicht möglich sein
(manche verwenden externe Libraries die in Yapex nicht existieren, oder funktionieren nicht auf Android etc., auch wenn das natürlich hier egal ist.)
Die Seiten von denen ich die benutzen Lösungen habe sind (und das sind beides nicht die obersten Lösungen):

Für readFile: https://stackoverflow.com/questions/326390/how-do-i-create-a-java-string-from-the-contents-of-a-file
Für writeFile: https://stackoverflow.com/questions/1053467/how-do-i-save-a-string-to-a-text-file-using-java

Grundsätzlich ist es egal, wie ihr es macht, solange es funktioniert, aber es hilft natürlich wenn ihr versteht was der Code macht.
Das Gute ist: habt ihr es einmal gemacht, könnt ihr immer wenn ihr es braucht wieder den Code kopieren und dann läufts.
*/




import java.nio.file.Files;				// benötigte Imports
import java.nio.file.Paths;				// benötigte Imports
import java.io.IOException;				// benötigte Imports - wichtig hier: Java muss in der Methodendefinition gesagt bekommen, was für ein Fehler auftreten kann
										// Die verwendeten Klassen Files und Paths können eine IOException auswerfen (das weiß man einfach, entweder aus Erfahrung oder 
										// weil man die Dokumentation gelesen hat), daher muss in der Methodendefinition throws IOException angegeben werden

public class FileManagement{
	public static void main(String[] args){											// Hier ist throws IOException nicht nötig, da wir die besagten Klassen nicht verwenden
	}

	public static String readFromFile(String path) throws IOException {				// Hier schon
		String content = new String(Files.readAllBytes(Paths.get(path)));			// Code von SO, Paths wandelt den String in ein Path-Objekt um, 
																					// Files.readAllBytes nimmt ein Paths-Objekt und liest die Datei an diesem Pfad ein
																					// String liest Files in String aus. new da String eine Klasse ist.
		return content;																// Rückgabe des eingelesenen Wertes (muss String sein, siehe Methodendeklaration Z. 28)
    }

    public static void writeToFile(String text, String path) throws IOException {	// Auch hier muss throws IOException definiert sein
    	Files.write(Paths.get(path), text.getBytes());								// getBytes wandelt den string text in Bytes um, Files.write schreibt die Daten an den angegebenen Pfad
    }
}

