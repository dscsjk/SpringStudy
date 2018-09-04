package day0420;

public class Driver {
	Vehicle vehicle = new Vehicle();
	
	public void drive(Vehicle vehicle) {
		vehicle.run();
		this.vehicle = (Vehicle) vehicle;
		this.vehicle.run();
	}

}
