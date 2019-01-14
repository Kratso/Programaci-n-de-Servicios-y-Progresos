package ej5;

public class Buscador extends Thread {

	Tabla t;
	String nombre;
	int inicio;

	public Buscador(String nombre, int inicio, Tabla t) {
		this.nombre = nombre;
		this.inicio = inicio;
		this.t = t;
	}

	 public void run() {
		for (int k = inicio; k < t.tabla.length; k++) {
			synchronized (t) { // AQUÍ CONTROLARÉ QUE NADIE MÁS ACCEDA PARA EVITAR ERRORES
				if (!t.encontrado) {
					if (t.tabla[k] == 1) {
						t.encontrado = true;
						t.ganador = this.nombre;
						System.out.println("Hilo " + this.nombre
								+ " ha encontrado el 1 en la posición " + k);
					}
				} else {
					break;
				}
			}
		}
	}
}