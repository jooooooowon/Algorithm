package Algorithm.sasfy_algirithm_part.d3;

import java.util.Scanner;
import java.util.Stack;

public class Zero8931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1 ; testCase <= test; testCase++) {
			int k = sc.nextInt();
			Stack<Integer> stack = new Stack<>();
			for(int i = 0 ; i < k ; i++) {
				int num = sc.nextInt();
				if(num == 0) {
					stack.pop();
				}else {
					stack.push(num);
				}
			}
			int sum = 0;
			while(!stack.isEmpty()) {
				sum += stack.pop();
			}
			sb.append("#").append(testCase).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
