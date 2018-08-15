package teste.socket;

import java.io.IOException;
import java.io.InputStream;

public class TesteKeyboard {

	public static void main(String[] args) throws IOException {

		int c = 0;
		InputStream inputKeyboard = System.in;
		while (c != 27) { 
			System.out.println(inputKeyboard.available());
		}
	}

}
