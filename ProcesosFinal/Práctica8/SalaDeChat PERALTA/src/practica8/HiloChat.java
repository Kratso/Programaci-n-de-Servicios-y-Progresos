package practica8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

public class HiloChat implements Runnable {

	// Atributos:

	BufferedReader leer;// Lector de mensajes.
	PrintWriter pw;// Escritor de mensajes.
	List<PrintWriter> escribir;// Lista de escritor de mensajes.
	String cliente;// Variable para guardar el nombre o indentificador del cliente.

	// Constructores:

	HiloChat(InputStream is, PrintWriter pw, List<PrintWriter> writers, String cliente) {
		this.leer = new BufferedReader(new InputStreamReader(is));
		this.pw = pw;
		this.escribir = writers;
		this.cliente = cliente;
	}

	// M�todos:

	// Cuando se inicia el hilo.
	@Override
	public void run() {
		String mensaje;
		// Manda el mensaje de bienvenida.
		for (PrintWriter pwr : escribir) {
			if (pwr != pw) {
				pwr.println("Bienvenido " + cliente + "!!");
			}
		}
		// Bucle infinito para mandar mensajes de chat.
		while (true) {
			try {
				mensaje = leer.readLine();
				/*
				 * Manda el mensaje a los dem�s usuarios y al servidor.
				 */
				for (PrintWriter pwr : escribir) {
					if (pwr != pw) {
						pwr.println(cliente + "-> " + mensaje);
					}
				}
				System.out.println(cliente + "-> " + mensaje);
			} catch (IOException e) {// Si detecta alg�n error, deja de mandar mensajes.
				break;
			}
			if (mensaje == null)// Si recibe un nulo como mensaje, deja de mandar mensajes.
				break;
		}
		// Cierra el lector de mensajes.
		try {
			leer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
