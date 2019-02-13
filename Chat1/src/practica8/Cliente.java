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

			String host = "localhost";
			int puerto = 1313;
			Socket cliente = new Socket(host, puerto);
			System.out.println("Cliente activo.");

			Scanner sc = new Scanner(System.in);

			PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

			System.out.print("Nombre de usuario: ");
			String nombre = sc.nextLine();
			pw.println(nombre);
			
			String mensaje;
			mensaje = br.readLine();
			System.out.println(mensaje);

			Thread t = new Thread(() -> {
				while (true) {
					try {
						while (!br.ready()) {
							Thread.sleep(200);
						}
						String m = br.readLine();
						System.out.println(m);
					} catch (IOException | InterruptedException ioe) {

					}
				}
			});
			t.start();
			while (true) {
				pw.println(sc.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error: " + e.getMessage());
		}
	}

}
