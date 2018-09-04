package day0424test;

public class K3 implements I{
	String name;
	public K3(String name){
		this.name = name;
	}
	@Override
	public void play() {
		System.out.println( this.name+"K3의 놀이");
		
	}

}
