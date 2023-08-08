package sasfy_algirithm_part.d1;

import java.util.Scanner;

public class FindAvgNum2071 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		for(int testCase = 1 ; testCase <= test; testCase++) {
			double sum = 0.0;
			for(int i = 0 ; i < 10 ; i++) {
				sum += sc.nextInt();
			}
			
			double avg = Math.round(sum/10);
			sb.append("#").append(testCase).append(" ").append((int)avg).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
