/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import io.reactivex.Observable;

/**
 *
 * @author krats
 */
public class ObservableTesting {

	public static void main() {
//		Observable<String> source = Observable.create(emitter -> {
//			try {
//				emitter.onNext("Alpha");
//				emitter.onNext("Beta");
//				emitter.onNext("Gamma");
//				emitter.onNext("Delta");
//				emitter.onNext("Epsilon");
//				emitter.onComplete();
//			} catch (Throwable e) {
//				emitter.onError(e);
//			}
//		});
//		source.map(String::length)
//				.filter(i -> i >= 5)
//				.subscribe(s -> System.out.println("RECEIVED: " + s));

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

	}

}
