/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2ej1;

/**
 *
 * @author Alumno
 */
public class UT2Ej1 {

	public static void main(String[] args) {
		ForRun hilo = () -> {
			for(int i = 0; i < 15; i++){
				System.out.println("Dentro del hilo");
		}};
		
		hilo.start();
		for(int i = 0; i < 15; i++)
			System.out.println("Fuera del hilo");
	}
	
}

@FunctionalInterface
interface ForRun {
	public void start();
}








