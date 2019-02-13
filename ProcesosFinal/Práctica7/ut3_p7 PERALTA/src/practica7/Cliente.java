package practica7;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente{

	public static void main(String[] args) {
		//Definimos un objeto Scanner para poder leer lo que se pasa por consola.
		Scanner sc = new Scanner(System.in);
		try {
			//Creamos el cliente.
			Socket cliente = new Socket("localhost",5000);
			System.out.println("Cliente operativo");
			/*
			 * Manda persona.
			 */
			//Creamos escritor de objetos.
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			//Se escriben mensajes que se mandan al servidor.
			System.out.println("Introduce los datos de la persona para enviarlos al servidor.");
			System.out.print("Nombre:");
			String nombre = sc.nextLine();
			System.out.print("Apellidos:");
			String apellidos = sc.nextLine();
			System.out.print("DNI:");
			String dni = sc.nextLine();
			System.out.print("Telefono:");
			String telefono = sc.nextLine();
			System.out.print("Dirección:");
			String direccion = sc.nextLine();
			Persona p = new Persona(nombre, apellidos, dni, telefono, direccion);
			// Manda el objeto al servidor.
			oos.writeObject(p);
			//Cerramos el escritor de mensajes.
			oos.close();
			/*
			 * Recibe persona.
			 */
			//Volvemos a instanciar el objeto cliente.
			cliente = new Socket("localhost",5000);
			//Creamos escritor de objetos.
			System.out.println("\nRecibiendo datos desde Servidor.");
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			p=(Persona) ois.readObject();
        	System.out.println("Datos:");
        	System.out.println("Nombre:"+p.getNombre());
        	System.out.println("Apellidos:"+p.getApellidos());
        	System.out.println("DNI:"+p.getDni());
        	System.out.println("Telefono:"+p.getTelefono());
        	System.out.println("Dirección:"+p.getDireccion());
			ois.close();
		}catch (Exception e) {//Si ocurre algún error se muestra un mensaje informativo por pantalla.
			System.out.println("Error: "+e.getMessage());
		}
	}

}
