/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2ej4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class UT2Ej4 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws InterruptedException {
		TicTac tic = () -> {
			for (;;) {
				System.out.println("TIC");
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException ex) {
					Logger.getLogger(UT2Ej4.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		};
		
		TicTac tac = () -> {
			for (;;) {
				System.out.println("TAC");
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException ex) {
					Logger.getLogger(UT2Ej4.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		};
		
		new Thread(tic).start();
		Thread.sleep(1000L);
		new Thread(tac).start();
		
	}

}

@FunctionalInterface
interface TicTac extends Runnable{
	@Override
	public void run();
}

