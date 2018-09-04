package day0509;

import java.util.*;
public class HashMapExample {

	public static void main(String[] args) {

		Map <Long, String> map = new HashMap<>();
		
		for (int i=0; i<10; i++) {
			map.put(System.nanoTime(),"김수정"+i);
		}
		
		int size = map.size();
		System.out.println("총 객체수: "+size);
		System.out.println("김수정3 : "+ map.get("김수정3"));
		Set<Long> keySet = map.keySet();
		
		Iterator<Long> iterator = keySet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}

}
