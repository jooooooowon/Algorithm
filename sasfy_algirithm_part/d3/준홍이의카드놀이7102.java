package Algorithm.sasfy_algirithm_part.d3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 준홍이의카드놀이7102 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1 ; testCase <= test;  testCase++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] result = new int[n+m+1];
			Queue<Integer> queue = new LinkedList<Integer>();
			for(int i = 1 ; i <= n ; i++) {
				queue.offer(i);
			}
			int max = 0;
			while(!queue.isEmpty()) {
				int temp = queue.poll();
				for(int i = 1 ; i <= m ; i++) {
					result[temp+i]++;
					max = Math.max(max, result[temp+i]);
				}
			}
			sb.append("#").append(testCase).append(" ");
			for(int i = 0 ; i < result.length; i++) {
				if(max == result[i]) {
					sb.append(i).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
