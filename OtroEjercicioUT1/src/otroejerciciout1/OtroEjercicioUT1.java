/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otroejerciciout1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author alumno
 */
public class OtroEjercicioUT1 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		File f = new File("../EjercicioUT1/dist/EjercicioUT1.jar");
		System.out.println(f.exists());
		System.out.println(f.isFile());
		System.out.println(f.getCanonicalPath());
		String[] argumentos = "java -jar ../EjercicioUT1/dist/EjercicioUT1.jar 1 4".split(" ");
		ProcessBuilder pb = new ProcessBuilder(argumentos);

		Process process = pb.start();
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		System.out.println(br.readLine());

	}

}
