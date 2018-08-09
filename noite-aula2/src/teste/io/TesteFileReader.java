package teste.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TesteFileReader {

	public static void main(String[] args) {
		File f = new File("C:/temp/arquivo.txt");
		
		try {
			FileReader fr = new FileReader( f );
			int i = 0;
//			while (i != -1) {
//				i = fr.read();
//				if (i != -1) {
//					System.out.print( (char)i );
//				}
//			}
//			while ((i = fr.read()) != -1){
//				System.out.print( (char)i );
//			}
			while (fr.ready()){
				i = fr.read();
				System.out.print( (char)i );
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\nFim do programa");
	}

}
