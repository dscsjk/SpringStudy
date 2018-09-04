package day0411;

public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strName;
		strName = new String[10];
		/*
		String[] strName = {"김수정", "이혜은","천운숙","김현정","정인진"};
		*/
		System.out.println("이름:"+strName[0]);
		System.out.println("이름:"+strName[1]);
		System.out.println("이름:"+strName[2]);
		System.out.println("이름:"+strName[3]);
		System.out.println("이름:"+strName[4]);
		
		System.out.println("====================");
		for(int i=0;i<strName.length;i++) {
			System.out.println("이름:"+strName[i]);
		}
		
	}

}
