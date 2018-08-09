package teste.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TesteBufferedReader {

	public static void main(String[] args) {
		File f = new File("c:/temp/Antonio.txt");
		try {
			FileReader fr = new FileReader( f );
			BufferedReader br = new BufferedReader( fr );
			while (br.ready()) {
				System.out.println( br.readLine() );
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Fim do programa");
	}
}
