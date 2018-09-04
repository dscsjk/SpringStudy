package day0509;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashtableExample {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		for (int i=0; i<10; i++) {
			map.put("김수정"+i, Integer.toString(i));
		}
		
		Scanner scanner= new Scanner(System.in);
		
		while(true) {
			System.out.println("아이디와 비밀번호를 입력하세요");
			System.out.println("아이디: ");
			String id = scanner.nextLine();
			
			System.out.println("비밀번호: ");
			String password = scanner.nextLine();
			System.out.println("");
			
			if(map.containsKey(id)) {
				if(map.get(id).equals(password)) {
					System.out.println("로그인 되었습니다.");
					break;
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
					
				}
			} else {
				System.out.println("입력하신 아이디가 존재하지 않습니다.");
			}
		}
	}
}
