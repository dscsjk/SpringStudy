package day0411;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		while(true) {
			int num = (int)(Math.random()*6) + 1;
			System.out.println(num);
			if (num ==6)
				break;
		}
		System.out.println("end");
		*/
		
		for ( ; ; ) {
			int num = (int)(Math.random()*6) + 1;
			System.out.println(num);
			if (num==6)
				break;
		}
		System.out.println("end");
	}

}
