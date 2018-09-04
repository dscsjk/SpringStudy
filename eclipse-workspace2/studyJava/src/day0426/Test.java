package day0426;

public class Test {
	
	public static void main(String[] args) {
	
		NullTestClass nullTest = new NullTestClass();
		
		
		try {
			nullTest.getName(null);
		
		} catch (NullPointerException e) {
			
		} catch (ClassCastException e) {
		} finally {
		}
	}
}

class NullTestClass {

	public String getName(String name) throws NullPointerException
	                                         ,ClassCastException {
		// NullPointerException 발생가능
		String newName = name.toString();
		System.out.println(newName);
		return newName;
	}
}
