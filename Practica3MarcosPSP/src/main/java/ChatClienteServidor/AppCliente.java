package ChatClienteServidor;

import java.io.IOException;
import java.net.Socket;

public class AppCliente {

	private static final String HOST = "localhost";
	private static final int PUERTO = 4444;

	public static void main(String[] args) throws IOException {
		Socket clientSocket = new Socket(HOST, PUERTO);
		AtiendeServidor cliente = new AtiendeServidor(clientSocket);
		cliente.start();
	}

}
