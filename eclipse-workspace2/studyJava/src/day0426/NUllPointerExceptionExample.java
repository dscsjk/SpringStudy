package day0426;

public class NUllPointerExceptionExample {

	public static void main(String[] args) {
		String data = null;
		
		excptMethod(data);
	}
	
	public static void excptMethod( String data ) {
		try {
			System.out.println(data.toString());
		} catch (NullPointerException ne) {
			System.out.println("널값입니다.");
			ne.printStackTrace();
			data ="";
		} finally {
			System.out.println("다시 입력하세요");
		}
	}

}
