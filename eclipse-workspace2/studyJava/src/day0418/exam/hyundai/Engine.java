package day0418.exam.hyundai;

public class Engine {

	private String engineName;
	//모두다
	public Engine() {
		engineName="현대4기통엔진";
		System.out.println("현대 엔진이 생성되었습니다.");
	}

	public void setEngin() {
		System.out.println("현대엔진 "+engineName+"이 장착되었습니다.");
	}

	public String getEngineName() {
		return engineName;
	}

	public void setEngineName(String engineName) {
		this.engineName = engineName;

	}

}
