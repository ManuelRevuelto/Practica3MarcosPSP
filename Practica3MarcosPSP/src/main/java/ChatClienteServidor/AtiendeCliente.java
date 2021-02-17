package ChatClienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class AtiendeCliente extends Thread {

	private Socket socket = null;

	public AtiendeCliente(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		super.run();
		try {

			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
			String nombreUsuario = entrada.readUTF();
			while (true) {
				String mensajeDelCliente = entrada.readUTF();
				System.out.println("[" + nombreUsuario + "] => " + mensajeDelCliente);
				salida.writeUTF(mensajeDelCliente);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
