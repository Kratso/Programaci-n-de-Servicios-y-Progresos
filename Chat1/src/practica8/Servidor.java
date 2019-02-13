package practica8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

	public static void main(String[] args) {
		int clientes = 1;
		Thread t;
		while (true) {
			try {
				ServerSocket servidor = new ServerSocket(1313);
				System.out.println("Servidor activo.");
				List<PrintWriter> escribeMensajes = new ArrayList<>();
				t = new Thread(() -> {
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					System.out.print("Escriba 'exit' para cerrar el servidor");
					try {
						String m;
						while (!(m = br.readLine()).equals("exit")) {

						}
						escribeMensajes.forEach((pw)->{
							pw.println("El servidor se va a cerrar ahora.");
						});
						
						System.exit(0);
					} catch (IOException ex) {
						Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
					}

				});
				t.start();
				while (clientes <= 5) {
					Socket cliente = servidor.accept();
					PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true);
					BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
					escribeMensajes.add(pw);
					String nombre = br.readLine();
					System.out.println("Bienvenido " + nombre + "!!");
					pw.println("Bienvenido " + nombre + "!!");
					HiloChat hilo = new HiloChat(cliente.getInputStream(), pw, escribeMensajes, nombre);
					clientes++;
					new Thread(hilo).start();
				}
				System.out.println("M�ximo de clientes alcanzado");
			} catch (IOException e) {
				clientes--;
			}
		}
	}

}
