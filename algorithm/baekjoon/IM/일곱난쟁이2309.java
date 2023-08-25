package Algorithm.algorithm.baekjoon.IM;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이2309 {
	static int[] arr = new int[9];
	static int[] result = new int[7];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ; i < 9 ; i++) {
			arr[i] = sc.nextInt();
		}
		
		boolean[] chk = new boolean[9];
		
		combination(0, chk, 0);
		for(int temp : result) {
			System.out.println(temp);
		}
		
	}
	
	private static int[] combination(int start, boolean[] chk, int count) {
		if(count == 2) {
			int sum = 0;
			int index = 0;
			for(int i = 0 ; i < 9 ; i++) {
				if(!chk[i]) {
					result[index] = arr[i];
					sum += result[index];
					index++;
				}
			}
			if(sum != 100) {
				return null;
			}else {
				Arrays.sort(result);
				return result;
			}
		}
		for(int i = start ; i < 9 ; i++) {
			if(!chk[i]) {
				chk[i] = true;
				int[] temp = combination(start + 1, chk, count + 1);
				if(temp != null) {
					return temp;
				}
				chk[i] = false;
			}
		}
		return null;
	}
}
