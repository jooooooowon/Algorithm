package Algorithm.sasfy_algirithm_part.d4;

import java.util.Scanner;
import java.util.Stack;

public class SWProblemSolve1218 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= 10 ; testCase++) {
			int n = sc.nextInt();
			String str = sc.next();
			Stack<Character> stack = new Stack<>();
			for(int i = 0 ; i < n ; i++) {
				char temp = str.charAt(i);
				if(temp == '}' || temp == ']' || temp == ')' || temp == '>') {
					char last = stack.pop();
					if(temp == '}' && last != '{' ||
						temp == ']' && last != '[' ||
						temp == ')' && last != '(' ||
						temp == '>' && last != '<') {
						break;
					}
				}else {
					stack.push(temp);
				}
			}
			int chk = 0;
			if(stack.isEmpty()) {
				chk = 1;
			}
			sb.append("#").append(testCase).append(" ").append(chk).append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
