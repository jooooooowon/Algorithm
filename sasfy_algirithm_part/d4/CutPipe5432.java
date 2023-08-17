package Algorithm.sasfy_algirithm_part.d4;

import java.util.Scanner;
import java.util.Stack;

public class CutPipe5432 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= test ; testCase++) {
			String str = sc.next();
			char[] arr = str.toCharArray();
			Stack<Character> stack = new Stack<>();
			int sum = 0;
			for(int i = 0 ; i < arr.length; i++) {
				if(arr[i] == ')') {
					if(arr[i-1] == ')') {
						sum += 1;
						stack.pop();
					}else {
						stack.pop();
						sum += stack.size();
					}
				}else {
					stack.push(arr[i]);
				}
			}
			sb.append("#").append(testCase).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
