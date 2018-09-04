package day0424test;

public class A {

	I inf;
	
	A(I inf) {
		this.inf = inf;
	}
/*
	A(I i2, I i3) {
		this.i2 = i2;
		this.i3 = i3;
	}
*/	
	public void play() {
		this.inf.play();
	}
	public void playAnyone(I inf) {
		inf.play();
	}
	
}
