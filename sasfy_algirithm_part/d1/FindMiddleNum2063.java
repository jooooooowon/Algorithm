package Algorithm.sasfy_algirithm_part.d1;

import java.util.Scanner;

public class FindMiddleNum2063 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
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
		
		System.out.println(arr[n/2]);
	}
}
