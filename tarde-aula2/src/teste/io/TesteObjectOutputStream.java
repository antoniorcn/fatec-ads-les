package teste.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TesteObjectOutputStream {

	public static void main(String[] args) {
		String[] textos = {"Antonio", "Carvalho", "Fatec", "LES", "ADS"};
		File f = new File("C:/temp/objeto.bin");
		try {
			FileOutputStream fos = new FileOutputStream( f );
			ObjectOutputStream obj = new ObjectOutputStream( fos );
			obj.writeObject( textos );
			obj.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fim do programa");
	}
}
