package teste.socket;
import java.io.IOException;
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
			server.close();
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fim do programa");
	}

}
