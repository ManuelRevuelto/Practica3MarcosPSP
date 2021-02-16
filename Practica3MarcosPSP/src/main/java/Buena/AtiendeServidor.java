package Buena;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class AtiendeServidor extends Thread {

	private Socket socket = null;
	private String ms;

	public AtiendeServidor(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		super.run();

		try {
            Scanner ky = new Scanner(System.in);
			ComunHilos.aniadir(socket);
			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
			salida.flush();
			ms = ky.nextLine();
			salida.writeUTF(ms);
			while (true) {
				String mensaje = entrada.readUTF();
				System.out.println("Mensaje"+ mensaje);
				ComunHilos.aniadir(mensaje, mensaje);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}