package day0417;

public class Cal {
	
	static double bankRate = 0.05;
	
	static int calInput (int inmoney, int nowmoney) {
		int nowmoney1=0;
		nowmoney1=nowmoney+inmoney;
		return nowmoney1;
	}

	static int calOutput (int outmoney, int nowmoney) {
		int nowmoney1=0;
		nowmoney1=nowmoney-outmoney;
		return nowmoney1;
	}
}
