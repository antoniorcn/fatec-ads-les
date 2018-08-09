package teste.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscreveNome {

	public static void main(String[] args) {
		File f = new File("C:/temp/index.html");
		System.out.println("Arquivo existe ? : " + f.exists());
		
		try {
			FileWriter fw = new FileWriter( f );
			fw.write("<html>\r\n");
			fw.write("<body>\r\n");
			fw.write("<h1>Ola mundo</h1>\r\n");
			fw.write("</body>\r\n");
			fw.write("</html>\r\n");
//			fw.flush();
//			fw.write("Este é um codigo de teste da aula da tarde");
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Fim do programa");

	}

}
