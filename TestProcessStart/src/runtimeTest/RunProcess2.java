/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtimeTest;

import java.io.IOException;

public class RunProcess2 {

	public static void main(String[] args) throws InterruptedException {
		try {
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec("ls -l|cat > /home/alumno/asdf ");
			
			//process.destroy();
			System.out.println("Fin");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
