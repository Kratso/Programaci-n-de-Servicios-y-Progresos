/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2ej6;

/**
 *
 * @author Alumno
 */
public class UT2Ej6 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		ImprimirNumeros impares = () -> {
			for (int i = 1; i <= 10; i++) {
				if (i % 2 + 1 == 2) {
					System.out.println(i);
				}
			}
		};
		ImprimirNumeros pares = () -> {
			for (int i = 1; i <= 10; i++) {
				if (i % 2 + 1 == 1) {
					System.out.println(i);
				}
			}
		};
		new Thread(impares).start();
		new Thread(pares).start();
	}

}

@FunctionalInterface
interface ImprimirNumeros extends Runnable {

	@Override
	public void run();
}
