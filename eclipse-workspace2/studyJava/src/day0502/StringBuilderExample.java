package day0502;

public class StringBuilderExample {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Java");
		sb.append("Program Studey");
		System.out.println(sb.toString());
		
		sb.insert(4,"2");
		System.out.println(sb.toString());
		
		sb.setCharAt(4,'6');
		System.out.println(sb.toString());

		sb.replace(6,13,"Book");
		System.out.println(sb.toString());
		
		sb.delete(4,5);
		System.out.println(sb.toString());
	}

}
