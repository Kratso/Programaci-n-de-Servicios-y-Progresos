package ej5;

public class Encuentra {

	public static void main(String[] args) {

		int[] tabla = new int[1000000];
		int posicion = (int) (Math.random() * 1000000);
		for (int i = 0; i < tabla.length; i++) {
			if (i == posicion) {
				tabla[i] = 1;
			} else {
				tabla[i] = 0;
			}
		}

		Tabla t = new Tabla(tabla);

		Buscador b1 = new Buscador("1", (int) (Math.random() * 1000000), t);
		Buscador b2 = new Buscador("2", (int) (Math.random() * 1000000), t);
		Buscador b3 = new Buscador("3", (int) (Math.random() * 1000000), t);
		Buscador b4 = new Buscador("4", (int) (Math.random() * 1000000), t);

		/* 
		 * //comprobación de variables
		 * 
		 * System.out.println("Posición del 1: " + posicion);
		 * System.out.println("Inicio de b1: "+b1.inicio);
		 * System.out.println("Inicio de b2: "+b2.inicio);
		 * System.out.println("Inicio de b3: "+b3.inicio);
		 * System.out.println("Inicio de b4: "+b4.inicio);
		 * 
		 * //fin de comprobación
		 */

		b1.start();
		b2.start();
		b3.start();
		b4.start();

		try {
			b1.join();
			b2.join();
			b3.join();
			b4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (!t.encontrado) {
			System.out.println("Ningún hilo ha encontrado el 1.");
		} else {
			System.out.println("El hilo " + t.ganador + " ha ganado.");
		}

	}
}