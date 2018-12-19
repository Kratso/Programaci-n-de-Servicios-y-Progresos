/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Alumno
 */
public class MainSaludo {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(0);
		Saludo t1 = new Saludo(1, semaphore);
		Saludo t2 = new Saludo(2, semaphore);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			System.out.println("Hilo principal del proceso interrumpido.");
		}
		System.out.println("Proceso acabando.");
	}

}
