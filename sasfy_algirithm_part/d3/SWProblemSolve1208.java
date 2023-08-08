package sasfy_algirithm_part.d3;

import java.util.Scanner;

public class SWProblemSolve1208 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int test = 1 ; test <= 10 ; test++) {
			int dump = sc.nextInt();
			int[] arr = new int[100];
			for(int i = 0 ; i < 100 ; i++) {
				arr[i] = sc.nextInt();
			}
			
			
			for(int dumpCnt = 0 ; dumpCnt < dump ; dumpCnt++) {
				int max = arr[0];
				int maxIdx = 0;
				int min = arr[0];
				int minIdx = 0;
				for(int i = 0 ; i < 100 ; i++) {
					if(max < arr[i]) {
						max = arr[i];
						maxIdx = i;
					}
					if(min > arr[i]) {
						min = arr[i];
						minIdx = i;
					}
				}
				arr[maxIdx]--;
				arr[minIdx]++;
			}

			int max = arr[0];
			int min = arr[0];
			for(int i = 0 ; i < 100 ; i++) {
				max = Math.max(max, arr[i]);
				min = Math.min(min, arr[i]);
			}
			
			sb.append("#").append(test).append(" ").append(max - min).append("\n");
		}
		System.out.println(sb.toString());
	}
}
