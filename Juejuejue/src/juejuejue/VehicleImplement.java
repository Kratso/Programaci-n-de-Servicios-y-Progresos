
package juejuejue;




public class VehicleImplement {


	public static void main(String[] args) {
		

	}
	
}

@FunctionalInterface
interface Func<T1,T2,T3,R>{
	R apply(T1 t1, T2 t2, T3 t3);
}

interface Vehicle {
	void setSpeedModel(Func<Double, Integer, Integer,
			Double> speedModel);
	double getSpeedMph(double timeSec);
}