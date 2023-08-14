package Algorithm.sasfy_algirithm_part.d2;

import java.util.Scanner;

public class SWProblemSolve1204 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1 ; testCase <= test ; testCase++) {
			sc.nextInt();
			int[] gradeArr = new int[101];
			for(int i = 0 ; i < 1000; i++) {
				int idx = sc.nextInt();
				gradeArr[idx]++;
			}
			int max = gradeArr[0];
			int maxIdx = 0;
			for(int i = 0 ; i < 101; i++) {
				if(max <= gradeArr[i]) {
					max = gradeArr[i];
					maxIdx = i;
				}
			}
			sb.append("#").append(testCase).append(" ").append(maxIdx).append("\n");
		}
		System.out.println(sb.toString());
	}
}
