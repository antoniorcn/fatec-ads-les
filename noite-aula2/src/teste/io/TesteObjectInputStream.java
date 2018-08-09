package teste.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TesteObjectInputStream {

	public static void main(String[] args) {
		File f = new File("C:/temp/numeros.dat");		
		try {
			FileInputStream fin = new FileInputStream( f );
			ObjectInputStream objIn = new ObjectInputStream( fin );
			int vetor[] = (int[])objIn.readObject();
			objIn.close();
			System.out.println("Vetor lido do arquivo " + vetor.length + " elementos");
			for (int i : vetor) { 
				System.out.println( i );
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Fim do programa");
	}

}
