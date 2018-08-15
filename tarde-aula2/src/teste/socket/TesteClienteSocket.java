package teste.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TesteClienteSocket {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("10.68.77.40", 40000);
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			InputStream inputKeyboard = System.in;
			boolean fim = false;
			while (!fim) { 
				while (in.available() > 0) {
					int b = in.read();
					System.out.print((char)b);
				}
				
				while(inputKeyboard.available() > 0) {
					int b = inputKeyboard.read();
					out.write(b);
					out.flush();
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
