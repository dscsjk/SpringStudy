package day0509.homework;

import java.util.*;

public class HashSetExample {

	public static void main(String[] args) {

		Set<Student> set = new HashSet<>();
		
		set.add(new Student(1,"홍길동"));
		set.add(new Student(2,"신용권"));
		set.add(new Student(1,"장길산"));

		Iterator<Student> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student.sno+":"+student.name);
		}
	}
}
