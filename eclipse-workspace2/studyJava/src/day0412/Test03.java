package day0412;

import java.util.Arrays;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][][] sOrg = new String[2][3][5];
//		String[][][] sTrg = new String[3][1][1];
		
		String[][][] sTrg = new String[3][][];
		
		for ( int i=0; i < sOrg.length ; i++ ) { 
			for ( int j=0; j < sOrg[i].length ; j++) {
				for ( int k=0; k < sOrg[i][j].length ; k++) {
					sOrg[i][j][k]="테스트"+i+j+k;
				}
			}
		}

		System.out.println(sOrg.toString()); 
	    System.out.println(Arrays.toString(sOrg[0])); 

		System.arraycopy(sOrg, 0, sTrg, 0, sOrg.length);

		System.out.printf("sTrg.length=%d\n",sTrg.length);
		System.out.printf("sTrg.length[0]=%d\n",sTrg[0].length);
		System.out.printf("sTrg.length[0][0]=%d\n",sTrg[0][0].length);
		
		System.out.println(sTrg.toString()); 
	    System.out.println(Arrays.toString(sTrg[0])); 
		

		for ( int i=0; i < sTrg.length ; i++ ) { 
			for ( int j=0; j < sTrg[i].length ; j++) {
				for ( int k=0; k < sTrg[i][j].length ; k++) {
					System.out.println(sTrg[i][j][k]);
				}
				System.out.println();
			}
		System.out.printf("------------------------------\n");
		}
		
	}
}
