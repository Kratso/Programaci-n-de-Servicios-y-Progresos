/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

import org.apache.commons.net.ftp.*;

/**
 *
 * @author Alumno
 */
public class SubirFichero {

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

		JFileChooser jfc = new JFileChooser("/");

		while (jfc.showDialog(null, "Elegir fichero") != JFileChooser.APPROVE_OPTION) {
		}

		File f = jfc.getSelectedFile();
		InputStream is = new FileInputStream(f);

		cliente.storeFile(f.getName(), is);

		is.close();

		verFicheros(cliente);

		cliente.disconnect();
		System.out.println("Conexi�n FINALIZADA");
	}

	private static void verFicheros(FTPClient cliente) {
		try {
			FTPFile[] files = cliente.listFiles();
			List<FTPFile> l = new ArrayList(Arrays.asList(files));
			List<String[]> l2 = new ArrayList<>();
			l.stream().forEach((ftpf) -> {
				try {
					l2.add(new String[]{ftpf.getName(), cliente.printWorkingDirectory()});
				} catch (IOException ex) {
					Logger.getLogger(SubirFichero.class.getName()).log(Level.SEVERE, null, ex);
				}
			});
			l2.stream().forEach((sa)->{System.out.println(sa[0] + " - " + sa[1]);});
		} catch (IOException ex) {
			Logger.getLogger(SubirFichero.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
