package day0509;

import java.text.*;
import java.util.*;

public class Customer {
	String name, address, phone;
	int id, age;
	Date now;
	
	Customer(String n, int i, String a, String p, int age, Date nd){
//	Customer(String n, int i, String a, String p, int age){
		name = n;
		id = i;
		address = a;
		phone = p;
		this.age = age;
		now = nd;
	}
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:dd");
		String str = String.format("%s  %d  %s  %s  %d  %s"
				, name, id, address,phone, age, dateFormat.format(now));
		return str;
	}

}
