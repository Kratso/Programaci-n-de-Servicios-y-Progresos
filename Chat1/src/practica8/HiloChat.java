package practica8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

public class HiloChat implements Runnable {



	BufferedReader leer;
	PrintWriter pw;
	List<PrintWriter> escribir;
	String cliente;


	HiloChat(InputStream is, PrintWriter pw, List<PrintWriter> writers, String cliente) {
		this.leer = new BufferedReader(new InputStreamReader(is));
		this.pw = pw;
		this.escribir = writers;
		this.cliente = cliente;
	}

	@Override
	public void run() {
		String mensaje;
		for (PrintWriter pwr : escribir) {
			if (pwr != pw) {
				pwr.println("¡¡Bienvenido " + cliente + "!!");
			}
		}

		while (true) {
			try {
				mensaje = leer.readLine();
				
				for (PrintWriter pwr : escribir) {
					if (pwr != pw) {
						pwr.println(cliente + "-> " + mensaje);
					}
				}
				System.out.println(cliente + "->'" + mensaje + "'");
			} catch (IOException e) {
				break;
			}
			if (mensaje == null)
				break;
		}

		try {
			leer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
