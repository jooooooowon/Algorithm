package Algorithm.algorithm.baekjoon.IM;

import java.util.Scanner;

public class 배수스위치12927 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		boolean[] arr = new boolean[str.length()+1];
		for(int i = 0 ; i < str.length(); i++) {
			if(str.charAt(i) == 'Y') {
				arr[i+1] = true;
			}
		}
		int count = 0;
		for(int i = 1 ; i < arr.length; i++) {
			if(arr[i]) {
				count++;
				for(int j = i ; j < arr.length ; j += i) {
					arr[j] = !arr[j];
				}
			}
		}
		for(int i = 1 ; i < arr.length ; i++) {
			if(arr[i]) {
				count = -1;
				break;
			}
		}
		System.out.println(count);
	}
}
