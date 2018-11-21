/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chouut1ej1;

/**
 *
 * @author Alumno
 */
public class ChouUT1Ej1 {

	public static void main(String[] args) {
		Caja caja1 = new Caja(1);
		Caja caja2 = new Caja(2);
		Caja caja3 = new Caja(3);
		Caja caja4 = new Caja(4);

		Cliente cliente1 = new Cliente(2, 2, 1, 2),
				cliente2 = new Cliente(1, 3, 1, 1, 1, 1),
				cliente3 = new Cliente(1, 1, 1),
				cliente4 = new Cliente(2, 5);
		
		caja1.cogerCliente(cliente1);
		caja2.cogerCliente(cliente2);
		caja3.cogerCliente(cliente3);
		caja4.cogerCliente(cliente4);
		
		new Thread(caja1).start();
		new Thread(caja2).start();
		new Thread(caja3).start();
		new Thread(caja4).start();
	}

}
