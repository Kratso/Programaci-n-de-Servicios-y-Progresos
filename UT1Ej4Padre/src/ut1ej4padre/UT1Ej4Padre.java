/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut1ej4padre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class UT1Ej4Padre {

	public static void main(String[] args) throws InterruptedException, IOException {  
		//String[] argumentos = "java -jar /media/Datos/Git/Programaci-n-de-Servicios-y-Progresos/UT1Ej4/dist/UT1Ej4.jar".split(" ");
		ProcessBuilder pb = new ProcessBuilder(args);
		Process process = pb.start();

		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

		String linea;
		while (!(linea = br2.readLine()).equals("")) {
			OutputStream os = process.getOutputStream();
			InputStreamReader isr = new InputStreamReader(process.getInputStream());
			BufferedReader brp = new BufferedReader(isr);
			PrintStream ps = new PrintStream(process.getOutputStream());
			PrintWriter pw = new PrintWriter(os);
			ps.println("");
			pw.println(linea);
			pw.close();
			System.out.println("Salida: " + brp.readLine());
		}
		System.out.println("fin");
	}
}
