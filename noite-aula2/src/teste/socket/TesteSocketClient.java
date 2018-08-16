package teste.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TesteSocketClient {

	public static void main(String[] args) {
		try {
			System.out.println("Cliente socket iniciado");
			Socket s = new Socket("localhost", 40000);
			OutputStream out = s.getOutputStream();
			InputStream in = s.getInputStream();
			InputStream inputkbd = System.in;
			System.out.println("Conectado no servidor");
			boolean fim = false;
			while (!fim) { 
				while (in.available() > 0) { 
					int b = in.read();
					System.out.print((char)b);
				}
				while (inputkbd.available() > 0) { 
					int b = inputkbd.read();
					if (b == 27) { 
						fim = true;
					}
					out.write(b);
					out.flush();
				}
			}
			System.out.println("Fim do programa");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
