package practica7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Servidor {

	public static void main(String[] args) {
		try {
			//Creamos el servidor.
			ServerSocket server = new ServerSocket(5000);
			System.out.println("Servidor operativo.");
	        //Creamos lector de mensajes.
			ObjectInputStream ois = new ObjectInputStream(server.accept().getInputStream());
			Persona p = null;//Igualamos el objeto a nulo.
			//Entraremos en un bucle infinito de lectura de objetos que van al servidor.
			while(true) {
				/*
				 * El objeto será nulo la primera vez que entre en el bucle y cada vez que intente leer un mensaje y no haya, 
				 * entonces leerá continuamente lo que se esté mandando al servidor.
				 */
				if(p==null) {
	        		p = (Persona) ois.readObject();
	        	}else {
	        		// Si el objeto no es nulo, mostrará sus datos por pantalla.
		        	System.out.println("Persona recibida.");
		        	System.out.println("Datos:");
		        	System.out.println("Nombre:"+p.getNombre());
		        	System.out.println("Apellidos:"+p.getApellidos());
		        	System.out.println("DNI:"+p.getDni());
		        	System.out.println("Telefono:"+p.getTelefono());
		        	System.out.println("Dirección:"+p.getDireccion());
		        	break;
		        	}
	        }
			//Creamos escritor de objetos para enviar la Persona al Cliente.
			ObjectOutputStream oos = new ObjectOutputStream(server.accept().getOutputStream());
			oos.writeObject(p);
			oos.close();
			//Cerramos la conexión con el servidor.
			server.close();
			System.out.println("Conexión con servidor cerrada.");
		}catch (Exception e) {//Si ocurre algún error se muestra un mensaje informativo por pantalla.
			System.out.println("Error: "+e.getMessage());
		}
	}
}
