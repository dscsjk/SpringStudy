package day0509;

import java.util.*;

public class HashMapexample2 {

	public static void main(String[] args) {

		Map<Student, Integer> map = new HashMap<>();
		/*
		for (int i=0; i<10; i++) {
			map.put(new Student(i,"김수정"+i), System.nanoTime());
		}
		*/
		map.put(new Student(1,"김수정"), 95);
		map.put(new Student(1,"김수정"), 95);
		
		System.out.println("개수: " + map.size());
		
	}

}
