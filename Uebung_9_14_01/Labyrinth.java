import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Labyrinth{
	private int x_dim;
	private int y_dim;
	private boolean[][] matrix;
	private int x_pos;
	private int y_pos = 0;


	public Labyrinth(String name) throws IOException{
		String content = new String(Files.readAllBytes(Paths.get("sample.txt")));
		String[] rows = content.split("\n");
		x_dim = rows[0].trim().length() - 1;
		y_dim = rows.length - 1;
		matrix = new boolean[x_dim + 1][y_dim + 1];

		for (int y = 0; y<= y_dim; y++){
			for (int x = 0; x<= x_dim; x++){
				String val = rows[y].trim().split("")[x];
				if (val.equals("#")){
					matrix[x][y] = false;
				}
				else{
					matrix[x][y] = true;
				}
			}
		}
		
		for (int x = 0; x < x_dim; x++){
			if(matrix[x][0]){
				x_pos = x;
				break;
			}
		}
	}

	public boolean bewegeDich(char z){
		switch (z){
			case 'l':
				if (x_pos > 0){
					return matrix[x_pos - 1][y_pos];
				}
				else {return false;}
			case 'r':
				if (x_pos < x_dim){
					return matrix[x_pos + 1][y_pos];
				}
				else {return false;}
			case 'o':
				if (y_pos > 0){
					return matrix[x_pos][y_pos - 1];
				}
				else {return false;}
			case 'u':
				if (y_pos < y_dim){
					return matrix[x_pos][y_pos + 1];
				}
				else {return false;}
			default:
				return false;
		}
	}

	public String toString(){
		String output = "";
		for(int y=0; y<=y_dim; y++){
			for(int x=0; x<=x_pos; x++){
				if (x==x_pos && y==y_pos){
					output+="x";
				}
				else if (matrix[x][y]){
					output+="O";
				}
				else {
					output+="#";
				}
			}
			output +="\n";
		}
		return output;
	}
}