package teste.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TesteObjetInputStream {

	public static void main(String[] args) {
		String[] teste;	
		File f = new File("c:/temp/objeto.bin");
		try {
			FileInputStream fin = new FileInputStream( f );
			ObjectInputStream objin = new ObjectInputStream( fin );
			teste = (String[])objin.readObject();
			System.out.println("Elementos no vetor : " + teste.length);
			for (String s : teste) { 
				System.out.println("Elemento : " + s);
			}
			objin.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
