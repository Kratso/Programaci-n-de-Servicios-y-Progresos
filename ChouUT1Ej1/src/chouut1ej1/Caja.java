/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chouut1ej1;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Caja implements Runnable{
	
	private Cliente cliente;
	private int numero;

	public Caja(int numero) {
		super();
		this.numero = numero;
	}

	@Override
	public void run(){
		procesarCliente();
	}
	
	public void procesarCliente() {
		long tinicial = System.currentTimeMillis();
		System.out.println("Caja numero " + numero + " comienza operación");
		int cnt = 0;
		for(int i : cliente.getCompra()){
			try {
				Thread.sleep(i * 1000);
				System.out.println("Caja " + numero + " Articulo " + ++cnt + " procesado(" + i + "s)");
			} catch (InterruptedException ex) {
				Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		long tfinal = (System.currentTimeMillis()-tinicial);
		System.out.println("Caja numero " + numero + " ha finalizado "
				+ "el procesamiento del Cliente.\n" + "Esta operación ha durado " 
				+ tfinal + " milisegundos");
		System.out.println();
	}
	
	public void cogerCliente(Cliente cliente){
		setCliente(cliente);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	}
