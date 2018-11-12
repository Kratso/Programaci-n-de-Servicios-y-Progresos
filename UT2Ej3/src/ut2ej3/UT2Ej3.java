/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2ej3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class UT2Ej3 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws InterruptedException {
		Tic tic = new Tic();
		Tac tac = new Tac();
		tic.start();
		Thread.sleep(1000L);
		tac.start();
	}
	
	private static class Tic extends Thread {
		@Override
		public void run(){
			for(;;){
			System.out.println("TIC");
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException ex) {
					Logger.getLogger(UT2Ej3.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}
	
	private static class Tac extends Thread {
		public void run(){
			for(;;){
			System.out.println("TAC");
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException ex) {
					Logger.getLogger(UT2Ej3.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}
	
}
