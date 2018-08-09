package teste.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeNome {
	public static void main(String[] args) {
		File f = new File("C:/temp/Antonio.txt");
		try {
			FileReader fr = new FileReader( f );
			int i = 0;
			while ( i != -1 ) {
				i = fr.read();
				System.out.print( (char)i );
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
