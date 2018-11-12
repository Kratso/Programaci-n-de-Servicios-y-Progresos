
package juejuejue;

class VehicleImplement  implements Vehicle {
	private Func<Double, Integer, Integer, Double> speedModel;
	private int weightPounds, hoursePower;
	public VehicleImplement (int weightPounds, int hoursePower){
		this.weightPounds = weightPounds;
		this.hoursePower = hoursePower;   }
	public void setSpeedModel(Func<Double, Integer,
			Integer, Double> speedModel){
		this.speedModel = speedModel;
	}   
	public double getSpeedMph(double timeSec){
		return this.speedModel.apply(timeSec,
				weightPounds, hoursePower);
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