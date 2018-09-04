package day0413;

public class StudentExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1= new Student();
		System.out.println(s1);
		
		s1.setName();
		System.out.println(s1.getName());
		
		s1.setStudentNumber(456);
		System.out.println(s1.getStudentNumber());

		s1.setStudentNumber(456,2);
		System.out.println(s1.getStudentNumber());
		
		Student s2= new Student("김수정",789);
		System.out.println(s2.getName());
		System.out.println(s2.getStudentNumber());
		
		
	}

}
