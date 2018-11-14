/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author krats
 */
public class ObservableTesting {

	public static void main(String[] args) {

		Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta",
				"Epsilon");
		source.map(String::length).filter(i -> i >= 5)
				.subscribe(s -> System.out.println("RECEIVED: " + s), Throwable::printStackTrace, () -> System.out.println("Done!"));
		//first observer
		source.subscribe(s -> System.out.println(
				"Observer 1 Received:" + s));
		//second observer
		source.map(String::length).filter(i -> i >= 5)
				.subscribe(s -> System.out.println("Observer 2 Received: "
				+ s));
		
		System.out.println("Fin primera prueba");
		
		Observable<Long> seconds
				= Observable.interval(1, TimeUnit.SECONDS);
		Disposable disposable
				= seconds.subscribe(l -> System.out.println("Received: " + l));
		//sleep 5 seconds
		sleep(5000);
		disposable.dispose();
		//sleep 5 seconds to prove
		//there are no more emissions
		sleep(5000);
		
		System.out.println("Fin segunda prueba");

		Observable.interval(500, TimeUnit.MILLISECONDS)
				.take(2, TimeUnit.SECONDS)
				.subscribe(i -> System.out.println("RECEIVED: " + i));
		sleep(5000);
		
		System.out.println("Fin tercera prueba");

	}

	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
