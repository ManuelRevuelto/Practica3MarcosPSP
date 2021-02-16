package Practica3MarcosPSP.Practica3MarcosPSP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class AtiendeCliente {
	static String patata = "Patata";
	static String st = "";
	static Socket socket = null;
	static DataInputStream input = null;
	static DataOutputStream output = null;
	final static String COMANDO_TERMINACION = "salir()";
	
	public static void conexion(int PUERTO, String IP) {

		try {
			 socket = new Socket(IP, PUERTO);
			System.out.println("Conectado a :" + socket.getInetAddress().getHostName());
		} catch (Exception e) {
			System.out.println("Excepción al levantar conexión: " + e.getMessage());
			System.exit(0);
		}

		try {
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
			output.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
        try {
            do {
                st = (String) input.readUTF();
                System.out.println("\n[Servidor] => " + st);
                System.out.print("\n[Usted] => ");
            } while (!st.equals(COMANDO_TERMINACION));
        } catch (IOException e) {}
		
        
        try {
            output.close();
            input.close();
            socket.close();
            System.out.println("Conexión terminada");
        } catch (IOException e) {
            System.out.println("IOException on cerrarConexion()" + e.getMessage());
        }
        
	}
}
