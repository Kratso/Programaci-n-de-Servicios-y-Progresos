package practica2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.PrivilegedAction;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Conectar {

	public static void main(String[] args) {
		//Creamos el cliente.
		FTPClient cliente = new FTPClient();
		//Conecta al servidor FTP.
		try {
			System.out.print("Conectando a servidor...");
			cliente.connect("localhost",21);
			cliente.login("anonymous","");
			System.out.print("Conectado\n");
		} catch (IOException e) {
			System.out.println("No ha sido posible conectar. Saliendo...");
			System.exit(0);
		}
		//Creo un directorio para hacer pruebas con archivos.
		try {
			System.out.print("Creando nuevo directorio...");
			cliente.makeDirectory("SAMUEL_PERALTAALBA");
			System.out.print("Operación exitosa.\n");
			System.out.print("Cambiando de directorio de trabajo al nuevo directorio...");
			cliente.changeWorkingDirectory("/SAMUEL_PERALTAALBA");
			System.out.print("Operación exitosa.\n\n");
		} catch (IOException e) {
			System.out.println("No ha sido posible realizar la operación. Saliendo...");
			System.exit(0);
		}
		Scanner sc = new Scanner(System.in);
		while(true) {
			menu();
			String resp=sc.nextLine();
			boolean salir = false;
			switch(resp) {
				case "1":
					try {
						//Definimos el tipo de archivo que vamos a subir a la carpeta.
						cliente.setFileType(FTP.BINARY_FILE_TYPE);
						//Creamos un archivo al que hacer referencia con el InputStream.
						File f = new File("C:/Users/Samuel/Desktop/FTP_Pruebas/SAMUEL_PERALTAALBA/referencia");
						f.createNewFile();
						//Pedimos un nombre para el archivo.
						System.out.print("Introduce el nombre del archivo: ");
						String nombre = sc.nextLine();
						//Enviamos el archivo a la carpeta.
			            BufferedInputStream ois = new BufferedInputStream(new FileInputStream(f));
			            cliente.storeFile(nombre+".bin",ois);
			            System.out.println("Archivo creado de forma satisfactoria.");
			            //Cierra el envío de arcivos al FTP.
			            ois.close(); 
					}catch (Exception e) {//Si ocurre algún error, se mostrará.
						System.out.println("No se ha podido crear el fichero.\n"+e.getMessage());
					}
					break;
				case "2":
					try {
						//Mostramos los archivos en el directorio.
						System.out.println("Archivos en directorio "+ cliente.printWorkingDirectory()+":");
						FTPFile[] archivos = cliente.listFiles();
						for(int i=0; i<archivos.length;i++){
							System.out.println("-"+archivos[i].getName());
						}
						System.out.print("\n");
						//Pedimos el nombre del fichero que queremos renombrar y su nuevo nombre.
						System.out.println("¿Cómo se llama el fichero que quieres cambiar de nombre?");
						String nombre = sc.nextLine();
						System.out.println("¿Cómo quieres llamarlo ahora?");
						String nombre2 = sc.nextLine();
						//Lo intentamos renombrar.
						if(cliente.rename(nombre,nombre2)) {
							System.out.println("Operación satisfactoria.");
						}else {
							System.out.println("El archivo no existe.");//Si no se ha podido renombrar lo indicamos por pantalla.
						}
					}catch (Exception e) {//Si ocurre algún error lo mostramos por pantalla.
						System.out.println("No se ha podido renombrar el fichero.\n"+e.getMessage());
					}
					break;
				case "3":
					try {
						//Mostramos los archivos en el directorio.
						System.out.println("Archivos en directorio "+ cliente.printWorkingDirectory()+":");
						FTPFile[] archivos = cliente.listFiles();
						for(int i=0; i<archivos.length;i++){
							System.out.println("-"+archivos[i].getName());
						}
						System.out.print("\n");
						//Pedimos el nombre del archivo que borrar.
						System.out.println("¿Cómo se llama el fichero que quieres borrar?");
						String nombre = sc.nextLine();
						if(cliente.deleteFile(nombre)) {
							System.out.println("Operación satisfactoria.");
						}else {
							System.out.println("El archivo no existe.");//Si no se ha podido borrar lo indicamos por pantalla.
						}
					}catch (Exception e) {//Si ocurre algún error lo mostramos por pantalla.
						System.out.println("No se ha podido eliminar el fichero.\n"+e.getMessage());
					}
					break;
				case "0":
					System.out.println("Saliendo...");
					salir=true;
					break;
				default:
					System.out.println("Opción inválida.");
					break;
			}
			if(salir) {
				break;
			}else {
				System.out.println("\n\n");
			}
		}
	}
	
	public static void menu() {
		System.out.println("1-Crear archivo.");
		System.out.println("2-Renombrar archivo.");
		System.out.println("3-Borrar archivo.");
		System.out.println("0-SALIR.");
	}
}
