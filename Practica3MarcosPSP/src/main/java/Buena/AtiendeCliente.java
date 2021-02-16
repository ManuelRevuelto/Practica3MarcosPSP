package Buena;

import java.io.DataInputStream;
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
			entrada.readUTF();
			while (true) {
				String mensaje = entrada.readUTF();
				System.out.println("Mensaje" + mensaje);
				ComunHilos.aniadir(mensaje, mensaje);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
