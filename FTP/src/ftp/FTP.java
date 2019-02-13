/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftp;

import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.net.ftp.*;

/**
 *
 * @author Alumno
 */
public class FTP {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws IOException, SocketException{
		FTPClient cliente = new FTPClient();
		String servidor = "localhost";
		System.out.println ("Conecto con el servidor: "+servidor);
		//conectamos cliente FTP al servidor FTP
		cliente.connect(servidor);
		//obtenemos la respuesta
		System.out.println (cliente.getReplyString());
		//c�digo de respuesta
		int respuesta = cliente.getReplyCode();
		cliente.login("anonymous", "");
		FTPFile[] files = cliente.listFiles();
		List<FTPFile> l = new ArrayList(Arrays.asList(files));
		FTPFile[] direc = cliente.listDirectories();
		List<FTPFile> l2 = new ArrayList(Arrays.asList(direc));
		System.out.println(l.isEmpty());
		l.forEach((f)->{System.out.println(f.toString());});
		l2.forEach((f)->{System.out.println(f.toString());});
		//comprobaci�n del c�digo
		if (!FTPReply.isPositiveCompletion(respuesta)) {
			System.out.println ("Conexion NO ESTABLECIDA: "+respuesta);
			cliente.disconnect();
			System.exit(0);
		}
		//aqui el resto del programa...
		cliente.disconnect();
		System.out.println ("Conexi�n FINALIZADA");
	}
	
}
