/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testplanificacionhilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class TestPlanificacionHilos {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws InterruptedException {
		Runnable r = () -> {try {
			Thread.sleep(2000L);
			System.out.println("Hola");
			Thread.sleep(2000L);
			System.out.println("Hola2");
			} catch (InterruptedException ex) {
				Logger.getLogger(TestPlanificacionHilos.class.getName()).log(Level.SEVERE, null, ex);
			}
							};
		var h1 = new Thread(r);
		var h2 = new Thread(r);
		var h3 = new Thread(r);
		
		h1.start();
		h1.join();
		h2.start();
		h2.join();
		h3.start();
		h3.join();
		
	}
	
}
