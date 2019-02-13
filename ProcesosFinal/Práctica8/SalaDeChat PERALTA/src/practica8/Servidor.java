package practica8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Servidor {

	public static void main(String[] args) {
		// Variable para contabilizar el n�mero de clientes en conexi�n.
		int clientes = 1;
		try {
			// Creamos el servidor.
			ServerSocket servidor = new ServerSocket(1313);
			System.out.println("Servidor activo.");
			// Creamos un objeto List para guardar el n�mero de escritores o "writers" que
			// van interactuando en el chat.
			List<PrintWriter> escribeMensajes = new LinkedList<PrintWriter>();
			/*
			 * Bucle infinito que representa al chat: -Recibe los clientes hasta un tope de
			 * 5. -Da la bienvenida a los clientes nuevos. -Escribe por pantalla los
			 * mensajes de los usuarios activos.
			 */
			while (clientes <= 5) {
				// Recibe los clientes.
				Socket cliente = servidor.accept();
				PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true);
				BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				escribeMensajes.add(pw);
				// Da la bienvenida a los clientes nuevos.
				String nombre = br.readLine();
				System.out.println("Bienvenido " + nombre + "!!");
				pw.println("Bienvenido " + nombre + "!!");
				// "Lanza" al cliente al chat.
				HiloChat hilo = new HiloChat(cliente.getInputStream(), pw, escribeMensajes, nombre);
				clientes++;
				new Thread(hilo).start();
			}
			// Si se alcanza el tope de clientes, muestra este mensaje:
			System.out.println("M�ximo de clientes alcanzado");
		} catch (IOException e) {// Si salta una exepci�n, se resta un cliente.
			clientes--;
		}
	}

}
