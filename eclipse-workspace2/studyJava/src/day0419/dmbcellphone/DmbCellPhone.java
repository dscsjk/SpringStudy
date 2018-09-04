package day0419.dmbcellphone;

import day0419.cellphone.CellPhone;

public class DmbCellPhone extends CellPhone{
	public int channel;
	
	public DmbCellPhone(String model, String color, int channel){
		this.model = model;
		this.color = color;
		this.channel = channel;
	}
	
	public void turnOnDmb() { System.out.println("채널 " + channel + "번 DMB방송을 수신합니다.");}
	public void changeChannelDmb(int channel) { 
		this.channel = channel;
		System.out.println("채널 " + channel + "번 DMB방송을 수신합니다.");}
	
	public void turnOffDmb() { System.out.println("DMB 방송수신을 멈춥니다.");}
	
	@Override
	public void bell() {
		super.bell();
		System.out.println("아름다운 벨이 울립니다.");
	}
	
}
