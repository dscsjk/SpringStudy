package day0418;

public class TestSingleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if (obj1==obj2)
			System.out.println("같다");
		else 
			System.out.println("다르다");
	}

}
