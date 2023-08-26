package Algorithm.algorithm.baekjoon.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치켜고끄기1244 {
	static boolean[] arr ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		arr = new boolean[len+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i < len + 1; i++) {
			if(st.nextToken().equals("1")) {
				arr[i] = true;
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(gender == 1) {
				man(num);
			}else {
				woman(num);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i < arr.length ; i++) {
			if(arr[i]) {
				sb.append(1);
			}else {
				sb.append(0);
			}
			if(i % 20 == 0) {
				sb.append("\n");
			}else {
				sb.append(" ");
			}
		}
		System.out.println(sb.toString());
	}
	
	private static void man(int num) {
		for(int i = 1 ; i < arr.length ; i++) {
			if(num * i < arr.length) {
				arr[num * i] = !arr[num * i];
			}else {
				return ;
			}
		}
	}

	private static void woman(int num) {
		arr[num] = !arr[num];
		for(int i = 1 ; i < arr.length ; i++) {
			if(num - i > 0 && num + i < arr.length && arr[num - i] == arr[num + i]) {
				arr[num - i] = !arr[num - i];
				arr[num + i] = !arr[num + i];
			}else {
				return ;
			}
		}
	}
}
