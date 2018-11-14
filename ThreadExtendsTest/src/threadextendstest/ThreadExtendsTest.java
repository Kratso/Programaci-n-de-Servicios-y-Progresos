/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadextendstest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author krats
 */
public class ThreadExtendsTest {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		Test t1 = new Test(((i) -> {
			for (int j = 1; j <= 100; j++) {
				if (j % 2 + i == 2) {
					System.out.println(j);
					try {
						Thread.sleep(500L);
					} catch (InterruptedException ex) {
						Logger.getLogger(ThreadExtendsTest.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		}));
		
		Test t2 = new Test(((i) -> {
			for (int j = 1; j <= 100; j++) {
				if (j % 2 + i == 2) {
					System.out.println(j);
					try {
						Thread.sleep(500L);
					} catch (InterruptedException ex) {
						Logger.getLogger(ThreadExtendsTest.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		}));
		
		t1.start(1);
		t2.start(2);
	}
}

class Test extends Thread {

	LeNumer a;

	public Test(LeNumer a) {
		super();
		this.a = a;
	}

	public Test(Runnable r) {
		super(r);
	}

	public Test(Runnable r, LeNumer a) {
		super(r);
		this.a = a;
	}

	@Override
	public void start() {
		super.start();
	}

	public void start(int n) {
		super.start();
		a.run(n);
	}
}

@FunctionalInterface
interface LeNumer {

	public void run(int n);
}
