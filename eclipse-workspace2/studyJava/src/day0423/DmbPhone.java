package day0423;

public class DmbPhone extends Phone {

	DmbPhone(String owner){
		super(owner);
	}

	@Override
	public void call() {
		System.out.println(super.owner+"Dmb폰에서 전화를 겁니다.");
		// TODO Auto-generated method stub
		
	}

	
}
