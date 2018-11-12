/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut1ej3padre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UT1Ej3Padre {

	public static void main(String[] args) throws IOException {
		Process process = new ProcessBuilder(args).start();
		System.out.println(Arrays.toString(args));
		BufferedReader brp = new BufferedReader(new InputStreamReader(process.getInputStream()));
		System.out.println(brp.readLine());
	}

}
