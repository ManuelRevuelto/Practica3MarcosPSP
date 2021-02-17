package ChatClienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class AtiendeServidor extends Thread {

	private Socket socket;
	private String ms, nombreUsuario;

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

			System.out.print("INTRODUZCA EL NOMBRE DE USUARIO => ");
			nombreUsuario = ky.nextLine();
			salida.writeUTF(nombreUsuario);

			while (true) {
				ms = ky.nextLine();
				salida.writeUTF(ms);
				String mensaje = entrada.readUTF();
				System.out.println("[" + nombreUsuario + "] => " + mensaje);

				ComunHilos.aniadir(mensaje, nombreUsuario);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}