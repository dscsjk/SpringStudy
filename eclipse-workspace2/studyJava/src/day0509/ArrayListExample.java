package day0509;

import java.util.*;

public class ArrayListExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("JAVA");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2,"Database");
		list.add("iBATIS");

		int size = list.size();
		System.out.println("총 객체수: "+size);
		
		String skill = list.get(2);
		System.out.println("2: "+skill);

		for(String str : list) {
			System.out.println(str);
		}

		list.remove(3);
		
		for(int i=0 ; i < list.size();i++) {
			String str= list.get(i);
			System.out.println(str);
		}

		List<String> list1 = Arrays.asList("홍길동","김자바","이명신","김을동","신동식");
		List<Integer> list2 = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
		
	}

}
