package Algorithm.sasfy_algirithm_part.d1;

import java.util.Scanner;

public class FindMaxNum2068 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		for(int testCase = 1 ; testCase <= test; testCase++) {
			int[] arr = new int[10];
			for(int i = 0 ; i < 10 ; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max = arr[0];
			for(int i = 0 ; i < 10 ; i++) {
				max = Math.max(max, arr[i]);
			}
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}
