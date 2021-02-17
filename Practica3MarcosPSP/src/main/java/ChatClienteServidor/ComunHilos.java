package ChatClienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ComunHilos {

	private int MAX_CONEXIONES, conexionesTotales, conexionesActuales;
	private String mensajes;
	private static ArrayList<Socket> tablaDeConexiones;

	public ComunHilos(int MAX_CONEXIONES) {
		this.MAX_CONEXIONES = MAX_CONEXIONES;
	}

	public int getConexionesTotales() {
		return conexionesTotales;
	}

	public int getConexionesActuales() {
		return conexionesActuales;
	}

	public String getMensajes() {
		return mensajes;
	}

	public static void aniadir(Socket conexion) {

		tablaDeConexiones = new ArrayList<Socket>();
		tablaDeConexiones.add(conexion);
		for (int i = 0; i < tablaDeConexiones.size(); i++) {
			System.out.println(tablaDeConexiones.get(i));
		}

	}

	public static void aniadir(String mensaje, String nombreUsuario) {

		for (int i = 0; i < tablaDeConexiones.size(); i++) {

			DataInputStream entrada = null;
			DataOutputStream salida = null;
			try {
				entrada = new DataInputStream(tablaDeConexiones.get(i).getInputStream());
				salida = new DataOutputStream(tablaDeConexiones.get(i).getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}

			
			

		}

	}

}
