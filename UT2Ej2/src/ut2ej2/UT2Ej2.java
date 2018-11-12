/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2ej2;

/**
 *
 * @author Alumno
 */
public class UT2Ej2 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		HiloC[] hilos = new HiloC[5];
		for (int i = 0; i < 5; i++) {
			hilos[i] = new HiloC(i + 1);
			hilos[i].start();
		}
		System.out.println("Todos los hilos iniciados");

	}

	private static class HiloC implements IntC {

		int a;

		public HiloC(int a) {
			this.a = a;
			System.out.println("Creando el hilo " + a);
		}

		public void start() {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hilo " + a + " linea: " + (i + 1));
			}
		}
	}

}

@FunctionalInterface
interface IntC {

	public void start();
}
