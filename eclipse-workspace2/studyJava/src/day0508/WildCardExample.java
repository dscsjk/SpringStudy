package day0508;

import java.util.Arrays;

public class WildCardExample {
	public static void registerCouse( Course<?> course ) {
		System.out.println(course.getName()+" 수강생: " 
				+ Arrays.toString(course.getStudents()));
	}

	public static void registerCouseStudent( Course<? extends Student> course ) {
		System.out.println(course.getName()+" 수강생: " 
				+ Arrays.toString(course.getStudents()));
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
