import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class FileManagement{
	public static void main(String[] args) throws IOException {
	}

	public static String readFromFile(String path) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get(path)));
		return content;
    }

    public static void writeToFile(String text, String path) throws IOException {
    	Files.write(Paths.get(path), text.getBytes());
    }
}

