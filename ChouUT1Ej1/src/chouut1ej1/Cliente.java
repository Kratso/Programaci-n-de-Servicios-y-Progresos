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
public class Cliente {
	private int[] compra;
	
	public Cliente(int... productos){
		this.compra = productos;
	}

	public int[] getCompra() {
		return compra;
	}

	public void setCompra(int[] compra) {
		this.compra = compra;
	}
}
