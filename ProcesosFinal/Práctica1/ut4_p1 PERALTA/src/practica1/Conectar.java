package practica1;
import java.io.IOException;
import java.net.SocketException;
import org.apache.commons.net.ftp.*;

public class Conectar {

	public static void main(String[] args) {
		//Creamos el cliente.
		FTPClient cliente = new FTPClient();
		//Conecta al servidor FTP.
		try {
			System.out.println("Conectando a servidor...");
			String servidor = "ftp.rediris.es";
			cliente.connect(servidor);
			cliente.login("anonymous","anonymous");
			System.out.println("Conectado\n");
		} catch (IOException e) {
			System.out.println("No ha sido posible conectar. Saliendo...");
			System.exit(0);
		}
		//Muestra los archivos del directorio raíz.
		try {
			System.out.println("Archivos en directorio raíz:");
			FTPFile[] archivos = cliente.listFiles();
			for(int i=2; i<archivos.length;i++){
				System.out.println(archivos[i].getName());
			}
			System.out.print("\n");
		} catch (IOException e) {
			System.out.println("No ha sido posible mostrar el contenido del directorio raíz.");
		}
		//Guardamos la ruta del primer directorio del raíz y jugamos un poco con él.
		try {
			FTPFile[] archivos2 = cliente.listFiles();
			FTPFile hijo = archivos2[2];
			String ruta = "ftp.rediris.es/"+hijo.getName();
			System.out.println("Datos de "+ruta+":");
			//Mostramos el nombre del hijo.
			System.out.println("Nombre:"+hijo.getName());
			//Mostramos tamaño del hijo.
			System.out.println("Tamaño:"+hijo.getSize());
			//Mostramos el tipo del hijo.
			System.out.println("Tipo: "+hijo.getType());
		} catch (IOException e) {
			System.out.println("No ha sido posible mostrar característica del directorio hijo.");
		}
	}

}
