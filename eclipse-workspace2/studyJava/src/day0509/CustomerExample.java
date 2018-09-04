package day0509;

import java.text.SimpleDateFormat;
import java.util.*;

public class CustomerExample {

	public static void main(String[] args) {
		//ArrayList
		List<Customer> customer1 = new ArrayList<>();
		System.out.println(new Date());
		for (int i=0; i<10; i++) {
//			customer1.add(new Customer("김수정"+i, i, "안양"+i+"동", "010-123-123"+i, 20+i));
			customer1.add(new Customer("김수정"+i, i, "안양"+i+"동", "010-123-123"+i, 20+i, new Date()));
		}
		
		for (Customer customer2: customer1) {
			System.out.println(customer2);
		}
/*		
		//Vector
		List<Customer> customer3 = new Vector<>();
		for (int i=0; i<10; i++) {
			customer3.add(new Customer("홍길동"+i, i, "성남"+i+"동", "010-321-321"+i, 30+i));
		}
		customer3.remove(2);
		customer3.remove(7);
		
		for (Customer customer4: customer3) {
			System.out.println(customer4);
		}
		
		//Linked List - ArrayList보다 빠르다
		long startTime, endTime;
		List<Customer> list1 = new ArrayList<>();
		
		startTime = System.nanoTime();
		for (int i=0; i<10000; i++) {
			list1.add(0,new Customer("이효리"+i, i, "제주"+i+"동", "011-123-123"+i, 10+i));
		}
		if (list1.contains(list1.get(9999)))
			System.out.println(list1.get(9999));
		endTime = System.nanoTime();
		System.out.println("ArrayList 걸린시간: "+(endTime-startTime)+" ns");

		List<Customer> list2 = new LinkedList<>();
		startTime = System.nanoTime();
		for (int i=0; i<10000; i++) {
			list2.add(0,new Customer("이기동"+i, i, "강원"+i+"동", "010-123-987"+i, 10+i));
		}
		
		Customer customer5 = list2.get(9999);
		if (list2.contains(customer5))
			System.out.println(customer5);
		endTime = System.nanoTime();
		System.out.println("LinkedList 걸린시간: "+(endTime-startTime)+" ns");

		SimpleDate sdate = 
		String str = String.format("%d %d %d", now.YEAR, now.MONTH+1, now.DAY_OF_MONTH);
		System.out.println(str);
*/
	}
}
