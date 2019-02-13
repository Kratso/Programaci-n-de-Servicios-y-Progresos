/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import javax.swing.JFileChooser;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author Alumno
 */
public class DescargarFichero {
	public static void main(String[] args) throws IOException, SocketException {
		FTPClient cliente = new FTPClient();
		String servidor = "localhost";
		System.out.println("Conecto con el servidor: " + servidor);
		//conectamos cliente FTP al servidor FTP
		cliente.connect(servidor);
		//obtenemos la respuesta
		System.out.println(cliente.getReplyString());
		//c�digo de respuesta
		int respuesta = cliente.getReplyCode();
		cliente.login("mortadelo", "tia");

		cliente.setFileType(FTP.BINARY_FILE_TYPE);

		
		JFileChooser jfc = new JFileChooser("I:\\FTP\\mortadelo");

		while (jfc.showDialog(null, "Elegir fichero") != JFileChooser.APPROVE_OPTION) {
		}

		File f = jfc.getSelectedFile();
		FileOutputStream fos = new FileOutputStream(new File("I:\\download\\" + f.getName()));
		
		if(cliente.retrieveFile(f.getName(), fos))
			System.out.println("Descarga completada");
		else
			System.out.println("Descarga fallida");

		fos.close();

		cliente.disconnect();
		System.out.println("Conexi�n FINALIZADA");
	}
}
