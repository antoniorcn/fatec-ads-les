package teste.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TesteObjectOutputStream {

	public static void main(String[] args) {
		int[] numeros = {35, 22, 5, 47, 38, 99};
		File f = new File("c:/temp/numeros.dat");
		try {
			FileOutputStream fout = new FileOutputStream( f );
			ObjectOutputStream objOut = new ObjectOutputStream( fout );
			objOut.writeObject(numeros);
			objOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Fim de programa");
		
		

	}

}
