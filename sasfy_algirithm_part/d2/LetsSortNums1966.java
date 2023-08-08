package sasfy_algirithm_part.d2;

import java.util.Scanner;

public class LetsSortNums1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= test ; testCase++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0 ; i < n ; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n - i - 1; j++) {
					if(arr[j] > arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}

			sb.append("#").append(testCase).append(" ");
			for(int i = 0 ; i < n ; i++) {
				sb.append(arr[i]).append(" ");
			}
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
