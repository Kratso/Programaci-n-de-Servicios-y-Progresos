/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut1ej4padre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class UT1Ej4Padre {

	public static void main(String[] args) throws InterruptedException, IOException {
		Scanner sc = new Scanner(System.in);
		
		String[] argumentos = "java -jar ../EjercicioUT1Ej4/dist/EjercicioUT1Ej4.jar".split(" ");
		ProcessBuilder pb = new ProcessBuilder(argumentos);
		Process process = pb.start();
		
		BufferedReader brp = new BufferedReader(new InputStreamReader(process.getInputStream()));
		PrintWriter pwp = new PrintWriter(process.getOutputStream());
		String linea;
		while ((linea = sc.nextLine()) != null) {
			pwp.print(linea);
			System.out.println(brp.readLine());
		}
	}
}
