/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author krats
 */
public class HelloWorld {

	public static void main() {
		Observable<String> myStrings
				= Observable.just("Alpha", "Beta", "Gamma", "Delta",
						"Epsilon");
		myStrings.subscribe((s) -> {
			System.out.println(s);
		});
		Observable<Long> secondIntervals
				= Observable.interval(1, TimeUnit.SECONDS);
		secondIntervals.subscribe(s -> System.out.println(s));
		sleep(5000);

	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException ie) {

		}
	}
}
