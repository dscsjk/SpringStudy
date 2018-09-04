package day0424test;

public class K2 implements I {
	String name;
	public K2(String name){
		this.name = name;
	}
	
	@Override
	public void play() {
		System.out.println( this.name+"K2의 놀이");
		// TODO Auto-generated method stub
		
	}

}
