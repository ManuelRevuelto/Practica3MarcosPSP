package Practica3MarcosPSP.Practica3MarcosPSP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Se debe lanzar primero tcp.AppServidor y depués tcp.AppCliente. Enviará un
 * mensaje al Servidor y esperará su contestación.
 */
public class AppCliente {
	static final String IP = "localhost";
	static final int PUERTO = 4444;

	public static void main(String[] args) throws IOException {
		// Obtenemos conexion e inicializamos
		Socket socketTcp = new Socket(IP, PUERTO);

		// Obtenemos los canales de entrada de datos y de salida
		DataInputStream entrada = new DataInputStream(socketTcp.getInputStream());
		DataOutputStream salida = new DataOutputStream(socketTcp.getOutputStream());

		// Enviamos un mensaje y esperamos la respuesta del servidor
		salida.writeUTF("patata");
		String mensajeDelServidor = entrada.readUTF();
		System.out.println("Recibido mensaje del servidor: " + mensajeDelServidor);

		// Cerramos la conexión
		socketTcp.close();

	}
}
