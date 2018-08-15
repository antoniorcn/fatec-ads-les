package teste.socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class TesteServerSocket {
	public static void main(String[] args) {
		try {
			System.out.println("Servidor iniciado");
			ServerSocket server = new ServerSocket(40000);
			System.out.println("Aguardando mensagem na porta 40000");
			Socket cliente = server.accept();
			System.out.println("Cliente foi conectado");
			OutputStream out = cliente.getOutputStream();
			InputStream in = cliente.getInputStream();
			out.write("Bem vindo ao servidor Java\n".getBytes());
			out.flush();
			boolean fim = false;
			while (!fim) {
				InputStream inputKeyboard = System.in;
				while (inputKeyboard.available() > 0) { 
					int b = inputKeyboard.read();
					out.write(b);
					if (b == 27) { 
						fim = true;
					}
					out.flush();
				}
				while (in.available() > 0) { 
					int b = in.read();
					if (b == 27) { 
						fim = true;
					}
					System.out.print((char)b);
				}
			}
			server.close();
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fim do programa");
	}

}
