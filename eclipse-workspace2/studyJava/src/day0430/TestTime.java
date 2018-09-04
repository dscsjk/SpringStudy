package day0430;

public class TestTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long time1 = System.currentTimeMillis();
		long time2 = System.nanoTime();
		
		System.out.println(time1);
		System.out.println(time2);
	
		String javahome = System.getenv("JAVA_HOME");
		System.out.println(javahome);
		
		String stest = "123456-7890123";
		
		String fstr = stest.substring(2,3);
		
		System.out.println(fstr);
		
		byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
		
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2  = new String(bytes,6,4);
		System.out.println(str2);
		
		//Exception
		
	}

}
