package practica3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
			cliente.makeDirectory("SAMUEL_PERALTAALBA2");
			System.out.print("Operación exitosa.\n");
			System.out.print("Cambiando de directorio de trabajo al nuevo directorio...");
			cliente.changeWorkingDirectory("/SAMUEL_PERALTAALBA2");
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
						//Mostramos los archivos en el directorio.
						System.out.println("Archivos en directorio "+ cliente.printWorkingDirectory()+":");
						FTPFile[] archivos = cliente.listFiles();
						for(int i=0; i<archivos.length;i++){
							System.out.println("-"+archivos[i].getName());
						}
					}catch (Exception e) {//Si ocurre algún error, se mostrará.
						System.out.println("No se han podido mostrar los archivos en el fichero.\n"+e.getMessage());
					}
					break;
				case "2":
					try {
						//Definimos el tipo de archivo que vamos a subir a la carpeta.
						cliente.setFileType(FTP.BINARY_FILE_TYPE);
						//Creamos un archivo al que hacer referencia con el InputStream.
						File f = new File("C:/Users/Samuel/Desktop/FTP_Pruebas/SAMUEL_PERALTAALBA2/referencia");
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
					}catch (Exception e) {//Si ocurre algún error lo mostramos por pantalla.
						System.out.println("No se ha podido subir el archivo.\n"+e.getMessage());
					}
					break;
				case "3":
					try {
						//Definimos el tipo de archivo que vamos a subir a la carpeta.
						cliente.enterLocalPassiveMode();
						cliente.setFileType(FTP.BINARY_FILE_TYPE);
						//Pedimos el nombre del archivo.
						System.out.print("Introduce el nombre del archivo que quieres descargar: ");
						String nombre = sc.nextLine();
						//Descargamos el archivo donde se supone que tenemos que descargarlo.
						File f = new File("C:/Users/Samuel/Downloads/"+nombre);
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
						if(cliente.retrieveFile(nombre, bos)) {
							System.out.println("Operación exitosa.");
						}else {
							System.out.println("No se ha podido descargar.");
						}
						bos.close();
					}catch (Exception e) {//Si ocurre algún error lo mostramos por pantalla.
						System.out.println("No se ha podido descargar el archivo.\n"+e.getMessage());
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
		System.out.println("1-Mostrar archivos.");
		System.out.println("2-Subir archivo.");
		System.out.println("3-Descargar archivo.");
		System.out.println("0-SALIR.");
	}
}
