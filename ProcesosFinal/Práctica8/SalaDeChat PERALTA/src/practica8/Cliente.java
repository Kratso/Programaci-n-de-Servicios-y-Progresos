package practica8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		try {
			// Creamos el cliente.
			String host = "localhost";
			int puerto = 1313;
			Socket cliente = new Socket(host, puerto);
			System.out.println("Cliente activo.");
			// Creamos un objeto Scanner para recibir datos por teclado.
			Scanner sc = new Scanner(System.in);
			// Definimos los dos objetos que van a servir para el env�o y recibo de m
			// nsajes
			// entre clientes.
			PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			// Se registra el cliente.
			System.out.print("Nombre de usuario: ");
			String nombre = sc.nextLine();
			pw.println(nombre);
			/*
			 * Comienza la interacci�n en el chat: -Recibimos mensaje de bienvenida. -
			 * eemos los mensajes que vayan escribiendo el resto de usuarios/clientes. -Si
			 * no hay interacci�n podremos escribir.
			 */
			String mensaje;// Variable para recibir mensajes del chat.
			// Recibimos mensaje de bienvenida.
			mensaje = br.readLine();
			System.out.println(mensaje);
			// Bucle infinito que corresponde a las interacciones con el chat.
			Thread t = new Thread(() -> {
				try {
					while (!br.ready()) {
						Thread.sleep(200);
					}
					String m = br.readLine();
					System.out.println(m);
				} catch (IOException | InterruptedException ioe) {

				}
			});
			t.start();
			while (true) {// Se leen los mensajes del chat.

				System.out.println("Mensaje:");
				pw.println(sc.nextLine());
			}
		} catch (IOException e) {// Si ocurre alg�n error, lo visualizamos por pantalla.
			System.out.println("Ha ocurrido un error: " + e.getMessage());
		}
	}

}
