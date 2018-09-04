package day0424.vehicle;

public class DriverExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver d = new Driver();
		
		Vehicle v = new Bus();
		d.drive(v);
	
		if (v instanceof Bus) {
			Bus a = (Bus)v;
			a.stop();
		}
		
		Bus b = new Bus();
		d.drive(b);
		b.stop();
		

	}

}
