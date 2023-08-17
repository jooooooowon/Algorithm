package Algorithm.sasfy_algirithm_part.d4;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWProblemSolve1222 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		StringBuilder sb =new StringBuilder();
		for(int t = 0 ; t < 10 ; t++) {
			int test = sc.nextInt();
			String str = sc.next();
			st = new StringTokenizer(str, "+");
			Stack<Integer> stack = new Stack<>();
			while(st.hasMoreTokens()) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			while(stack.size() > 1) {
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.push(num1 + num2);
			}
			sb.append("#").append(t+1).append(" ").append(stack.pop()).append("\n");
		}
		System.out.println(sb.toString());
	}
}
