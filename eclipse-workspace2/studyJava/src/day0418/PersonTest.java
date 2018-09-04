package day0418;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person1 = new Person("123456-78901234","김수정");
		System.out.println ("국적: "+ person1.nation);
		System.out.println ("민증: "+ person1.ssn);
		System.out.println ("이름: "+ person1.name);

//		person1.ssn= "789012-3456789";
		person1.name= "이수정";
		
		System.out.println ("국적: "+ person1.nation);
		System.out.println ("민증: "+ person1.ssn);
		System.out.println ("이름: "+ person1.name);
		
		System.out.println ("DB_NAME: "+ Person.DB_NAME);
		
		
		}

}
