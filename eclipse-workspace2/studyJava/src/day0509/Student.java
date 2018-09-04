package day0509;

public class Student {

	public int sno;
	public String name;
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student student = (Student) obj;
//			return (sno==student.sno) && (name.equals(student.name));
			return (sno==student.sno);
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return sno+name.hashCode();
	}
}
