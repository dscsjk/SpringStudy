package day0426;

public class CatchByExceptionKindExample {

	public static void main(String[] args) {

		String data1 = "9898";
		String data2 = "3455";
		try {
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1+value2;
			System.out.println(data1+"+"+data2+"="+result);

			int[] i = {1,2,3,4,5};
			
			for(int j=0;j<6;j++) {
				System.out.println("배열["+j+"]->"+i[j]);
			}
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException......... ");
			
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException......... ");
			
		} finally {
			System.out.println("Retry......... ");
		}
	}

}
