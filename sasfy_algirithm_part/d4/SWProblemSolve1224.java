package Algorithm.sasfy_algirithm_part.d4;

import java.util.Scanner;
import java.util.Stack;

public class SWProblemSolve1224 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for (int test = 1; test <= 10; test++) {
			int len = sc.nextInt();
			String str = sc.next();
			StringBuilder tempSb = new StringBuilder();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < len; i++) {
				char tempChar = str.charAt(i);
				if (tempChar >= '0' && tempChar <= '9') {
					tempSb.append(tempChar);
				} else {
					if (stack.isEmpty()) {
						stack.push(tempChar);
					} else if (tempChar == ')') {
						while (stack.peek() != '(') {
							tempSb.append(stack.pop());
						}
						stack.pop();
					} else if (tempChar == '+' || tempChar == '-') {
						while (!stack.isEmpty()) {
							if (stack.peek() == '(') {
								break;
							}
							tempSb.append(stack.pop());
						}
						stack.push(tempChar);
					} else if (tempChar == '*' || tempChar == '/') {
						while (!stack.isEmpty()) {
							if (stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '(') {
								break;
							}
							tempSb.append(stack.pop());
						}
						stack.push(tempChar);
					} else if (tempChar == '(') {
						stack.push(tempChar);
					}
				}
			}

			while (!stack.isEmpty()) {
				tempSb.append(stack.pop());
			}
			str = tempSb.toString();
			Stack<Integer> numStack = new Stack<>();
			for (int i = 0; i < str.length(); i++) {
				char tempChar = str.charAt(i);
				if (tempChar >= '0' && tempChar <= '9') {
					numStack.push(Integer.parseInt(Character.toString(tempChar)));
				} else if (tempChar == '*') {
					int num1 = numStack.pop();
					int num2 = numStack.pop();
					numStack.push(num1 * num2);
				} else if (tempChar == '+') {
					int num1 = numStack.pop();
					int num2 = numStack.pop();
					numStack.push(num1 + num2);
				} else if (tempChar == '-') {
					int num1 = numStack.pop();
					int num2 = numStack.pop();
					numStack.push(num1 - num2);
				} else if (tempChar == '/') {
					int num1 = numStack.pop();
					int num2 = numStack.pop();
					numStack.push(num1 / num2);
				}
			}
			sb.append("#").append(test).append(" ").append(numStack.pop()).append("\n");
		}
		System.out.println(sb.toString());
	}
}
