package day0411;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] scores = { 83,90,87 };
		
		int[] scores;
		
		scores = new int[] { 83,90,87 };
		
		System.out.println("Scores[0] : " + scores[0]);
		System.out.println("Scores[1] : " + scores[1]);
		
		scores[1]=100;
		System.out.println("값변경Scores[1] : " + scores[1]);
		
		System.out.println("Scores[2] : " + scores[2]);
		
		int sum = 0;
		
		for (int i=0;i<scores.length; i++)
			sum += scores[i];
		
		System.out.println("합 : " + sum);
		
		double avg = (double) sum/3;
		
		System.out.println("평균 : " + avg);
		
	
		
	}

	
	
}
