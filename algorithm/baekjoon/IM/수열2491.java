package Algorithm.algorithm.baekjoon.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열2491 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for(int i = 0 ; i < n ; i++) {
			if(i + max >= n) {
				break;
			}
			max = Math.max(max, increase(i,arr));
		}
		for(int i = 0 ; i < n/2 ; i++) {
			int temp = arr[i];
			arr[i] = arr[n-1-i];
			arr[n-1-i] = temp;
		}
		for(int i = 0 ; i < n ; i++) {
			if(i + max >= n) {
				break;
			}
			max = Math.max(max, increase(i,arr));
		}
		System.out.println(max);
	}


	private static int increase(int index, int[] arr) {
		// TODO Auto-generated method stub
		int result = 1;
		for(int i = index ; i < arr.length - 1; i++) {
			if(arr[i] > arr[i+1]) {
				break;
			}
			result++;
		}
		return result;
	}
}
